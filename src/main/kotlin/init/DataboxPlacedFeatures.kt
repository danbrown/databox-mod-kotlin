package com.dannbrown.databox.init

import com.dannbrown.databox.lib.LibUtils
import net.minecraft.core.BlockPos
import net.minecraft.core.Direction
import net.minecraft.core.registries.Registries
import net.minecraft.data.worldgen.BootstapContext
import net.minecraft.data.worldgen.placement.OrePlacements
import net.minecraft.data.worldgen.placement.PlacementUtils
import net.minecraft.resources.ResourceKey
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.levelgen.VerticalAnchor
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
//    val IRON_ORE = createPlacedFeature("iron_ore")
//    val GOLD_ORE = createPlacedFeature("gold_ore")
//    val DIAMOND_ORE = createPlacedFeature("diamond_ore")

    //deltas
//    val BOG_DELTA = createPlacedFeature("bog_delta")
//    val GRONGLEGROWTH_DELTA = createPlacedFeature("gronglegrowth_delta")
//
//    //vegetation
//    val AMOROUS_BRISTLE_PATCH = createPlacedFeature("amorous_bristle_patch")
//    val MISERABELL_PATCH = createPlacedFeature("miserabell_patch")
//    val BUTTERBUNCH_PATCH = createPlacedFeature("butterbunch_patch")
//    val DEEPTURF_PATCH = createPlacedFeature("deepturf_patch")
//    val ASHEN_DEEPTURF_PATCH = createPlacedFeature("ashen_deepturf_patch")
//    val FROZEN_DEEPTURF_PATCH = createPlacedFeature("frozen_deepturf_patch")
//    val SHIMMERWEED_PATCH = createPlacedFeature("shimmerweed_patch")
//    val DEPTHROCK_PEBBLE_PATCH = createPlacedFeature("depthrock_pebble_patch")
//    val DITCHBULB_PATCH = createPlacedFeature("ditchbulb_patch")
//    val TALL_DEEPTURF_PATCH = createPlacedFeature("tall_deepturf_patch")
//    val TALL_SHIMMERWEED_PATCH = createPlacedFeature("tall_shimmerweed_patch")
//    val INDIGO_MUSHROOM_PATCH = createPlacedFeature("indigo_mushroom_patch")
//    val VEIL_MUSHROOM_PATCH = createPlacedFeature("veil_mushroom_patch")
//    val INK_MUSHROOM_PATCH = createPlacedFeature("ink_mushroom_patch")
//    val BLOOD_MUSHROOM_PATCH = createPlacedFeature("blood_mushroom_patch")
//    val UNDERBEAN_BUSH_PATCH = createPlacedFeature("underbean_bush_patch")
//    val BLISTERBERRY_BUSH_PATCH = createPlacedFeature("blisterberry_bush_patch")
//    val GLOOMGOURD_PATCH = createPlacedFeature("gloomgourd_patch")
//    val DROOPVINE_PATCH = createPlacedFeature("droopvine_patch")
//    val GLITTERKELP_PATCH = createPlacedFeature("glitterkelp_patch")
//
//    //tree
//    val SMOGSTEM_TREE = createPlacedFeature("smogstem_tree")
//    val WIDE_SMOGSTEM_TREE = createPlacedFeature("wide_smogstem_tree")
//    val TALL_SMOGSTEM_TREE = createPlacedFeature("tall_smogstem_tree")
//    val SMOGSTEM_BUSH = createPlacedFeature("smogstem_bush")
//    val WIGGLEWOOD_TREE = createPlacedFeature("wigglewood_tree")
//    val TALL_WIGGLEWOOD_TREE = createPlacedFeature("tall_wigglewood_tree")
//    val GRONGLE_TREE = createPlacedFeature("grongle_tree")
//    val SMALL_GRONGLE_TREE = createPlacedFeature("small_grongle_tree")
//    val GRONGLE_BUSH = createPlacedFeature("grongle_bush")
//
//    //huge mushrooms
//    val HUGE_INDIGO_MUSHROOM = createPlacedFeature("huge_indigo_mushroom")
//    val HUGE_INDIGO_MUSHROOM_SMOGSTEM_FOREST = createPlacedFeature("huge_indigo_mushroom_smogstem_forest")
//    val HUGE_VEIL_MUSHROOM = createPlacedFeature("huge_veil_mushroom")
//    val HUGE_INK_MUSHROOM = createPlacedFeature("huge_ink_mushroom")
//    val HUGE_BLOOD_MUSHROOM = createPlacedFeature("huge_blood_mushroom")
//
//    //rocks
//    val DEPTHROCK_ROCK = createPlacedFeature("depthrock_rock")
//    val SHIVERSTONE_ROCK = createPlacedFeature("shiverstone_rock")
//
//    //misc
//    val SMOG_VENT = createPlacedFeature("smog_vent")
//    val ICE_PILLAR = createPlacedFeature("ice_pillar")

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
          commonOrePlacement(30, PlacementUtils.FULL_RANGE)
        )
      )
