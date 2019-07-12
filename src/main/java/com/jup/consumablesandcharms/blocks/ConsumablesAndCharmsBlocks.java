package com.jup.consumablesandcharms.blocks;

import com.jup.consumablesandcharms.ConsumablesAndCharms;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

public class ConsumablesAndCharmsBlocks
{
    public static Block ARCANOKITCHEN;
    
    @SubscribeEvent
    public static void registerBlocks(IForgeRegistry<Block> registry)
    {
        registry.register(ARCANOKITCHEN = new BlockArcanokitchen().setRegistryName("arcanokitchen"));
    }
    
    private static ResourceLocation location(String name)
    {
        return new ResourceLocation(ConsumablesAndCharms.MOD_ID, name);
    }
}