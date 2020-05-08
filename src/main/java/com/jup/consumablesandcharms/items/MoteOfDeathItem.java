package com.jup.consumablesandcharms.items;

import net.minecraft.block.Blocks;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.List;

public class MoteOfDeathItem extends Item
{
    public MoteOfDeathItem(Properties properties)
    {
        super(properties);
    }
    
    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn)
    {
        playerIn.addPotionEffect(new EffectInstance(Effects.STRENGTH, 50, getTier(playerIn.getHeldItem(handIn)) - 1));
        
        playerIn.getHeldItem(handIn).shrink(1);
        return super.onItemRightClick(worldIn, playerIn, handIn);
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
        
        ITextComponent message = new StringTextComponent("On use, grants Strength " + tier);
        Style s = message.getStyle();
        s.setColor(TextFormatting.GRAY);
        
        tooltip.add(message);
        super.addInformation(stack, worldIn, tooltip, flagIn);
    }
}
