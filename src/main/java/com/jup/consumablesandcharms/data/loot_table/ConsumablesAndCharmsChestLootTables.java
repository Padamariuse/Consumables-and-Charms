package com.jup.consumablesandcharms.data.loot_table;

import com.jup.consumablesandcharms.items.ConsumablesAndCharmsItems;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.ConstantRange;
import net.minecraft.world.storage.loot.ItemLootEntry;
import net.minecraft.world.storage.loot.LootPool;
import net.minecraft.world.storage.loot.LootTable;

import java.util.function.BiConsumer;
import java.util.function.Consumer;

public class ConsumablesAndCharmsChestLootTables implements Consumer<BiConsumer<ResourceLocation, LootTable.Builder>>
{
    public static final ResourceLocation VANILLA_LOOT_CHEST = new ResourceLocation("consumablesandcharms", "chests/vanilla_loot");
    
    @Override
    public void accept(BiConsumer<ResourceLocation, LootTable.Builder> rlbbs)
    {
        rlbbs.accept(VANILLA_LOOT_CHEST, LootTable.builder()
            .addLootPool(LootPool.builder().name("MAIN").rolls(ConstantRange.of(1))
                .addEntry(ItemLootEntry.builder(ConsumablesAndCharmsItems.SPIRIT_OF_ADVENTURE).weight(1))));
    }
}
