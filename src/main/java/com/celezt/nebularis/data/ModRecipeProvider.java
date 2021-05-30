package com.celezt.nebularis.data;

import java.util.function.Consumer;

import com.celezt.nebularis.NebularisMod;
import com.celezt.nebularis.setup.ModBlocks;
import com.celezt.nebularis.setup.ModItems;

import net.minecraft.data.CookingRecipeBuilder;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.IFinishedRecipe;
import net.minecraft.data.RecipeProvider;
import net.minecraft.data.ShapedRecipeBuilder;
import net.minecraft.data.ShapelessRecipeBuilder;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.ResourceLocation;

public class ModRecipeProvider extends RecipeProvider {

    public ModRecipeProvider(DataGenerator generator) {
        super(generator);
    }

    @Override
    protected void buildShapelessRecipes(Consumer<IFinishedRecipe> consumer) {
        ShapelessRecipeBuilder.shapeless(ModItems.RAW_NEBULARIUM.get(), 4)
            .requires(ModBlocks.RAW_NEBULARIUM_BLOCK.get())
            .unlockedBy("has_item", has(ModItems.RAW_NEBULARIUM.get()))
            .save(consumer);

        ShapedRecipeBuilder.shaped(ModBlocks.RAW_NEBULARIUM_BLOCK.get())
            .define('#', ModItems.RAW_NEBULARIUM.get())
            .pattern("##")
            .pattern("##")
            .unlockedBy("has_item", has(ModItems.RAW_NEBULARIUM.get()))
            .save(consumer);
            
        CookingRecipeBuilder.smelting(Ingredient.of(ModBlocks.NEBULARIUM_ORE.get()), ModItems.RAW_NEBULARIUM.get(), 0.7f, 200)
            .unlockedBy("has_item", has(ModBlocks.NEBULARIUM_ORE.get()))
            .save(consumer, modId("raw_nebularium_smelting"));
        CookingRecipeBuilder.blasting(Ingredient.of(ModBlocks.NEBULARIUM_ORE.get()), ModItems.RAW_NEBULARIUM.get(), 0.7f, 100)
            .unlockedBy("has_item", has(ModBlocks.NEBULARIUM_ORE.get()))
            .save(consumer, modId("raw_nebularium_blasting"));
    }

    private static ResourceLocation modId(String path){
        return new ResourceLocation(NebularisMod.MOD_ID, path);
    }
    
}
