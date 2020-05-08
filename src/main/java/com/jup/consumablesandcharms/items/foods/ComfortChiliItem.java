package com.jup.consumablesandcharms.items.foods;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class ComfortChiliItem extends FoodBaseItem
{
    public ComfortChiliItem(Properties properties)
    {
        super(properties);
    }
    
    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving)
    {
        if(entityLiving instanceof PlayerEntity)
        {
            BlockPos pos = ((PlayerEntity) entityLiving).getBedLocation(entityLiving.dimension);
            if(pos != null)
            {
                entityLiving.setPositionAndUpdate(pos.getX(), pos.getY() + 1, pos.getZ());
                if(!worldIn.isRemote)
                {
                    entityLiving.addPotionEffect(new EffectInstance(Effects.ABSORPTION, 400 + (getPowerMod(stack, entityLiving) * 100), getPowerMod(stack, entityLiving) - 1));
                    entityLiving.addPotionEffect(new EffectInstance(Effects.REGENERATION, 400 + (getPowerMod(stack, entityLiving) * 100), Math.floorDiv(getPowerMod(stack, entityLiving), 4)));
                }
            }
            else
            {
            }
        }
        return super.onItemUseFinish(stack, worldIn, entityLiving);
    }
}
