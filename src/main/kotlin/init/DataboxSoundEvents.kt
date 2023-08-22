package com.dannbrown.databox.init

import com.dannbrown.databox.DataboxMod
import com.dannbrown.databox.lib.LibUtils
import net.minecraft.sounds.SoundEvent
import net.minecraftforge.eventbus.api.IEventBus
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import net.minecraftforge.registries.RegistryObject


object DataboxSoundEvents {
  // @ Register
  val SOUNDS: DeferredRegister<SoundEvent> = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, DataboxMod.MOD_ID)

  fun register(bus: IEventBus) {
    SOUNDS.register(bus)
  }

  // @ Sounds
  val CORE_BLOCK_BREAK: RegistryObject<SoundEvent> = registerSound("block.core_block.break")


  // @ Utils
  private fun registerSound(name: String): RegistryObject<SoundEvent> {
    return SOUNDS.register(name) {
      SoundEvent.createVariableRangeEvent(
        LibUtils.resourceLocation(name)
      )
    }
  }
}