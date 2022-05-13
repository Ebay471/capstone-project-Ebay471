package com.example.mrc.datagen;

import com.example.mrc.MrC;
import com.example.mrc.setup.Registration;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class BlockTaggss extends BlockTagsProvider{
	
	public BlockTaggss(DataGenerator generator, ExistingFileHelper existingFileHelper) {
		super(generator, MrC.MODID, existingFileHelper);
	}
	
	@Override
	protected void addTags() {
		tag(BlockTags.MINEABLE_WITH_AXE)
			.add(Registration.MR_C.get());
		tag(BlockTags.NON_FLAMMABLE_WOOD)
			.add(Registration.MR_C.get());
		tag(Tags.Blocks.GLASS)
			.add(Registration.MR_C.get());
		
		//tag(Registration.MR_C)
		//.add(Registration.MR_C.get();
	}
	
	@Override
	public String getName() {
		return "Mr C";
	}
}
