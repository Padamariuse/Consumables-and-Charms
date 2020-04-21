package com.jup.consumablesandcharms.potions.effects;

import com.jup.consumablesandcharms.ConsumablesAndCharms;
import com.jup.consumablesandcharms.potions.ConsumablesAndCharmsEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.EffectType;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Random;

@Mod.EventBusSubscriber(modid = ConsumablesAndCharms.MOD_ID, bus=Mod.EventBusSubscriber.Bus.FORGE)
public class EnderDistortionEffect extends Effect
{
    public EnderDistortionEffect()
    {
        super(EffectType.HARMFUL, 8618723);
    }
    
    @SubscribeEvent
    public static void onLivingUpdate(LivingEvent.LivingUpdateEvent event)
    {
        LivingEntity affected = event.getEntityLiving();
        EffectInstance potion = affected.getActivePotionEffect(ConsumablesAndCharmsEffects.ENDER_DISTORTION);
        if(affected.isPotionActive(ConsumablesAndCharmsEffects.ENDER_DISTORTION) && affected.getRNG().nextFloat() < 0.01 * (potion.getAmplifier() + 1))
        {
            Random rand = new Random();
            double d0 = affected.posX + (rand.nextDouble() - 0.5D) * 16.0D;
            double d1 = affected.posY + (double)(rand.nextInt(3));
            double d2 = affected.posZ + (rand.nextDouble() - 0.5D) * 16.0D;
            
            affected.setPositionAndUpdate(d0, d1, d2);
        }
    }
}
