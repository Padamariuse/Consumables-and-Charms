package com.jup.consumablesandcharms.items.foods;

import com.jup.consumablesandcharms.entities.ConsumablesAndCharmsEntityTypes;
import com.jup.consumablesandcharms.entities.MatronMotherMeatballEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.stats.Stats;
import net.minecraft.util.*;
import net.minecraft.world.World;

public class MatronMotherMeatballItem extends FoodBaseItem
{
    public MatronMotherMeatballItem(Properties properties)
    {
        super(properties);
    }
    
    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn)
    {
        ItemStack item = playerIn.getHeldItem(handIn);
        
        if(!playerIn.isCreative() && playerIn.canEat(true))
        {
            item.shrink(1);
            playerIn.getFoodStats().addStats(3, 0.6F);
        }
    
        worldIn.playSound(null, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ENTITY_GENERIC_EAT, SoundCategory.NEUTRAL, 1.0F, 1.0F);
    
        if(!worldIn.isRemote)
        {
            MatronMotherMeatballEntity meatball = new MatronMotherMeatballEntity(ConsumablesAndCharmsEntityTypes.MATRON_MOTHER_MEATBALL, playerIn, worldIn, getTier(playerIn.getHeldItem(handIn)));
            meatball.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, -20.0F, 0.7F, 1.0F);
            worldIn.addEntity(meatball);
        }
    
        playerIn.addStat(Stats.ITEM_USED.get(this));
        return new ActionResult<>(ActionResultType.SUCCESS, new ItemStack(this));
    }
}
