package com.dannbrown.databox.registry

import com.dannbrown.databox.DataboxMod
import com.dannbrown.databox.init.DataboxEnchantments
import com.dannbrown.databox.lib.LibEnchantmentNames
import net.minecraft.world.item.enchantment.Enchantment
import net.minecraftforge.eventbus.api.IEventBus
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries

object EnchantmentRegistry {
  fun registerEnchantments(bus: IEventBus) {
    val rEnchantments: DeferredRegister<Enchantment> =
      DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, DataboxMod.MOD_ID)

    rEnchantments.register(LibEnchantmentNames.BLINKING_STRIKE) { DataboxEnchantments.BLINKING_STRIKE }

    rEnchantments.register(bus)
  }
}