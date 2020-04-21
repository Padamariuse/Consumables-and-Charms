package com.jup.consumablesandcharms.items.foods;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.world.World;

import java.util.function.Supplier;

public class GiveEffectItem extends FoodBaseItem
{
    private final Supplier<Effect> effect;
    private int duration;
    private int amplifier;
    private final boolean tieredDuration;
    private final boolean tieredAmplifier;
    
    public GiveEffectItem(Supplier<Effect> effect, int duration, int amplifier, boolean tieredDuration, boolean tieredAmplifier, Properties properties)
    {
        super(properties);
        this.effect = effect;
        this.duration = duration;
        this.amplifier = amplifier;
        this.tieredDuration = tieredDuration;
        this.tieredAmplifier = tieredAmplifier;
    }
    
    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World world, LivingEntity entity)
    {
        if(tieredDuration)
            duration = duration * getTier(stack);
        if(tieredAmplifier)
            amplifier = getTier(stack) - 1;
        
        if(!world.isRemote)
            entity.addPotionEffect(new EffectInstance(effect.get(), duration, amplifier));
        return super.onItemUseFinish(stack, world, entity);
    }
}
