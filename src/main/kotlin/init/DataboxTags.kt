package com.dannbrown.databox.init

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
import net.minecraftforge.versions.forge.ForgeVersion
import javax.lang.model.type.TypeVariable


class DataboxTags {

  object Items {
    val MUSHROOMS: TagKey<Item> = tag("mushrooms")
    val CLOGGRUM_ITEMS: TagKey<Item> = tag("cloggrum_items")
    val FROSTSTEEL_ITEMS: TagKey<Item> = tag("froststeel_items")
    val UTHERIUM_ITEMS: TagKey<Item> = tag("utherium_items")
    val SMOGSTEM_LOGS: TagKey<Item> = tag("smogstem_logs")
    val WIGGLEWOOD_LOGS: TagKey<Item> = tag("wigglewood_logs")
    val GRONGLE_LOGS: TagKey<Item> = tag("grongle_logs")
    val RAW_MATERIALS_CLOGGRUM: TagKey<Item> = forgeTag("raw_materials/cloggrum")
    val RAW_MATERIALS_FROSTSTEEL: TagKey<Item> = forgeTag("raw_materials/froststeel")
    val INGOTS_CLOGGRUM: TagKey<Item> = forgeTag("ingots/cloggrum")
    val INGOTS_FROSTSTEEL: TagKey<Item> = forgeTag("ingots/froststeel")
    val INGOTS_UTHERIUM: TagKey<Item> = forgeTag("ingots/utherium")
    val INGOTS_REGALIUM: TagKey<Item> = forgeTag("ingots/regalium")
    val INGOTS_FORGOTTEN_METAL: TagKey<Item> = forgeTag("ingots/forgotten_metal")
    val NUGGETS_CLOGGRUM: TagKey<Item> = forgeTag("nuggets/cloggrum")
    val NUGGETS_FROSTSTEEL: TagKey<Item> = forgeTag("nuggets/froststeel")
    val NUGGETS_FORGOTTEN_METAL: TagKey<Item> = forgeTag("nuggets/forgotten_metal")
    val ORES_CLOGGRUM: TagKey<Item> = forgeTag("ores/cloggrum")
    val ORES_FROSTSTEEL: TagKey<Item> = forgeTag("ores/froststeel")
    val ORES_UTHERIUM: TagKey<Item> = forgeTag("ores/utherium")
    val ORES_REGALIUM: TagKey<Item> = forgeTag("ores/regalium")
    val STORAGE_BLOCKS_CLOGGRUM: TagKey<Item> = forgeTag("storage_blocks/cloggrum")
    val STORAGE_BLOCKS_FROSTSTEEL: TagKey<Item> = forgeTag("storage_blocks/froststeel")
    val STORAGE_BLOCKS_UTHERIUM: TagKey<Item> = forgeTag("storage_blocks/utherium")
    val STORAGE_BLOCKS_REGALIUM: TagKey<Item> = forgeTag("storage_blocks/regalium")
    val STORAGE_BLOCKS_FORGOTTEN_METAL: TagKey<Item> = forgeTag("storage_blocks/forgotten_metal")
    val STORAGE_BLOCKS_RAW_CLOGGRUM: TagKey<Item> = forgeTag("storage_blocks/raw_cloggrum")
    val STORAGE_BLOCKS_RAW_FROSTSTEEL: TagKey<Item> = forgeTag("storage_blocks/raw_froststeel")

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
    val UNDERGARDEN_CARVER_REPLACEABLES: TagKey<Block> = tag("undergarden_carver_replaceables")
    val MUSHROOMS: TagKey<Block> = tag("mushrooms")
    val PORTAL_FRAME_BLOCKS: TagKey<Block> = tag("portal_frame_blocks")
    val SMOGSTEM_LOGS: TagKey<Block> = tag("smogstem_logs")
    val WIGGLEWOOD_LOGS: TagKey<Block> = tag("wigglewood_logs")
    val GRONGLE_LOGS: TagKey<Block> = tag("grongle_logs")
    val MUNCHER_BREAKABLES: TagKey<Block> = tag("muncher_breakables")
    val SCINTLING_SPAWNABLE_ON: TagKey<Block> = tag("scintling_spawnable_on")
    val ORES_CLOGGRUM: TagKey<Block> = forgeTag("ores/cloggrum")
    val ORES_FROSTSTEEL: TagKey<Block> = forgeTag("ores/froststeel")
    val ORES_UTHERIUM: TagKey<Block> = forgeTag("ores/utherium")
    val ORES_REGALIUM: TagKey<Block> = forgeTag("ores/regalium")
    val STORAGE_BLOCKS_CLOGGRUM: TagKey<Block> = forgeTag("storage_blocks/cloggrum")
    val STORAGE_BLOCKS_FROSTSTEEL: TagKey<Block> = forgeTag("storage_blocks/froststeel")
    val STORAGE_BLOCKS_UTHERIUM: TagKey<Block> = forgeTag("storage_blocks/utherium")
    val STORAGE_BLOCKS_REGALIUM: TagKey<Block> = forgeTag("storage_blocks/regalium")
    val STORAGE_BLOCKS_FORGOTTEN_METAL: TagKey<Block> = forgeTag("storage_blocks/forgotten_metal")
    val STORAGE_BLOCKS_RAW_CLOGGRUM: TagKey<Block> = forgeTag("storage_blocks/raw_cloggrum")
    val STORAGE_BLOCKS_RAW_FROSTSTEEL: TagKey<Block> = forgeTag("storage_blocks/raw_froststeel")
    val DEPTHROCK_GROUND: TagKey<Block> = forgeTag("ore_bearing_ground/depthrock")
    val DEPTHROCK_ORES: TagKey<Block> = forgeTag("ores_in_ground/depthrock")
    val SHIVERSTONE_GROUND: TagKey<Block> = forgeTag("ore_bearing_ground/shiverstone")
    val SHIVERSTONE_ORES: TagKey<Block> = forgeTag("ores_in_ground/shiverstone")
    val TREMBLECRUST_GROUND: TagKey<Block> = forgeTag("ore_bearing_ground/tremblecrust")
    val TREMBLECRUST_ORES: TagKey<Block> = forgeTag("ores_in_ground/tremblecrust")

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
//        return BiomeTags.create(LibUtils.resourceLocation(name).toString())
      return createTagKey(Registries.BIOME, LibUtils.resourceLocation(name))
    }

    private fun forgeTag(name: String): TagKey<Biome> {
      return createTagKey(Registries.BIOME, LibUtils.forgeResourceLocation(name))
    }
  }


  // @ Utility functions
//    private fun create(p_203849_: String): TagKey<T<*>?>? {
//      return TagKey.create(Registries.ENTITY_TYPE, ResourceLocation(p_203849_))
//    }
  companion object {
    private fun <T> createTagKey(registry: ResourceKey<Registry<T>>, key: ResourceLocation): TagKey<T> {
      return TagKey.create(registry, key) as TagKey<T>
    }
  }
}