package com.dannbrown.databox.init

import com.dannbrown.databox.DataboxMod
import com.dannbrown.databox.content.block.CoreBlock
import com.dannbrown.databox.content.block.JumpBlock
import com.dannbrown.databox.lib.LibBlockNames
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.*
import net.minecraft.world.level.block.state.BlockBehaviour
import net.minecraftforge.eventbus.api.IEventBus
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import net.minecraftforge.registries.RegistryObject

object DataboxBlocks {

  // @ Registering
  val BLOCKS: DeferredRegister<Block> = DeferredRegister.create(ForgeRegistries.BLOCKS, DataboxMod.MOD_ID)

  fun register(bus: IEventBus) {
    BLOCKS.register(bus)
  }


  // @ Blocks
  // Adamantium
  val ADAMANTIUM_BLOCK: RegistryObject<Block> = BLOCKS.register(LibBlockNames.ADAMANTIUM_BLOCK) {
    Block(
      BlockBehaviour.Properties
        .copy(Blocks.NETHERITE_BLOCK)
        .sound(SoundType.NETHERITE_BLOCK)
    )
  }

  val ADAMANTIUM_ORE: RegistryObject<Block> = BLOCKS.register(LibBlockNames.ADAMANTIUM_ORE) {
    DropExperienceBlock(
      BlockBehaviour.Properties
        .copy(Blocks.DIAMOND_ORE)
        .sound(SoundType.BASALT)
    )
  }

  val DEEPSLATE_ADAMANTIUM_ORE: RegistryObject<Block> = BLOCKS.register(LibBlockNames.DEEPSLATE_ADAMANTIUM_ORE) {
    DropExperienceBlock(
      BlockBehaviour.Properties
        .copy(Blocks.DEEPSLATE_DIAMOND_ORE)
        .sound(SoundType.BASALT)
    )
  }

  val ADAMANTIUM_DEBRIS: RegistryObject<Block> = BLOCKS.register(LibBlockNames.ADAMANTIUM_DEBRIS)
  {
    Block(
      BlockBehaviour.Properties
        .copy(Blocks.ANCIENT_DEBRIS)
        .sound(SoundType.ANCIENT_DEBRIS)
    )
  }

  //  Jump Block
  val JUMP_BLOCK: RegistryObject<Block> = BLOCKS.register(LibBlockNames.JUMP_BLOCK) {
    JumpBlock(
      BlockBehaviour.Properties
        .copy(Blocks.DIRT)
    )
  }

  //  Core Block
  val CORE_BLOCK: RegistryObject<Block> = BLOCKS.register(LibBlockNames.CORE_BLOCK) {
    CoreBlock(
      BlockBehaviour.Properties
        .copy(Blocks.IRON_BLOCK)
        .lightLevel { state -> if (state.getValue(CoreBlock.lit)) 15 else 0 }
    )
  }

  // @ Blacklist for block items, it will not register a block item for these blocks
  val DONT_INCLUDE_BLOCK_ITEM: List<RegistryObject<Block>> = listOf(ADAMANTIUM_DEBRIS)

  // @ Blacklist for creative tab, block item may still be registered
  val DONT_INCLUDE_CREATIVE: List<RegistryObject<Block>> = listOf(ADAMANTIUM_BLOCK)
}