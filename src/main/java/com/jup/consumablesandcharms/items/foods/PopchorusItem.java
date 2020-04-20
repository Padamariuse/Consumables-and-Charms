package com.jup.consumablesandcharms.items.foods;

import com.jup.consumablesandcharms.potions.ConsumablesAndCharmsEffects;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

import java.util.List;

public class PopchorusItem extends FoodBaseItem
{
    public PopchorusItem(Properties properties)
    {
        super(properties);
    }
    
    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving)
    {
        List<Entity> entities = entityLiving.world.getEntitiesWithinAABBExcludingEntity(entityLiving, entityLiving.getBoundingBox().expand(20.0D, 20.0D, -20.0D).offset(-10, -10, 10));
        for(int i = 0; entities.size() > i; i++)
        {
            Entity listEntity = entities.get(i);
            if(listEntity instanceof LivingEntity)
            {
                ((LivingEntity) listEntity).addPotionEffect(new EffectInstance(ConsumablesAndCharmsEffects.ENDER_DISTORTION, 60, 0 + getTier(stack)));
            }
        }
        return super.onItemUseFinish(stack, worldIn, entityLiving);
    }
}
