package com.jup.consumablesandcharms.items.foods;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.world.World;

import static net.minecraft.potion.Effects.LEVITATION;

public class ItemPopchorus extends ItemFoodBase
{
    public ItemPopchorus(Properties properties)
    {
        super(properties);
    }
    
    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving)
    {
        entityLiving.addPotionEffect(new EffectInstance(LEVITATION, 20, getTier(stack)));
        return super.onItemUseFinish(stack, worldIn, entityLiving);
    }
}
