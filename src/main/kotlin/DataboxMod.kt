package com.dannbrown.databox

import com.dannbrown.databox.datagen.DataboxRegistries
import com.dannbrown.databox.init.*
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
    private val LOGGER: Logger = LogManager.getLogger(MOD_ID)

    init {
      LOGGER.log(Level.INFO, "$MOD_ID has started!")

      MOD_BUS.addListener(this::commonSetup)

      // run register methods
      DataboxCreativeTabs.register(MOD_BUS)
      DataboxBlocks.register(MOD_BUS)
      DataboxItems.register(MOD_BUS)
      DataboxEnchantments.register(MOD_BUS)
      DataboxSoundEvents.register(MOD_BUS)
      DataboxCarvers.register(MOD_BUS)

      // add items to vanilla creative tabs
      MOD_BUS.addListener(DataboxCreativeTabs::addVanillaCreativeTabs)

      // gather datapack data
      MOD_BUS.addListener(DataboxRegistries::registerDataProviders)
    }

    private fun commonSetup(event: FMLCommonSetupEvent) {}


    // use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    fun onServerStarting(event: ServerStartingEvent) {
    }

  }
}
