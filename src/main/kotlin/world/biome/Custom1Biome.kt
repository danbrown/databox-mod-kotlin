package com.dannbrown.databox.world.biome

import net.minecraft.core.HolderGetter
import net.minecraft.core.particles.ParticleTypes
import net.minecraft.core.registries.Registries
import net.minecraft.data.worldgen.BiomeDefaultFeatures
import net.minecraft.data.worldgen.BootstapContext
import net.minecraft.world.entity.EntityType
import net.minecraft.world.entity.MobCategory
import net.minecraft.world.level.biome.*
import net.minecraft.world.level.biome.Biome.BiomeBuilder
import net.minecraft.world.level.biome.MobSpawnSettings.SpawnerData
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver
import net.minecraft.world.level.levelgen.placement.*


class Custom1Biome {
  companion object {

    fun createBiome(
      placedFeatures: HolderGetter<PlacedFeature>,
      worldCarvers: HolderGetter<ConfiguredWorldCarver<*>>
    ): Biome {
      val generation = BiomeGenerationSettings.Builder(placedFeatures, worldCarvers)

      BiomeDefaultFeatures.addDefaultCrystalFormations(generation);
      BiomeDefaultFeatures.addDefaultUndergroundVariety(generation);
      BiomeDefaultFeatures.addDefaultOres(generation);

      val effects = BiomeSpecialEffects.Builder()
        .fogColor(12638463)
        .waterColor(4159204)
        .waterFogColor(329011)
        .skyColor(7972607)
        .foliageColorOverride(10387789)
        .grassColorOverride(9470285)
        .ambientParticle(AmbientParticleSettings(ParticleTypes.SPIT, 0.005f))

      val mobSpawnInfo = MobSpawnSettings.Builder()
      mobSpawnInfo.addSpawn(MobCategory.CREATURE, SpawnerData(EntityType.FROG, 20, 4, 4))

      return BiomeBuilder()
        .hasPrecipitation(true)
        .temperature(1.5f).downfall(1.25f)
        .generationSettings(generation.build())
        .mobSpawnSettings(mobSpawnInfo.build())
        .specialEffects(effects.build())
        .build()
    }
  }
}