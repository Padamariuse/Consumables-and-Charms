package com.jup.consumablesandcharms;

import com.jup.consumablesandcharms.blocks.ConsumablesAndCharmsBlocks;
import com.jup.consumablesandcharms.proxy.ClientProxy;
import com.jup.consumablesandcharms.items.ConsumablesAndCharmsItems;
import com.jup.consumablesandcharms.potions.ConsumablesAndCharmsEffects;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.potion.Effect;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(ConsumablesAndCharms.MOD_ID)
public class ConsumablesAndCharms
{
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();
    
    public static final String MOD_ID = "consumablesandcharms";
    
    public ConsumablesAndCharms()
    {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {
    }

    private void doClientStuff(final FMLClientSetupEvent event)
    {
        ClientProxy.init();
    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
    }

    private void processIMC(final InterModProcessEvent event)
    {
    }
    
    @SubscribeEvent
    public void onServerStarting(FMLServerStartingEvent event)
    {
    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus=Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> event)
        {
            ConsumablesAndCharmsBlocks.registerBlocks(event.getRegistry());
        }
        
        @SubscribeEvent
        public static void onItemRegistry(final RegistryEvent.Register<Item> event)
        {
            ConsumablesAndCharmsItems.registerItems(event);
        }
    
        @SubscribeEvent
        public static void onPotionRegistry(final RegistryEvent.Register<Effect> event)
        {
            ConsumablesAndCharmsEffects.registerEffects(event);
        }
    }
}
