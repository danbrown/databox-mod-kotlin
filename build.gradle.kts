import org.spongepowered.asm.gradle.plugins.MixinExtension
import org.spongepowered.asm.gradle.plugins.struct.DynamicProperties
import java.text.SimpleDateFormat
import java.util.*

buildscript {
  repositories {
    mavenCentral()
    maven {
      url = uri("https://plugins.gradle.org/m2/")
    }
  }
  dependencies {
    val kotlinVersion = "1.9.0"
    classpath(kotlin("gradle-plugin", version = kotlinVersion))
    classpath(kotlin("serialization", version = kotlinVersion))
    // classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.0")
    classpath("org.spongepowered:mixingradle:0.7.+")
  }
}

apply(plugin = "kotlin")
apply(plugin = "org.jetbrains.kotlin.plugin.serialization")
apply(plugin = "org.spongepowered.mixin")

plugins {
  eclipse
  `maven-publish`
  id("net.minecraftforge.gradle") version "[6.0,6.2)"
//    id("org.parchmentmc.librarian.forgegradle") version "1.+"
  // id("org.jetbrains.kotlin.jvm") version "1.9.0"
  // id("org.jetbrains.kotlin.plugin.serialization") version "1.9.0"
  kotlin("jvm") version "1.9.0"
  kotlin("plugin.serialization") version "1.9.0"
}

version = "1.20-0.1.0"
group = "com.dannbrown"

val modid = "databox"
val vendor = "dannbrown"

val mod_version: String by project // Add any other properties from gradle.properties that you need

java.toolchain.languageVersion.set(JavaLanguageVersion.of(17))

println(
  "Java: " + System.getProperty("java.version") + " JVM: " + System.getProperty("java.vm.version") + "(" + System.getProperty(
    "java.vendor"
  ) + ") Arch: " + System.getProperty("os.arch")
)

kotlin {
  jvmToolchain(17)
}

minecraft {
  mappings("official", "1.20")
//    mappings("parchment", "BLEEDING-SNAPSHOT-1.19.3") // not support 1.20.x yet

  accessTransformer(file("src/main/resources/META-INF/accesstransformer.cfg"))

  runs.all {
    mods {
      workingDirectory(project.file("run"))
      property("forge.logging.markers", "REGISTRIES")
      property("forge.logging.console.level", "debug")
      property("forge.enabledGameTestNamespaces", modid)
      property("terminal.jline", "true")
      mods {
        create(modid) {
          source(sourceSets.main.get())
        }
      }
    }
  }

  runs.run {
    create("client") {
      property("log4j.configurationFile", "log4j2.xml")

      // for hotswap https://forge.gemwire.uk/wiki/Hotswap
      // jvmArg("-XX:+AllowEnhancedClassRedefinition")

      args(
        "--username", "DanBrown_",
      )
    }

    create("server") {}

    create("gameTestServer") {}

    create("data") {
      workingDirectory(project.file("run"))
      args(
        "--mod",
        modid,
        "--all",
        "--output",
        file("src/generated/resources/"),
        "--existing",
        file("src/main/resources")
      )
    }

  }
}

sourceSets.main.configure { resources.srcDirs("src/generated/resources/") }

configurations {
  minecraftLibrary {
    exclude("org.jetbrains", "annotations")
  }
}

repositories {
  mavenCentral()
  maven {
    name = "Kotlin for Forge"
    setUrl("https://thedarkcolour.github.io/KotlinForForge/")
  }
}

dependencies {
  minecraft("net.minecraftforge:forge:1.20-46.0.1")
  annotationProcessor("org.spongepowered:mixin:0.8.5:processor")
  implementation("thedarkcolour:kotlinforforge:4.3.0")
}

val Project.mixin: MixinExtension get() = extensions.getByType()

mixin.run {
  add(sourceSets.main.get(), "databox.mixins.refmap.json")
  config("databox.mixins.json")
  val debug = this.debug as DynamicProperties
  debug.setProperty("verbose", true)
  debug.setProperty("export", true)
  setDebug(debug)
}

tasks.withType<Jar> {
  archiveBaseName.set(modid)
  manifest {
    val map = HashMap<String, String>()
    map["Specification-Title"] = modid
    map["Specification-Vendor"] = vendor
    map["Specification-Version"] = "1"
    map["Implementation-Title"] = project.name
    map["Implementation-Version"] = project.version.toString()
    map["Implementation-Vendor"] = vendor
    map["Implementation-Timestamp"] = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ").format(Date())
    attributes(map)
  }
  finalizedBy("reobfJar")
}

publishing {
  publications {
    create<MavenPublication>("mavenJava") {
      from(components["java"])
    }
  }
  repositories {
    maven {
      url = uri("file://${project.projectDir}/mcmodsrepo")
    }
  }
}

tasks.withType<JavaCompile>().configureEach {
  options.encoding = "UTF-8"
}


tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile>().configureEach {
  kotlinOptions {
    jvmTarget = "17"
  }
}