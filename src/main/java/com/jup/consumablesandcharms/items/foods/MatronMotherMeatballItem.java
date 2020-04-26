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
        Boolean c = playerIn.isCreative();
        
        if(!c && playerIn.canEat(false))
        {
            playerIn.getFoodStats().addStats(7, 0.6F);
        } else if(c) {}
        else
        {
            return super.onItemRightClick(worldIn, playerIn, handIn);
        }
    
        worldIn.playSound(null, playerIn.posX, playerIn.posY, playerIn.posZ, SoundEvents.ENTITY_GENERIC_EAT, SoundCategory.NEUTRAL, 1.0F, 1.0F);
    
        if(!worldIn.isRemote)
        {
            MatronMotherMeatballEntity meatball = new MatronMotherMeatballEntity(ConsumablesAndCharmsEntityTypes.MATRON_MOTHER_MEATBALL, playerIn, worldIn, getTier(playerIn.getHeldItem(handIn)));
            meatball.shoot(playerIn, playerIn.rotationPitch, playerIn.rotationYaw, 0.0F, 2.25F, 1.0F);
            worldIn.addEntity(meatball);
        }
        
        if(!c)
            item.shrink(1);
        
        playerIn.addStat(Stats.ITEM_USED.get(this));
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}
