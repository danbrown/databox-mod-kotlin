package com.dannbrown.databox.init

import com.dannbrown.databox.DataboxMod
import com.dannbrown.databox.enchantment.BlinkingStrikeEnchantment
import net.minecraft.world.item.enchantment.Enchantment
import net.minecraftforge.eventbus.api.IEventBus
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import net.minecraftforge.registries.RegistryObject

class DataboxEnchantments {
  companion object {
    val ENCHANTMENTS: DeferredRegister<Enchantment> =
      DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, DataboxMod.MOD_ID)

    @kotlin.jvm.JvmField
    val BLINKING_STRIKE: RegistryObject<Enchantment> =
      ENCHANTMENTS.register("blinking_strike") { BlinkingStrikeEnchantment() }

    //  register
    fun register(bus: IEventBus) {
      ENCHANTMENTS.register(bus)
    }
  }
}