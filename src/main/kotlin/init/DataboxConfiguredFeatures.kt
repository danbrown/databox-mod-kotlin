package com.dannbrown.databox.init

import com.dannbrown.databox.lib.LibUtils
import com.google.common.collect.ImmutableList
import net.minecraft.core.registries.Registries
import net.minecraft.data.worldgen.BootstapContext
import net.minecraft.data.worldgen.features.FeatureUtils
import net.minecraft.data.worldgen.placement.PlacementUtils
import net.minecraft.resources.ResourceKey
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature
import net.minecraft.world.level.levelgen.feature.Feature
import net.minecraft.world.level.levelgen.feature.configurations.*
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration.TargetBlockState
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest


class DataboxConfiguredFeatures {
  companion object {
    //ore tags
    val BASE_STONE_UNDERGARDEN: RuleTest = TagMatchTest(DataboxTags.Blocks.BASE_STONE_UNDERGARDEN)
    val DEPTHROCK_ORE_REPLACEABLES: RuleTest = TagMatchTest(DataboxTags.Blocks.DEPTHROCK_ORE_REPLACEABLES)
    val SHIVERSTONE_ORE_REPLACEABLES: RuleTest = TagMatchTest(DataboxTags.Blocks.SHIVERSTONE_ORE_REPLACEABLES)
    val TREMBLECRUST_ORE_REPLACEABLES: RuleTest = TagMatchTest(DataboxTags.Blocks.TREMBLECRUST_ORE_REPLACEABLES)
    val BASALT_ORE_REPLACEABLES: RuleTest = TagMatchTest(DataboxTags.Blocks.BASALT_ORE_REPLACEABLES)

    //ores
    val ADAMANTIUM_ORE = create("adamantium_ore")
//    val IRON_ORE = createConfiguredFeature("iron_ore")
//    val GOLD_ORE = createConfiguredFeature("gold_ore")
//    val DIAMOND_ORE = createConfiguredFeature("diamond_ore")
//    val CLOGGRUM_ORE = createConfiguredFeature("cloggrum_ore")
//    val FROSTSTEEL_ORE = createConfiguredFeature("froststeel_ore")
//    val UTHERIUM_ORE = createConfiguredFeature("utherium_ore")
//    val REGALIUM_ORE = createConfiguredFeature("regalium_ore")
//    val SHIVERSTONE_ORE = createConfiguredFeature("shiverstone_ore")
//    val DEEPSOIL_ORE = createConfiguredFeature("deepsoil_ore")
//    val ICE_ORE = createConfiguredFeature("ice_ore")
//    val SEDIMENT_ORE = createConfiguredFeature("sediment_ore")

    //deltas
//    val BOG_DELTA = createConfiguredFeature("bog_delta")
//    val GRONGLEGROWTH_DELTA = createConfiguredFeature("gronglegrowth_delta")

//    //vegetation
//    val AMOROUS_BRISTLE_PATCH = createConfiguredFeature("amorous_bristle_patch")
//    val MISERABELL_PATCH = createConfiguredFeature("miserabell_patch")
//    val BUTTERBUNCH_PATCH = createConfiguredFeature("butterbunch_patch")
//    val DEEPTURF_PATCH = createConfiguredFeature("deepturf_patch")
//    val ASHEN_DEEPTURF_PATCH = createConfiguredFeature("ashen_deepturf_patch")
//    val FROZEN_DEEPTURF_PATCH = createConfiguredFeature("frozen_deepturf_patch")
//    val SHIMMERWEED_PATCH = createConfiguredFeature("shimmerweed_patch")
//    val DEPTHROCK_PEBBLE_PATCH = createConfiguredFeature("depthrock_pebble_patch")
//    val DITCHBULB_PATCH = createConfiguredFeature("ditchbulb_patch")
//    val TALL_DEEPTURF_PATCH = createConfiguredFeature("tall_deepturf_patch")
//    val TALL_SHIMMERWEED_PATCH = createConfiguredFeature("tall_shimmerweed_patch")
//    val INDIGO_MUSHROOM_PATCH = createConfiguredFeature("indigo_mushroom_patch")
//    val VEIL_MUSHROOM_PATCH = createConfiguredFeature("veil_mushroom_patch")
//    val INK_MUSHROOM_PATCH = createConfiguredFeature("ink_mushroom_patch")
//    val BLOOD_MUSHROOM_PATCH = createConfiguredFeature("blood_mushroom_patch")
//    val UNDERBEAN_BUSH_PATCH = createConfiguredFeature("underbean_bush_patch")
//    val BLISTERBERRY_BUSH_PATCH = createConfiguredFeature("blisterberry_bush_patch")
//    val GLOOMGOURD_PATCH = createConfiguredFeature("gloomgourd_patch")
//    val DROOPVINE = createConfiguredFeature("droopvine")
//    val GLITTERKELP = createConfiguredFeature("glitterkelp")
//
//    //tree
//    val SMOGSTEM_TREE = createConfiguredFeature("smogstem_tree")
//    val WIDE_SMOGSTEM_TREE = createConfiguredFeature("wide_smogstem_tree")
//    val TALL_SMOGSTEM_TREE = createConfiguredFeature("tall_smogstem_tree")
//    val SMOGSTEM_BUSH = createConfiguredFeature("smogstem_bush")
//    val WIGGLEWOOD_TREE = createConfiguredFeature("wigglewood_tree")
//    val TALL_WIGGLEWOOD_TREE = createConfiguredFeature("tall_wigglewood_tree")
//    val GRONGLE_TREE = createConfiguredFeature("grongle_tree")
//    val SMALL_GRONGLE_TREE = createConfiguredFeature("small_grongle_tree")
//    val GRONGLE_BUSH = createConfiguredFeature("grongle_bush")
//
//    //huge mushrooms
//    val HUGE_INDIGO_MUSHROOM = createConfiguredFeature("huge_indigo_mushroom")
//    val HUGE_VEIL_MUSHROOM = createConfiguredFeature("huge_veil_mushroom")
//    val HUGE_INK_MUSHROOM = createConfiguredFeature("huge_ink_mushroom")
//    val HUGE_BLOOD_MUSHROOM = createConfiguredFeature("huge_blood_mushroom")
//
//    //rocks
//    val DEPTHROCK_ROCK = createConfiguredFeature("depthrock_rock")
//    val SHIVERSTONE_ROCK = createConfiguredFeature("shiverstone_rock")
//
//    //misc
//    val SMOG_VENT = createConfiguredFeature("smog_vent")
//    val ICE_PILLAR = createConfiguredFeature("ice_pillar")

    fun create(name: String): ResourceKey<ConfiguredFeature<*, *>> {
      return ResourceKey.create(
        Registries.CONFIGURED_FEATURE,
        LibUtils.resourceLocation(name)
      )
    }

    fun bootstrap(context: BootstapContext<ConfiguredFeature<*, *>>) {
      context.register(
        ADAMANTIUM_ORE, ConfiguredFeature<OreConfiguration, Feature<OreConfiguration>>(
          Feature.ORE, OreConfiguration(
            ImmutableList.of<TargetBlockState>(
              OreConfiguration.target(
                BASALT_ORE_REPLACEABLES,
                DataboxBlocks.ADAMANTIUM_ORE.defaultBlockState()
              ),
              OreConfiguration.target(
                BASALT_ORE_REPLACEABLES,
                DataboxBlocks.ADAMANTIUM_ORE.defaultBlockState()
              )
            ), 17
          )
        )
      )
//      context.register(
//        IRON_ORE, ConfiguredFeature<OreConfiguration, Feature<OreConfiguration>>(
//          Feature.ORE, OreConfiguration(
//            ImmutableList.of<TargetBlockState>(
//              OreConfiguration.target(
//                DEPTHROCK_ORE_REPLACEABLES,
//                UGBlocks.DEPTHROCK_IRON_ORE.get().defaultBlockState()
//              ),
//              OreConfiguration.target(
//                SHIVERSTONE_ORE_REPLACEABLES,
//                UGBlocks.SHIVERSTONE_IRON_ORE.get().defaultBlockState()
//              )
//            ), 9, 0.5f
//          )
//        )
//      )
//      context.register(
//        GOLD_ORE, ConfiguredFeature<OreConfiguration, Feature<OreConfiguration>>(
//          Feature.ORE, OreConfiguration(
//            ImmutableList.of<TargetBlockState>(
//              OreConfiguration.target(
//                DEPTHROCK_ORE_REPLACEABLES,
//                UGBlocks.DEPTHROCK_GOLD_ORE.get().defaultBlockState()
//              )
//            ), 9, 0.5f
//          )
//        )
//      )
//      context.register(
//        DIAMOND_ORE, ConfiguredFeature<OreConfiguration, Feature<OreConfiguration>>(
//          Feature.ORE, OreConfiguration(
//            ImmutableList.of<TargetBlockState>(
//              OreConfiguration.target(
//                DEPTHROCK_ORE_REPLACEABLES,
//                UGBlocks.DEPTHROCK_DIAMOND_ORE.get().defaultBlockState()
//              ),
//              OreConfiguration.target(
//                SHIVERSTONE_ORE_REPLACEABLES,
//                UGBlocks.SHIVERSTONE_DIAMOND_ORE.get().defaultBlockState()
//              )
//            ), 8, 0.5f
//          )
//        )
//      )
//      context.register(
//        CLOGGRUM_ORE, ConfiguredFeature<OreConfiguration, Feature<OreConfiguration>>(
//          Feature.ORE, OreConfiguration(
//            ImmutableList.of<TargetBlockState>(
//              OreConfiguration.target(
//                DEPTHROCK_ORE_REPLACEABLES,
//                UGBlocks.DEPTHROCK_CLOGGRUM_ORE.get().defaultBlockState()
//              ),
//              OreConfiguration.target(
//                SHIVERSTONE_ORE_REPLACEABLES,
//                UGBlocks.SHIVERSTONE_CLOGGRUM_ORE.get().defaultBlockState()
//              )
//            ), 9
//          )
//        )
//      )
//      context.register(
//        FROSTSTEEL_ORE, ConfiguredFeature<OreConfiguration, Feature<OreConfiguration>>(
//          Feature.ORE, OreConfiguration(
//            ImmutableList.of<TargetBlockState>(
//              OreConfiguration.target(
//                SHIVERSTONE_ORE_REPLACEABLES,
//                UGBlocks.SHIVERSTONE_FROSTSTEEL_ORE.get().defaultBlockState()
//              )
//            ), 9
//          )
//        )
//      )
//      context.register(
//        UTHERIUM_ORE, ConfiguredFeature<OreConfiguration, Feature<OreConfiguration>>(
//          Feature.ORE, OreConfiguration(
//            ImmutableList.of<TargetBlockState>(
//              OreConfiguration.target(
//                DEPTHROCK_ORE_REPLACEABLES,
//                UGBlocks.DEPTHROCK_UTHERIUM_ORE.get().defaultBlockState()
//              ),
//              OreConfiguration.target(
//                SHIVERSTONE_ORE_REPLACEABLES,
//                UGBlocks.SHIVERSTONE_UTHERIUM_ORE.get().defaultBlockState()
//              ),
//              OreConfiguration.target(
//                TREMBLECRUST_ORE_REPLACEABLES,
//                UGBlocks.TREMBLECRUST_UTHERIUM_ORE.get().defaultBlockState()
//              )
//            ), 8, 0.5f
//          )
//        )
//      )
//      context.register(
//        REGALIUM_ORE, ConfiguredFeature<OreConfiguration, Feature<OreConfiguration>>(
//          Feature.ORE, OreConfiguration(
//            ImmutableList.of<TargetBlockState>(
//              OreConfiguration.target(
//                DEPTHROCK_ORE_REPLACEABLES,
//                UGBlocks.DEPTHROCK_REGALIUM_ORE.get().defaultBlockState()
//              ),
//              OreConfiguration.target(
//                SHIVERSTONE_ORE_REPLACEABLES,
//                UGBlocks.SHIVERSTONE_REGALIUM_ORE.get().defaultBlockState()
//              )
//            ), 4
//          )
//        )
//      )
//      context.register(
//        SHIVERSTONE_ORE,
//        ConfiguredFeature<OreConfiguration, Feature<OreConfiguration>>(
//          Feature.ORE,
//          OreConfiguration(BASE_STONE_UNDERGARDEN, UGBlocks.SHIVERSTONE.get().defaultBlockState(), 33)
//        )
//      )
//      context.register(
//        DEEPSOIL_ORE,
//        ConfiguredFeature<OreConfiguration, Feature<OreConfiguration>>(
//          Feature.ORE,
//          OreConfiguration(BASE_STONE_UNDERGARDEN, UGBlocks.DEEPSOIL.get().defaultBlockState(), 33)
//        )
//      )
//      context.register(
//        ICE_ORE,
//        ConfiguredFeature<OreConfiguration, Feature<OreConfiguration>>(
//          Feature.ORE,
//          OreConfiguration(BASE_STONE_UNDERGARDEN, Blocks.PACKED_ICE.defaultBlockState(), 33)
//        )
//      )
//      context.register(
//        SEDIMENT_ORE,
//        ConfiguredFeature<OreConfiguration, Feature<OreConfiguration>>(
//          Feature.ORE,
//          OreConfiguration(BASE_STONE_UNDERGARDEN, UGBlocks.SEDIMENT.get().defaultBlockState(), 33)
//        )
//      )
//
//      //deltas
//      context.register(
//        BOG_DELTA,
//        ConfiguredFeature<FC, F>(
//          UGFeatures.DELTA.get(),
//          DeltaFeatureConfiguration(
//            UGBlocks.VIRULENT_MIX.get().defaultBlockState(),
//            UGBlocks.COARSE_DEEPSOIL.get().defaultBlockState(),
//            UniformInt.of(6, 8),
//            UniformInt.of(2, 4)
//          )
//        )
//      )
//      context.register(
//        GRONGLEGROWTH_DELTA,
//        ConfiguredFeature<FC, F>(
//          UGFeatures.DELTA.get(),
//          DeltaFeatureConfiguration(
//            Blocks.WATER.defaultBlockState(),
//            UGBlocks.SEDIMENT.get().defaultBlockState(),
//            UniformInt.of(3, 4),
//            UniformInt.of(2, 4)
//          )
//        )
//      )
//
//      //vegetation
//      context.register(
//        AMOROUS_BRISTLE_PATCH,
//        ConfiguredFeature<RandomPatchConfiguration, Feature<RandomPatchConfiguration>>(
//          Feature.FLOWER,
//          patch(UGBlocks.AMOROUS_BRISTLE.get(), 64)
//        )
//      )
//      context.register(
//        MISERABELL_PATCH,
//        ConfiguredFeature<RandomPatchConfiguration, Feature<RandomPatchConfiguration>>(
//          Feature.FLOWER,
//          patch(UGBlocks.MISERABELL.get(), 64)
//        )
//      )
//      context.register(
//        BUTTERBUNCH_PATCH,
//        ConfiguredFeature<RandomPatchConfiguration, Feature<RandomPatchConfiguration>>(
//          Feature.FLOWER,
//          patch(UGBlocks.BUTTERBUNCH.get(), 64)
//        )
//      )
//      context.register(
//        DEEPTURF_PATCH,
//        ConfiguredFeature<RandomPatchConfiguration, Feature<RandomPatchConfiguration>>(
//          Feature.RANDOM_PATCH,
//          patch(UGBlocks.DEEPTURF.get(), 64)
//        )
//      )
//      context.register(
//        ASHEN_DEEPTURF_PATCH,
//        ConfiguredFeature<RandomPatchConfiguration, Feature<RandomPatchConfiguration>>(
//          Feature.RANDOM_PATCH,
//          patch(UGBlocks.ASHEN_DEEPTURF.get(), 64)
//        )
//      )
//      context.register(
//        FROZEN_DEEPTURF_PATCH,
//        ConfiguredFeature<RandomPatchConfiguration, Feature<RandomPatchConfiguration>>(
//          Feature.RANDOM_PATCH,
//          patch(UGBlocks.FROZEN_DEEPTURF.get(), 64)
//        )
//      )
//      context.register(
//        SHIMMERWEED_PATCH,
//        ConfiguredFeature<RandomPatchConfiguration, Feature<RandomPatchConfiguration>>(
//          Feature.RANDOM_PATCH,
//          patch(UGBlocks.SHIMMERWEED.get(), 32)
//        )
//      )
//      context.register(
//        DEPTHROCK_PEBBLE_PATCH,
//        ConfiguredFeature<RandomPatchConfiguration, Feature<RandomPatchConfiguration>>(
//          Feature.RANDOM_PATCH,
//          pebble(
//            UGBlocks.DEPTHROCK_PEBBLES.get(),
//            java.util.List.of(
//              UGBlocks.DEEPTURF_BLOCK.get(),
//              UGBlocks.ASHEN_DEEPTURF_BLOCK.get(),
//              UGBlocks.DEPTHROCK.get(),
//              UGBlocks.SHIVERSTONE.get(),
//              UGBlocks.SEDIMENT.get(),
//              UGBlocks.COARSE_DEEPSOIL.get()
//            )
//          )
//        )
//      )
//      context.register(
//        DITCHBULB_PATCH,
//        ConfiguredFeature<FC, F>(
//          Feature.RANDOM_PATCH,
//          patch(
//            UGBlocks.DITCHBULB_PLANT.get().defaultBlockState().setValue(DitchbulbBlock.AGE, 1),
//            16,
//            java.util.List.of(UGBlocks.DEPTHROCK.get())
//          )
//        )
//      )
//      context.register(
//        TALL_DEEPTURF_PATCH,
//        ConfiguredFeature<RandomPatchConfiguration, Feature<RandomPatchConfiguration>>(
//          Feature.RANDOM_PATCH,
//          patch(UGBlocks.TALL_DEEPTURF.get(), 32)
//        )
//      )
//      context.register(
//        TALL_SHIMMERWEED_PATCH,
//        ConfiguredFeature<RandomPatchConfiguration, Feature<RandomPatchConfiguration>>(
//          Feature.RANDOM_PATCH,
//          patch(UGBlocks.TALL_SHIMMERWEED.get(), 32)
//        )
//      )
//      context.register(
//        INDIGO_MUSHROOM_PATCH,
//        ConfiguredFeature<RandomPatchConfiguration, Feature<RandomPatchConfiguration>>(
//          Feature.RANDOM_PATCH,
//          patch(UGBlocks.INDIGO_MUSHROOM.get(), 64)
//        )
//      )
//      context.register(
//        VEIL_MUSHROOM_PATCH,
//        ConfiguredFeature<RandomPatchConfiguration, Feature<RandomPatchConfiguration>>(
//          Feature.RANDOM_PATCH,
//          patch(UGBlocks.VEIL_MUSHROOM.get(), 64)
//        )
//      )
//      context.register(
//        INK_MUSHROOM_PATCH,
//        ConfiguredFeature<RandomPatchConfiguration, Feature<RandomPatchConfiguration>>(
//          Feature.RANDOM_PATCH,
//          patch(UGBlocks.INK_MUSHROOM.get(), 64)
//        )
//      )
//      context.register(
//        BLOOD_MUSHROOM_PATCH,
//        ConfiguredFeature<RandomPatchConfiguration, Feature<RandomPatchConfiguration>>(
//          Feature.RANDOM_PATCH,
//          patch(UGBlocks.BLOOD_MUSHROOM.get(), 64)
//        )
//      )
//      context.register(
//        UNDERBEAN_BUSH_PATCH,
//        ConfiguredFeature<FC, F>(
//          Feature.RANDOM_PATCH,
//          patch(
//            UGBlocks.UNDERBEAN_BUSH.get().defaultBlockState().setValue(UnderbeanBushBlock.AGE, 3),
//            64,
//            java.util.List.of(UGBlocks.DEEPTURF_BLOCK.get())
//          )
//        )
//      )
//      context.register(
//        BLISTERBERRY_BUSH_PATCH,
//        ConfiguredFeature<FC, F>(
//          Feature.RANDOM_PATCH,
//          patch(
//            UGBlocks.BLISTERBERRY_BUSH.get().defaultBlockState().setValue(BlisterberryBushBlock.AGE, 3),
//            64,
//            java.util.List.of(UGBlocks.ASHEN_DEEPTURF_BLOCK.get())
//          )
//        )
//      )
//      context.register(
//        GLOOMGOURD_PATCH,
//        ConfiguredFeature<FC, F>(
//          Feature.RANDOM_PATCH,
//          patch(UGBlocks.GLOOMGOURD.get(), 16, java.util.List.of(UGBlocks.DEEPTURF_BLOCK.get()))
//        )
//      )
//      context.register(DROOPVINE, ConfiguredFeature<FC, F>(UGFeatures.DROOPVINE.get(), FeatureConfiguration.NONE))
//      context.register(GLITTERKELP, ConfiguredFeature<FC, F>(UGFeatures.GLITTERKELP.get(), FeatureConfiguration.NONE))
//
//      //tree
//      context.register(
//        SMOGSTEM_TREE,
//        ConfiguredFeature<TreeConfiguration, Feature<TreeConfiguration>>(
//          Feature.TREE,
//          TreeConfigurationBuilder(
//            BlockStateProvider.simple(UGBlocks.SMOGSTEM_LOG.get()),
//            SmogstemTrunkPlacer(10, 2, 2, 1),
//            BlockStateProvider.simple(UGBlocks.SMOGSTEM_LEAVES.get()),
//            BlobFoliagePlacer(ConstantInt.of(3), ConstantInt.of(0), 2),
//            TwoLayersFeatureSize(1, 1, 2)
//          ).ignoreVines().dirt(BlockStateProvider.simple(UGBlocks.DEEPSOIL.get())).build()
//        )
//      )
//      context.register(
//        WIDE_SMOGSTEM_TREE,
//        ConfiguredFeature<TreeConfiguration, Feature<TreeConfiguration>>(
//          Feature.TREE,
//          TreeConfigurationBuilder(
//            BlockStateProvider.simple(UGBlocks.SMOGSTEM_LOG.get()),
//            SmogstemTrunkPlacer(10, 2, 2, 2),
//            BlockStateProvider.simple(UGBlocks.SMOGSTEM_LEAVES.get()),
//            BlobFoliagePlacer(ConstantInt.of(3), ConstantInt.of(0), 2),
//            TwoLayersFeatureSize(1, 1, 2)
//          ).ignoreVines().dirt(BlockStateProvider.simple(UGBlocks.DEEPSOIL.get())).build()
//        )
//      )
//      context.register(
//        TALL_SMOGSTEM_TREE,
//        ConfiguredFeature<TreeConfiguration, Feature<TreeConfiguration>>(
//          Feature.TREE,
//          TreeConfigurationBuilder(
//            BlockStateProvider.simple(UGBlocks.SMOGSTEM_LOG.get()),
//            SmogstemTrunkPlacer(15, 4, 4, 2),
//            BlockStateProvider.simple(UGBlocks.SMOGSTEM_LEAVES.get()),
//            BlobFoliagePlacer(ConstantInt.of(3), ConstantInt.of(0), 2),
//            TwoLayersFeatureSize(1, 1, 2)
//          ).ignoreVines().dirt(BlockStateProvider.simple(UGBlocks.DEEPSOIL.get())).build()
//        )
//      )
//      context.register(
//        SMOGSTEM_BUSH,
//        ConfiguredFeature<TreeConfiguration, Feature<TreeConfiguration>>(
//          Feature.TREE,
//          TreeConfigurationBuilder(
//            BlockStateProvider.simple(UGBlocks.SMOGSTEM_LOG.get()),
//            StraightTrunkPlacer(1, 0, 0),
//            BlockStateProvider.simple(UGBlocks.SMOGSTEM_LEAVES.get()),
//            BushFoliagePlacer(ConstantInt.of(2), ConstantInt.of(1), 2),
//            TwoLayersFeatureSize(0, 0, 0)
//          ).ignoreVines().dirt(BlockStateProvider.simple(UGBlocks.DEEPSOIL.get())).build()
//        )
//      )
//      context.register(
//        WIGGLEWOOD_TREE,
//        ConfiguredFeature<TreeConfiguration, Feature<TreeConfiguration>>(
//          Feature.TREE,
//          TreeConfigurationBuilder(
//            BlockStateProvider.simple(UGBlocks.WIGGLEWOOD_LOG.get()),
//            ForkingTrunkPlacer(3, 1, 1),
//            BlockStateProvider.simple(UGBlocks.WIGGLEWOOD_LEAVES.get()),
//            BushFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 0),
//            TwoLayersFeatureSize(1, 0, 2)
//          ).ignoreVines().dirt(BlockStateProvider.simple(UGBlocks.DEEPSOIL.get())).build()
//        )
//      )
//      context.register(
//        TALL_WIGGLEWOOD_TREE,
//        ConfiguredFeature<TreeConfiguration, Feature<TreeConfiguration>>(
//          Feature.TREE,
//          TreeConfigurationBuilder(
//            BlockStateProvider.simple(UGBlocks.WIGGLEWOOD_LOG.get()),
//            ForkingTrunkPlacer(6, 1, 1),
//            BlockStateProvider.simple(UGBlocks.WIGGLEWOOD_LEAVES.get()),
//            BushFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0), 0),
//            TwoLayersFeatureSize(1, 0, 2)
//          ).ignoreVines().dirt(BlockStateProvider.simple(UGBlocks.DEEPSOIL.get())).build()
//        )
//      )
//      context.register(
//        GRONGLE_TREE, ConfiguredFeature<TreeConfiguration, Feature<TreeConfiguration>>(
//          Feature.TREE,
//          TreeConfigurationBuilder(
//            BlockStateProvider.simple(UGBlocks.GRONGLE_LOG.get()),
//            MegaJungleTrunkPlacer(10, 2, 19),
//            BlockStateProvider.simple(UGBlocks.GRONGLE_LEAVES.get()),
//            DarkOakFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0)),
//            TwoLayersFeatureSize(1, 1, 2)
//          ).ignoreVines().dirt(BlockStateProvider.simple(UGBlocks.DEEPSOIL.get())).decorators(
//            ImmutableList.of<TreeDecorator>(GrongleLeafDecorator.INSTANCE, GrongletTrunkDecorator.INSTANCE)
//          ).build()
//        )
//      )
//      context.register(
//        SMALL_GRONGLE_TREE, ConfiguredFeature<TreeConfiguration, Feature<TreeConfiguration>>(
//          Feature.TREE,
//          TreeConfigurationBuilder(
//            BlockStateProvider.simple(UGBlocks.GRONGLE_LOG.get()),
//            StraightTrunkPlacer(5, 2, 19),
//            BlockStateProvider.simple(UGBlocks.GRONGLE_LEAVES.get()),
//            DarkOakFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0)),
//            TwoLayersFeatureSize(1, 0, 1)
//          ).ignoreVines().dirt(BlockStateProvider.simple(UGBlocks.DEEPSOIL.get())).decorators(
//            ImmutableList.of<TreeDecorator>(GrongleLeafDecorator.INSTANCE, GrongletTrunkDecorator.INSTANCE)
//          ).build()
//        )
//      )
//      context.register(
//        GRONGLE_BUSH,
//        ConfiguredFeature<TreeConfiguration, Feature<TreeConfiguration>>(
//          Feature.TREE,
//          TreeConfigurationBuilder(
//            BlockStateProvider.simple(UGBlocks.GRONGLE_LOG.get()),
//            StraightTrunkPlacer(1, 0, 0),
//            BlockStateProvider.simple(UGBlocks.GRONGLE_LEAVES.get()),
//            DarkOakFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0)),
//            TwoLayersFeatureSize(0, 0, 0)
//          ).ignoreVines().dirt(BlockStateProvider.simple(UGBlocks.DEEPSOIL.get())).build()
//        )
//      )
//
//      //huge mushrooms
//      context.register(
//        HUGE_INDIGO_MUSHROOM,
//        ConfiguredFeature<HugeMushroomFeatureConfiguration, Feature<HugeMushroomFeatureConfiguration>>(
//          Feature.HUGE_BROWN_MUSHROOM,
//          HugeMushroomFeatureConfiguration(
//            BlockStateProvider.simple(
//              UGBlocks.INDIGO_MUSHROOM_CAP.get().defaultBlockState()
//            ), BlockStateProvider.simple(UGBlocks.INDIGO_MUSHROOM_STEM.get().defaultBlockState()), 3
//          )
//        )
//      )
//      context.register(
//        HUGE_VEIL_MUSHROOM,
//        ConfiguredFeature<TreeConfiguration, Feature<TreeConfiguration>>(
//          Feature.TREE,
//          TreeConfigurationBuilder(
//            BlockStateProvider.simple(UGBlocks.VEIL_MUSHROOM_STEM.get()),
//            StraightTrunkPlacer(9, 1, 1),
//            BlockStateProvider.simple(UGBlocks.VEIL_MUSHROOM_CAP.get()),
//            VeilFoliagePlacer(ConstantInt.of(3), ConstantInt.of(0)),
//            TwoLayersFeatureSize(1, 0, 1)
//          ).dirt(BlockStateProvider.simple(UGBlocks.DEEPSOIL.get())).build()
//        )
//      )
//      context.register(
//        HUGE_INK_MUSHROOM, ConfiguredFeature<TreeConfiguration, Feature<TreeConfiguration>>(
//          Feature.TREE,
//          TreeConfigurationBuilder(
//            BlockStateProvider.simple(UGBlocks.INK_MUSHROOM_STEM.get()),
//            SingleForkingTrunkPlacer(6, 2, 2),
//            BlockStateProvider.simple(UGBlocks.INK_MUSHROOM_CAP.get()),
//            AcaciaFoliagePlacer(ConstantInt.of(2), ConstantInt.of(0)),
//            TwoLayersFeatureSize(1, 0, 2)
//          ).dirt(BlockStateProvider.simple(UGBlocks.DEEPSOIL.get())).decorators(
//            ImmutableList.of<TreeDecorator>(
//              AttachedToLeavesDecorator(
//                0.2f,
//                1,
//                0,
//                BlockStateProvider.simple(UGBlocks.SEEPING_INK.get()),
//                1,
//                java.util.List.of<Direction>(Direction.DOWN)
//              )
//            )
//          ).build()
//        )
//      )
//      context.register(
//        HUGE_BLOOD_MUSHROOM, ConfiguredFeature<TreeConfiguration, Feature<TreeConfiguration>>(
//          Feature.TREE,
//          TreeConfigurationBuilder(
//            BlockStateProvider.simple(UGBlocks.BLOOD_MUSHROOM_STEM.get()),
//            DarkOakTrunkPlacer(6, 2, 2),
//            BlockStateProvider.simple(UGBlocks.BLOOD_MUSHROOM_CAP.get()),
//            DarkOakFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0)),
//            ThreeLayersFeatureSize(1, 1, 0, 1, 2, OptionalInt.empty())
//          ).dirt(BlockStateProvider.simple(UGBlocks.DEEPSOIL.get())).decorators(
//            ImmutableList.of<TreeDecorator>(
//              ReplaceLeafDecorator(
//                0.2f,
//                BlockStateProvider.simple(UGBlocks.ENGORGED_BLOOD_MUSHROOM_CAP.get())
//              )
//            )
//          ).build()
//        )
//      )
//
//      //rocks
//      context.register(
//        DEPTHROCK_ROCK,
//        ConfiguredFeature<BlockStateConfiguration, Feature<BlockStateConfiguration>>(
//          Feature.FOREST_ROCK,
//          BlockStateConfiguration(UGBlocks.DEPTHROCK.get().defaultBlockState())
//        )
//      )
//      context.register(
//        SHIVERSTONE_ROCK,
//        ConfiguredFeature<BlockStateConfiguration, Feature<BlockStateConfiguration>>(
//          Feature.FOREST_ROCK,
//          BlockStateConfiguration(UGBlocks.SHIVERSTONE.get().defaultBlockState())
//        )
//      )

    }

//    private fun pebble(block: Block, whitelist: List<Block>): RandomPatchConfiguration {
//      return FeatureUtils.simplePatchConfiguration(
//        Feature.SIMPLE_BLOCK,
//        SimpleBlockConfiguration(
//          RandomizedIntStateProvider(
//            BlockStateProvider.simple(block),
//            DepthrockPebblesBlock.PEBBLES,
//            UniformInt.of(1, 2)
//          )
//        ),
//        whitelist,
//        32
//      )
//    }

//    private fun patch(block: Block, tries: Int): RandomPatchConfiguration {
//      return FeatureUtils.simpleRandomPatchConfiguration(
//        tries,
//        PlacementUtils.onlyWhenEmpty<SimpleBlockConfiguration, Feature<SimpleBlockConfiguration>>(
//          Feature.SIMPLE_BLOCK,
//          SimpleBlockConfiguration(BlockStateProvider.simple(block))
//        )
//      )
//    }
//
//    private fun patch(block: Block, tries: Int, whitelist: List<Block>): RandomPatchConfiguration {
//      return FeatureUtils.simplePatchConfiguration(
//        Feature.SIMPLE_BLOCK,
//        SimpleBlockConfiguration(BlockStateProvider.simple(block)),
//        whitelist,
//        tries
//      )
//    }
//
//    private fun patch(block: BlockState, tries: Int, whitelist: List<Block>): RandomPatchConfiguration {
//      return FeatureUtils.simplePatchConfiguration(
//        Feature.SIMPLE_BLOCK,
//        SimpleBlockConfiguration(BlockStateProvider.simple(block)),
//        whitelist,
//        tries
//      )
//    }
  }
}