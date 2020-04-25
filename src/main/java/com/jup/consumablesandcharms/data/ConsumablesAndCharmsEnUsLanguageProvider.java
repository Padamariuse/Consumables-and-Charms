package com.jup.consumablesandcharms.data;

import com.jup.consumablesandcharms.ConsumablesAndCharms;
import com.jup.consumablesandcharms.blocks.ConsumablesAndCharmsBlocks;
import com.jup.consumablesandcharms.items.ConsumablesAndCharmsItemGroup;
import com.jup.consumablesandcharms.items.ConsumablesAndCharmsItems;
import com.jup.consumablesandcharms.potions.ConsumablesAndCharmsEffects;
import net.minecraft.data.DataGenerator;

public class ConsumablesAndCharmsEnUsLanguageProvider extends ConsumablesAndCharmsLanguageProvider
{
    ConsumablesAndCharmsEnUsLanguageProvider(DataGenerator gen)
    {
        super(gen, ConsumablesAndCharms.MOD_ID, "en_us");
    }
    
    @Override
    protected void addTranslations()
    {
        add(ConsumablesAndCharmsItems.CANDYCICLE, "Candycicle");
        add(ConsumablesAndCharmsItems.HOLY_COW, "Holy Cow!");
        add(ConsumablesAndCharmsItems.GUNPOWDER_GANACHE_CAKE, "Gunpowder Ganache Cake");
        add(ConsumablesAndCharmsItems.POPCHORUS, "Popchorus");
        add(ConsumablesAndCharmsItems.ROCKET_COLA, "Rocket Cola");
        add(ConsumablesAndCharmsItems.SOUP_OF_SINKING, "Soup of Sinking");;
        add(ConsumablesAndCharmsItems.HARDENED_OATMEAL_COOKIE, "Hardened Oatmeal Cookie");
        add(ConsumablesAndCharmsItems.MATRON_MOTHER_MEATBALL, "Matron Mother Meatball");
        
        add(ConsumablesAndCharmsBlocks.ARCANOKITCHEN, "Arcanokitchen");
        
        add(ConsumablesAndCharmsEffects.ENDER_DISTORTION, "Ender Distortion");
        add(ConsumablesAndCharmsEffects.SHOCKWAVE, "Shockwave");
    
        add(ConsumablesAndCharmsItemGroup.MAIN, "Consumables and Charms");
    }
}
