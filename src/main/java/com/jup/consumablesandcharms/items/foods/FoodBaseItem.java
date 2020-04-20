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

public class FoodBaseItem extends Item {
    CompoundNBT nbt;
    public FoodBaseItem(Properties properties) {
        super(properties);
    }
    
    public static int getTier(ItemStack stack)
    {
        if(stack.hasTag() && stack.getTag().contains("Tier"))
        {
            return stack.getTag().getInt("Tier");
        } else return 1;
    }
    
    public static String getModifier(ItemStack stack)
    {
        if(stack.hasTag() && stack.getTag().contains("Modifier"))
        {
            return stack.getTag().getString("Modifier");
        } else return "None";
    }
    
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn)
    {
        ITextComponent message = new StringTextComponent("Tier " + getTier(stack));
        message.getStyle().setColor(TextFormatting.GOLD);
        tooltip.add(message);
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }
}
