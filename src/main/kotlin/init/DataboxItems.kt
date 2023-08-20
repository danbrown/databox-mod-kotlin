package com.dannbrown.databox.init

import com.dannbrown.databox.DataboxMod
import com.dannbrown.databox.item.CustomItem
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.Item
import net.minecraftforge.eventbus.api.IEventBus
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import net.minecraftforge.registries.RegistryObject

class DataboxItems {


  //  utils (static)
  companion object {
    val ITEMS: DeferredRegister<Item> =
      DeferredRegister.create(ForgeRegistries.ITEMS, DataboxMod.MOD_ID)

    // Register
    fun register(eventBus: IEventBus) {
      ITEMS.register(eventBus)
    }

    // init
    fun init() {}

    // register item util
    private fun registerItem(
      name: String,
      item: Item,
    ): RegistryObject<Item> {
      return ITEMS.register(name) { item }
    }


    // adamantium
    val ADAMANTIUM_INGOT: RegistryObject<Item> =
      ITEMS.register("adamantium_ingot") { Item(Item.Properties()) }

    val ADAMANTIUM_FRAGMENT: RegistryObject<Item> =
      ITEMS.register("adamantium_fragment") { Item(Item.Properties()) }

    // custom items
    val CUSTOM_ITEM: RegistryObject<Item> =
      ITEMS.register("custom_item") { CustomItem(Item.Properties()) }
  }
}
