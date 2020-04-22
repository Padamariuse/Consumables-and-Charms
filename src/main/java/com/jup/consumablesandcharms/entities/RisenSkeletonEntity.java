package com.jup.consumablesandcharms.entities;

import net.minecraft.entity.CreatureEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.MobEntity;
import net.minecraft.entity.ai.goal.LookAtGoal;
import net.minecraft.entity.ai.goal.LookRandomlyGoal;
import net.minecraft.entity.ai.goal.NearestAttackableTargetGoal;
import net.minecraft.entity.ai.goal.SwimGoal;
import net.minecraft.entity.monster.CreeperEntity;
import net.minecraft.entity.monster.IMob;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.HandSide;
import net.minecraft.world.World;

public class RisenSkeletonEntity extends CreatureEntity
{
    public RisenSkeletonEntity(EntityType<? extends CreatureEntity> type, World world)
    {
        super(type, world);
    }
    
    @Override
    protected void registerGoals() {
        goalSelector.addGoal(1, new SwimGoal(this));
        goalSelector.addGoal(2, new LookAtGoal(this, PlayerEntity.class, 6.0F));
        goalSelector.addGoal(3, new LookRandomlyGoal(this));
        this.targetSelector.addGoal(5, new NearestAttackableTargetGoal<>(this, MobEntity.class, 5, false, false, (p_213619_0_) -> {
            return p_213619_0_ instanceof IMob;
        }));
    }
}

