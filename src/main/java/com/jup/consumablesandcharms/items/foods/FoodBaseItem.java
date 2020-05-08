package com.jup.consumablesandcharms.items.foods;

import com.jup.consumablesandcharms.items.ConsumablesAndCharmsItems;
import com.jup.consumablesandcharms.potions.ConsumablesAndCharmsEffects;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class FoodBaseItem extends Item {
    public FoodBaseItem(Properties properties)
    {
        super(properties);
    }
    
    
    //Use this method to make effects which scale with an item's power.
    public static int getPowerMod(ItemStack stack, LivingEntity player)
    {
        int power = getTier(stack);
        
        if(player.isPotionActive(ConsumablesAndCharmsEffects.TASTE_OF_POWER))
        {
            EffectInstance potion = player.getActivePotionEffect(ConsumablesAndCharmsEffects.TASTE_OF_POWER);
            power = power + 2 + ((int)(Math.floor(potion.getAmplifier() * .4)));
        }
        
        return power;
    }
    
    public static int getTier(ItemStack stack)
    {
        if(stack.hasTag() && stack.getTag().contains("tier"))
        {
            return stack.getTag().getInt("tier");
        } else return 1;
    }
    
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
    {
        int tier = getTier(stack);
        
        ITextComponent message = new StringTextComponent("Tier " + tier);
        Style s = message.getStyle();
        
        if(tier >= 15)
        {
            s.setColor(TextFormatting.LIGHT_PURPLE);
        } else if(tier >= 10)
        {
            s.setColor(TextFormatting.AQUA);
        } else if(tier >= 5)
        {
            s.setColor(TextFormatting.YELLOW);
        }
        
        tooltip.add(message);
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }
    
    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, LivingEntity entityLiving)
    {
        if(entityLiving instanceof PlayerEntity)
        {
            if(entityLiving.getRNG().nextFloat() <= 0.01 && !worldIn.isRemote)
            {
                ((PlayerEntity) entityLiving).addItemStackToInventory(new ItemStack(ConsumablesAndCharmsItems.DIVINE_POWER));
            }
        }
        return super.onItemUseFinish(stack, worldIn, entityLiving);
    }
}
