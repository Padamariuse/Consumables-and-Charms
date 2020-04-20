package com.jup.consumablesandcharms.data;

import com.jup.consumablesandcharms.ConsumablesAndCharms;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = ConsumablesAndCharms.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ConsumablesAndCharmsData
{
    @SubscribeEvent
    public static void gatherData(GatherDataEvent e)
    {
        DataGenerator gen = e.getGenerator();
        if(e.includeServer())
        {
            gen.addProvider(new ConsumablesAndCharmsEnUsLanguageProvider(gen));
        }
    }
}
