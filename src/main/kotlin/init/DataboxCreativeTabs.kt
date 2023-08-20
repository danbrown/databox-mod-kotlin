package com.dannbrown.databox.init

import com.dannbrown.databox.DataboxMod
import net.minecraft.core.registries.Registries
import net.minecraft.network.chat.Component
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.CreativeModeTab.DisplayItemsGenerator
import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack
import net.minecraftforge.eventbus.api.IEventBus
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.RegistryObject

class DataboxCreativeTabs {
  companion object {
    val TABS: DeferredRegister<CreativeModeTab> =
      DeferredRegister.create(Registries.CREATIVE_MODE_TAB, DataboxMod.MOD_ID)

    // Creative mode tab for databox items
    val DATABOX_TAB: RegistryObject<CreativeModeTab> =
      TABS.register("databox_tab") {
        CreativeModeTab.builder()
          .icon() { ItemStack(DataboxItems.ADAMANTIUM_INGOT) }
          .title(Component.translatable("databox.databox_tab"))
          .displayItems(DATABOX_TAB_DISPLAY)
          .build()
      }

    //  @ Display items
    //  function to generate the display items for the creative tab
    private val DATABOX_TAB_DISPLAY: DisplayItemsGenerator =
      DisplayItemsGenerator { _, pOutput ->
        pOutput.accept(DataboxItems.ADAMANTIUM_INGOT)
        pOutput.accept(DataboxItems.ADAMANTIUM_FRAGMENT)
        pOutput.accept(DataboxItems.CUSTOM_ITEM)

        pOutput.accept(DataboxBlocks.ADAMANTIUM_BLOCK)
        pOutput.accept(DataboxBlocks.ADAMANTIUM_ORE)
        pOutput.accept(DataboxBlocks.DEEPSLATE_ADAMANTIUM_ORE)
        pOutput.accept(DataboxBlocks.ADAMANTIUM_DEBRIS)

        pOutput.accept(DataboxBlocks.JUMP_BLOCK)
        pOutput.accept(DataboxBlocks.CORE_BLOCK)
      }


    // @ register
    fun register(bus: IEventBus) {
      TABS.register(bus)
    }
  }
}
