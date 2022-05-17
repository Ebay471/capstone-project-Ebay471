package com.example.mrc.setup;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

public class ModSetup {

	public static void init(FMLCommonSetupEvent event) {}
	public static final String TAB_NAME = "mrc";
	public static final CreativeModeTab ITEM_GROUP = new CreativeModeTab(TAB_NAME) {
		@Override
		public ItemStack makeIcon() {
			return new ItemStack(Registration.MR_C.get());
		}
	};
}
