package com.jup.consumablesandcharms.data.loot_tables;

import com.jup.consumablesandcharms.items.ConsumablesAndCharmsItems;
import net.minecraft.data.loot.BlockLootTables;
import net.minecraft.world.storage.loot.*;
import net.minecraft.world.storage.loot.functions.SetCount;

import static com.jup.consumablesandcharms.blocks.ConsumablesAndCharmsBlocks.*;

public class ConsumablesAndCharmsBlockLootTables extends BlockLootTables
{
    @Override
    protected void addTables()
    {
        func_218492_c(ARCANOKITCHEN);
        
        registerLootTable(MOUNTAIN_CACAO, LootTable.builder()
                .addLootPool(LootPool.builder().name("mountain_cacao").rolls(ConstantRange.of(1))
                        .addEntry(ItemLootEntry.builder(ConsumablesAndCharmsItems.STONE_CACAO).acceptFunction(SetCount.func_215932_a(RandomValueRange.func_215837_a(2.0F, 4.0F))))));
        super.addTables();
    }
}
