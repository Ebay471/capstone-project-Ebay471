package com.example.mrc.datagen;

import com.example.mrc.MrC;
import com.example.mrc.setup.Registration;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class BlockStates extends BlockStateProvider{

	public BlockStates(DataGenerator gen, ExistingFileHelper helper) {
		super(gen, MrC.MODID, helper);
	}
	
	@Override
	protected void registerStatesAndModels() {
		simpleBlock(Registration.MR_C.get());
	}
}
