package net.jjvcob.morehoppers.hoppers;

import net.jjvcob.morehoppers.ModBlockEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.stats.Stats;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import org.jspecify.annotations.Nullable;

public class GoldenHopperBlock extends HopperBlock {
    public GoldenHopperBlock(BlockBehaviour.Properties properties) {
        super(properties);
    }

    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new GoldenHopperBlockEntity(blockPos, blockState);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState blockState, BlockEntityType<T> blockEntityType) {
        return level.isClientSide() ? null : createTickerHelper(blockEntityType, ModBlockEntities.GOLDEN_HOPPER_BLOCK_ENTITY, GoldenHopperBlockEntity::pushItemsTick);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState blockState, Level level, BlockPos blockPos, Player player, BlockHitResult blockHitResult) {
        if (!level.isClientSide() && level.getBlockEntity(blockPos) instanceof GoldenHopperBlockEntity hopperBlockEntity) {
            player.openMenu(hopperBlockEntity);
            player.awardStat(Stats.INSPECT_HOPPER);
        }

        return InteractionResult.SUCCESS;
    }
}
