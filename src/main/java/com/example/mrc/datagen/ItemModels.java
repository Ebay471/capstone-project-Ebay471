package com.example.mrc.datagen;

import com.example.mrc.MrC;
import com.example.mrc.setup.Registration;

import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ItemModels extends ItemModelProvider{

	public ItemModels(DataGenerator generator, ExistingFileHelper existingFileHelper) {
		super(generator, MrC.MODID, existingFileHelper);
	}
@Override
	protected void registerModels() {

		withExistingParent(Registration.MR_C_ITEM.get().getRegistryName().getPath(), modLoc("block/mr_c"));

		singleTexture(Registration.RAW_MR_C_CHUNK.get().getRegistryName().getPath(),
			mcLoc("item/generated"),
			"layer0", modLoc("item/raw_mr_c_chunk"));
		singleTexture(Registration.MR_C_INGOT.get().getRegistryName().getPath(),
			mcLoc("item/generated"),
			"layer0", modLoc("item/mr_c_ingot"));
	}
}
