package com.dannbrown.databox.datagen

import com.dannbrown.databox.DataboxMod
import com.dannbrown.databox.init.DataboxBiomes
import net.minecraft.core.HolderLookup
import net.minecraft.core.RegistrySetBuilder
import net.minecraft.core.registries.Registries
import net.minecraft.data.PackOutput
import net.minecraft.world.level.biome.Biome
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider
import java.util.Set
import java.util.concurrent.CompletableFuture


class WorldGeneration(output: PackOutput?, registries: CompletableFuture<HolderLookup.Provider?>?) :
  DatapackBuiltinEntriesProvider(output, registries, BUILDER, Set.of<String>(DataboxMod.MOD_ID)) {
  companion object {
    val BUILDER = RegistrySetBuilder()
      .add(Registries.BIOME) { ctx ->
        DataboxBiomes.bootstrap(ctx)
      }
  }
}