package com.dannbrown.databox.init

import com.dannbrown.databox.DataboxMod
import com.dannbrown.databox.content.carver.CaveWorldCarver
import net.minecraft.world.level.levelgen.carver.CaveCarverConfiguration
import net.minecraft.world.level.levelgen.carver.WorldCarver
import net.minecraftforge.eventbus.api.IEventBus
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import java.util.function.Supplier


object DataboxCarvers {
  val CARVERS = DeferredRegister.create(ForgeRegistries.WORLD_CARVERS, DataboxMod.MOD_ID)

  val UNDERGARDEN_CAVE = CARVERS.register("undergarden_cave") { CaveWorldCarver(CaveCarverConfiguration.CODEC) }

  fun register(eventBus: IEventBus) {
    CARVERS.register(eventBus)
  }
}