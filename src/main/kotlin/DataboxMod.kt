package com.dannbrown.databox

import com.dannbrown.databox.datagen.WorldGeneration
import com.dannbrown.databox.init.*
import com.dannbrown.databox.lib.LibBlockNames
import com.dannbrown.databox.lib.LibUtils
import com.dannbrown.databox.registry.BlockRegistry
import com.dannbrown.databox.registry.EnchantmentRegistry
import com.dannbrown.databox.registry.ItemRegistry
import net.minecraft.core.Registry
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.resources.ResourceKey
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.CreativeModeTabs
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.Block
import net.minecraftforge.data.event.GatherDataEvent
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent
import net.minecraftforge.event.server.ServerStartingEvent
import net.minecraftforge.eventbus.api.IEventBus
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import net.minecraftforge.registries.RegisterEvent
import org.apache.logging.log4j.Level
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import thedarkcolour.kotlinforforge.forge.MOD_BUS
import java.util.function.BiConsumer
import java.util.function.Consumer
import java.util.function.Supplier


@Mod(DataboxMod.MOD_ID)
class DataboxMod {
  companion object {
    const val MOD_ID = "databox"
    val LOGGER: Logger = LogManager.getLogger(MOD_ID)
    // val MOD_BUS: IEventBus = FMLJavaModLoadingContext.get().getModEventBus()

    init {
      LOGGER.log(Level.INFO, "$MOD_ID has started!")

      MOD_BUS.addListener(this::commonSetup)

      // run register methods
//      DataboxBlockItems.register(MOD_BUS)
      DataboxCreativeTabs.register(MOD_BUS)
      BlockRegistry.registerBlocks(MOD_BUS)
      BlockRegistry.registerBlockItems(MOD_BUS)
      ItemRegistry.registerItems(MOD_BUS)
      EnchantmentRegistry.registerEnchantments(MOD_BUS)

      // add creative tabs
      MOD_BUS.addListener(this::addCreativeTabs)

      // generate data
      MOD_BUS.addListener(this::generateData)
    }

    fun commonSetup(event: FMLCommonSetupEvent) {}

    //  This will register items into the vanilla creative tabs
    fun addCreativeTabs(event: BuildCreativeModeTabContentsEvent) {
      if (event.tabKey == CreativeModeTabs.INGREDIENTS) {
        event.accept(DataboxItems.ADAMANTIUM_INGOT)
      }
    }

    private fun generateData(event: GatherDataEvent) {
      val generator = event.generator
      val packOutput = generator.packOutput
      val fileHelper = event.existingFileHelper



      generator.addProvider(event.includeServer(), WorldGeneration(packOutput, event.lookupProvider))
    }

    private fun <T> bind(registry: ResourceKey<Registry<T>>, source: Consumer<BiConsumer<T, ResourceLocation>>) {
      FMLJavaModLoadingContext.get().modEventBus.addListener { event: RegisterEvent ->
        if (registry == event.registryKey) {
          source.accept { t, rl -> event.register(registry, rl, Supplier<T> { t }) }
        }
      }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    fun onServerStarting(event: ServerStartingEvent) {
    }

  }
}
