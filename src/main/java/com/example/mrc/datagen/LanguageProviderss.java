package com.example.mrc.datagen;


import com.example.mrc.MrC;
import com.example.mrc.setup.Registration;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

import static com.example.mrc.setup.ModSetup.TAB_NAME;

public class LanguageProviderss extends LanguageProvider{
	
	public LanguageProviderss(DataGenerator gen, String locale) { super(gen, MrC.MODID, locale); }

	@Override
	protected void addTranslations() {
		add("itemGroup." + TAB_NAME, "MrC");
		add(Registration.MR_C.get(), "Mr. C");
	}
}
