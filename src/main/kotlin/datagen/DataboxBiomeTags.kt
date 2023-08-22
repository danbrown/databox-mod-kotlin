package com.dannbrown.databox.datagen

import com.dannbrown.databox.DataboxMod
import net.minecraft.core.HolderLookup
import net.minecraft.data.PackOutput
import net.minecraft.data.tags.BiomeTagsProvider
import net.minecraft.tags.BiomeTags
import net.minecraftforge.common.data.ExistingFileHelper
import java.util.concurrent.CompletableFuture
import javax.annotation.Nullable


class DataboxBiomeTags(
  output: PackOutput,
  future: CompletableFuture<HolderLookup.Provider>,
  @Nullable existingFileHelper: ExistingFileHelper?
) :
  BiomeTagsProvider(output, future, DataboxMod.MOD_ID, existingFileHelper) {


  override fun addTags(provider: HolderLookup.Provider) {
    super.addTags(provider)

    // databox
    tag(DataboxTags.Biomes.IS_DATABOX).add(
      DataboxBiomes.ANCIENT_SEA,
    )

    // vanilla
    tag(BiomeTags.WITHOUT_ZOMBIE_SIEGES).addTag(DataboxTags.Biomes.IS_DATABOX)
    tag(BiomeTags.WITHOUT_PATROL_SPAWNS).addTag(DataboxTags.Biomes.IS_DATABOX)
    tag(BiomeTags.WITHOUT_WANDERING_TRADER_SPAWNS).addTag(DataboxTags.Biomes.IS_DATABOX)
  }

  override fun getName(): String {
    return "Databox Biome Tags"
  }
}