package com.dannbrown.databox.datagen

import com.dannbrown.databox.init.DataboxBlocks
import com.dannbrown.databox.lib.LibUtils
import net.minecraft.core.Holder
import net.minecraft.core.registries.Registries
import net.minecraft.data.worldgen.BootstapContext
import net.minecraft.resources.ResourceKey
import net.minecraft.resources.ResourceLocation
import net.minecraft.tags.BlockTags
import net.minecraft.util.valueproviders.UniformInt
import net.minecraft.world.level.biome.BiomeSources
import net.minecraft.world.level.biome.Biomes
import net.minecraft.world.level.biome.Climate.ParameterPoint
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.dimension.DimensionType
import net.minecraft.world.level.dimension.DimensionType.MonsterSettings
import net.minecraft.world.level.dimension.LevelStem
import net.minecraft.world.level.levelgen.*
import net.minecraft.world.level.levelgen.placement.CaveSurface
import net.minecraft.world.level.levelgen.synth.BlendedNoise
import java.util.*


object DataboxDimensions {
//  val DATABOX_LEVEL = ResourceKey.create(Registries.DIMENSION, LibUtils.resourceLocation("databox"))
////  val DATABOX_NOISE_GEN = ResourceKey.create(Registries.NOISE_SETTINGS, LibUtils.resourceLocation("databox"))
//  val DATABOX_DIM_TYPE = ResourceKey.create(Registries.DIMENSION_TYPE, LibUtils.resourceLocation("databox"))
//  val DATABOX_LEVEL_STEM = ResourceKey.create(Registries.LEVEL_STEM, LibUtils.resourceLocation("databox"))
//
//
//  fun bootstrapType(context: BootstapContext<DimensionType>) {
//    context.register(
//      DATABOX_DIM_TYPE, DimensionType(
//        OptionalLong.of(18000L),  //fixed time
//        false,  //skylight
//        true,  //ceiling
//        false,  //ultrawarm
//        true,  //natural
//        4.0,  //coordinate scale
//        true,  //bed works
//        false,  //respawn anchor works
//        0,  // Minimum Y Level
//        128,  // Height + Min Y = Max Y
//        128,  // Logical Height
//        BlockTags.INFINIBURN_OVERWORLD,  //infiniburn
//        LibUtils.resourceLocation("databox"),  // DimensionRenderInfo
//        0.1f,  // ambient light
//        MonsterSettings(true, false, UniformInt.of(0, 7), 0)
//      )
//    )
//  }
//
//  fun bootstrapStem(context: BootstapContext<LevelStem>) {
//    val biomeRegistry = context.lookup(Registries.BIOME)
//    val dimTypes = context.lookup(Registries.DIMENSION_TYPE)
//    val noiseGenSettings = context.lookup(Registries.NOISE_SETTINGS)
//
//    context.register(
//      DATABOX_LEVEL_STEM,
//        LevelStem(
//            DATABOX_DIM_TYPE,
//            dimTypes.getOrThrow(DATABOX_DIM_TYPE),
//            noiseGenSettings.getOrThrow(NoiseSettings.OVERWORLD),
//            BiomeSources.fixed(Biomes.PLAINS),
//            OptionalLong.of(0L),
//            true,
//            false,
//            false
//        )
//      )
//    )
//  }

//  fun bootstrapNoise(context: BootstapContext<NoiseGeneratorSettings>) {
//    val functions = context.lookup(Registries.DENSITY_FUNCTION)
//
//    val noises = context.lookup(Registries.NOISE)
//    val densityfunction = NoiseRouterData().getFunction(functions, NoiseRouterData.SHIFT_X)
//    val densityfunction1 = NoiseRouterData.getFunction(functions, NoiseRouterData.SHIFT_Z)
//    context.register(
//      DATABOX_NOISE_GEN, NoiseGeneratorSettings(
//        NoiseSettings.create(0, 128, 2, 2),
//        DataboxBlocks.ADAMANTIUM_DEBRIS.get().defaultBlockState(),
//        Blocks.WATER.defaultBlockState(),
//        NoiseRouter(
//          DensityFunctions.zero(),  //barrier
//          DensityFunctions.zero(),  //fluid level floodedness
//          DensityFunctions.zero(),  //fluid level spread
//          DensityFunctions.zero(),  //lava
//          DensityFunctions.shiftedNoise2d(
//            densityfunction,
//            densityfunction1,
//            0.25,
//            noises.getOrThrow(Noises.TEMPERATURE)
//          ),  //temperature
//          DensityFunctions.shiftedNoise2d(
//            densityfunction,
//            densityfunction1,
//            0.25,
//            noises.getOrThrow(Noises.VEGETATION)
//          ),  //vegetation
//          NoiseRouterData.CONTINENTS,
//          NoiseRouterData.getFunction(functions, NoiseRouterData.EROSION),  //erosion
//          DensityFunctions.rangeChoice(
//            NoiseRouterData.getFunction(functions, NoiseRouterData.Y),
//            0.0,
//            32.0,
//            DensityFunctions.constant(2.0),
//            DensityFunctions.constant(-2.0)
//          ),  //depth
//          NoiseRouterData.getFunction(functions, NoiseRouterData.RIDGES),  //ridges
//          DensityFunctions.zero(),  //initial density
//          DensityFunctions.mul(
//            DensityFunctions.constant(0.64),
//            DensityFunctions.interpolated(
//              DensityFunctions.blendDensity(
//                DensityFunctions.add(
//                  DensityFunctions.constant(2.5),
//                  DensityFunctions.mul(
//                    DensityFunctions.yClampedGradient(-8, 24, 0.0, 1.0),
//                    DensityFunctions.add(
//                      DensityFunctions.constant(-2.5),
//                      DensityFunctions.add(
//                        DensityFunctions.constant(0.5),
//                        DensityFunctions.mul(
//                          DensityFunctions.yClampedGradient(110, 128, 1.0, 0.0),
//                          DensityFunctions.add(
//                            DensityFunctions.constant(-0.5),
//                            BlendedNoise.createUnseeded(0.1, 0.3, 80.0, 60.0, 1.0)
//                          )
//                        )
//                      )
//                    )
//                  )
//                )
//              )
//            )
//          ).squeeze(),  //final density
//          DensityFunctions.zero(),  //vein toggle
//          DensityFunctions.zero(),  //vein ridged
//          DensityFunctions.zero() //vein gap
//        ),
//        SurfaceRules.sequence( //bedrock floor
//          SurfaceRules.ifTrue(
//            SurfaceRules.verticalGradient(
//              "minecraft:bedrock_floor",
//              VerticalAnchor.bottom(),
//              VerticalAnchor.aboveBottom(5)
//            ), SurfaceRules.state(
//              Blocks.BEDROCK.defaultBlockState()
//            )
//          ),  //bedrock ceiling
//          SurfaceRules.ifTrue(
//            SurfaceRules.not(
//              SurfaceRules.verticalGradient(
//                "minecraft:bedrock_roof",
//                VerticalAnchor.belowTop(5),
//                VerticalAnchor.top()
//              )
//            ), SurfaceRules.state(
//              Blocks.BEDROCK.defaultBlockState()
//            )
//          ),  //filler depthrock
//          SurfaceRules.ifTrue(
//            SurfaceRules.yBlockCheck(VerticalAnchor.belowTop(5), 0),
//            SurfaceRules.state(UGBlocks.DEPTHROCK.get().defaultBlockState())
//          ),  //sediment
//          SurfaceRules.ifTrue(
//            SurfaceRules.stoneDepthCheck(0, true, CaveSurface.FLOOR),
//            SurfaceRules.ifTrue(
//              SurfaceRules.not(SurfaceRules.yBlockCheck(VerticalAnchor.absolute(33), 0)),
//              SurfaceRules.state(UGBlocks.SEDIMENT.get().defaultBlockState())
//            )
//          ),  //frozen deepturf
//          SurfaceRules.ifTrue(
//            SurfaceRules.isBiome(UGBiomes.FROSTFIELDS, UGBiomes.ICY_SEA), SurfaceRules.ifTrue(
//              SurfaceRules.stoneDepthCheck(0, false, CaveSurface.FLOOR),
//              SurfaceRules.state(UGBlocks.FROZEN_DEEPTURF_BLOCK.get().defaultBlockState())
//            )
//          ),  //mix coarse deepsoil into blood bog
//          SurfaceRules.ifTrue(
//            SurfaceRules.isBiome(UGBiomes.BLOOD_MUSHROOM_BOG),
//            SurfaceRules.ifTrue(
//              SurfaceRules.stoneDepthCheck(0, true, 0, CaveSurface.FLOOR),
//              SurfaceRules.sequence(
//                SurfaceRules.ifTrue(
//                  SurfaceRules.noiseCondition(noises.getOrThrow(Noises.NETHER_STATE_SELECTOR).key(), 0.0, 1.8),
//                  SurfaceRules.state(UGBlocks.COARSE_DEEPSOIL.get().defaultBlockState())
//                ),
//                SurfaceRules.ifTrue(
//                  SurfaceRules.stoneDepthCheck(0, false, 0, CaveSurface.FLOOR),
//                  SurfaceRules.state(UGBlocks.DEEPTURF_BLOCK.get().defaultBlockState())
//                )
//              )
//            )
//          ),  //mix coarse deepsoil into smog spires
//          SurfaceRules.ifTrue(
//            SurfaceRules.isBiome(UGBiomes.SMOG_SPIRES),
//            SurfaceRules.ifTrue(
//              SurfaceRules.stoneDepthCheck(0, true, 0, CaveSurface.FLOOR),
//              SurfaceRules.sequence(
//                SurfaceRules.ifTrue(
//                  SurfaceRules.noiseCondition(noises.getOrThrow(Noises.NETHER_STATE_SELECTOR).key(), 0.0, 1.8),
//                  SurfaceRules.state(UGBlocks.COARSE_DEEPSOIL.get().defaultBlockState())
//                ),
//                SurfaceRules.ifTrue(
//                  SurfaceRules.stoneDepthCheck(0, false, 0, CaveSurface.FLOOR),
//                  SurfaceRules.state(UGBlocks.ASHEN_DEEPTURF_BLOCK.get().defaultBlockState())
//                )
//              )
//            )
//          ),  //mix coarse deepsoil into barren biomes
//          SurfaceRules.ifTrue(
//            SurfaceRules.isBiome(UGBiomes.BARREN_ABYSS, UGBiomes.DEAD_SEA),
//            SurfaceRules.ifTrue(
//              SurfaceRules.stoneDepthCheck(0, true, 0, CaveSurface.FLOOR),
//              SurfaceRules.sequence(
//                SurfaceRules.ifTrue(
//                  SurfaceRules.noiseCondition(noises.getOrThrow(Noises.NETHER_STATE_SELECTOR).key(), 0.0, 1.8),
//                  SurfaceRules.state(UGBlocks.COARSE_DEEPSOIL.get().defaultBlockState())
//                ),
//                SurfaceRules.ifTrue(
//                  SurfaceRules.stoneDepthCheck(0, false, 0, CaveSurface.FLOOR),
//                  SurfaceRules.state(UGBlocks.DEPTHROCK.get().defaultBlockState())
//                ),
//                SurfaceRules.state(UGBlocks.DEPTHROCK.get().defaultBlockState())
//              )
//            )
//          ),  //cover the ground in deepturf
//          SurfaceRules.ifTrue(
//            SurfaceRules.stoneDepthCheck(0, false, 0, CaveSurface.FLOOR),
//            SurfaceRules.state(UGBlocks.DEEPTURF_BLOCK.get().defaultBlockState())
//          ),  //add deepsoil underneath
//          SurfaceRules.ifTrue(
//            SurfaceRules.stoneDepthCheck(0, true, 0, CaveSurface.FLOOR),
//            SurfaceRules.state(UGBlocks.DEEPSOIL.get().defaultBlockState())
//          ),  //add shiverstone to icy biomes
//          SurfaceRules.ifTrue(
//            SurfaceRules.isBiome(UGBiomes.FROSTFIELDS, UGBiomes.ICY_SEA),
//            SurfaceRules.state(UGBlocks.SHIVERSTONE.get().defaultBlockState())
//          )
//        ), listOf<ParameterPoint>(),  //spawn targets
//        32,
//        false,
//        false,
//        false,
//        false
//      )
//    )
//  }
//}
}