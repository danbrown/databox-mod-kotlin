package com.dannbrown.databox.datagen

import com.dannbrown.databox.DataboxMod
import com.dannbrown.databox.init.DataboxBiomes
import com.dannbrown.databox.init.DataboxConfiguredCarvers
import com.dannbrown.databox.init.DataboxConfiguredFeatures
import com.dannbrown.databox.init.DataboxPlacedFeatures
import net.minecraft.core.HolderLookup
import net.minecraft.core.Registry
import net.minecraft.core.RegistryAccess
import net.minecraft.core.RegistrySetBuilder
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.core.registries.Registries
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider
import net.minecraftforge.data.event.GatherDataEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod.EventBusSubscriber
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus
import org.apache.logging.log4j.Level
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import thedarkcolour.kotlinforforge.forge.MOD_BUS
import java.util.concurrent.CompletableFuture


class DataboxRegistries {
  companion object {

    private val LOGGER: Logger = LogManager.getLogger(DataboxMod.MOD_ID)

    fun registerDataProviders(event: GatherDataEvent) {
      val dataGenerator = event.generator
      val output = dataGenerator.packOutput
      val existingFileHelper = event.existingFileHelper
      val lookupProvider = event.lookupProvider.thenApply { obj: HolderLookup.Provider -> createLookup(obj) }

      LOGGER.log(Level.INFO, "${DataboxMod.MOD_ID} is registering data providers!")

//    dataGenerator.addProvider(true, TestMod3PackMetadataGenerator.create(output))
//    dataGenerator.addProvider(event.includeClient(), TestMod3LanguageProvider(output))
//    val itemModelProvider = TestMod3ItemModelProvider(output, existingFileHelper)
//    dataGenerator.addProvider(event.includeClient(), itemModelProvider)

      // Let blockstate provider see generated item models by passing its existing file helper
//    dataGenerator.addProvider(event.includeClient(), TestMod3BlockStateProvider(output, itemModelProvider.existingFileHelper))
//    dataGenerator.addProvider(event.includeServer(), TestMod3RecipeProvider(output))
//    dataGenerator.addProvider(event.includeServer(), TestMod3LootTableProvider.create(output))
//    dataGenerator.addProvider(event.includeServer(), TestMod3LootModifierProvider(output))
//    val blockTagsProvider = TestMod3BlockTagsProvider(output, lookupProvider, existingFileHelper)
//    dataGenerator.addProvider(event.includeServer(), blockTagsProvider)
//    dataGenerator.addProvider(event.includeServer(), TestMod3ItemTagsProvider(output, lookupProvider, blockTagsProvider.contentsGetter(), existingFileHelper))
      val modIds = mutableSetOf("minecraft", DataboxMod.MOD_ID)
      val datapackEntries = DatapackBuiltinEntriesProvider(output, lookupProvider, modIds)

      dataGenerator.addProvider(event.includeServer(), datapackEntries)
      dataGenerator.addProvider(event.includeServer(), DataboxBiomeTags(output, lookupProvider, existingFileHelper))
//    dataGenerator.addProvider(
//      event.includeServer(),
//      TestMod3FluidTagsProvider(output, lookupProvider, existingFileHelper)
//    )

    }

    private fun createLookup(vanillaLookupProvider: HolderLookup.Provider): HolderLookup.Provider {
      val registryAccess = RegistryAccess.fromRegistryOfRegistries(BuiltInRegistries.REGISTRY)
      val builder = RegistrySetBuilder()
        .add(Registries.BIOME, DataboxBiomes.Companion::bootstrap)
        .add(Registries.CONFIGURED_FEATURE, DataboxConfiguredFeatures.Companion::bootstrap)
        .add(Registries.CONFIGURED_CARVER, DataboxConfiguredCarvers.Companion::bootstrap)
        .add(Registries.PLACED_FEATURE, DataboxPlacedFeatures::bootstrap)

      return builder.buildPatch(registryAccess, vanillaLookupProvider)


//    val allKeys: Set<ResourceKey<Registry<Any?>?>> = DataPackRegistriesHooks.getDataPackRegistries()
//      .stream()
//      .map { RegistryDataLoader.RegistryData.key() }
//      .collect(Collectors.toSet())
//    val modKeys = java.util.Set.copyOf(builder.entryKeys)
//    val missingKeys: Unit = Sets.difference(allKeys, modKeys)
//    missingKeys.forEach { key ->
//      builder.add(
//        ResourceKey.create(ResourceKey.createRegistryKey(key.registry()), key.location()),
//        RegistrySetBuilder.RegistryBootstrap<T?> { context: BootstapContext<T?>? -> }
//      )
//    }
//
    }
  }
}


