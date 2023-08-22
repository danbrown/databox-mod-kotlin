package com.dannbrown.databox.init

import com.dannbrown.databox.DataboxMod
import com.dannbrown.databox.lib.LibUtils
import net.minecraft.sounds.SoundEvent
import net.minecraftforge.registries.DeferredRegister
import net.minecraftforge.registries.ForgeRegistries
import net.minecraftforge.registries.RegistryObject


class DataboxSoundEvents {
  companion object {
    val SOUNDS: DeferredRegister<SoundEvent> = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, DataboxMod.MOD_ID)

    val UNDERGARDEN_AMBIENCE: RegistryObject<SoundEvent> = register("ambient.undergarden")
    val ABYSS_AMBIENCE: RegistryObject<SoundEvent> = register("ambient.abyss")
    val SPIRES_AMBIENCE: RegistryObject<SoundEvent> = register("ambient.spires")
    val FROST_AMBIENCE: RegistryObject<SoundEvent> = register("ambient.frost")
    val SEA_AMBIENCE: RegistryObject<SoundEvent> = register("ambient.sea")

    val ABYSS_AMBIENT_ADDITION: RegistryObject<SoundEvent> = register("ambient.abyss_addition")
    val BOG_AMBIENT_ADDITION: RegistryObject<SoundEvent> = register("ambient.bog_addition")
    val FIELDS_AMBIENT_ADDITION: RegistryObject<SoundEvent> = register("ambient.fields_addition")
    val SMOGSTEM_FOREST_AMBIENT_ADDITION: RegistryObject<SoundEvent> = register("ambient.smogstem_forest_addition")
    val WIGGLEWOOD_FOREST_AMBIENT_ADDITION: RegistryObject<SoundEvent> = register("ambient.wigglewood_forest_addition")
    val GRONGLEGROWTH_AMBIENT_ADDITION: RegistryObject<SoundEvent> = register("ambient.gronglegrowth_addition")
    val DENSE_FOREST_AMBIENT_ADDITION: RegistryObject<SoundEvent> = register("ambient.dense_forest_addition")
    val FROSTFIELDS_AMBIENT_ADDITION: RegistryObject<SoundEvent> = register("ambient.frostfields_addition")
    val SPIRES_AMBIENT_ADDITION: RegistryObject<SoundEvent> = register("ambient.spires_addition")
    val SEA_AMBIENT_ADDITION: RegistryObject<SoundEvent> = register("ambient.sea_addition")

    val MOOD: RegistryObject<SoundEvent> = register("ambient.mood")
    val FROST_MOOD: RegistryObject<SoundEvent> = register("ambient.frost_mood")

    val UNDERGARDEN_MUSIC: RegistryObject<SoundEvent> = register("music.undergarden")

    val MAMMOTH_DISC: RegistryObject<SoundEvent> = register("music.disc.mammoth")
    val LIMAX_MAXIMUS_DISC: RegistryObject<SoundEvent> = register("music.disc.limax_maximus")
    val RELICT_DISC: RegistryObject<SoundEvent> = register("music.disc.relict")
    val GLOOMPER_ANTHEM_DISC: RegistryObject<SoundEvent> = register("music.disc.gloomper_anthem")
    val GLOOMPER_SECRET_DISC: RegistryObject<SoundEvent> = register("music.disc.gloomper_secret")

    val UNDERGARDEN_PORTAL_AMBIENT: RegistryObject<SoundEvent> = register("block.undergarden_portal.ambient")
    val UNDERGARDEN_PORTAL_ACTIVATE: RegistryObject<SoundEvent> = register("block.undergarden_portal.activate")
    val UNDERGARDEN_PORTAL_TRAVEL: RegistryObject<SoundEvent> = register("block.undergarden_portal.travel")

    val VIRULENT_FLOW: RegistryObject<SoundEvent> = register("block.virulent.flow")
    val VIRULENT_BUBBLE: RegistryObject<SoundEvent> = register("block.virulent.bubble")

    val GRONGLET_AMBIENT: RegistryObject<SoundEvent> = register("block.gronglet.ambient")
    val GRONGLET_BREAK: RegistryObject<SoundEvent> = register("block.gronglet.break")
    val GRONGLET_PLACE: RegistryObject<SoundEvent> = register("block.gronglet.place")
    val GRONGLET_BURN: RegistryObject<SoundEvent> = register("block.gronglet.burn")

    val BLISTERBOMB_THROW: RegistryObject<SoundEvent> = register("item.blisterbomb")

