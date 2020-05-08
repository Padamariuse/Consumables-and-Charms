package com.jup.consumablesandcharms.items.foods;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

import java.util.List;

public class PlanetColaItem extends FoodBaseItem
{
    public PlanetColaItem(Properties properties)
    {
        super(properties);
    }
    
    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving) {
        if(entityLiving instanceof PlayerEntity)
        {
            List<Entity> entities = entityLiving.world.getEntitiesWithinAABBExcludingEntity(entityLiving, entityLiving.getBoundingBox().expand(25.0D, 25.0D, -25.0D).offset(-12.5, -12.5, 12.5));
            for(int i = 0; entities.size() > i; i++)
            {
                Entity listEntity = entities.get(i);
                if(listEntity instanceof LivingEntity)
                {
                    Vec3d vec = entityLiving.getLookVec().normalize();
                    double f = getPowerMod(stack, entityLiving) * 0.65;
    
                    listEntity.addVelocity(vec.x * f, vec.y * f, vec.z * f);
                }
            }
        }
        return super.onItemUseFinish(stack, worldIn, entityLiving);
    }
}
