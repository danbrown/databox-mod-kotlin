package com.dannbrown.databox.init


import com.dannbrown.databox.DataboxMod
import com.dannbrown.databox.lib.LibUtils
import com.dannbrown.databox.world.biome.Custom1Biome
import net.minecraft.core.registries.Registries
import net.minecraft.data.worldgen.BootstapContext
import net.minecraft.resources.ResourceKey
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.level.biome.Biome


class DataboxBiomes {
  companion object {
    val CUSTOM_BIOME_1: ResourceKey<Biome> = createKey("custom_biome_1")

    fun bootstrap(context: BootstapContext<Biome>) {
      val placedFeatures = context.lookup(Registries.PLACED_FEATURE)
      val worldCarvers = context.lookup(Registries.CONFIGURED_CARVER)
      context.register(CUSTOM_BIOME_1, Custom1Biome.createBiome(placedFeatures, worldCarvers))
    }

    private fun createKey(name: String): ResourceKey<Biome> {
      return ResourceKey.create(Registries.BIOME, LibUtils.resourceLocation(name))
    }
  }
}

