package com.jup.consumablesandcharms.items.foods;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ClockTacoItem extends FoodBaseItem
{
    public ClockTacoItem(Properties properties)
    {
        super(properties);
    }
    
    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving)
    {
        worldIn.setDayTime(worldIn.getDayTime() + (500 * getPowerMod(stack, entityLiving)));
        return super.onItemUseFinish(stack, worldIn, entityLiving);
    }
}
