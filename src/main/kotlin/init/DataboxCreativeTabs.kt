package com.dannbrown.databox.init

import com.dannbrown.databox.DataboxMod
import net.minecraft.core.registries.Registries
import net.minecraft.network.chat.Component
import net.minecraft.world.item.*
import net.minecraft.world.item.CreativeModeTab.DisplayItemsGenerator
import net.minecraft.world.item.enchantment.EnchantmentInstance
import net.minecraft.world.level.block.Block
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent
import net.minecraftforge.eventbus.api.IEventBus
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.RegistryObject


object DataboxCreativeTabs {
  // @ register
  val TABS: DeferredRegister<CreativeModeTab> =
    DeferredRegister.create(Registries.CREATIVE_MODE_TAB, DataboxMod.MOD_ID)

  fun register(bus: IEventBus) {
    TABS.register(bus)
  }

  // Creative mode tab for databox items
  val DATABOX_TAB: RegistryObject<CreativeModeTab> =
    TABS.register("databox_tab") {
      CreativeModeTab.builder()
        .icon() { ItemStack(DataboxItems.ADAMANTIUM_INGOT.get()) }
        .title(Component.translatable("databox.databox_tab"))
        .displayItems(DATABOX_TAB_DISPLAY)
        .build()
    }

  //  @ Display items
  //  function to generate the display items for the creative tab
  private val DATABOX_TAB_DISPLAY: DisplayItemsGenerator =
    DisplayItemsGenerator { _, pOutput ->

      // Block Items
      DataboxItems.BLOCK_ITEMS.entries.forEach() { item ->
        val block: Block = Block.byItem(item.get())
        val blockRegistry: RegistryObject<Block> = DataboxBlocks.BLOCKS.entries.find { it.get() == block }!!

        if (!DataboxBlocks.DONT_INCLUDE_CREATIVE.contains(blockRegistry)) {
          pOutput.accept(ItemStack(item.get()))
        }
      }

      // Items
      DataboxItems.ITEMS.entries.forEach() { item ->
        if (!DataboxItems.DONT_INCLUDE_CREATIVE.contains(item)) {
          pOutput.accept(item.get())
        }
      }

      // Enchanted books
      DataboxEnchantments.ENCHANTMENTS.entries.forEach() { enchantment ->
        if (!DataboxEnchantments.DONT_INCLUDE_CREATIVE.contains(enchantment)) {
          pOutput.accept(
            EnchantedBookItem.createForEnchantment(
              EnchantmentInstance(
                enchantment.get(),
                enchantment.get().maxLevel
              )
            )
          )
        }
      }

      // Spawn eggs?
    }


  //  This will register items into the vanilla creative tabs
  fun addVanillaCreativeTabs(event: BuildCreativeModeTabContentsEvent) {
    if (event.tabKey == CreativeModeTabs.INGREDIENTS) {
      event.accept(DataboxItems.ADAMANTIUM_INGOT)
    }
  }
}
