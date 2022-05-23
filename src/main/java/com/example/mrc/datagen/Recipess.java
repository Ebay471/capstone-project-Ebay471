package com.example.mrc.datagen;

import java.util.function.Consumer;

import com.example.mrc.setup.Registration;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.world.item.crafting.Ingredient;

public class Recipess extends RecipeProvider{
	public Recipess(DataGenerator generatorIn) { super(generatorIn);}
	
	@Override
	protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {

		SimpleCookingRecipeBuilder.smelting(Ingredient.of(Registration.MR_C_ORE_ITEM),
						Registration.MR_C_INGOT.get(), 1.0f, 100)
				.unlockedBy("has_ore", has(Registration.MR_C_ORE_ITEM))
				.save(consumer, "mysterious_ingot1");
		SimpleCookingRecipeBuilder.smelting(Ingredient.of(Registration.RAW_MR_C_CHUNK.get()),
						Registration.MR_C_INGOT.get(), 0.0f, 100)
				.unlockedBy("has_chunk", has(Registration.RAW_MR_C_CHUNK.get()))
				.save(consumer, "mysterious_ingot2");
	}
}
