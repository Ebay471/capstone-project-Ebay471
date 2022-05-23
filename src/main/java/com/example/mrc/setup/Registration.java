package com.example.mrc.setup;

import com.example.mrc.MrC;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.common.Tags;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.minecraft.world.level.material.Material;
import static com.example.mrc.MrC.MODID;

public class Registration {

	private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, MODID);
	private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);
	
	public static void init() {
		IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
		BLOCKS.register(bus);
		ITEMS.register(bus);
	}
	
	public static final BlockBehaviour.Properties ORE_PROPERTIES = BlockBehaviour.Properties.of(Material.STONE).strength(2f);
	public static final Item.Properties ITEM_PROPERTIES = new Item.Properties().tab(ModSetup.ITEM_GROUP);
	
	public static final RegistryObject<Block> MR_C = BLOCKS.register("mr_c" , () -> new Block(ORE_PROPERTIES));
	public static final RegistryObject<Item> MR_C_ITEM = fromBlock(MR_C);

	public static final RegistryObject<Item> RAW_MR_C_CHUNK = ITEMS.register("raw_mr_c_chunk", () -> new Item(ITEM_PROPERTIES));
	public static final RegistryObject<Item> MR_C_INGOT = ITEMS.register("mr_c_ingot", () -> new Item(ITEM_PROPERTIES));

	public static final Tags.IOptionalNamedTag<Block> MR_C_ORE = BlockTags.createOptional(new ResourceLocation(MrC.MODID, "mrc"));
	public static final Tags.IOptionalNamedTag<Item> MR_C_ORE_ITEM = ItemTags.createOptional(new ResourceLocation(MrC.MODID, "mrc"));
	
	private static <B extends Block> RegistryObject<Item> fromBlock(RegistryObject<B> block) {
		return ITEMS.register(block.getId().getPath(), () -> new BlockItem(block.get(), ITEM_PROPERTIES));
	}
	
	
}
