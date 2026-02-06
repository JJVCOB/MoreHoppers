package net.jjvcob.morehoppers;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

import net.jjvcob.morehoppers.hoppers.NetheriteHopperBlockEntity;
import net.jjvcob.morehoppers.hoppers.DiamondHopperBlockEntity;
import net.jjvcob.morehoppers.hoppers.EmeraldHopperBlockEntity;
import net.jjvcob.morehoppers.hoppers.GoldenHopperBlockEntity;
import net.jjvcob.morehoppers.hoppers.CopperHopperBlockEntity;
import net.jjvcob.morehoppers.hoppers.BrickHopperBlockEntity;
import net.jjvcob.morehoppers.hoppers.StoneHopperBlockEntity;
import net.jjvcob.morehoppers.hoppers.WoodenHopperBlockEntity;

public class ModBlockEntities {

    public static final BlockEntityType<NetheriteHopperBlockEntity> NETHERITE_HOPPER_BLOCK_ENTITY = register("netherite_hopper", NetheriteHopperBlockEntity::new, ModBlocks.NETHERITE_HOPPER);
    public static final BlockEntityType<DiamondHopperBlockEntity> DIAMOND_HOPPER_BLOCK_ENTITY = register("diamond_hopper", DiamondHopperBlockEntity::new, ModBlocks.DIAMOND_HOPPER);
    public static final BlockEntityType<EmeraldHopperBlockEntity> EMERALD_HOPPER_BLOCK_ENTITY = register("emerald_hopper", EmeraldHopperBlockEntity::new, ModBlocks.EMERALD_HOPPER);
    public static final BlockEntityType<GoldenHopperBlockEntity> GOLDEN_HOPPER_BLOCK_ENTITY = register("golden_hopper", GoldenHopperBlockEntity::new, ModBlocks.GOLDEN_HOPPER);
    public static final BlockEntityType<CopperHopperBlockEntity> COPPER_HOPPER_BLOCK_ENTITY = register("copper_hopper", CopperHopperBlockEntity::new, ModBlocks.COPPER_HOPPER);
    public static final BlockEntityType<BrickHopperBlockEntity> BRICK_HOPPER_BLOCK_ENTITY = register("brick_hopper", BrickHopperBlockEntity::new, ModBlocks.BRICK_HOPPER);
    public static final BlockEntityType<StoneHopperBlockEntity> STONE_HOPPER_BLOCK_ENTITY = register("stone_hopper", StoneHopperBlockEntity::new, ModBlocks.STONE_HOPPER);
    public static final BlockEntityType<WoodenHopperBlockEntity> WOODEN_HOPPER_BLOCK_ENTITY = register("wooden_hopper", WoodenHopperBlockEntity::new, ModBlocks.WOODEN_HOPPER);

    private static <T extends BlockEntity>BlockEntityType<T> register(
            String name,
            FabricBlockEntityTypeBuilder.Factory<? extends T> entityFactory,
            Block... blocks
    ) {
        Identifier id = Identifier.fromNamespaceAndPath(MoreHoppers.MOD_ID, name);
        return Registry.register(BuiltInRegistries.BLOCK_ENTITY_TYPE, id, FabricBlockEntityTypeBuilder.<T>create(entityFactory, blocks).build());
    }

    public static void initialize() {}
}
