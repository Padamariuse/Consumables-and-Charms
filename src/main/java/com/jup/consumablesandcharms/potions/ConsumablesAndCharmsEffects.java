package com.jup.consumablesandcharms.potions;

import com.jup.consumablesandcharms.ConsumablesAndCharms;
import com.jup.consumablesandcharms.potions.effects.EnderDistortionEffect;
import com.jup.consumablesandcharms.potions.effects.ShockwaveEffect;
import net.minecraft.potion.Effect;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ConsumablesAndCharmsEffects
{
    public static final Effect ENDER_DISTORTION = new EnderDistortionEffect().setRegistryName(ConsumablesAndCharms.MOD_ID, "ender_distortion");
    public static final Effect SHOCKWAVE = new ShockwaveEffect().setRegistryName(ConsumablesAndCharms.MOD_ID, "shockwave");
    public static final Effect SOARING = new ShockwaveEffect().setRegistryName(ConsumablesAndCharms.MOD_ID, "soaring");
    
    @SubscribeEvent
    public static void registerEffects(RegistryEvent.Register<Effect> register)
    {
        register.getRegistry().register(ENDER_DISTORTION);
        register.getRegistry().register(SHOCKWAVE);
        register.getRegistry().register(SOARING);
    }
}
