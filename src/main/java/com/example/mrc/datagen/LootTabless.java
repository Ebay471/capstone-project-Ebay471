package com.example.mrc.datagen;

import com.example.mrc.setup.Registration;
import net.minecraft.data.DataGenerator;

public class LootTabless extends BaseLootTableProvider{

	public LootTabless(DataGenerator dataGeneratorIn) { super(dataGeneratorIn); }
	
	@Override
	protected void addTables() {
		lootTables.put(Registration.MR_C.get(), createSilkTouchTable("mrc", Registration.MR_C.get(), Registration.RAW_MR_C_CHUNK.get(), 1, 3));
	}
}
