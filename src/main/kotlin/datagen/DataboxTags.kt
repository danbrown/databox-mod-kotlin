package com.dannbrown.databox.datagen

import com.dannbrown.databox.lib.LibUtils
import net.minecraft.core.Registry
import net.minecraft.core.registries.Registries
import net.minecraft.resources.ResourceKey
import net.minecraft.resources.ResourceLocation
import net.minecraft.tags.*
import net.minecraft.world.entity.EntityType
import net.minecraft.world.item.Item
import net.minecraft.world.level.biome.Biome
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.material.Fluid


class DataboxTags {

  object Items {

    private fun tag(name: String): TagKey<Item> {
      return ItemTags.create(LibUtils.resourceLocation(name))
    }

    private fun forgeTag(name: String): TagKey<Item> {
      return ItemTags.create(LibUtils.forgeResourceLocation(name))
    }
  }

  object Blocks {
    val BASE_STONE_UNDERGARDEN: TagKey<Block> = tag("base_stone_undergarden")
    val DEPTHROCK_ORE_REPLACEABLES: TagKey<Block> = tag("depthrock_ore_replaceables")
    val SHIVERSTONE_ORE_REPLACEABLES: TagKey<Block> = tag("shiverstone_ore_replaceables")
    val TREMBLECRUST_ORE_REPLACEABLES: TagKey<Block> = tag("tremblecrust_ore_replaceables")
    val BASALT_ORE_REPLACEABLES: TagKey<Block> = tag("basalt_ore_replaceables")
    val DATABOX_CARVER_REPLACEABLES: TagKey<Block> = tag("databox_carver_replaceables")

    private fun tag(name: String): TagKey<Block> {
      return BlockTags.create(LibUtils.resourceLocation(name))
    }

    private fun forgeTag(name: String): TagKey<Block> {
      return createTagKey(Registries.BLOCK, LibUtils.forgeResourceLocation(name))
    }
  }


  object Entities {
    val ROTSPAWN = tag("rotspawn")
    val CAVERN_CREATURE = tag("cavern_creature")
    val IMMUNE_TO_VIRULENT_MIX = tag("immune_to_virulent_mix")
    val IMMUNE_TO_SCINTLING_GOO = tag("immune_to_scintling_goo")

    private fun tag(name: String): TagKey<EntityType<*>> {
      return createTagKey(Registries.ENTITY_TYPE, LibUtils.resourceLocation(name))
    }
  }


  object Fluids {
    val VIRULENT: TagKey<Fluid> = tag("virulent")

    private fun tag(name: String): TagKey<Fluid> {
      return createTagKey(Registries.FLUID, LibUtils.resourceLocation(name))
    }
  }


  object Biomes {
    val IS_DATABOX = tag("is_databox")
    val HAS_CATACOMBS = tag("has_structure/catacombs")

    private fun tag(name: String): TagKey<Biome> {
      return createTagKey(Registries.BIOME, LibUtils.resourceLocation(name))
    }

    private fun forgeTag(name: String): TagKey<Biome> {
      return createTagKey(Registries.BIOME, LibUtils.forgeResourceLocation(name))
    }
  }

  companion object {
    private fun <T> createTagKey(registry: ResourceKey<Registry<T>>, key: ResourceLocation): TagKey<T> {
      return TagKey.create(registry, key) as TagKey<T>
    }
  }
}