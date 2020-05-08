package com.jup.consumablesandcharms.potions;

import com.jup.consumablesandcharms.ConsumablesAndCharms;
import com.jup.consumablesandcharms.potions.effects.BaseEffect;
import com.jup.consumablesandcharms.potions.effects.EnderDistortionEffect;
import com.jup.consumablesandcharms.potions.effects.InfernoEffect;
import com.jup.consumablesandcharms.potions.effects.ShockwaveEffect;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.EffectType;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ConsumablesAndCharmsEffects
{
    public static final Effect ENDER_DISTORTION = new EnderDistortionEffect().setRegistryName(ConsumablesAndCharms.MOD_ID, "ender_distortion");
    public static final Effect SHOCKWAVE = new ShockwaveEffect().setRegistryName(ConsumablesAndCharms.MOD_ID, "shockwave");
    public static final Effect SOARING = new ShockwaveEffect().setRegistryName(ConsumablesAndCharms.MOD_ID, "soaring");
    public static final Effect INFERNO = new InfernoEffect().setRegistryName(ConsumablesAndCharms.MOD_ID, "inferno");
    public static final Effect TASTE_OF_POWER = new BaseEffect(EffectType.BENEFICIAL, 12751653).setRegistryName(ConsumablesAndCharms.MOD_ID, "taste_of_power");
    
    @SubscribeEvent
    public static void registerEffects(RegistryEvent.Register<Effect> register)
    {
        register.getRegistry().register(ENDER_DISTORTION);
        register.getRegistry().register(SHOCKWAVE);
        register.getRegistry().register(SOARING);
        register.getRegistry().register(INFERNO);
        register.getRegistry().register(TASTE_OF_POWER);
    }
}
