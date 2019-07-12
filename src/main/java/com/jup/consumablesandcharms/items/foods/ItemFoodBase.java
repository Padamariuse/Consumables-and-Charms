package com.jup.consumablesandcharms.items.foods;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class ItemFoodBase extends Item {
    CompoundNBT nbt;
    public ItemFoodBase(Properties properties) {
        super(properties);
    }
    
    public static int getTier(ItemStack stack)
    {
        if(!stack.getOrCreateTag().contains("Tier"))
        {
            stack.getTag().putInt("Tier", 1);
        }
    
        return stack.getTag().getInt("Tier");
    }
    
    @Override
    public void onCreated(ItemStack stack, World worldIn, PlayerEntity playerIn) {
        stack.getOrCreateTag().putInt("Tier", 1);
        
        super.onCreated(stack, worldIn, playerIn);
    }
    
    
    
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
    {
        if (stack.hasTag() && stack.getTag().contains("Tier"))
        {
            ITextComponent message = new StringTextComponent("item.tier" + stack.getTag().getInt("Tier"));
            message.getStyle().setColor(TextFormatting.GOLD);
            tooltip.add(message);
        }
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }
}
