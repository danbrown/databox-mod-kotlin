package com.dannbrown.databox.init

import com.dannbrown.databox.DataboxMod
import com.dannbrown.databox.block.CoreBlock
import com.dannbrown.databox.block.JumpBlock
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.Item
import net.minecraft.world.item.ItemStack
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.block.DropExperienceBlock
import net.minecraft.world.level.block.SoundType
import net.minecraft.world.level.block.state.BlockBehaviour
import net.minecraftforge.eventbus.api.IEventBus
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import net.minecraftforge.registries.RegistryObject
import org.apache.logging.log4j.core.Core
import java.util.function.Supplier

class DataboxBlocks {

  companion object {
    val BLOCKS: DeferredRegister<Block> =
      DeferredRegister.create(ForgeRegistries.BLOCKS, DataboxMod.MOD_ID)


    // @ Blocks

    // Adamantium
    val ADAMANTIUM_BLOCK: RegistryObject<Block> =
      BLOCKS.register("adamantium_block") {
        Block(
          BlockBehaviour.Properties
            .copy(Blocks.NETHERITE_BLOCK)
            .sound(SoundType.NETHERITE_BLOCK)
        )
      }

    val ADAMANTIUM_ORE: RegistryObject<Block> = BLOCKS.register("adamantium_ore") {
      DropExperienceBlock(
        BlockBehaviour.Properties
          .copy(Blocks.DIAMOND_ORE)
          .sound(SoundType.BASALT)
      )
    }

    val DEEPSLATE_ADAMANTIUM_ORE: RegistryObject<Block> = BLOCKS.register("deepslate_adamantium_ore") {
      DropExperienceBlock(
        BlockBehaviour.Properties
          .copy(Blocks.DEEPSLATE_DIAMOND_ORE)
          .sound(SoundType.BASALT)
      )
    }

    val ADAMANTIUM_DEBRIS: RegistryObject<Block> = BLOCKS.register("adamantium_debris") {
      Block(
        BlockBehaviour.Properties
          .copy(Blocks.ANCIENT_DEBRIS)
          .sound(SoundType.ANCIENT_DEBRIS)
      )
    }

    //  Jump Block
    val JUMP_BLOCK: RegistryObject<Block> = BLOCKS.register("jump_block") {
      JumpBlock(
        BlockBehaviour.Properties
          .copy(Blocks.DIRT)
      )
    }

    //  Core Block
    val CORE_BLOCK: RegistryObject<Block> = BLOCKS.register("core_block") {
      CoreBlock(
        BlockBehaviour.Properties
          .copy(Blocks.IRON_BLOCK)
      )
    }


    // Register
    fun register(eventBus: IEventBus) {
      BLOCKS.register(eventBus)
    }
  }
}