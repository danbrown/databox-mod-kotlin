package com.dannbrown.databox.init

import com.dannbrown.databox.DataboxMod
import com.dannbrown.databox.item.CustomItem
import com.dannbrown.databox.lib.LibUtils
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.Item
import net.minecraftforge.eventbus.api.IEventBus
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import net.minecraftforge.registries.RegistryObject

class DataboxItems {


  //  utils (static)
  companion object {
    private val defaultProps = LibUtils.defaultItemProps()

    // adamantium
    val ADAMANTIUM_INGOT: Item = Item(defaultProps)
    val ADAMANTIUM_FRAGMENT: Item = Item(defaultProps)

    // custom items
    val CUSTOM_ITEM: Item = CustomItem(defaultProps)
  }
}
