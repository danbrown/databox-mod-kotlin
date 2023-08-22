package com.dannbrown.databox.datagen

import com.dannbrown.databox.init.DataboxBlocks
import com.dannbrown.databox.lib.LibUtils
import com.google.common.collect.ImmutableList
import net.minecraft.core.registries.Registries
import net.minecraft.data.worldgen.BootstapContext
import net.minecraft.resources.ResourceKey
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature
import net.minecraft.world.level.levelgen.feature.Feature
import net.minecraft.world.level.levelgen.feature.configurations.*
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration.TargetBlockState
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest


class DataboxConfiguredFeatures {
  companion object {
    // ore tags
    val BASALT_ORE_REPLACEABLES: RuleTest = TagMatchTest(DataboxTags.Blocks.BASALT_ORE_REPLACEABLES)

    // ores
    val ADAMANTIUM_ORE = create("adamantium_ore")

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
                DataboxBlocks.ADAMANTIUM_ORE.get().defaultBlockState()
              ),
              OreConfiguration.target(
                BASALT_ORE_REPLACEABLES,
                DataboxBlocks.ADAMANTIUM_ORE.get().defaultBlockState()
              )
            ), 17
          )
        )
      )
    }
  }
}