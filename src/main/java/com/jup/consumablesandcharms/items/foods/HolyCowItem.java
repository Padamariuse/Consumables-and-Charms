package com.jup.consumablesandcharms.items.foods;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

import java.util.List;

public class HolyCowItem extends FoodBaseItem
{
    public HolyCowItem(Properties properties) {
        super(properties);
    }
    
    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        if(entityLiving instanceof PlayerEntity)
        {
            List<Entity> entities = entityLiving.world.getEntitiesWithinAABBExcludingEntity(entityLiving, entityLiving.getBoundingBox().expand(20.0D, 20.0D, -20.0D).offset(-10, -10, 10));
            for(int i = 0; entities.size() > i; i++)
            {
                Entity listEntity = entities.get(i);
                if(listEntity instanceof LivingEntity)
                {
                    if(((LivingEntity) listEntity).isEntityUndead() && !listEntity.world.isRemote())
                    {
                        listEntity.attackEntityFrom(DamageSource.LIGHTNING_BOLT, 50.0F);
                    }
                    else if(getTier(stack) > 1 && !listEntity.world.isRemote())
                    {
                        listEntity.attackEntityFrom(DamageSource.LIGHTNING_BOLT, 5.0F * getTier(stack));
                    }
                }
            }
        }
        return super.onItemUseFinish(stack, worldIn, entityLiving);
    }
}
