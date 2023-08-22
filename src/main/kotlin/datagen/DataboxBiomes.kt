package com.dannbrown.databox.datagen


import com.dannbrown.databox.content.biome.AncientSeaBiome
import com.dannbrown.databox.content.biome.Custom1Biome
import com.dannbrown.databox.lib.LibBiomeFeatures
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
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver
import net.minecraft.world.level.levelgen.placement.PlacedFeature


class DataboxBiomes {
  companion object {
    val CUSTOM_BIOME_1: ResourceKey<Biome> = createBiomeKey("custom_biome_1")
    val ANCIENT_SEA: ResourceKey<Biome> = createBiomeKey("ancient_sea")

    private fun createBiomeKey(name: String): ResourceKey<Biome> {
      return ResourceKey.create(Registries.BIOME, LibUtils.resourceLocation(name))
    }


    fun bootstrap(context: BootstapContext<Biome>) {
      val placedFeatures: HolderGetter<PlacedFeature> = context.lookup(Registries.PLACED_FEATURE)
      val worldCarvers: HolderGetter<ConfiguredWorldCarver<*>> = context.lookup(Registries.CONFIGURED_CARVER)

      context.register(CUSTOM_BIOME_1, Custom1Biome.createBiome(placedFeatures, worldCarvers))
      context.register(ANCIENT_SEA, AncientSeaBiome.createBiome(placedFeatures, worldCarvers))
    }

    // @ Utility functions


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

