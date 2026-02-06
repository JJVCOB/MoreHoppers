package net.jjvcob.morehoppers;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SmithingTransformRecipeBuilder;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;

import java.util.concurrent.CompletableFuture;

public class MoreHoppersRecipeProvider extends FabricRecipeProvider {
    public MoreHoppersRecipeProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeProvider createRecipeProvider(HolderLookup.Provider registryLookup, RecipeOutput exporter) {
        return new RecipeProvider(registryLookup, exporter) {
            @Override
            public void buildRecipes() {
                HolderLookup.RegistryLookup<Item> itemLookup = registries.lookupOrThrow(Registries.ITEM);
                shaped(RecipeCategory.REDSTONE, ModBlocks.WOODEN_HOPPER, 1)
                        .pattern("g g")
                        .pattern("ghg")
                        .pattern(" g ")
                        .define('g', ItemTags.LOGS)
                        .define('h', Items.CHEST)
                        .group("multi_bench")
                        .unlockedBy(getHasName(ModBlocks.WOODEN_HOPPER), has(ModBlocks.WOODEN_HOPPER))
                        .save(output);
                shaped(RecipeCategory.REDSTONE, ModBlocks.STONE_HOPPER, 1)
                        .pattern("g g")
                        .pattern("ghg")
                        .pattern(" g ")
                        .define('g', ItemTags.STONE_CRAFTING_MATERIALS)
                        .define('h', Items.CHEST)
                        .group("multi_bench")
                        .unlockedBy(getHasName(ModBlocks.STONE_HOPPER), has(ModBlocks.STONE_HOPPER))
                        .save(output);
                shaped(RecipeCategory.REDSTONE, ModBlocks.BRICK_HOPPER, 1)
                        .pattern("g g")
                        .pattern("ghg")
                        .pattern(" g ")
                        .define('g', Items.BRICK)
                        .define('h', Items.CHEST)
                        .group("multi_bench")
                        .unlockedBy(getHasName(ModBlocks.BRICK_HOPPER), has(ModBlocks.BRICK_HOPPER))
                        .save(output);
                shaped(RecipeCategory.REDSTONE, ModBlocks.COPPER_HOPPER, 1)
                        .pattern("g g")
                        .pattern("ghg")
                        .pattern(" g ")
                        .define('g', Items.COPPER_INGOT)
                        .define('h', Items.CHEST)
                        .group("multi_bench")
                        .unlockedBy(getHasName(ModBlocks.COPPER_HOPPER), has(ModBlocks.COPPER_HOPPER))
                        .save(output);
                shaped(RecipeCategory.REDSTONE, ModBlocks.GOLDEN_HOPPER, 1)
                        .pattern("g g")
                        .pattern("ghg")
                        .pattern(" g ")
                        .define('g', Items.GOLD_INGOT)
                        .define('h', Items.HOPPER)
                        .group("multi_bench")
                        .unlockedBy(getHasName(ModBlocks.GOLDEN_HOPPER), has(ModBlocks.GOLDEN_HOPPER))
                        .save(output);
                shaped(RecipeCategory.REDSTONE, ModBlocks.EMERALD_HOPPER, 1)
                        .pattern("g g")
                        .pattern("ghg")
                        .pattern(" g ")
                        .define('g', Items.EMERALD)
                        .define('h', ModBlocks.GOLDEN_HOPPER)
                        .group("multi_bench")
                        .unlockedBy(getHasName(ModBlocks.EMERALD_HOPPER), has(ModBlocks.EMERALD_HOPPER))
                        .save(output);
                shaped(RecipeCategory.REDSTONE, ModBlocks.DIAMOND_HOPPER, 1)
                        .pattern("g g")
                        .pattern("ghg")
                        .pattern(" g ")
                        .define('g', Items.DIAMOND)
                        .define('h', ModBlocks.EMERALD_HOPPER)
                        .group("multi_bench")
                        .unlockedBy(getHasName(ModBlocks.DIAMOND_HOPPER), has(ModBlocks.DIAMOND_HOPPER))
                        .save(output);
                netheriteSmithing(ModBlocks.DIAMOND_HOPPER.asItem(), RecipeCategory.REDSTONE, ModBlocks.NETHERITE_HOPPER.asItem());
            }
        };
    }

    @Override
    public String getName() {
        return "MoreHoppersRecipeProvider";
    }
}
