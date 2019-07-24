package com.jup.consumablesandcharms.recipes;

import com.jup.consumablesandcharms.ConsumablesAndCharms;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.IRecipeType;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

import java.util.ArrayList;
import java.util.Arrays;

public class ArcanokitchenRecipe implements IRecipe<Inventory>
{
    protected final ResourceLocation id;
    protected final ItemStack output;
    protected final NonNullList<Ingredient> inputs;
    
    public ArcanokitchenRecipe(ResourceLocation id, ItemStack output, NonNullList<Ingredient> inputs)
    {
        this.id = id;
        this.output = output;
        this.inputs = inputs;
    }
    
    @Override
    public boolean matches(Inventory inv, World worldIn)
    {
        return false;
    }
    
    @Override
    public ItemStack getCraftingResult(Inventory inv)
    {
        return this.output.copy();
    }
    
    @Override
    public ItemStack getRecipeOutput()
    {
        return output;
    }
    
    @Override
    public ResourceLocation getId()
    {
        return id;
    }
    
    @Override
    public IRecipeSerializer<?> getSerializer()
    {
        return null;
    }
    
    @Override
    public IRecipeType<?> getType()
    {
        return null;
    }
}
