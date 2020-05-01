package com.jup.consumablesandcharms.world.features;

import com.jup.consumablesandcharms.ConsumablesAndCharms;
import com.jup.consumablesandcharms.blocks.ConsumablesAndCharmsBlocks;
import net.java.games.input.Controller;
import net.minecraft.block.Blocks;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.ScatteredPlantFeature;
import net.minecraft.world.gen.placement.FrequencyConfig;
import net.minecraft.world.gen.placement.Placement;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;

@ObjectHolder(ConsumablesAndCharms.MOD_ID)
@Mod.EventBusSubscriber(modid = ConsumablesAndCharms.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ConsumablesAndCharmsFeatures
{
    public static final Feature<NoFeatureConfig> MOUNTAIN_CACAO = null;
    
    @SubscribeEvent
    public static void registerFeatures(RegistryEvent.Register<Feature<?>> event)
    {
        IForgeRegistry<Feature<?>> registry = event.getRegistry();
    
        registry.register(new UniqueBlockScatteredPlantFeature(NoFeatureConfig::deserialize, ConsumablesAndCharmsBlocks.MOUNTAIN_CACAO.getDefaultState(), Blocks.STONE).setRegistryName("mountain_cacao"));
    }
    
    public static void gen()
    {
        for(Biome biome : ForgeRegistries.BIOMES)
        {
            if (BiomeDictionary.getTypes(biome).contains(BiomeDictionary.Type.MOUNTAIN))
            {
                biome.addFeature(GenerationStage.Decoration.VEGETAL_DECORATION, biome.createDecoratedFeature(MOUNTAIN_CACAO, IFeatureConfig.NO_FEATURE_CONFIG, Placement.COUNT_HEIGHTMAP_32, new FrequencyConfig(8)));
            }
        }
    }
}
