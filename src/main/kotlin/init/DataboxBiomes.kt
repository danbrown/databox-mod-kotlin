package com.dannbrown.databox.init


import com.dannbrown.databox.lib.LibUtils
import com.google.common.collect.ImmutableList
import net.minecraft.core.HolderGetter
import net.minecraft.core.registries.Registries
import net.minecraft.data.worldgen.BootstapContext
import net.minecraft.resources.ResourceKey
import net.minecraft.sounds.Music
import net.minecraft.sounds.SoundEvent
import net.minecraft.world.entity.EntityType
import net.minecraft.world.entity.MobCategory
import net.minecraft.world.level.biome.*
import net.minecraft.world.level.biome.BiomeGenerationSettings
import net.minecraft.world.level.biome.BiomeSpecialEffects
import net.minecraft.world.level.biome.Climate.ParameterList
import net.minecraft.world.level.biome.MobSpawnSettings
import net.minecraft.world.level.biome.MobSpawnSettings.SpawnerData
import net.minecraft.world.level.levelgen.GenerationStep
import net.minecraftforge.registries.RegistryObject
import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Holder
import net.minecraft.sounds.SoundEvents
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver
import net.minecraft.world.level.levelgen.placement.PlacedFeature


class DataboxBiomes {
  companion object {
    val CUSTOM_BIOME_1: ResourceKey<Biome> = createBiomeKey("custom_biome_1")
    val ANCIENT_SEA: ResourceKey<Biome> = createBiomeKey("ancient_sea")

    private fun createBiomeKey(name: String): ResourceKey<Biome> {
      return ResourceKey.create(Registries.BIOME, LibUtils.resourceLocation(name))
    }


    fun createAncientSea(
      placedFeatures: HolderGetter<PlacedFeature>,
      caveGetter: HolderGetter<ConfiguredWorldCarver<*>>
    ): Biome {
      val generationSettings: BiomeGenerationSettings =
        addOresAndCaves(BiomeGenerationSettings.Builder(placedFeatures, caveGetter)).build()

      val mobSpawnSettings: MobSpawnSettings = MobSpawnSettings.EMPTY

      val biomeSpecialEffects: BiomeSpecialEffects =
        generateColors(BiomeSpecialEffects.Builder(), 1186057, 4477507).build()

      return Biome.BiomeBuilder()
        .generationSettings(generationSettings)
        .mobSpawnSettings(mobSpawnSettings)
        .specialEffects(biomeSpecialEffects)
        .hasPrecipitation(false)
        .downfall(0.0F)
        .temperature(0.8F)
        .build()
    }

    fun createCustomBiome1(
      placedFeatures: HolderGetter<PlacedFeature>,
      caveGetter: HolderGetter<ConfiguredWorldCarver<*>>
    ): Biome {
      val generationSettings: BiomeGenerationSettings =
        addOresAndCaves(BiomeGenerationSettings.Builder(placedFeatures, caveGetter)).build()
//          .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DataboxPlacedFeatures.DEEPTURF_PATCH)
////        .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DataboxPlacedFeatures.SHIMMERWEED_PATCH)
////        .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DataboxPlacedFeatures.DEPTHROCK_PEBBLE_PATCH)
////        .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DataboxPlacedFeatures.DITCHBULB_PATCH)
////        .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DataboxPlacedFeatures.DROOPVINE_PATCH)
////        .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DataboxPlacedFeatures.GLITTERKELP_PATCH)

      val mobSpawnSettings: MobSpawnSettings = addRotspawn(addCaveMobs(MobSpawnSettings.Builder())).build()

      val specialEffects: BiomeSpecialEffects =
        generateColors(BiomeSpecialEffects.Builder(), 1186057, 4477507)
          .build()
//      val specialEffects: BiomeSpecialEffects = addMusicAndAmbience(
//        generateColors(BiomeSpecialEffects.Builder(), 1186057, 4477507),
//        DataboxSoundEvents.SEA_AMBIENT_ADDITION,
//        DataboxSoundEvents.UNDERGARDEN_AMBIENCE,
//        DataboxSoundEvents.UNDERGARDEN_MUSIC
//      ).build()


      return Biome.BiomeBuilder()
        .generationSettings(generationSettings)
        .mobSpawnSettings(mobSpawnSettings)
        .specialEffects(specialEffects)
        .hasPrecipitation(false)
        .downfall(0.0F)
        .temperature(0.8F)
        .build()
    }

    fun bootstrap(context: BootstapContext<Biome>) {
      val placedFeatures: HolderGetter<PlacedFeature> = context.lookup(Registries.PLACED_FEATURE)
      val worldCarvers: HolderGetter<ConfiguredWorldCarver<*>> = context.lookup(Registries.CONFIGURED_CARVER)

      context.register(CUSTOM_BIOME_1, createCustomBiome1(placedFeatures, worldCarvers))
      context.register(ANCIENT_SEA, createAncientSea(placedFeatures, worldCarvers))
    }

    // @ Utility functions

    private fun addOresAndCaves(builder: BiomeGenerationSettings.Builder): BiomeGenerationSettings.Builder {
      return builder
        .addCarver(GenerationStep.Carving.AIR, DataboxConfiguredCarvers.UNDERGARDEN_CAVE)
        .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DataboxPlacedFeatures.ADAMANTIUM_ORE)
//        .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DataboxPlacedFeatures.IRON_ORE)
//        .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DataboxPlacedFeatures.GOLD_ORE)
//        .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DataboxPlacedFeatures.DIAMOND_ORE)
    }

//    private fun addShroomPatches(builder: BiomeGenerationSettings.Builder): BiomeGenerationSettings.Builder {
//      return builder
//        .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DataboxPlacedFeatures.BLOOD_MUSHROOM_PATCH)
//        .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DataboxPlacedFeatures.INDIGO_MUSHROOM_PATCH)
//        .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DataboxPlacedFeatures.INK_MUSHROOM_PATCH)
//        .addFeature(GenerationStep.Decoration.VEGETAL_DECORATION, DataboxPlacedFeatures.VEIL_MUSHROOM_PATCH)
//    }

