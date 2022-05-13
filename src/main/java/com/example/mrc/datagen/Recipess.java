package com.example.mrc.datagen;

import java.util.function.Consumer;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;

public class Recipess extends RecipeProvider{
	public Recipess(DataGenerator generatorIn) { super(generatorIn);}
	
	@Override
	protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
		
	}
}
