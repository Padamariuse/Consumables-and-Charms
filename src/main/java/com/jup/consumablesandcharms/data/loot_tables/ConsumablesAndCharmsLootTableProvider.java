package com.jup.consumablesandcharms.data.loot_tables;

import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.LootTableProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootParameterSet;
import net.minecraft.world.storage.loot.LootParameterSets;
import net.minecraft.world.storage.loot.LootTable;
import net.minecraft.world.storage.loot.ValidationResults;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class ConsumablesAndCharmsLootTableProvider extends LootTableProvider
{
    public ConsumablesAndCharmsLootTableProvider(DataGenerator dataGeneratorIn)
    {
        super(dataGeneratorIn);
    }
    
    @Override
    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>>, LootParameterSet>> getTables()
    {
        return ImmutableList.of(Pair.of(ConsumablesAndCharmsChestLootTables::new, LootParameterSets.CHEST), Pair.of(ConsumablesAndCharmsBlockLootTables::new, LootParameterSets.BLOCK));
    }
    
    @Override
    protected void validate(Map<ResourceLocation, LootTable> lootTableMap, ValidationResults results)
    {
    
    }
    
    @Override
    public String getName()
    {
        return "Consumables and Charms Loot";
    }
}