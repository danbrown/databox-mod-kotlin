package com.dannbrown.databox.init

import com.dannbrown.databox.DataboxMod
import com.dannbrown.databox.content.item.CustomItem
import com.dannbrown.databox.lib.LibItemNames
import com.dannbrown.databox.lib.LibUtils
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.Item
import net.minecraftforge.eventbus.api.IEventBus
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import net.minecraftforge.registries.RegistryObject

object DataboxItems {
  // @ Utils
  private val defaultProps = LibUtils.defaultItemProps()

  // @ Registry
  val ITEMS: DeferredRegister<Item> = DeferredRegister.create(ForgeRegistries.ITEMS, DataboxMod.MOD_ID)
  val BLOCK_ITEMS: DeferredRegister<Item> = DeferredRegister.create(ForgeRegistries.ITEMS, DataboxMod.MOD_ID)

  fun register(bus: IEventBus) {
    ITEMS.register(bus)
    BLOCK_ITEMS.register(bus)
  }

  init {
    registerBlockItems()
  }

  private fun registerBlockItems() {
    DataboxBlocks.BLOCKS.entries.forEach() { item ->
      if (!DataboxBlocks.DONT_INCLUDE_BLOCK_ITEM.contains(item)) {
        BLOCK_ITEMS.register(item.id.path) {
          BlockItem(item.get(), defaultProps)
        }
      }
    }
  }

  // @ Items
  // adamantium
  val ADAMANTIUM_INGOT: RegistryObject<Item> = ITEMS.register(LibItemNames.ADAMANTIUM_INGOT) {
    Item(defaultProps)
  }
  val ADAMANTIUM_FRAGMENT: RegistryObject<Item> = ITEMS.register(LibItemNames.ADAMANTIUM_FRAGMENT) {
    Item(defaultProps)
  }

  // custom items
  val CUSTOM_ITEM: RegistryObject<Item> = ITEMS.register(LibItemNames.CUSTOM_ITEM) {
    CustomItem(defaultProps)
  }

  // @ Blacklist for creative tab
  val DONT_INCLUDE_CREATIVE: List<RegistryObject<Item>> = listOf(ADAMANTIUM_INGOT, CUSTOM_ITEM)
}
