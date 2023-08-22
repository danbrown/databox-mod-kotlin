package com.dannbrown.databox.datagen

import com.dannbrown.databox.lib.LibUtils
import net.minecraft.core.BlockPos
import net.minecraft.core.registries.Registries
import net.minecraft.data.worldgen.BootstapContext
import net.minecraft.data.worldgen.placement.PlacementUtils
import net.minecraft.resources.ResourceKey
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate
import net.minecraft.world.level.levelgen.placement.BiomeFilter
import net.minecraft.world.level.levelgen.placement.BlockPredicateFilter
import net.minecraft.world.level.levelgen.placement.CountOnEveryLayerPlacement
import net.minecraft.world.level.levelgen.placement.CountPlacement
import net.minecraft.world.level.levelgen.placement.InSquarePlacement
import net.minecraft.world.level.levelgen.placement.NoiseBasedCountPlacement
import net.minecraft.world.level.levelgen.placement.PlacedFeature
import net.minecraft.world.level.levelgen.placement.PlacementModifier
import net.minecraft.world.level.levelgen.placement.RarityFilter


class DataboxPlacedFeatures {
  companion object {

    //ores
    val ADAMANTIUM_ORE = createPlacedFeature("adamantium_ore")

    fun createPlacedFeature(name: String): ResourceKey<PlacedFeature> {
      return ResourceKey.create(Registries.PLACED_FEATURE, LibUtils.resourceLocation(name))
    }

    fun bootstrap(context: BootstapContext<PlacedFeature>) {
      val features = context.lookup(Registries.CONFIGURED_FEATURE)
      //ores
      context.register(
        ADAMANTIUM_ORE,
        PlacedFeature(
          features.getOrThrow(DataboxConfiguredFeatures.ADAMANTIUM_ORE),
          rareOrePlacement(30, PlacementUtils.FULL_RANGE)
        )
      )
    }

    private fun tree(count: Int): List<PlacementModifier> {
      return listOf(
        CountOnEveryLayerPlacement.of(count),
        BiomeFilter.biome(),
        BlockPredicateFilter.forPredicate(
          BlockPredicate.wouldSurvive(
            Blocks.OAK_SAPLING.defaultBlockState(),
            BlockPos.ZERO
          )
        )
      )
    }

    private fun patch(count: Int): List<PlacementModifier> {
      return listOf(
        CountPlacement.of(count),
        InSquarePlacement.spread(),
        PlacementUtils.FULL_RANGE,
        BiomeFilter.biome()
      )
    }

    private fun patchWithFilter(count: Int, filter: BlockPredicate): List<PlacementModifier> {
      return listOf(
        CountPlacement.of(count),
        InSquarePlacement.spread(),
        PlacementUtils.FULL_RANGE,
        BlockPredicateFilter.forPredicate(filter),
        BiomeFilter.biome()
      )
    }

    private fun noise(noiseToCountRatio: Int, factor: Double, offset: Double): List<PlacementModifier> {
      return listOf(
        NoiseBasedCountPlacement.of(noiseToCountRatio, factor, offset),
        InSquarePlacement.spread(),
        PlacementUtils.FULL_RANGE,
        BiomeFilter.biome()
      )
    }

    private fun noiseWithFilter(
      noiseToCountRatio: Int,
      factor: Double,
      offset: Double,
      filter: BlockPredicate
    ): List<PlacementModifier> {
      return java.util.List.of(
        NoiseBasedCountPlacement.of(noiseToCountRatio, factor, offset),
        InSquarePlacement.spread(),
        PlacementUtils.FULL_RANGE,
        BlockPredicateFilter.forPredicate(filter),
        BiomeFilter.biome()
      )
    }

    private fun orePlacement(
      firstModifier: PlacementModifier,
      secondModifier: PlacementModifier
    ): List<PlacementModifier> {
      return java.util.List.of(firstModifier, InSquarePlacement.spread(), secondModifier, BiomeFilter.biome())
    }

    private fun commonOrePlacement(placement: Int, modifier: PlacementModifier): List<PlacementModifier> {
      return orePlacement(CountPlacement.of(placement), modifier)
    }

    private fun rareOrePlacement(placement: Int, modifier: PlacementModifier): List<PlacementModifier> {
      return orePlacement(RarityFilter.onAverageOnceEvery(placement), modifier)
    }
  }
}