package net.jjvcob.morehoppers;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.jjvcob.morehoppers.hoppers.*;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;

public class ModBlockEntities {

    public static final BlockEntityType<EndHopperBlockEntity> END_HOPPER_BLOCK_ENTITY = register("end_hopper", EndHopperBlockEntity::new, ModBlocks.END_HOPPER);
    public static final BlockEntityType<NetheriteHopperBlockEntity> NETHERITE_HOPPER_BLOCK_ENTITY = register("netherite_hopper", NetheriteHopperBlockEntity::new, ModBlocks.NETHERITE_HOPPER);
    public static final BlockEntityType<DiamondHopperBlockEntity> DIAMOND_HOPPER_BLOCK_ENTITY = register("diamond_hopper", DiamondHopperBlockEntity::new, ModBlocks.DIAMOND_HOPPER);
    public static final BlockEntityType<EmeraldHopperBlockEntity> EMERALD_HOPPER_BLOCK_ENTITY = register("emerald_hopper", EmeraldHopperBlockEntity::new, ModBlocks.EMERALD_HOPPER);
    public static final BlockEntityType<GoldenHopperBlockEntity> GOLDEN_HOPPER_BLOCK_ENTITY = register("golden_hopper", GoldenHopperBlockEntity::new, ModBlocks.GOLDEN_HOPPER);
    public static final BlockEntityType<CopperHopperBlockEntity> COPPER_HOPPER_BLOCK_ENTITY = register("copper_hopper", CopperHopperBlockEntity::new, ModBlocks.COPPER_HOPPER);
    public static final BlockEntityType<BrickHopperBlockEntity> BRICK_HOPPER_BLOCK_ENTITY = register("brick_hopper", BrickHopperBlockEntity::new, ModBlocks.BRICK_HOPPER);
    public static final BlockEntityType<StoneHopperBlockEntity> STONE_HOPPER_BLOCK_ENTITY = register("stone_hopper", StoneHopperBlockEntity::new, ModBlocks.STONE_HOPPER);
    public static final BlockEntityType<WoodenHopperBlockEntity> WOODEN_HOPPER_BLOCK_ENTITY = register("wooden_hopper", WoodenHopperBlockEntity::new, ModBlocks.WOODEN_HOPPER);
    public static final BlockEntityType<DirtHopperBlockEntity> DIRT_HOPPER_BLOCK_ENTITY = register("dirt_hopper", DirtHopperBlockEntity::new, ModBlocks.DIRT_HOPPER);

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
