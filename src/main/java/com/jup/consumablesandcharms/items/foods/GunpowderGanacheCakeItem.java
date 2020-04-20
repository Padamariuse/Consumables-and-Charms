package com.jup.consumablesandcharms.items.foods;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.LightningBoltEntity;
import net.minecraft.entity.monster.CreeperEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;

import java.util.List;

public class GunpowderGanacheCakeItem extends FoodBaseItem
{
    public GunpowderGanacheCakeItem(Properties properties)
    {
        super(properties);
    }
    
    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving)
    {
        if (entityLiving instanceof PlayerEntity)
        {
            List<Entity> entities = entityLiving.world.getEntitiesWithinAABBExcludingEntity(entityLiving, entityLiving.getBoundingBox().expand(20.0D, 20.0D, -20.0D).offset(-10, -10, 10));
            for (int i = 0; entities.size() > i; i++)
            {
                Entity listEntity = entities.get(i);
                if (listEntity instanceof LivingEntity)
                {
                    if (listEntity instanceof CreeperEntity)
                    {
                        ((CreeperEntity) listEntity).ignite();
                    } else if (getTier(stack) > 1 && !listEntity.world.isRemote())
                    {
                        float listEntityMaxHealth = ((LivingEntity) listEntity).getMaxHealth();
                        if (listEntityMaxHealth < (getTier(stack) * 5) - 5)
                        {
                            listEntity.world.createExplosion(listEntity, listEntity.posX, listEntity.posY, listEntity.posZ, 1.0F, Explosion.Mode.DESTROY);
                            listEntity.attackEntityFrom(DamageSource.GENERIC, listEntityMaxHealth);
                        }
                    }
                }
            }
        }
        return super.onItemUseFinish(stack, worldIn, entityLiving);
    }
}
