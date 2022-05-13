package com.example.mrc.datagen;

import com.example.mrc.MrC;
import com.example.mrc.setup.Registration;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ItemModels extends ItemModelProvider{

	public ItemModels(DataGenerator generator, ExistingFileHelper existingFileHelper) {
		super(generator, MrC.MODID, existingFileHelper);
	}
@Override
	protected void registerModels() {
		withExistingParent(Registration.MR_C_ITEM.get().getRegistryName().getPath(), modLoc("block/mr_c"));
	}
}
