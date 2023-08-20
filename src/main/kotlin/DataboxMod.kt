package com.dannbrown.databox

import com.dannbrown.databox.init.*
import net.minecraft.world.item.CreativeModeTabs
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent
import net.minecraftforge.event.server.ServerStartingEvent
import net.minecraftforge.eventbus.api.SubscribeEvent
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent
import org.apache.logging.log4j.Level
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import thedarkcolour.kotlinforforge.forge.MOD_BUS

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
      DataboxBlockItems.register(MOD_BUS)
      DataboxCreativeTabs.register(MOD_BUS)
      DataboxBlocks.register(MOD_BUS)
      DataboxItems.register(MOD_BUS)
      DataboxEnchantments.register(MOD_BUS)

      // add creative tabs
      MOD_BUS.addListener(this::addCreativeTabs)
    }

    fun commonSetup(event: FMLCommonSetupEvent) {}

    //  This will register items into the vanilla creative tabs
    fun addCreativeTabs(event: BuildCreativeModeTabContentsEvent) {
      if (event.tabKey == CreativeModeTabs.INGREDIENTS) {
        event.accept(DataboxItems.ADAMANTIUM_INGOT)
      }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    fun onServerStarting(event: ServerStartingEvent) {
    }
  }
}