    private fun addCaveMobs(builder: MobSpawnSettings.Builder): MobSpawnSettings.Builder {
      return builder
        .addSpawn(MobCategory.AMBIENT, SpawnerData(EntityType.FROG, 50, 1, 1))
        .addSpawn(MobCategory.MONSTER, SpawnerData(EntityType.CAVE_SPIDER, 50, 1, 1))
        .addSpawn(MobCategory.MONSTER, SpawnerData(EntityType.STRIDER, 50, 1, 1))
    }

    private fun addRotspawn(builder: MobSpawnSettings.Builder): MobSpawnSettings.Builder {
      return builder
        .addSpawn(MobCategory.MONSTER, SpawnerData(EntityType.EVOKER, 100, 2, 4))
        .addSpawn(MobCategory.MONSTER, SpawnerData(EntityType.ALLAY, 100, 4, 4))
        .addSpawn(MobCategory.MONSTER, SpawnerData(EntityType.SNOW_GOLEM, 100, 1, 2))
    }


//    private fun addMusicAndAmbience(
//      builder: BiomeSpecialEffects.Builder,
//      mood: RegistryObject<SoundEvent>,
//      ambient: RegistryObject<SoundEvent>,
//      addition: RegistryObject<SoundEvent>,
//      additionInterval: Double = 0.00555
//    ): BiomeSpecialEffects.Builder {
//      return builder
//        .ambientAdditionsSound(AmbientAdditionsSettings(addition.getHolder().get(), additionInterval))
//        .ambientMoodSound(AmbientMoodSettings(mood.getHolder().get(), 6000, 8, 2.0))
//        .ambientLoopSound(ambient.getHolder().get())
//    }

    private fun addBackgroundMusic(
      builder: BiomeSpecialEffects.Builder,
      music: RegistryObject<SoundEvent>,
      minDelay: Int = 12000,
      maxDelay: Int = 24000,
      replaceCurrentMusic: Boolean = true
    ): BiomeSpecialEffects.Builder {
      return builder
        .backgroundMusic(Music(music.holder.get(), minDelay, maxDelay, replaceCurrentMusic))
    }

