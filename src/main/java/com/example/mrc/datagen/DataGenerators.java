package com.example.mrc.datagen;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;
import com.example.mrc.datagen.ItemTaggss;
import com.example.mrc.datagen.Recipess;
import com.example.mrc.datagen.LanguageProviderss;
import com.example.mrc.datagen.BlockTaggss;
import com.example.mrc.datagen.LootTabless;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD) 

public class DataGenerators{
	
	@SubscribeEvent 
	public static void gatherData(GatherDataEvent event) {
		DataGenerator generator = event.getGenerator(); 
		if (event.includeServer()) {
			generator.addProvider(new Recipess(generator)); 
			generator.addProvider(new LootTabless(generator)); 
			BlockTaggss blockTags = new BlockTaggss(generator, event.getExistingFileHelper()); 
			generator.addProvider(blockTags); 
			generator.addProvider(new ItemTaggss(generator, blockTags, event.getExistingFileHelper()));
		}
		if (event.includeClient()) {
			generator.addProvider(new BlockStates (generator, event.getExistingFileHelper())); 
			generator.addProvider(new ItemModels (generator, event.getExistingFileHelper())); 
			generator.addProvider(new LanguageProviderss(generator, "en_US"));
		}
	}
}
