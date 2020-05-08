package com.jup.consumablesandcharms.items.foods;

import com.jup.consumablesandcharms.potions.ConsumablesAndCharmsEffects;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.world.World;

import java.util.List;

public class InfernoItem extends FoodBaseItem
{
    public InfernoItem(Properties properties)
    {
        super(properties);
    }
    
    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World world, LivingEntity entity)
    {
        if(entity instanceof PlayerEntity)
        {
            if(!world.isRemote)
            {
                entity.addPotionEffect(new EffectInstance(Effects.FIRE_RESISTANCE, 140 + (60 * getPowerMod(stack, entity)), 0));
                entity.addPotionEffect(new EffectInstance(ConsumablesAndCharmsEffects.INFERNO, 240 + (60 * getPowerMod(stack, entity)), getPowerMod(stack, entity)-1));
            }
    
            for(int i = 0; i < entity.getRNG().nextInt(30) + 55; i++)
                entity.world.addParticle(ParticleTypes.FLAME, (double)((float)entity.posX + 0.5F), (double)((float)entity.posY + 0.5F), (double)((float)entity.posZ + 0.5F), 0, 0, 0);
            
            world.playSound(entity.posX, entity.posY, entity.posZ, SoundEvents.ENTITY_WITHER_SHOOT, SoundCategory.PLAYERS, 1.0F, 1.0F, true);
            
            int bbmod = (getPowerMod(stack, entity)-1) * 5;
            List<Entity> entities = entity.world.getEntitiesWithinAABBExcludingEntity(entity, entity.getBoundingBox().expand(15 + bbmod, 15.0D + bbmod, -15.0D - bbmod).offset(-7.5 - (bbmod / 2), -7.5 - (bbmod / 2), 7.5 + (bbmod / 2)));
            for(int i = 0; entities.size() > i; i++)
            {
                Entity listEntity = entities.get(i);
                if(listEntity instanceof LivingEntity)
                {
                    listEntity.setFire(5 + getPowerMod(stack, entity));
                }
            }
        }
        return super.onItemUseFinish(stack, world, entity);
    }
}