    private fun generateColors(
      builder: BiomeSpecialEffects.Builder,
      skyFog: Int,
      grass: Int
    ): BiomeSpecialEffects.Builder {
      return builder
        .skyColor(1186057)
        .fogColor(skyFog)
        .waterColor(342306)
        .waterFogColor(332810)
        .grassColorOverride(grass)
        .foliageColorOverride(grass)
    }

    fun buildBiomeSource(biomes: HolderGetter<Biome?>): BiomeSource {
      return MultiNoiseBiomeSource.createFromList(
        ParameterList(
          ImmutableList.of(
//            Pair.of(Climate.parameters(0.0f, 0.0f, 0.0f, 0.0f, -2.0f, 0.0f, 0.0f), biomes.getOrThrow(FORGOTTEN_FIELD)),
//            Pair.of(Climate.parameters(-1.0f, -0.4f, -0.9f, -0.7f, -2.0f, 0.0f, 0.0f), biomes.getOrThrow(FROSTFIELDS)),
//            Pair.of(Climate.parameters(1.0f, 0.0f, 0.0f, 0.0f, -2.0f, 0.0f, 0.0f), biomes.getOrThrow(SMOGSTEM_FOREST)),
//            Pair.of(
//              Climate.parameters(0.0f, -0.4f, 0.0f, 0.0f, -2.0f, 0.0f, 0.0f),
//              biomes.getOrThrow(WIGGLEWOOD_FOREST)
//            ),
//            Pair.of(Climate.parameters(1.0f, 0.4f, 0.0f, 0.0f, -2.0f, 0.0f, 0.0f), biomes.getOrThrow(DENSE_FOREST)),
//            Pair.of(Climate.parameters(0.0f, 0.0f, 0.9f, 0.0f, -2.0f, 0.0f, 0.0f), biomes.getOrThrow(GRONGLEGROWTH)),
//            Pair.of(Climate.parameters(0.0f, 0.0f, 0.0f, 0.7f, -2.0f, 0.0f, 0.0f), biomes.getOrThrow(BARREN_ABYSS)),
//            Pair.of(Climate.parameters(0.0f, 0.0f, 0.0f, 1.0f, -2.0f, 0.0f, 0.0f), biomes.getOrThrow(SMOG_SPIRES)),
//            Pair.of(Climate.parameters(0.0f, 0.0f, 0.0f, 0.0f, -2.0f, 1.0f, 0.0f), biomes.getOrThrow(INK_MUSHROOM_BOG)),
//            Pair.of(
//              Climate.parameters(1.0f, 0.0f, 0.0f, 0.0f, -2.0f, 1.0f, 0.0f),
//              biomes.getOrThrow(INDIGO_MUSHROOM_BOG)
//            ),
//            Pair.of(
//              Climate.parameters(0.0f, 0.0f, 0.0f, 0.0f, -2.0f, -1.0f, 0.0f),
//              biomes.getOrThrow(VEIL_MUSHROOM_BOG)
//            ),
//            Pair.of(
//              Climate.parameters(0.0f, 0.0f, 0.0f, 0.7f, -2.0f, -1.0f, 0.0f),
//              biomes.getOrThrow(BLOOD_MUSHROOM_BOG)
//            ),
            Pair.of(
              Climate.parameters(
                Climate.Parameter.span(0.0f, 1.0f),
                Climate.Parameter.span(0.0f, 0.4f),
                Climate.Parameter.span(0.0f, 0.9f),
                Climate.Parameter.point(0.0f),
                Climate.Parameter.point(2.0f),
                Climate.Parameter.span(-1.0f, 1.0f),
                0.0f
              ), biomes.getOrThrow(ANCIENT_SEA as ResourceKey<Biome?>)
            ),
//            Pair.of(
//              Climate.parameters(
//                Climate.Parameter.point(0.0f),
//                Climate.Parameter.point(0.0f),
//                Climate.Parameter.point(0.0f),
//                Climate.Parameter.span(0.7f, 1.0f),
//                Climate.Parameter.point(2.0f),
//                Climate.Parameter.point(0.0f),
//                0.0f
//              ), biomes.getOrThrow(DEAD_SEA)
//            ),
//            Pair.of(Climate.parameters(-0.7f, -0.7f, -0.7f, 0.0f, 2.0f, 0.0f, 0.0f), biomes.getOrThrow(ICY_SEA))
          )
        )
      )
    }

  }
}

