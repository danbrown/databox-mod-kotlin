package com.dannbrown.databox.lib

import com.dannbrown.databox.datagen.DataboxConfiguredCarvers
import com.dannbrown.databox.datagen.DataboxPlacedFeatures
import net.minecraft.sounds.Music
import net.minecraft.sounds.SoundEvent
import net.minecraft.world.entity.EntityType
import net.minecraft.world.entity.MobCategory
import net.minecraft.world.level.biome.BiomeGenerationSettings
import net.minecraft.world.level.biome.BiomeSpecialEffects
import net.minecraft.world.level.biome.MobSpawnSettings
import net.minecraft.world.level.levelgen.GenerationStep
import net.minecraftforge.registries.RegistryObject

object LibBiomeFeatures {
  fun addOresAndCaves(builder: BiomeGenerationSettings.Builder): BiomeGenerationSettings.Builder {
    return builder
      .addCarver(GenerationStep.Carving.AIR, DataboxConfiguredCarvers.UNDERGARDEN_CAVE)
      .addFeature(GenerationStep.Decoration.UNDERGROUND_ORES, DataboxPlacedFeatures.ADAMANTIUM_ORE)
  }

  fun addCaveMobs(builder: MobSpawnSettings.Builder): MobSpawnSettings.Builder {
    return builder
      .addSpawn(MobCategory.AMBIENT, MobSpawnSettings.SpawnerData(EntityType.FROG, 50, 1, 1))
      .addSpawn(MobCategory.MONSTER, MobSpawnSettings.SpawnerData(EntityType.CAVE_SPIDER, 50, 1, 1))
      .addSpawn(MobCategory.MONSTER, MobSpawnSettings.SpawnerData(EntityType.STRIDER, 50, 1, 1))
  }

  fun addRotspawn(builder: MobSpawnSettings.Builder): MobSpawnSettings.Builder {
    return builder
      .addSpawn(MobCategory.MONSTER, MobSpawnSettings.SpawnerData(EntityType.EVOKER, 100, 2, 4))
      .addSpawn(MobCategory.MONSTER, MobSpawnSettings.SpawnerData(EntityType.ALLAY, 100, 4, 4))
      .addSpawn(MobCategory.MONSTER, MobSpawnSettings.SpawnerData(EntityType.SNOW_GOLEM, 100, 1, 2))
  }

  fun addBackgroundMusic(
    builder: BiomeSpecialEffects.Builder,
    music: RegistryObject<SoundEvent>,
    minDelay: Int = 12000,
    maxDelay: Int = 24000,
    replaceCurrentMusic: Boolean = true
  ): BiomeSpecialEffects.Builder {
    return builder
      .backgroundMusic(Music(music.holder.get(), minDelay, maxDelay, replaceCurrentMusic))
  }

  fun generateColors(
    builder: BiomeSpecialEffects.Builder,
    skyFog: Int = 12638463,
    grass: Int = 10387789,

    ): BiomeSpecialEffects.Builder {
    return builder
      .skyColor(1186057)
      .fogColor(skyFog)
      .waterColor(342306)
      .waterFogColor(332810)
      .grassColorOverride(grass)
      .foliageColorOverride(grass)
  }
}