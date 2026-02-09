package net.jjvcob.morehoppers;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.jjvcob.morehoppers.hoppers.*;

import java.util.function.Function;

public class ModBlocks {

    public static final Block END_HOPPER = register(
            "end_hopper",
            EndHopperBlock::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PINK).strength(3.0F).lightLevel(blockStatex -> 15).noOcclusion(),
            true
    );

    public static final Block NETHERITE_HOPPER = register(
            "netherite_hopper",
            NetheriteHopperBlock::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BLACK).requiresCorrectToolForDrops().strength(50.0F, 1200.0F).sound(SoundType.NETHERITE_BLOCK).noOcclusion(),
            true
    );

    public static final Block DIAMOND_HOPPER = register(
            "diamond_hopper",
            DiamondHopperBlock::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.DIAMOND).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL).noOcclusion(),
            true
    );

    public static final Block EMERALD_HOPPER = register(
            "emerald_hopper",
            EmeraldHopperBlock::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.EMERALD).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL).noOcclusion(),
            true
    );

    public static final Block GOLDEN_HOPPER = register(
            "golden_hopper",
            GoldenHopperBlock::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.GOLD).requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.METAL).noOcclusion(),
            true
    );

    public static final Block COPPER_HOPPER = register(
            "copper_hopper",
            CopperHopperBlock::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.COPPER).noOcclusion(),
            true
    );

    public static final Block BRICK_HOPPER = register(
            "brick_hopper",
            BrickHopperBlock::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_RED).requiresCorrectToolForDrops().strength(2.0F, 6.0F).noOcclusion(),
            true
    );

    public static final Block STONE_HOPPER = register(
            "stone_hopper",
            StoneHopperBlock::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.STONE).requiresCorrectToolForDrops().strength(2.0F, 6.0F).sound(SoundType.STONE).noOcclusion(),
            true
    );

    public static final Block WOODEN_HOPPER = register(
            "wooden_hopper",
            WoodenHopperBlock::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.WOOD).strength(2.0F, 3.0F).sound(SoundType.WOOD).noOcclusion(),
            true
    );

    public static final Block DIRT_HOPPER = register(
            "dirt_hopper",
            DirtHopperBlock::new,
            BlockBehaviour.Properties.of().mapColor(MapColor.DIRT).strength(0.5F).sound(SoundType.GRAVEL).noOcclusion(),
            true
    );

    private static Block register(String name, Function<BlockBehaviour.Properties, Block> blockFactory, BlockBehaviour.Properties settings, boolean shouldRegisterItem) {
        ResourceKey<Block> blockKey = keyOfBlock(name);
        Block block = blockFactory.apply(settings.setId(blockKey));
        if (shouldRegisterItem) {
            ResourceKey<Item> itemKey = keyOfItem(name);
            BlockItem blockItem = new BlockItem(block, new Item.Properties().setId(itemKey).useBlockDescriptionPrefix());
            Registry.register(BuiltInRegistries.ITEM, itemKey, blockItem);
        }
        return Registry.register(BuiltInRegistries.BLOCK, blockKey, block);
    }

    private static ResourceKey<Block> keyOfBlock(String name) {
        return ResourceKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(MoreHoppers.MOD_ID, name));
    }

    private static ResourceKey<Item> keyOfItem(String name) {
        return ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(MoreHoppers.MOD_ID, name));
    }

    public static void initialize() {
        ItemGroupEvents.modifyEntriesEvent(CreativeModeTabs.REDSTONE_BLOCKS).register((itemGroup) -> {
            itemGroup.accept(ModBlocks.DIRT_HOPPER.asItem());
            itemGroup.accept(ModBlocks.WOODEN_HOPPER.asItem());
            itemGroup.accept(ModBlocks.STONE_HOPPER.asItem());
            itemGroup.accept(ModBlocks.BRICK_HOPPER.asItem());
            itemGroup.accept(ModBlocks.COPPER_HOPPER.asItem());
            itemGroup.accept(ModBlocks.GOLDEN_HOPPER.asItem());
            itemGroup.accept(ModBlocks.EMERALD_HOPPER.asItem());
            itemGroup.accept(ModBlocks.DIAMOND_HOPPER.asItem());
            itemGroup.accept(ModBlocks.NETHERITE_HOPPER.asItem());
            itemGroup.accept(ModBlocks.END_HOPPER.asItem());
        });
    }
}
