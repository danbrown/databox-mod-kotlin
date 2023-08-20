package com.dannbrown.databox.init

import com.dannbrown.databox.DataboxMod
import com.dannbrown.databox.block.CoreBlock
import com.dannbrown.databox.block.JumpBlock
import com.dannbrown.databox.lib.LibBlockNames
import com.dannbrown.databox.lib.LibUtils
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.resources.ResourceLocation
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
import java.util.function.BiConsumer
import java.util.function.Supplier

class DataboxBlocks {
  companion object {
    // @ Blocks
    // Adamantium
    val ADAMANTIUM_BLOCK: Block = Block(
      BlockBehaviour.Properties
        .copy(Blocks.NETHERITE_BLOCK)
        .sound(SoundType.NETHERITE_BLOCK)
    )

    val ADAMANTIUM_ORE: Block = DropExperienceBlock(
      BlockBehaviour.Properties
        .copy(Blocks.DIAMOND_ORE)
        .sound(SoundType.BASALT)
    )

    val DEEPSLATE_ADAMANTIUM_ORE: Block = DropExperienceBlock(
      BlockBehaviour.Properties
        .copy(Blocks.DEEPSLATE_DIAMOND_ORE)
        .sound(SoundType.BASALT)
    )

    val ADAMANTIUM_DEBRIS: Block = Block(
      BlockBehaviour.Properties
        .copy(Blocks.ANCIENT_DEBRIS)
        .sound(SoundType.ANCIENT_DEBRIS)
    )

    //  Jump Block
    val JUMP_BLOCK: Block = JumpBlock(
      BlockBehaviour.Properties
        .copy(Blocks.DIRT)
    )

    //  Core Block
    val CORE_BLOCK: Block = CoreBlock(
      BlockBehaviour.Properties
        .copy(Blocks.IRON_BLOCK)
        .lightLevel { state -> if (state.getValue(CoreBlock.lit)) 15 else 0 }
    )
  }
}