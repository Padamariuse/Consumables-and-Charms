package com.jup.consumablesandcharms.items.foods;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.boss.WitherEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.BlockParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

public class SoupOfSinkingItem extends FoodBaseItem
{
    
    public SoupOfSinkingItem(Properties properties)
    {
        super(properties);
    }
    
    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World world, LivingEntity entity)
    {
        List<Entity> entities = entity.world.getEntitiesWithinAABBExcludingEntity(entity, entity.getBoundingBox().expand(20.0D, 20.0D, -20.0D).offset(-10, -10, 10));
        for(int i = 0; entities.size() > i; i++)
        {
            Entity listEntity = entities.get(i);
            
            if(listEntity instanceof LivingEntity)
            {
                BlockState b = getBlockBelow(listEntity, world);
    
                double x = listEntity.posX;
                double y = listEntity.posY;
                double z = listEntity.posZ;
    
                int d = MathHelper.floor(x);
                int e = MathHelper.floor(y - (double)0.2F);
                int f = MathHelper.floor(z);
                BlockPos blockpos = new BlockPos(d, e, f);
    
                WitherEntity testingWither = new WitherEntity(EntityType.WITHER, world);
                
                for(int a = 0; a < 2+getPowerMod(stack, entity) && b.getBlock().canEntityDestroy(b, world, blockpos, testingWither); a++)
                {
                    x = listEntity.posX;
                    y = listEntity.posY;
                    z = listEntity.posZ;
    
                    //sets block to air
                    d = MathHelper.floor(x);
                    e = MathHelper.floor(y - (double)0.2F);
                    f = MathHelper.floor(z);
                    b = getBlockBelow(listEntity, world);
                    blockpos = new BlockPos(d, e, f);
                    world.setBlockState(blockpos, Blocks.AIR.getDefaultState());
                    
                    //particles & sound
                    Random rand = new Random();
                    int j = rand.nextInt(2) * 2 - 1;
                    int k = rand.nextInt(2) * 2 - 1;
                    double d0 = (double)x + 0.5D + 0.25D * (double)j;
                    double d1 = (double)((float)y + rand.nextFloat());
                    double d2 = (double)z + 0.5D + 0.25D * (double)k;
                    double d3 = (double)(rand.nextFloat() * (float)j);
                    double d4 = ((double)rand.nextFloat() - 0.5D) * 0.125D;
                    double d5 = (double)(rand.nextFloat() * (float)k);
                    world.addParticle(new BlockParticleData(ParticleTypes.BLOCK, Blocks.DIRT.getDefaultState()), d0, d1, d2, d3, d4, d5);
                    listEntity.playSound(SoundEvents.BLOCK_GRASS_BREAK, 1.0F, 0.8F);
                    
                    //moves entity
                    listEntity.setPositionAndUpdate(x, y - 1, z);
                    b = getBlockBelow(listEntity, world);
                }
            }
        }
        return super.onItemUseFinish(stack, world, entity);
    }
    
    public BlockState getBlockBelow(Entity entity, World world)
    {
        int d = MathHelper.floor(entity.posX);
        int e = MathHelper.floor(entity.posY - (double)0.2F);
        int f = MathHelper.floor(entity.posZ);
        BlockPos blockpos = new BlockPos(d, e, f);
        
        return world.getBlockState(blockpos);
    }
}
