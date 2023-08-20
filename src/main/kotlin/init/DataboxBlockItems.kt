package com.dannbrown.databox.init

import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.Item
import net.minecraftforge.eventbus.api.IEventBus

class DataboxBlockItems {
  companion object {
    //  for all blocks in DataboxBlocks, register a block item
    fun register(bus: IEventBus) {
      DataboxBlocks.BLOCKS.entries.forEach { block ->
        DataboxItems.ITEMS.register(block.id.path) { BlockItem(block.get(), Item.Properties()) }
      }
    }
  }
}