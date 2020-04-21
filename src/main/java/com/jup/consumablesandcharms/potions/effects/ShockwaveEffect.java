package com.jup.consumablesandcharms.potions.effects;

import com.jup.consumablesandcharms.ConsumablesAndCharms;
import com.jup.consumablesandcharms.potions.ConsumablesAndCharmsEffects;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.EffectType;
import net.minecraft.util.DamageSource;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.List;
import java.util.Random;

@Mod.EventBusSubscriber(modid = ConsumablesAndCharms.MOD_ID, bus=Mod.EventBusSubscriber.Bus.FORGE)
public class ShockwaveEffect extends Effect
{
    public ShockwaveEffect()
    {
        super(EffectType.BENEFICIAL, 6308404);
    }
    
    @SubscribeEvent
    public static void onFall(LivingFallEvent e)
    {
        LivingEntity affected = e.getEntityLiving();
        EffectInstance potion = affected.getActivePotionEffect(ConsumablesAndCharmsEffects.SHOCKWAVE);
        if(affected.isPotionActive(ConsumablesAndCharmsEffects.SHOCKWAVE) && e.getDistance() >= 4)
        {
            Entity entity = e.getEntity();
            int addifier = 3 * potion.getAmplifier();
            
            List<Entity> entities = entity.world.getEntitiesWithinAABBExcludingEntity(e.getEntity(), entity.getBoundingBox().expand(20.0D + addifier, 20.0D + addifier, -20.0D - addifier).offset(-10D - addifier / 2, -10D - addifier / 2, 10D + addifier / 2));
            for(int i = 0; entities.size() > i; i++)
            {
                Entity listEntity = entities.get(i);
                if(listEntity instanceof LivingEntity)
                {
                    listEntity.attackEntityFrom(DamageSource.GENERIC, 3 + (2 * potion.getAmplifier()));
                    listEntity.addVelocity(0, 1.5 * (potion.getAmplifier() + 1) / 5, 0);
                }
            }
        }
    }
}
