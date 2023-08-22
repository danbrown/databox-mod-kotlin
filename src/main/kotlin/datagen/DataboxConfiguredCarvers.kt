package com.dannbrown.databox.datagen

import com.dannbrown.databox.init.DataboxCarvers
import com.dannbrown.databox.lib.LibUtils
import net.minecraft.core.HolderGetter
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.core.registries.Registries
import net.minecraft.data.worldgen.BootstapContext
import net.minecraft.resources.ResourceKey
import net.minecraft.util.valueproviders.ConstantFloat
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.levelgen.VerticalAnchor
import net.minecraft.world.level.levelgen.carver.CaveCarverConfiguration
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver
import net.minecraft.world.level.levelgen.heightproviders.UniformHeight


class DataboxConfiguredCarvers {
  companion object {
    val UNDERGARDEN_CAVE = ResourceKey.create(
      Registries.CONFIGURED_CARVER,
      LibUtils.resourceLocation("undergarden_cave")
    )

    fun bootstrap(context: BootstapContext<ConfiguredWorldCarver<*>>) {
      val blocks: HolderGetter<Block> = context.lookup(Registries.BLOCK)

      context.register(
        UNDERGARDEN_CAVE,
        DataboxCarvers.UNDERGARDEN_CAVE.get().configured(
          CaveCarverConfiguration(
            0.5f,
            UniformHeight.of(VerticalAnchor.aboveBottom(5), VerticalAnchor.belowTop(1)),
            ConstantFloat.of(0.5f),
            VerticalAnchor.aboveBottom(10),
            BuiltInRegistries.BLOCK.getOrCreateTag(DataboxTags.Blocks.DATABOX_CARVER_REPLACEABLES),
            ConstantFloat.of(1.0f),
            ConstantFloat.of(1.0f),
            ConstantFloat.of(-0.7f)
          )
        )
      )
    }
  }
}