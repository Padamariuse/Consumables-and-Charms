package com.jup.consumablesandcharms.items.foods;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.List;

public class MagnetFoodItem extends FoodBaseItem
{
    public MagnetFoodItem(Properties properties)
    {
        super(properties);
    }
    
    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving)
    {
        if(entityLiving instanceof PlayerEntity)
        {
            int bbmod = (getPowerMod(stack, entityLiving)-1) * 5;
            List<Entity> entities = entityLiving.world.getEntitiesWithinAABBExcludingEntity(entityLiving, entityLiving.getBoundingBox().expand(15 + bbmod, 15.0D + bbmod, -15.0D - bbmod).offset(-7.5 - (bbmod / 2), -7.5 - (bbmod / 2), 7.5 + (bbmod / 2)));
            for(int i = 0; entities.size() > i; i++)
            {
                Entity listEntity = entities.get(i);
                if(listEntity instanceof ItemEntity)
                {
                    listEntity.addVelocity((entityLiving.posX - listEntity.posX), (entityLiving.posY - listEntity.posY), (entityLiving.posZ - listEntity.posZ));
                }
            }
        }
        return super.onItemUseFinish(stack, worldIn, entityLiving);
    }
}
