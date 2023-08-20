pluginManagement {
    repositories {
        maven("https://maven.minecraftforge.net/")
        maven("https://maven.parchmentmc.org")
        gradlePluginPortal()
    }
}

plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}