package com.dannbrown.databox

import com.dannbrown.databox.datagen.DataboxBiomeTags
import com.dannbrown.databox.datagen.DataboxRegistries
import com.dannbrown.databox.init.*
import com.dannbrown.databox.registry.BlockRegistry
import com.dannbrown.databox.registry.EnchantmentRegistry
import com.dannbrown.databox.registry.ItemRegistry
import net.minecraft.DetectedVersion
import net.minecraft.core.HolderLookup
import net.minecraft.core.RegistrySetBuilder
import net.minecraft.core.registries.Registries
import net.minecraft.data.CachedOutput
import net.minecraft.data.DataGenerator
import net.minecraft.data.PackOutput
import net.minecraft.data.metadata.PackMetadataGenerator
import net.minecraft.network.chat.Component
import net.minecraft.server.packs.PackType
import net.minecraft.server.packs.metadata.pack.PackMetadataSection
import net.minecraft.world.item.CreativeModeTabs
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider
import net.minecraftforge.common.data.ExistingFileHelper
import net.minecraftforge.data.event.GatherDataEvent
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent
import net.minecraftforge.event.server.ServerStartingEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent
import org.apache.logging.log4j.Level
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import thedarkcolour.kotlinforforge.forge.MOD_BUS
import java.util.*
import java.util.concurrent.CompletableFuture
import java.util.function.Function
import java.util.stream.Collectors


@Mod(DataboxMod.MOD_ID)
class DataboxMod {
  companion object {
    const val MOD_ID = "databox"
    private val LOGGER: Logger = LogManager.getLogger(MOD_ID)
//    private val MOD_BUS: IEventBus = FMLJavaModLoadingContext.get().modEventBus

    init {
      LOGGER.log(Level.INFO, "$MOD_ID has started!")

      MOD_BUS.addListener(this::commonSetup)

      // run register methods
//      DataboxBlockItems.register(MOD_BUS)
      DataboxCreativeTabs.register(MOD_BUS)
      DataboxCarvers.register(MOD_BUS)
      BlockRegistry.registerBlocks(MOD_BUS)
      BlockRegistry.registerBlockItems(MOD_BUS)
      ItemRegistry.registerItems(MOD_BUS)
      EnchantmentRegistry.registerEnchantments(MOD_BUS)

      // add creative tabs
      MOD_BUS.addListener(this::addCreativeTabs)

      // gather datapack data
      MOD_BUS.addListener(DataboxRegistries::registerDataProviders);
    }

    private fun commonSetup(event: FMLCommonSetupEvent) {}

    //  This will register items into the vanilla creative tabs
    private fun addCreativeTabs(event: BuildCreativeModeTabContentsEvent) {
      if (event.tabKey == CreativeModeTabs.INGREDIENTS) {
        event.accept(DataboxItems.ADAMANTIUM_INGOT)
      }
    }

//    private fun gatherData(event: GatherDataEvent) {
//      val generator: DataGenerator = event.generator
//      val output: PackOutput = generator.packOutput
//      val provider: CompletableFuture<HolderLookup.Provider> = event.lookupProvider
//      val helper: ExistingFileHelper = event.existingFileHelper
////      generator.addProvider(event.includeClient(), UGBlockStates(output, helper))
////      generator.addProvider(event.includeClient(), UGItemModels(output, helper))
////      generator.addProvider(event.includeClient(), UGLang(output))
////      generator.addProvider(event.includeClient(), UGSoundDefinitions(output, helper))
////      generator.addProvider(event.includeServer(), UGRecipes(output))
////      generator.addProvider(event.includeServer(), UGLootTables(output))
////      val blockTags = UGBlockTags(output, provider, helper)
////      generator.addProvider(event.includeServer(), blockTags)
////      generator.addProvider(event.includeServer(), UGItemTags(output, provider, blockTags.contentsGetter(), helper))
////      generator.addProvider(event.includeServer(), UGEntityTags(output, provider, helper))
////      generator.addProvider(event.includeServer(), UGAdvancements(output, provider, helper))
////      generator.addProvider(event.includeServer(), UGFluidTags(output, provider, helper))
////      val datapackProvider = DataboxRegistries(output, provider)
////      val datapackProvider: DatapackBuiltinEntriesProvider = RegistryDataGenerator(output, provider)
////      val lookupProvider: CompletableFuture<HolderLookup.Provider> = datapackProvider.getRegistryProvider2()
//
//      val BUILDER = RegistrySetBuilder()
//        .add(Registries.BIOME, DataboxBiomes.Companion::bootstrap)
//        .add(Registries.CONFIGURED_FEATURE, DataboxConfiguredFeatures.Companion::bootstrap)
//        .add(Registries.CONFIGURED_CARVER, DataboxConfiguredCarvers.Companion::bootstrap)
//        .add(Registries.PLACED_FEATURE, DataboxPlacedFeatures::bootstrap)
//
//
//      generator.addProvider(
//        event.includeServer(), DatapackBuiltinEntriesProvider(
//          output,
//          provider,
//          BUILDER,
//          mutableSetOf("minecraft", MOD_ID)
//        )
//      )
//      generator.addProvider(event.includeServer(), DataboxBiomeTags(output, provider, helper))
//
////      generator.addProvider(event.includeServer(), datapackProvider)
//
//
////      generator.addProvider(event.includeServer(), UGDamageTypeTags(output, lookupProvider, helper))
//      generator.addProvider(
//        true, PackMetadataGenerator(output).add(
//          PackMetadataSection.TYPE, PackMetadataSection(
//            Component.literal("databox resources"),
//            DetectedVersion.BUILT_IN.getPackVersion(PackType.CLIENT_RESOURCES),
//            Arrays.stream(PackType.entries.toTypedArray()).collect(
//              Collectors.toMap(
//                Function.identity()
//              ) { packType -> DetectedVersion.BUILT_IN.getPackVersion(packType) }
//            )
//          )
//        )
//      )
//    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    fun onServerStarting(event: ServerStartingEvent) {
    }

  }
}