//      context.register(
//        IRON_ORE,
//        PlacedFeature(
//          features.getOrThrow(DataboxConfiguredFeatures.IRON_ORE),
//          commonOrePlacement(
//            8,
//            HeightRangePlacement.triangle(VerticalAnchor.belowTop(64), VerticalAnchor.belowTop(-64))
//          )
//        )
//      )
//      context.register(
//        GOLD_ORE,
//        PlacedFeature(
//          features.getOrThrow(DataboxConfiguredFeatures.GOLD_ORE),
//          commonOrePlacement(
//            2,
//            HeightRangePlacement.triangle(VerticalAnchor.belowTop(32), VerticalAnchor.belowTop(-32))
//          )
//        )
//      )
//      context.register(
//        DIAMOND_ORE,
//        PlacedFeature(
//          features.getOrThrow(DataboxConfiguredFeatures.DIAMOND_ORE),
//          commonOrePlacement(
//            1,
//            HeightRangePlacement.triangle(VerticalAnchor.belowTop(16), VerticalAnchor.belowTop(-16))
//          )
//        )
//      )
//      context.register(
//        CLOGGRUM_ORE,
//        PlacedFeature(
//          features.getOrThrow(DataboxConfiguredFeatures.CLOGGRUM_ORE),
//          commonOrePlacement(
//            20,
//            HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-128), VerticalAnchor.aboveBottom(128))
//          )
//        )
//      )
//      context.register(
//        FROSTSTEEL_ORE,
//        PlacedFeature(
//          features.getOrThrow(DataboxConfiguredFeatures.FROSTSTEEL_ORE),
//          commonOrePlacement(
//            15,
//            HeightRangePlacement.triangle(VerticalAnchor.aboveBottom(-128), VerticalAnchor.aboveBottom(128))
//          )
//        )
//      )
//      context.register(
//        UTHERIUM_ORE,
//        PlacedFeature(
//          features.getOrThrow(DataboxConfiguredFeatures.UTHERIUM_ORE),
//          commonOrePlacement(
//            3,
//            HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(32))
//          )
//        )
//      )
//      context.register(
//        REGALIUM_ORE,
//        PlacedFeature(
//          features.getOrThrow(DataboxConfiguredFeatures.REGALIUM_ORE),
//          commonOrePlacement(
//            3,
//            HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(12))
//          )
//        )
//      )
//      context.register(
//        SHIVERSTONE_ORE,
//        PlacedFeature(
//          features.getOrThrow(DataboxConfiguredFeatures.SHIVERSTONE_ORE),
//          commonOrePlacement(10, PlacementUtils.FULL_RANGE)
//        )
//      )
//      context.register(
//        DEEPSOIL_ORE,
//        PlacedFeature(
//          features.getOrThrow(DataboxConfiguredFeatures.DEEPSOIL_ORE),
//          commonOrePlacement(10, PlacementUtils.FULL_RANGE)
//        )
//      )
//      context.register(
//        ICE_ORE,
//        PlacedFeature(
//          features.getOrThrow(DataboxConfiguredFeatures.ICE_ORE),
//          commonOrePlacement(20, PlacementUtils.FULL_RANGE)
//        )
//      )
//      context.register(
//        SEDIMENT_ORE,
//        PlacedFeature(
//          features.getOrThrow(DataboxConfiguredFeatures.SEDIMENT_ORE),
//          commonOrePlacement(
//            10,
//            HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(32))
//          )
//        )
//      )
//
//      //deltas
//      context.register(
//        BOG_DELTA,
//        PlacedFeature(
//          features.getOrThrow(DataboxConfiguredFeatures.BOG_DELTA),
//          java.util.List.of<PlacementModifier>(CountOnEveryLayerPlacement.of(40), BiomeFilter.biome())
//        )
//      )
//      context.register(
//        GRONGLEGROWTH_DELTA,
//        PlacedFeature(
//          features.getOrThrow(DataboxConfiguredFeatures.GRONGLEGROWTH_DELTA),
//          java.util.List.of<PlacementModifier>(CountOnEveryLayerPlacement.of(40), BiomeFilter.biome())
//        )
//      )
//
//      //vegetation
//      context.register(
//        AMOROUS_BRISTLE_PATCH,
//        PlacedFeature(features.getOrThrow(DataboxConfiguredFeatures.AMOROUS_BRISTLE_PATCH), patch(5))
//      )
//      context.register(
//        MISERABELL_PATCH,
//        PlacedFeature(features.getOrThrow(DataboxConfiguredFeatures.MISERABELL_PATCH), patch(5))
//      )
//      context.register(
//        BUTTERBUNCH_PATCH,
//        PlacedFeature(features.getOrThrow(DataboxConfiguredFeatures.BUTTERBUNCH_PATCH), patch(5))
//      )
//      context.register(
//        DEEPTURF_PATCH,
//        PlacedFeature(
//          features.getOrThrow(DataboxConfiguredFeatures.DEEPTURF_PATCH),
//          patchWithFilter(100, BlockPredicate.matchesBlocks(Direction.DOWN.getNormal(), UGBlocks.DEEPTURF_BLOCK.get()))
//        )
//      )
//      context.register(
//        ASHEN_DEEPTURF_PATCH,
//        PlacedFeature(
//          features.getOrThrow(DataboxConfiguredFeatures.ASHEN_DEEPTURF_PATCH),
//          patchWithFilter(
//            100,
//            BlockPredicate.matchesBlocks(Direction.DOWN.getNormal(), UGBlocks.ASHEN_DEEPTURF_BLOCK.get())
//          )
//        )
//      )
//      context.register(
//        FROZEN_DEEPTURF_PATCH,
//        PlacedFeature(
//          features.getOrThrow(DataboxConfiguredFeatures.FROZEN_DEEPTURF_PATCH),
//          patchWithFilter(
//            100,
//            BlockPredicate.matchesBlocks(Direction.DOWN.getNormal(), UGBlocks.FROZEN_DEEPTURF_BLOCK.get())
//          )
//        )
//      )
//      context.register(
//        SHIMMERWEED_PATCH,
//        PlacedFeature(
//          features.getOrThrow(DataboxConfiguredFeatures.SHIMMERWEED_PATCH),
//          noiseWithFilter(
//            400,
//            75.0,
//            0.0,
//            BlockPredicate.matchesBlocks(
//              Direction.DOWN.getNormal(),
//              UGBlocks.DEEPTURF_BLOCK.get(),
//              UGBlocks.DEEPSOIL.get(),
//              UGBlocks.FROZEN_DEEPTURF_BLOCK.get()
//            )
//          )
//        )
//      )
//      context.register(
//        DEPTHROCK_PEBBLE_PATCH,
//        PlacedFeature(features.getOrThrow(DataboxConfiguredFeatures.DEPTHROCK_PEBBLE_PATCH), noise(400, 50.0, 0.0))
//      )
//      context.register(
//        DITCHBULB_PATCH,
//        PlacedFeature(
//          features.getOrThrow(DataboxConfiguredFeatures.DITCHBULB_PATCH),
//          patchWithFilter(75, BlockPredicate.matchesBlocks(Direction.DOWN.getNormal(), UGBlocks.DEPTHROCK.get()))
//        )
//      )
//      context.register(
//        TALL_DEEPTURF_PATCH,
//        PlacedFeature(
//          features.getOrThrow(DataboxConfiguredFeatures.TALL_DEEPTURF_PATCH),
//          patchWithFilter(100, BlockPredicate.matchesBlocks(Direction.DOWN.getNormal(), UGBlocks.DEEPTURF_BLOCK.get()))
//        )
//      )
//      context.register(
//        TALL_SHIMMERWEED_PATCH,
//        PlacedFeature(
//          features.getOrThrow(DataboxConfiguredFeatures.TALL_SHIMMERWEED_PATCH),
//          noiseWithFilter(
//            400,
//            75.0,
//            0.0,
//            BlockPredicate.matchesBlocks(
//              Direction.DOWN.getNormal(),
//              UGBlocks.DEEPTURF_BLOCK.get(),
//              UGBlocks.DEEPSOIL.get(),
//              UGBlocks.FROZEN_DEEPTURF_BLOCK.get()
//            )
//          )
//        )
//      )
//      context.register(
//        INDIGO_MUSHROOM_PATCH,
//        PlacedFeature(features.getOrThrow(DataboxConfiguredFeatures.INDIGO_MUSHROOM_PATCH), patch(1))
//      )
//      context.register(
//        VEIL_MUSHROOM_PATCH,
//        PlacedFeature(features.getOrThrow(DataboxConfiguredFeatures.VEIL_MUSHROOM_PATCH), patch(1))
//      )
//      context.register(
//        INK_MUSHROOM_PATCH,
//        PlacedFeature(features.getOrThrow(DataboxConfiguredFeatures.INK_MUSHROOM_PATCH), patch(1))
//      )
//      context.register(
//        BLOOD_MUSHROOM_PATCH,
//        PlacedFeature(features.getOrThrow(DataboxConfiguredFeatures.BLOOD_MUSHROOM_PATCH), patch(1))
//      )
//      context.register(
//        UNDERBEAN_BUSH_PATCH,
//        PlacedFeature(features.getOrThrow(DataboxConfiguredFeatures.UNDERBEAN_BUSH_PATCH), patch(5))
//      )
//      context.register(
//        BLISTERBERRY_BUSH_PATCH,
//        PlacedFeature(features.getOrThrow(DataboxConfiguredFeatures.BLISTERBERRY_BUSH_PATCH), patch(5))
//      )
//      context.register(
//        GLOOMGOURD_PATCH,
//        PlacedFeature(features.getOrThrow(DataboxConfiguredFeatures.GLOOMGOURD_PATCH), patch(5))
//      )
//      context.register(
//        DROOPVINE_PATCH,
//        PlacedFeature(features.getOrThrow(DataboxConfiguredFeatures.DROOPVINE), patch(100))
//      )
//      context.register(
//        GLITTERKELP_PATCH,
//        PlacedFeature(
//          features.getOrThrow(DataboxConfiguredFeatures.GLITTERKELP),
//          java.util.List.of<PlacementModifier>(
//            NoiseBasedCountPlacement.of(1000, 80.0, 0.0),
//            InSquarePlacement.spread(),
//            HeightRangePlacement.uniform(VerticalAnchor.bottom(), VerticalAnchor.absolute(31)),
//            BiomeFilter.biome()
//          )
//        )
//      )
//
//      //tree
//      context.register(
//        SMOGSTEM_TREE,
//        PlacedFeature(features.getOrThrow(DataboxConfiguredFeatures.SMOGSTEM_TREE), tree(8))
//      )
//      context.register(
//        WIDE_SMOGSTEM_TREE,
//        PlacedFeature(features.getOrThrow(DataboxConfiguredFeatures.WIDE_SMOGSTEM_TREE), tree(2))
//      )
//      context.register(
//        TALL_SMOGSTEM_TREE,
//        PlacedFeature(features.getOrThrow(DataboxConfiguredFeatures.TALL_SMOGSTEM_TREE), tree(4))
//      )
//      context.register(
//        SMOGSTEM_BUSH,
//        PlacedFeature(features.getOrThrow(DataboxConfiguredFeatures.SMOGSTEM_BUSH), tree(8))
//      )
//      context.register(
//        WIGGLEWOOD_TREE,
//        PlacedFeature(features.getOrThrow(DataboxConfiguredFeatures.WIGGLEWOOD_TREE), tree(8))
//      )
//      context.register(
//        TALL_WIGGLEWOOD_TREE,
//        PlacedFeature(features.getOrThrow(DataboxConfiguredFeatures.TALL_WIGGLEWOOD_TREE), tree(4))
//      )
//      context.register(
//        GRONGLE_TREE,
//        PlacedFeature(features.getOrThrow(DataboxConfiguredFeatures.GRONGLE_TREE), tree(8))
//      )
//      context.register(
//        SMALL_GRONGLE_TREE,
//        PlacedFeature(features.getOrThrow(DataboxConfiguredFeatures.SMALL_GRONGLE_TREE), tree(8))
//      )
//      context.register(
//        GRONGLE_BUSH,
//        PlacedFeature(features.getOrThrow(DataboxConfiguredFeatures.GRONGLE_BUSH), tree(8))
//      )
//
//      //huge mushrooms
//      context.register(
//        HUGE_INDIGO_MUSHROOM,
//        PlacedFeature(features.getOrThrow(DataboxConfiguredFeatures.HUGE_INDIGO_MUSHROOM), tree(8))
//      )
//      context.register(
//        HUGE_INDIGO_MUSHROOM_SMOGSTEM_FOREST,
//        PlacedFeature(features.getOrThrow(DataboxConfiguredFeatures.HUGE_INDIGO_MUSHROOM), tree(1))
//      )
//      context.register(
//        HUGE_VEIL_MUSHROOM,
//        PlacedFeature(features.getOrThrow(DataboxConfiguredFeatures.HUGE_VEIL_MUSHROOM), tree(8))
//      )
//      context.register(
//        HUGE_INK_MUSHROOM,
//        PlacedFeature(features.getOrThrow(DataboxConfiguredFeatures.HUGE_INK_MUSHROOM), tree(8))
//      )
//      context.register(
//        HUGE_BLOOD_MUSHROOM,
//        PlacedFeature(features.getOrThrow(DataboxConfiguredFeatures.HUGE_BLOOD_MUSHROOM), tree(8))
//      )
//
//      //rocks
//      context.register(
//        DEPTHROCK_ROCK,
//        PlacedFeature(features.getOrThrow(DataboxConfiguredFeatures.DEPTHROCK_ROCK), patch(5))
//      )
//      context.register(
//        SHIVERSTONE_ROCK,
//        PlacedFeature(features.getOrThrow(DataboxConfiguredFeatures.SHIVERSTONE_ROCK), patch(5))
//      )
//
//      //misc
//      context.register(SMOG_VENT, PlacedFeature(features.getOrThrow(DataboxConfiguredFeatures.SMOG_VENT), tree(8)))
//      context.register(ICE_PILLAR, PlacedFeature(features.getOrThrow(DataboxConfiguredFeatures.ICE_PILLAR), patch(50)))
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