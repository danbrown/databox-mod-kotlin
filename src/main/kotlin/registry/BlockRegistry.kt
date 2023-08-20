package com.dannbrown.databox.registry

import com.dannbrown.databox.DataboxMod
import com.dannbrown.databox.init.DataboxBlocks
import com.dannbrown.databox.lib.LibBlockNames
import com.dannbrown.databox.lib.LibUtils
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.Block
import net.minecraftforge.eventbus.api.IEventBus
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries

object BlockRegistry {


  fun registerBlocks(bus: IEventBus) {
    val rBlock: DeferredRegister<Block> = DeferredRegister.create(ForgeRegistries.BLOCKS, DataboxMod.MOD_ID)

    rBlock.register(LibBlockNames.ADAMANTIUM_BLOCK) {
      DataboxBlocks.ADAMANTIUM_BLOCK
    }
    rBlock.register(LibBlockNames.ADAMANTIUM_ORE) {
      DataboxBlocks.ADAMANTIUM_ORE
    }
    rBlock.register(LibBlockNames.DEEPSLATE_ADAMANTIUM_ORE) {
      DataboxBlocks.DEEPSLATE_ADAMANTIUM_ORE
    }
    rBlock.register(LibBlockNames.ADAMANTIUM_DEBRIS) {
      DataboxBlocks.ADAMANTIUM_DEBRIS
    }
    rBlock.register(LibBlockNames.JUMP_BLOCK) {
      DataboxBlocks.JUMP_BLOCK
    }
    rBlock.register(LibBlockNames.CORE_BLOCK) {
      DataboxBlocks.CORE_BLOCK
    }

    rBlock.register(bus)
  }

  fun registerBlockItems(bus: IEventBus) {
    val rItemBlock: DeferredRegister<Item> = DeferredRegister.create(ForgeRegistries.ITEMS, DataboxMod.MOD_ID)
    val props: Item.Properties = LibUtils.defaultItemProps()

    rItemBlock.register(LibBlockNames.ADAMANTIUM_BLOCK) {
      BlockItem(DataboxBlocks.ADAMANTIUM_BLOCK, props)
    }
    rItemBlock.register(LibBlockNames.ADAMANTIUM_ORE) {
      BlockItem(DataboxBlocks.ADAMANTIUM_ORE, props)
    }
    rItemBlock.register(LibBlockNames.DEEPSLATE_ADAMANTIUM_ORE) {
      BlockItem(DataboxBlocks.DEEPSLATE_ADAMANTIUM_ORE, props)
    }
    rItemBlock.register(LibBlockNames.ADAMANTIUM_DEBRIS) {
      BlockItem(DataboxBlocks.ADAMANTIUM_DEBRIS, props)
    }
    rItemBlock.register(LibBlockNames.JUMP_BLOCK) {
      BlockItem(DataboxBlocks.JUMP_BLOCK, props)
    }
    rItemBlock.register(LibBlockNames.CORE_BLOCK) {
      BlockItem(DataboxBlocks.CORE_BLOCK, props)
    }

    rItemBlock.register(bus)
  }
}