//class DataboxRegistries(output: PackOutput?, future: CompletableFuture<HolderLookup.Provider>) :
//  DatapackBuiltinEntriesProvider(output, future, BUILDER, mutableSetOf<String>("minecraft", DataboxMod.MOD_ID)) {
//
//  val registryProvider: CompletableFuture<HolderLookup.Provider>
//    get() = lp
//
//  init {
//    lp = future
//  }
//
//  fun getRegistryProvider2(): CompletableFuture<HolderLookup.Provider> {
//    return lp
//  }
//
//  companion object {
//    private lateinit var lp: CompletableFuture<HolderLookup.Provider>
//
//    val BUILDER = RegistrySetBuilder()
//      .add(Registries.BIOME, DataboxBiomes.Companion::bootstrap)
//      .add(Registries.CONFIGURED_FEATURE, DataboxConfiguredFeatures.Companion::bootstrap)
//      .add(Registries.CONFIGURED_CARVER, DataboxConfiguredCarvers.Companion::bootstrap)
//      .add(Registries.PLACED_FEATURE, DataboxPlacedFeatures::bootstrap)
////      .add<DimensionType>(Registries.DIMENSION_TYPE, DataboxDimensions::bootstrapType)
////      .add<LevelStem>(Registries.LEVEL_STEM, DataboxDimensions::bootstrapStem)
////      .add<NoiseGeneratorSettings>(Registries.NOISE_SETTINGS, DataboxDimensions::bootstrapNoise)
////      .add<StructureProcessorList>(Registries.PROCESSOR_LIST, UGStructures::bootstrapProcessors)
////      .add<Structure>(Registries.STRUCTURE, UGStructures::bootstrapStructures)
////      .add<StructureSet>(Registries.STRUCTURE_SET, UGStructures::bootstrapSets)
////      .add<StructureTemplatePool>(Registries.TEMPLATE_POOL, UGStructures::bootstrapPools)
////      .add<DamageType>(Registries.DAMAGE_TYPE, UGDamageSources::bootstrap)
////      .add<TrimMaterial>(Registries.TRIM_MATERIAL, UGTrimMaterials::bootstrap)
//  }
//}


//
//class DataboxRegistries(output: PackOutput, future: CompletableFuture<HolderLookup.Provider>) :
//  DatapackBuiltinEntriesProvider(output, future, BUILDER, mutableSetOf("minecraft", DataboxMod.MOD_ID)) {
//
//
//  companion object {
//
//    private val lookupProvider: CompletableFuture<HolderLookup.Provider> = future
//
//
//
//    val BUILDER = RegistrySetBuilder()
//      .add(Registries.BIOME, DataboxBiomes.Companion::bootstrap)
//      .add(Registries.CONFIGURED_FEATURE, DataboxConfiguredFeatures.Companion::bootstrap)
//      .add(Registries.CONFIGURED_CARVER, DataboxConfiguredCarvers.Companion::bootstrap)
//      .add(Registries.PLACED_FEATURE, DataboxPlacedFeatures::bootstrap)
////      .add<DimensionType>(Registries.DIMENSION_TYPE, DataboxDimensions::bootstrapType)
////      .add<LevelStem>(Registries.LEVEL_STEM, DataboxDimensions::bootstrapStem)
////      .add<NoiseGeneratorSettings>(Registries.NOISE_SETTINGS, DataboxDimensions::bootstrapNoise)
//      .add<StructureProcessorList>(Registries.PROCESSOR_LIST, UGStructures::bootstrapProcessors)
//      .add<Structure>(Registries.STRUCTURE, UGStructures::bootstrapStructures)
//      .add<StructureSet>(Registries.STRUCTURE_SET, UGStructures::bootstrapSets)
//      .add<StructureTemplatePool>(Registries.TEMPLATE_POOL, UGStructures::bootstrapPools)
//      .add<DamageType>(Registries.DAMAGE_TYPE, UGDamageSources::bootstrap)
//      .add<TrimMaterial>(Registries.TRIM_MATERIAL, UGTrimMaterials::bootstrap)


//  }
//
//  fun getRegistryProvider(): CompletableFuture<HolderLookup.Provider> {
//    return this.
//  }
//
//
//}