    val SLINGSHOT_SHOOT: RegistryObject<SoundEvent> = register("item.slingshot.shoot")
    val SLINGSHOT_DRAW: RegistryObject<SoundEvent> = register("item.slingshot.draw")
    val GRONGLET_SHOOT: RegistryObject<SoundEvent> = register("item.slingshot.gronglet_shoot")

    val PICK_BLISTERBERRY_BUSH: RegistryObject<SoundEvent> = register("item.blisterberry_bush.pick")

    val BUCKET_FILL_VIRULENT: RegistryObject<SoundEvent> = register("item.bucket.fill_virulent")
    val BUCKET_EMPTY_VIRULENT: RegistryObject<SoundEvent> = register("item.bucket.empty_virulent")

    val DITCHBULB_PASTE_USE: RegistryObject<SoundEvent> = register("item.ditchbulb_paste.use")

    val BOOMGOURD_PRIMED: RegistryObject<SoundEvent> = register("entity.boomgourd.primed")

    val DWELLER_AMBIENT: RegistryObject<SoundEvent> = register("entity.dweller.ambient")
    val DWELLER_HURT: RegistryObject<SoundEvent> = register("entity.dweller.hurt")
    val DWELLER_DEATH: RegistryObject<SoundEvent> = register("entity.dweller.death")
    val DWELLER_JUMP: RegistryObject<SoundEvent> = register("entity.dweller.jump")
    val DWELLER_STEP: RegistryObject<SoundEvent> = register("entity.dweller.step")
    val DWELLER_SADDLE_REMOVE: RegistryObject<SoundEvent> = register("entity.dweller.saddle_remove")

    val ROTLING_AMBIENT: RegistryObject<SoundEvent> = register("entity.rotling.ambient")
    val ROTLING_HURT: RegistryObject<SoundEvent> = register("entity.rotling.hurt")
    val ROTLING_DEATH: RegistryObject<SoundEvent> = register("entity.rotling.death")
    val ROTLING_STEP: RegistryObject<SoundEvent> = register("entity.rotling.step")

    val ROTWALKER_AMBIENT: RegistryObject<SoundEvent> = register("entity.rotwalker.ambient")
    val ROTWALKER_HURT: RegistryObject<SoundEvent> = register("entity.rotwalker.hurt")
    val ROTWALKER_DEATH: RegistryObject<SoundEvent> = register("entity.rotwalker.death")
    val ROTWALKER_STEP: RegistryObject<SoundEvent> = register("entity.rotwalker.step")

    val ROTBEAST_AMBIENT: RegistryObject<SoundEvent> = register("entity.rotbeast.ambient")
    val ROTBEAST_HURT: RegistryObject<SoundEvent> = register("entity.rotbeast.hurt")
    val ROTBEAST_DEATH: RegistryObject<SoundEvent> = register("entity.rotbeast.death")
    val ROTBEAST_STEP: RegistryObject<SoundEvent> = register("entity.rotbeast.step")
    val ROTBEAST_ATTACK: RegistryObject<SoundEvent> = register("entity.rotbeast.attack")

    val BRUTE_AMBIENT: RegistryObject<SoundEvent> = register("entity.brute.ambient")
    val BRUTE_HURT: RegistryObject<SoundEvent> = register("entity.brute.hurt")
    val BRUTE_DEATH: RegistryObject<SoundEvent> = register("entity.brute.death")

    val GLOOMPER_AMBIENT: RegistryObject<SoundEvent> = register("entity.gloomper.ambient")
    val GLOOMPER_HURT: RegistryObject<SoundEvent> = register("entity.gloomper.hurt")
    val GLOOMPER_DEATH: RegistryObject<SoundEvent> = register("entity.gloomper.death")
    val GLOOMPER_HOP: RegistryObject<SoundEvent> = register("entity.gloomper.hop")
    val GLOOMPER_FART: RegistryObject<SoundEvent> = register("entity.gloomper.fart")

    val STONEBORN_STEP: RegistryObject<SoundEvent> = register("entity.stoneborn.step")
    val STONEBORN_SPEAKING: RegistryObject<SoundEvent> = register("entity.stoneborn.speaking")
    val STONEBORN_PLEASED: RegistryObject<SoundEvent> = register("entity.stoneborn.pleased")
    val STONEBORN_HURT: RegistryObject<SoundEvent> = register("entity.stoneborn.hurt")
    val STONEBORN_ANGRY: RegistryObject<SoundEvent> = register("entity.stoneborn.angry")
    val STONEBORN_CONFUSED: RegistryObject<SoundEvent> = register("entity.stoneborn.confused")
    val STONEBORN_CHANT: RegistryObject<SoundEvent> = register("entity.stoneborn.chant")
    val STONEBORN_DEATH: RegistryObject<SoundEvent> = register("entity.stoneborn.death")

