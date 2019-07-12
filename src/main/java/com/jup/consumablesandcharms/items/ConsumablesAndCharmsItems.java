package com.jup.consumablesandcharms.items;

import com.jup.consumablesandcharms.ConsumablesAndCharms;
import com.jup.consumablesandcharms.items.foods.ItemCandycicle;
import com.jup.consumablesandcharms.items.foods.ItemHolyCow;
import net.minecraft.block.Block;
import net.minecraft.item.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

import static com.jup.consumablesandcharms.blocks.ConsumablesAndCharmsBlocks.*;

public class ConsumablesAndCharmsItems
{
    public static Item CANDYCICLE;
    public static Item HOLY_COW;
    
    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event)
    {
        IForgeRegistry<Item> registry = event.getRegistry();
        
        registerBlockItem(registry, new BlockItem(ARCANOKITCHEN, new Item.Properties().group(ConsumablesAndCharmsItemGroup.MAIN)));
        registry.register(CANDYCICLE = new ItemCandycicle(new Item.Properties().group(ConsumablesAndCharmsItemGroup.MAIN).food(ConsumablesAndCharmsFoods.candycicle)).setRegistryName(location("candycicle")));
        registry.register(HOLY_COW = new ItemHolyCow(new Item.Properties().group(ConsumablesAndCharmsItemGroup.MAIN).food(ConsumablesAndCharmsFoods.holyCow)).setRegistryName(location("holy_cow")));
    }
    
    private static Item registerBlockItem(IForgeRegistry<Item> registry, BlockItem item)
    {
        registry.register(item.setRegistryName(item.getBlock().getRegistryName()));
        return item;
    }
    
    private static ResourceLocation location(String name)
    {
        return new ResourceLocation(ConsumablesAndCharms.MOD_ID, name);
    }
}
