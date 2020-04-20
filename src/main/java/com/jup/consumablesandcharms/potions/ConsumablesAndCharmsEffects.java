package com.jup.consumablesandcharms.potions;

import com.jup.consumablesandcharms.ConsumablesAndCharms;
import com.jup.consumablesandcharms.potions.effects.EnderDistortionEffect;
import net.minecraft.potion.Effect;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ConsumablesAndCharmsEffects
{
    public static final Effect ENDER_DISTORTION = new EnderDistortionEffect().setRegistryName(ConsumablesAndCharms.MOD_ID, "ender_distortion");
    
    @SubscribeEvent
    public static void registerEffects(RegistryEvent.Register<Effect> register)
    {
        register.getRegistry().register(ENDER_DISTORTION);
    }
}
