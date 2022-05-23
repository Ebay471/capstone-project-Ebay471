package com.example.mrc.datagen;

import com.example.mrc.MrC;
import com.example.mrc.setup.Registration;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ItemTaggss extends ItemTagsProvider{
	public ItemTaggss(DataGenerator generator, BlockTagsProvider blockTags, ExistingFileHelper helper) {
		super(generator,blockTags, MrC.MODID, helper);
	}


	@Override
	protected void addTags() {
		tag(Tags.Items.ORES)
		.add(Registration.MR_C_ITEM.get());

		tag(Registration.MR_C_ITEM)
		.add(Registration.MR_C_ITEM.get());
	}
	
	@Override
	public String getName() {
		return "Mr C";
	}
}
