package com.dannbrown.databox.world.carver

import com.dannbrown.databox.init.DataboxBlocks
import com.google.common.collect.ImmutableSet;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.core.BlockPos.MutableBlockPos
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.CarvingMask;
import net.minecraft.world.level.chunk.ChunkAccess;
import net.minecraft.world.level.levelgen.Aquifer;
import net.minecraft.world.level.levelgen.carver.CarvingContext;
import net.minecraft.world.level.levelgen.carver.CaveCarverConfiguration;
import net.minecraft.world.level.levelgen.carver.CaveWorldCarver;
import net.minecraft.world.level.material.Fluid
import net.minecraft.world.level.material.Fluids;
import org.apache.commons.lang3.mutable.MutableBoolean;
import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min
import java.util.function.Function;


class CaveWorldCarver(configCodec: Codec<CaveCarverConfiguration?>?) : CaveWorldCarver(configCodec) {
  init {
    liquids = ImmutableSet.of(Fluids.WATER) as Set<Fluid>
  }

  override fun getThickness(random: RandomSource): Float {
    return super.getThickness(random) * 3
  }

  override fun carveEllipsoid(
    context: CarvingContext,
    config: CaveCarverConfiguration,
    chunk: ChunkAccess,
    biomeAccessor: Function<BlockPos, Holder<Biome>>,
    aquifer: Aquifer,
    x: Double,
    y: Double,
    z: Double,
    horizontalRadius: Double,
    verticalRadius: Double,
    carvingMask: CarvingMask,
    skipChecker: CarveSkipChecker
  ): Boolean {
    val chunkPos = chunk.pos
    val middleX = chunkPos.middleBlockX.toDouble()
    val middleZ = chunkPos.middleBlockZ.toDouble()
    val d2 = 16.0 + horizontalRadius * 2.0
    return if (!(abs(x - middleX) > d2) && !(abs(z - middleZ) > d2)) {
      val minX = chunkPos.minBlockX
      val minZ = chunkPos.minBlockZ
      val k = max((Mth.floor(x - horizontalRadius) - minX - 1).toDouble(), 0.0).toInt()
      val l = min((Mth.floor(x + horizontalRadius) - minX).toDouble(), 15.0).toInt()
      val i1 =
        max((Mth.floor(y - verticalRadius) - 1).toDouble(), (context.minGenY + 1).toDouble()).toInt()
      val j1 = if (chunk.isUpgrading) 0 else 7
      val k1 =
        min((Mth.floor(y + verticalRadius) + 1).toDouble(), (context.minGenY + context.genDepth - 1 - j1).toDouble())
          .toInt()
      val l1 = max((Mth.floor(z - horizontalRadius) - minZ - 1).toDouble(), 0.0).toInt()
      val i2 = min((Mth.floor(z + horizontalRadius) - minZ).toDouble(), 15.0).toInt()
      if (hasDisallowedLiquid(chunk, k, l, i1, k1, l1, i2)) {
        false
      } else {
        var flag = false
        val `blockpos$mutableblockpos` = MutableBlockPos()
        val `blockpos$mutableblockpos1` = MutableBlockPos()
        for (j2 in k..l) {
          val k2 = chunkPos.getBlockX(j2)
          val d3 = (k2.toDouble() + 0.5 - x) / horizontalRadius
          for (l2 in l1..i2) {
            val i3 = chunkPos.getBlockZ(l2)
            val d4 = (i3.toDouble() + 0.5 - z) / horizontalRadius
            if (!(d3 * d3 + d4 * d4 >= 1.0)) {
              val mutableboolean = MutableBoolean(false)
              for (j3 in k1 downTo i1 + 1) {
                val d5 = (j3.toDouble() - 0.5 - y) / verticalRadius
                if (!skipChecker.shouldSkip(context, d3, d5, d4, j3) && !carvingMask[j2, j3, l2]) {
                  carvingMask[j2, j3] = l2
                  `blockpos$mutableblockpos`[k2, j3] = i3
                  flag = flag or carveBlock(
                    context,
                    config,
                    chunk,
                    biomeAccessor,
                    carvingMask,
                    `blockpos$mutableblockpos`,
                    `blockpos$mutableblockpos1`,
                    aquifer,
                    mutableboolean
                  )
                }
              }
            }
          }
        }
        flag
      }
    } else {
      false
    }
  }

  override fun carveBlock(
    context: CarvingContext,
    config: CaveCarverConfiguration,
    chunk: ChunkAccess,
    biomeAccessor: Function<BlockPos, Holder<Biome>>,
    carvingMask: CarvingMask?,
    pos: MutableBlockPos,
    checkPos: MutableBlockPos,
    aquifer: Aquifer,
    reachedSurface: MutableBoolean
  ): Boolean {
    val chunkState = chunk.getBlockState(pos)
    // TODO: Replace with Tuff variants
    if (chunkState.`is`(DataboxBlocks.ADAMANTIUM_DEBRIS) || chunkState.`is`(DataboxBlocks.ADAMANTIUM_DEBRIS) || chunkState.`is`(
        DataboxBlocks.ADAMANTIUM_DEBRIS
      )
    ) {
      reachedSurface.setTrue()
    }
    return if (!canReplaceBlock(config, chunkState)) {
      false
    } else {
      val carveState = this.getCarveState(context, config, pos)
      if (carveState == null) {
        false
      } else {
        chunk.setBlockState(pos, carveState, false)
        if (aquifer.shouldScheduleFluidUpdate() && !carveState.fluidState.isEmpty) {
          chunk.markPosForPostprocessing(pos)
        }
        if (reachedSurface.isTrue) {
          checkPos.setWithOffset(pos, Direction.DOWN)
          // TODO: Replace with soil variants
          if (chunk.getBlockState(checkPos).`is`(Blocks.DIRT)) {
            context.topMaterial(biomeAccessor, chunk, checkPos, !carveState.fluidState.isEmpty)
              .ifPresent { state: BlockState ->
                chunk.setBlockState(checkPos, state, false)
                if (!state.fluidState.isEmpty) {
                  chunk.markPosForPostprocessing(checkPos)
                }
              }
          }
        }
        true
      }
    }
  }

  private fun getCarveState(context: CarvingContext, config: CaveCarverConfiguration, pos: BlockPos): BlockState {
    return if (pos.y <= config.lavaLevel.resolveY(context)) {
      // TODO: Replace with World Water
      Fluids.WATER.defaultFluidState().createLegacyBlock()
    } else {
      CAVE_AIR
    }
  }

  protected fun hasDisallowedLiquid(
    chunk: ChunkAccess,
    minX: Int,
    maxX: Int,
    minY: Int,
    maxY: Int,
    minZ: Int,
    maxZ: Int
  ): Boolean {
    val chunkpos = chunk.pos
    val minBlockX = chunkpos.minBlockX
    val minBlockZ = chunkpos.minBlockZ
    val mutablePos = MutableBlockPos()
    for (x in minX..maxX) {
      for (z in minZ..maxZ) {
        var y = minY - 1
        while (y <= maxY + 1) {
          mutablePos[minBlockX + x, y] = minBlockZ + z
          if (liquids.contains(chunk.getFluidState(mutablePos).type)) {
            return true
          }
          if (y != maxY + 1 && !isEdge(x, z, minX, maxX, minZ, maxZ)) {
            y = maxY
          }
          ++y
        }
      }
    }
    return false
  }

  companion object {
    private fun isEdge(x: Int, z: Int, minX: Int, maxX: Int, minZ: Int, maxZ: Int): Boolean {
      return x == minX || x == maxX || z == minZ || z == maxZ
    }
  }
}
