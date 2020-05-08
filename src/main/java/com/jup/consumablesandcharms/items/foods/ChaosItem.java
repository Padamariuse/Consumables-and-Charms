package com.jup.consumablesandcharms.items.foods;

import com.jup.consumablesandcharms.potions.ConsumablesAndCharmsEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;

public class ChaosItem extends FoodBaseItem
{
    static EffectInstance[] effect = new EffectInstance[]
            {
                    new EffectInstance(Effects.BLINDNESS, 200, 0),
                    new EffectInstance(Effects.WITHER, 200, 1),
                    new EffectInstance(Effects.POISON, 200, 2),
                    new EffectInstance(Effects.HUNGER, 200, 1),
                    new EffectInstance(Effects.SLOWNESS, 200, 2),
                    new EffectInstance(Effects.UNLUCK, 200, 3),
                    new EffectInstance(Effects.LUCK, 200, 3),
                    new EffectInstance(Effects.NIGHT_VISION, 200, 0),
                    new EffectInstance(Effects.STRENGTH, 200, 1),
                    new EffectInstance(Effects.RESISTANCE, 200, 1),
                    new EffectInstance(Effects.REGENERATION, 200, 2),
                    new EffectInstance(Effects.JUMP_BOOST, 200, 2),
                    new EffectInstance(Effects.SPEED, 200, 2),
                    new EffectInstance(Effects.HASTE, 200, 2),
                    new EffectInstance(Effects.ABSORPTION, 200, 1),
                    new EffectInstance(Effects.FIRE_RESISTANCE, 200, 0),
                    new EffectInstance(Effects.GLOWING, 200, 0),
                    new EffectInstance(Effects.INSTANT_HEALTH, 20, 0),
                    new EffectInstance(Effects.INSTANT_DAMAGE, 20, 0),
                    new EffectInstance(Effects.INVISIBILITY, 200, 3),
                    new EffectInstance(Effects.WATER_BREATHING, 200, 0),
                    new EffectInstance(Effects.NAUSEA, 200, 0),
                    new EffectInstance(Effects.WEAKNESS, 200, 1),
                    new EffectInstance(Effects.LEVITATION, 200, 2),
                    new EffectInstance(Effects.MINING_FATIGUE, 300, 2),
                    new EffectInstance(Effects.SATURATION, 20, 1),
                    new EffectInstance(ConsumablesAndCharmsEffects.INFERNO, 200, 4),
                    new EffectInstance(ConsumablesAndCharmsEffects.SOARING, 200, 4),
                    new EffectInstance(ConsumablesAndCharmsEffects.SHOCKWAVE, 200, 4),
                    new EffectInstance(ConsumablesAndCharmsEffects.ENDER_DISTORTION, 200, 4)
            };
    
    public ChaosItem(Properties properties)
    {
        super(properties);
    }
    
    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving)
    {
        if(entityLiving instanceof PlayerEntity && !worldIn.isRemote)
        {
            EffectInstance e = new EffectInstance(effect[entityLiving.getRNG().nextInt(effect.length)]);
            for(int i = 0; entityLiving.getRNG().nextFloat() < .15F && getPowerMod(stack, entityLiving) > i && !e.getPotion().isBeneficial(); i++)
            {
                e = new EffectInstance(effect[entityLiving.getRNG().nextInt(effect.length)]);
            }
            
            entityLiving.addPotionEffect(e);
        }
        return super.onItemUseFinish(stack, worldIn, entityLiving);
    }
}
