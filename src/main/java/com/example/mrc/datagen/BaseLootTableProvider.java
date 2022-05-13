package com.example.mrc.datagen;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import net.minecraft.data.DataGenerator;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.DynamicLoot;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.CopyNameFunction;
import net.minecraft.world.level.storage.loot.functions.CopyNbtFunction;
import net.minecraft.world.level.storage.loot.functions.SetContainerContents;
import net.minecraft.world.level.storage.loot.providers.nbt.ContextNbtProvider;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public abstract class BaseLootTableProvider extends LootTableProvider{

		private static final Logger LOGGER = LogManager.getLogger();
		private static final Gson GSON = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
		
		protected final Map<Block, LootTable.Builder> lootTables = new HashMap<>();
		private final DataGenerator generator;
		
		public BaseLootTableProvider(DataGenerator dataGeneratorIn) {
			super(dataGeneratorIn);
			this.generator = dataGeneratorIn;
		}
		
		protected abstract void addTables();
		
		protected LootTable.Builder createStandardTable(String name, Block block, BlockEntityType<?> type){
			LootPool.Builder builder = LootPool.lootPool()
			.name(name)
			.setRolls(ConstantValue.exactly(1))
			.add(LootItem.lootTableItem(block)
			    .apply(CopyNameFunction.copyName(CopyNameFunction.NameSource.BLOCK_ENTITY))
			    .apply(CopyNbtFunction.copyData(ContextNbtProvider.BLOCK_ENTITY)
					.copy("Info", "BlockEntityTag.Info", CopyNbtFunction.MergeStrategy.REPLACE)
			    	.copy("Inventory", "BlockEntityTag.Inventory", CopyNbtFunction.MergeStrategy.REPLACE)
			    	.copy("Energy", "BlockEntityTag.Energy", CopyNbtFunction.MergeStrategy.REPLACE))

				.apply(SetContainerContents.setContents(type)
						.withEntry(DynamicLoot.dynamicEntry(new ResourceLocation("minecraft", "contents"))))
					);
			    return LootTable.lootTable().withPool(builder);
			    
		}
		
		protected LootTable.Builder createSimpleTable(String name, Block block){
			LootPool.Builder builder = LootPool.lootPool()
				.name(name)
				.setRolls(ConstantValue.exactly(1))
				.add(LootItem.lootTableItem(block));
			return LootTable.lootTable().withPool(builder);
		}
}