    val FORGOTTEN_GUARDIAN_AMBIENT: RegistryObject<SoundEvent> = register("entity.forgotten_guardian.ambient")
    val FORGOTTEN_GUARDIAN_HURT: RegistryObject<SoundEvent> = register("entity.forgotten_guardian.hurt")
    val FORGOTTEN_GUARDIAN_DEATH: RegistryObject<SoundEvent> = register("entity.forgotten_guardian.death")
    val FORGOTTEN_GUARDIAN_ATTACK: RegistryObject<SoundEvent> = register("entity.forgotten_guardian.attack")
    val FORGOTTEN_GUARDIAN_DEFLECT: RegistryObject<SoundEvent> = register("entity.forgotten_guardian.deflect")
    val FORGOTTEN_GUARDIAN_STEP: RegistryObject<SoundEvent> = register("entity.forgotten_guardian.step")

    val MINION_SHOOT: RegistryObject<SoundEvent> = register("entity.minion.shoot")
    val MINION_DEATH: RegistryObject<SoundEvent> = register("entity.minion.death")
    val MINION_REPAIR: RegistryObject<SoundEvent> = register("entity.minion.repair")

    val NARGOYLE_HURT: RegistryObject<SoundEvent> = register("entity.nargoyle.hurt")
    val NARGOYLE_DEATH: RegistryObject<SoundEvent> = register("entity.nargoyle.death")
    val NARGOYLE_ATTACK: RegistryObject<SoundEvent> = register("entity.nargoyle.attack")

    val MUNCHER_AMBIENT: RegistryObject<SoundEvent> = register("entity.muncher.ambient")
    val MUNCHER_HURT: RegistryObject<SoundEvent> = register("entity.muncher.hurt")
    val MUNCHER_DEATH: RegistryObject<SoundEvent> = register("entity.muncher.death")
    val MUNCHER_CHEW: RegistryObject<SoundEvent> = register("entity.muncher.chew")

    val SPLOOGIE_AMBIENT: RegistryObject<SoundEvent> = register("entity.sploogie.ambient")
    val SPLOOGIE_HURT: RegistryObject<SoundEvent> = register("entity.sploogie.hurt")
    val SPLOOGIE_DEATH: RegistryObject<SoundEvent> = register("entity.sploogie.death")
    val SPLOOGIE_SPIT: RegistryObject<SoundEvent> = register("entity.sploogie.spit")

    val MASTICATOR_AMBIENT: RegistryObject<SoundEvent> = register("entity.masticator.ambient")
    val MASTICATOR_HURT: RegistryObject<SoundEvent> = register("entity.masticator.hurt")
    val MASTICATOR_DEATH: RegistryObject<SoundEvent> = register("entity.masticator.death")
    val MASTICATOR_EAT: RegistryObject<SoundEvent> = register("entity.masticator.eat")
    val MASTICATOR_STEP: RegistryObject<SoundEvent> = register("entity.masticator.step")

    val GWIB_HURT: RegistryObject<SoundEvent> = register("entity.gwib.hurt")
    val GWIB_DEATH: RegistryObject<SoundEvent> = register("entity.gwib.death")
    val GWIB_FLOP: RegistryObject<SoundEvent> = register("entity.gwib.flop")

    val GWIBLING_HURT: RegistryObject<SoundEvent> = register("entity.gwibling.hurt")
    val GWIBLING_DEATH: RegistryObject<SoundEvent> = register("entity.gwibling.death")
    val GWIBLING_FLOP: RegistryObject<SoundEvent> = register("entity.gwibling.flop")

    val MOG_AMBIENT: RegistryObject<SoundEvent> = register("entity.mog.ambient")
    val MOG_HURT: RegistryObject<SoundEvent> = register("entity.mog.hurt")
    val MOG_DEATH: RegistryObject<SoundEvent> = register("entity.mog.death")

    val SCINTLING_HURT: RegistryObject<SoundEvent> = register("entity.scintling.hurt")
    val SCINTLING_DEATH: RegistryObject<SoundEvent> = register("entity.scintling.death")
    val SCINTLING_STEP: RegistryObject<SoundEvent> = register("entity.scintling.step")

    private fun register(name: String): RegistryObject<SoundEvent> {
      return SOUNDS.register(
        name
      ) {
        SoundEvent.createVariableRangeEvent(
          LibUtils.resourceLocation(name)
        )
      }
    }
  }
}