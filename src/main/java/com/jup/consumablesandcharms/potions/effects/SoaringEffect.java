package com.jup.consumablesandcharms.potions.effects;

import com.jup.consumablesandcharms.ConsumablesAndCharms;
import com.jup.consumablesandcharms.potions.ConsumablesAndCharmsEffects;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.EffectType;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.Vec3d;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ConsumablesAndCharms.MOD_ID, bus=Mod.EventBusSubscriber.Bus.FORGE)
public class SoaringEffect extends Effect
{
    protected SoaringEffect()
    {
        super(EffectType.BENEFICIAL, 11518149);
    }
    
    @SubscribeEvent
    public static void onLivingTick(PlayerEvent.LivingUpdateEvent event)
    {
        if(event.getEntityLiving().isPotionActive(ConsumablesAndCharmsEffects.SOARING))
            event.getEntity().fallDistance = 0.0F;
    }
    
    @SubscribeEvent
    public static void onEntityJump(PlayerEvent.LivingJumpEvent event)
    {
        Entity e = event.getEntityLiving();
        EffectInstance potion = ((LivingEntity) e).getActivePotionEffect(ConsumablesAndCharmsEffects.SOARING);
        
        if(((LivingEntity) e).isPotionActive(ConsumablesAndCharmsEffects.SOARING))
        {
            Vec3d vec = e.getLookVec().normalize();
            int amp = potion.getAmplifier() + 1;
            
            e.addVelocity(1.5 * Math.sqrt(amp) * vec.x, 1.5 * Math.sqrt(amp) * vec.y, 1.5 * Math.sqrt(amp) * vec.z);
            e.playSound(SoundEvents.ENTITY_ENDER_DRAGON_FLAP, 1.0F, 1.0F);
        }
    }
}
