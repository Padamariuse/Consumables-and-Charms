package com.jup.consumablesandcharms.potions.effects;

import com.jup.consumablesandcharms.ConsumablesAndCharms;
import com.jup.consumablesandcharms.potions.ConsumablesAndCharmsEffects;
import net.minecraft.block.Blocks;
import net.minecraft.client.particle.FlameParticle;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.particles.BlockParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.EffectType;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.event.entity.player.CriticalHitEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = ConsumablesAndCharms.MOD_ID, bus=Mod.EventBusSubscriber.Bus.FORGE)
public class InfernoEffect extends Effect
{
    public InfernoEffect()
    {
        super(EffectType.BENEFICIAL, 16076572);
    }
    
    @SubscribeEvent
    public static void onCrit(CriticalHitEvent event)
    {
        Entity affected = event.getPlayer();
        EffectInstance potion = ((PlayerEntity) affected).getActivePotionEffect(ConsumablesAndCharmsEffects.INFERNO);
        Entity target = event.getTarget();
        if(potion != null && event.isVanillaCritical() && target instanceof LivingEntity)
        {
            target.setFire(2 + potion.getAmplifier());
            if(target.isBurning())
            {
                target.attackEntityFrom(DamageSource.IN_FIRE, ((float)(2.0F + (potion.getAmplifier() * .1))));
                for(int i = 0; i < ((PlayerEntity) affected).getRNG().nextInt(20) + 10; i++)
                    target.world.addParticle(ParticleTypes.FLAME, (double)((float)target.posX + 0.5F), (double)((float)target.posY + 0.5F), (double)((float)target.posZ + 0.5F), 0, 0,0);
                target.playSound(SoundEvents.BLOCK_FIRE_AMBIENT, 1.3F, 1F);
            }
        }
    }
}
