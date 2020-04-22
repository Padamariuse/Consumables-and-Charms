package com.jup.consumablesandcharms.entities;

import com.jup.consumablesandcharms.ConsumablesAndCharms;
import com.jup.consumablesandcharms.items.ConsumablesAndCharmsItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.IRendersAsItem;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.monster.GhastEntity;
import net.minecraft.entity.projectile.ThrowableEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.network.IPacket;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvents;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.network.NetworkHooks;
import net.minecraftforge.registries.ObjectHolder;

public class MatronMotherMeatballEntity extends ThrowableEntity implements IRendersAsItem
{
    private LivingEntity throwerIn;
    private int tier;
    
    public MatronMotherMeatballEntity(EntityType<? extends MatronMotherMeatballEntity> type, World world)
    {
        super(type, world);
    }
    
    public MatronMotherMeatballEntity(EntityType<? extends MatronMotherMeatballEntity> type, double x, double y, double z, World worldIn)
    {
        super(type, x, y, z, worldIn);
    }
    
    public MatronMotherMeatballEntity(EntityType<? extends MatronMotherMeatballEntity> type, LivingEntity livingEntityIn, World worldIn, int tier)
    {
        super(type, livingEntityIn, worldIn);
        this.tier = tier;
    }
    
    @Override
    protected float getGravityVelocity()
    {
        return 0.01F;
    }
    
    @Override
    protected void onImpact(RayTraceResult result)
    {
        GhastEntity ghast = new GhastEntity(EntityType.GHAST, world);
        Vec3d vec = result.getHitVec();
        
        for(int i = 0; i < 1 + tier; i++)
        {
            if(world.isRemote())
                world.addEntity(ghast);
        }
        
        world.playSound(vec.x, vec.y, vec.z, SoundEvents.BLOCK_SLIME_BLOCK_BREAK, SoundCategory.NEUTRAL, 1.0F, 1.0F, true);
        if(!world.isRemote)
        {
            this.remove();
        }
    }
    
    @Override
    public IPacket<?> createSpawnPacket()
    {
        return NetworkHooks.getEntitySpawningPacket(this);
    }
    
    @Override
    protected void registerData()
    {}
    
    @Override
    public ItemStack getItem()
    {
        return ConsumablesAndCharmsItems.MATRON_MOTHER_MEATBALL.getDefaultInstance();
    }
}
