package com.jup.consumablesandcharms.items.foods;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class RocketColaItem extends FoodBaseItem
{
    public RocketColaItem(Properties properties)
    {
        super(properties);
    }
    
    @Override
    public ItemStack onItemUseFinish(ItemStack i, World w, LivingEntity e)
    {
        Vec3d vec = e.getLookVec().normalize();
        double f = getTier(i) * .75;
        
        e.addVelocity(vec.x * f, vec.y * f, vec.z * f);
        return super.onItemUseFinish(i, w, e);
    }
}
