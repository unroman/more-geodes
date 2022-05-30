package com.github.thedeathlycow.moregeodes.blocks;

import com.github.thedeathlycow.moregeodes.blocks.entity.EchoLocatorBlockEntity;
import net.minecraft.block.BellBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.tag.TagKey;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.Pair;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("deprecation")
public class EchoLocatorBlock extends BlockWithEntity {



    private final TagKey<Block> blocksCanLocate;

    public EchoLocatorBlock(TagKey<Block> blocksCanLocate, Settings settings) {
        super(settings);
        this.blocksCanLocate = blocksCanLocate;
    }

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        return this.ding(world, pos, state, hit, player) ? ActionResult.success(world.isClient) : ActionResult.PASS;
    }

    private boolean ding(World world, BlockPos origin, BlockState state, BlockHitResult hit, PlayerEntity player) {

        world.playSound(null, origin, SoundEvents.BLOCK_BELL_USE, SoundCategory.BLOCKS, 2.0F, 1.0F);

        EchoLocatorBlockEntity blockEntity = (EchoLocatorBlockEntity) world.getBlockEntity(origin);

        if (blockEntity != null) {
            blockEntity.activate(world, origin, this.blocksCanLocate);
        }

        return true;
    }

    @Nullable
    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new EchoLocatorBlockEntity(pos, state);
    }
}
