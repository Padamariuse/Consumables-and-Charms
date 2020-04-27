package com.jup.consumablesandcharms.data.recipes;

import com.jup.consumablesandcharms.items.ConsumablesAndCharmsItems;
import net.minecraft.advancements.criterion.InventoryChangeTrigger;
import net.minecraft.data.*;
import net.minecraft.item.Items;
import net.minecraft.item.crafting.IRecipeSerializer;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.IItemProvider;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Objects;
import java.util.function.Consumer;

public class ConsumablesAndCharmsRecipeProvider extends RecipeProvider
{
    
    public ConsumablesAndCharmsRecipeProvider(DataGenerator generatorIn)
    {
        super(generatorIn);
    }
    
    @Override
    protected void registerRecipes(Consumer<IFinishedRecipe> consumer)
    {
        cookingRecipesFor(consumer, Ingredient.fromItems(ConsumablesAndCharmsItems.HELL_MEAT), ConsumablesAndCharmsItems.HELL_STEAK, 0.0F, "has_hell_meat", hasItem(ConsumablesAndCharmsItems.HELL_MEAT));
    
        ShapelessRecipeBuilder.shapelessRecipe(ConsumablesAndCharmsItems.EARTHEN_FLOUR, 4).addIngredient(ConsumablesAndCharmsItems.FOREST_SALT, 2).addIngredient(Items.WHEAT, 2).addCriterion("has_wheat", hasItem(Items.WHEAT)).build(consumer);
    }
    
    private void cookingRecipesFor(Consumer<IFinishedRecipe> recipeBuilder, Ingredient input, IItemProvider result, float experience, String criterionName, InventoryChangeTrigger.Instance criterion)
    {
        ResourceLocation itemName = Objects.requireNonNull(ForgeRegistries.ITEMS.getKey(result.asItem()), "Registry name for "+result+" was found to be null!");
        CookingRecipeBuilder.smeltingRecipe(input, result, experience, 200).addCriterion(criterionName, criterion).build(recipeBuilder);
        CookingRecipeBuilder.cookingRecipe(input, result, experience, 100, IRecipeSerializer.SMOKING).addCriterion(criterionName, criterion).build(recipeBuilder, new ResourceLocation(itemName.getNamespace(), itemName.getPath()+"_from_smoking"));
        CookingRecipeBuilder.cookingRecipe(input, result, experience, 600, IRecipeSerializer.CAMPFIRE_COOKING).addCriterion(criterionName, criterion).build(recipeBuilder, new ResourceLocation(itemName.getNamespace(), itemName.getPath()+"_from_campfire_cooking"));
    }
    
    @Override
    public String getName()
    {
        return "Consumables and Charms Recipes";
    }
    
}
