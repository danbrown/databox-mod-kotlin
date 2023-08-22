package com.dannbrown.databox.init

import com.dannbrown.databox.DataboxMod
import com.dannbrown.databox.content.enchantment.BlinkingStrikeEnchantment
import com.dannbrown.databox.lib.LibEnchantmentNames
import net.minecraft.world.item.Item
import net.minecraft.world.item.enchantment.Enchantment
import net.minecraftforge.eventbus.api.IEventBus
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import net.minecraftforge.registries.RegistryObject

object DataboxEnchantments {

  // @ Register
  val ENCHANTMENTS: DeferredRegister<Enchantment> =
    DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, DataboxMod.MOD_ID)

  fun register(bus: IEventBus) {
    ENCHANTMENTS.register(bus)
  }

  // @ Enchantments
  @kotlin.jvm.JvmField // This allows us to use the field as a static field in Java
  val BLINKING_STRIKE: RegistryObject<Enchantment> = ENCHANTMENTS.register(LibEnchantmentNames.BLINKING_STRIKE) {
    BlinkingStrikeEnchantment()
  }

  // @ Blacklist for creative tab
  val DONT_INCLUDE_CREATIVE: List<RegistryObject<Enchantment>> = listOf()
}