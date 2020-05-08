package com.jup.consumablesandcharms.items.foods;

import com.jup.consumablesandcharms.items.ConsumablesAndCharmsItems;
import com.jup.consumablesandcharms.items.MoteOfDeathItem;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

import java.util.List;

public class DeathHarvestItem extends FoodBaseItem
{
    public DeathHarvestItem(Properties properties)
    {
        super(properties);
    }
    
    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving)
    {
        if(entityLiving instanceof PlayerEntity)
        {
            List<Entity> entities = entityLiving.world.getEntitiesWithinAABBExcludingEntity(entityLiving, entityLiving.getBoundingBox().expand(15, 15.0D, -15.0D).offset(-7.5, -7.5, 7.5));
            for(int i = 0; entities.size() > i; i++)
            {
                Entity listEntity = entities.get(i);
                if(listEntity instanceof LivingEntity)
                {
                    double damagemod = 4.0 + getPowerMod(stack, entityLiving);
                    if(damagemod > 10 )
                        damagemod = 10;
                    listEntity.attackEntityFrom(DamageSource.MAGIC, ((float)damagemod));
                    
                    if(((LivingEntity) listEntity).getHealth() <= 0)
                    {
                        ItemStack mote = new ItemStack(ConsumablesAndCharmsItems.MOTE_OF_DEATH, 1);
                        CompoundNBT nbt = mote.getOrCreateTag();
                        nbt.putInt("tier", getPowerMod(stack, entityLiving));
                        
                        ((PlayerEntity) entityLiving).addItemStackToInventory(mote);
                    }
                }
            }
        }
        return super.onItemUseFinish(stack, worldIn, entityLiving);
    }
}
