package com.dannbrown.databox.registry

import com.dannbrown.databox.DataboxMod
import com.dannbrown.databox.init.DataboxItems
import com.dannbrown.databox.lib.LibItemNames
import net.minecraft.world.item.Item
import net.minecraftforge.eventbus.api.IEventBus
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries

object ItemRegistry {
  fun registerItems(bus: IEventBus) {
    val rItem: DeferredRegister<Item> = DeferredRegister.create(ForgeRegistries.ITEMS, DataboxMod.MOD_ID)

    rItem.register(LibItemNames.ADAMANTIUM_INGOT) { DataboxItems.ADAMANTIUM_INGOT }
    rItem.register(LibItemNames.ADAMANTIUM_FRAGMENT) { DataboxItems.ADAMANTIUM_FRAGMENT }
    rItem.register(LibItemNames.CUSTOM_ITEM) { DataboxItems.CUSTOM_ITEM }

    rItem.register(bus)
  }
}