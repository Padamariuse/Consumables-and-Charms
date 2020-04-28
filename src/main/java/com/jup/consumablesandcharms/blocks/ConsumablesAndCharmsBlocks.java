package com.jup.consumablesandcharms.blocks;

import com.jup.consumablesandcharms.ConsumablesAndCharms;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

public class ConsumablesAndCharmsBlocks
{
    public static Block ARCANOKITCHEN;
    public static Block MOUNTAIN_CACAO;
    
    @SubscribeEvent
    public static void registerBlocks(IForgeRegistry<Block> registry)
    {
        registry.register(ARCANOKITCHEN = new ArcanokitchenBlock().setRegistryName("arcanokitchen"));
        registry.register(MOUNTAIN_CACAO = new StoneFloraBlock(Block.Properties.create(Material.ROCK).doesNotBlockMovement().hardnessAndResistance(0.2F).sound(SoundType.STONE)).setRegistryName("mountain_cacao"));
    }
    
    private static ResourceLocation location(String name)
    {
        return new ResourceLocation(ConsumablesAndCharms.MOD_ID, name);
    }
}
