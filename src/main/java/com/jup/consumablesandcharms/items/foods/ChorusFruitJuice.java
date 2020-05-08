package com.jup.consumablesandcharms.items.foods;

import com.jup.consumablesandcharms.potions.ConsumablesAndCharmsEffects;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.UseAction;
import net.minecraft.potion.EffectInstance;
import net.minecraft.world.World;

public class ChorusFruitJuice extends FoodBaseItem
{
    public ChorusFruitJuice(Properties properties)
    {
        super(properties);
    }
    
    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving)
    {
        entityLiving.addPotionEffect(new EffectInstance(ConsumablesAndCharmsEffects.ENDER_DISTORTION, 200, 1-getPowerMod(stack, entityLiving)));
        return super.onItemUseFinish(stack, worldIn, entityLiving);
    }
    
    @Override
    public UseAction getUseAction(ItemStack stack)
    {
        return UseAction.DRINK;
    }
}
