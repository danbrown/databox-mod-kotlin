package com.dannbrown.databox.datagen

import com.dannbrown.databox.DataboxMod
import net.minecraft.core.HolderLookup
import net.minecraft.core.RegistryAccess
import net.minecraft.core.RegistrySetBuilder
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.core.registries.Registries
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider
import net.minecraftforge.data.event.GatherDataEvent
import org.apache.logging.log4j.Level
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger


class DataboxRegistries {
  companion object {

    private val LOGGER: Logger = LogManager.getLogger(DataboxMod.MOD_ID)

    fun registerDataProviders(event: GatherDataEvent) {
      val dataGenerator = event.generator
      val output = dataGenerator.packOutput
      val existingFileHelper = event.existingFileHelper
      val lookupProvider = event.lookupProvider.thenApply { obj: HolderLookup.Provider -> createLookup(obj) }

      LOGGER.log(Level.INFO, "${DataboxMod.MOD_ID} is registering data providers!")

      val modIds = mutableSetOf("minecraft", DataboxMod.MOD_ID)
      val datapackEntries = DatapackBuiltinEntriesProvider(output, lookupProvider, modIds)

      dataGenerator.addProvider(event.includeServer(), datapackEntries)
      dataGenerator.addProvider(event.includeServer(), DataboxBiomeTags(output, lookupProvider, existingFileHelper))
    }

    private fun createLookup(vanillaLookupProvider: HolderLookup.Provider): HolderLookup.Provider {
      val registryAccess = RegistryAccess.fromRegistryOfRegistries(BuiltInRegistries.REGISTRY)
      val builder = RegistrySetBuilder()
        .add(Registries.BIOME, DataboxBiomes.Companion::bootstrap)
        .add(Registries.CONFIGURED_FEATURE, DataboxConfiguredFeatures.Companion::bootstrap)
        .add(Registries.CONFIGURED_CARVER, DataboxConfiguredCarvers.Companion::bootstrap)
        .add(Registries.PLACED_FEATURE, DataboxPlacedFeatures::bootstrap)
//        .add(Registries.DIMENSION_TYPE, DataboxDimensions::bootstrapType)
//        .add(Registries.LEVEL_STEM, DataboxDimensions::bootstrapStem)
//        .add(Registries.NOISE_SETTINGS, DataboxDimensions::bootstrapNoise)

      return builder.buildPatch(registryAccess, vanillaLookupProvider)
    }
  }
}

