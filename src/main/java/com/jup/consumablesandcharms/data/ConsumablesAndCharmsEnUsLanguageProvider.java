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
        add(ConsumablesAndCharmsItems.PLANET_COLA, "Planet Cola");
        add(ConsumablesAndCharmsItems.SOUP_OF_SINKING, "Soup of Sinking");;
        add(ConsumablesAndCharmsItems.HARDENED_OATMEAL_COOKIE, "Hardened Oatmeal Cookie");
        add(ConsumablesAndCharmsItems.MATRON_MOTHER_MEATBALL, "Matron Mother Meatball");
        add(ConsumablesAndCharmsItems.COMFORT_CHILI, "Comfort Chili");
        add(ConsumablesAndCharmsItems.SOARING_STEW, "Soaring Stew");
        add(ConsumablesAndCharmsItems.HEART_OF_THE_SUSHI, "Heart of the Sushi");
        add(ConsumablesAndCharmsItems.MAGNETIC_NACHOS, "Magnetic Nachos");
        add(ConsumablesAndCharmsItems.DARK_HARVESTED_SALAD, "Dark Harvested Salad");
        add(ConsumablesAndCharmsItems.INFERNO_CELERY, "Inferno Celery");
        add(ConsumablesAndCharmsItems.CHAOS_FRUIT_GUMMIES, "Chaos Fruit Gummies");
        add(ConsumablesAndCharmsItems.HELL_MEAT, "Hell Meat");
        add(ConsumablesAndCharmsItems.FOREST_SALT, "Forest Salt");
        add(ConsumablesAndCharmsItems.GLACIER_MINT, "Glaciermint");
        add(ConsumablesAndCharmsItems.WITCHING_POWDER, "Witching Powder");
        add(ConsumablesAndCharmsItems.EARTHEN_FLOUR, "Earthen Flour");
        add(ConsumablesAndCharmsItems.DIVINE_POWER, "Divine Power");
        add(ConsumablesAndCharmsItems.STONE_CACAO, "Stone Cacao");
        add(ConsumablesAndCharmsItems.BATED_BREATH, "Bated Breath");
        add(ConsumablesAndCharmsItems.OTHERWORDLY_RESIDUE, "Otherwordly Residue");
        add(ConsumablesAndCharmsItems.SPIRIT_OF_ADVENTURE, "Spirit of Adventure");
        add(ConsumablesAndCharmsItems.HELL_STEAK, "Hell Steak");
        add(ConsumablesAndCharmsItems.MOTE_OF_DEATH, "Mote of Death");
        
        add(ConsumablesAndCharmsBlocks.ARCANOKITCHEN, "Arcanokitchen");
        add(ConsumablesAndCharmsBlocks.MOUNTAIN_CACAO, "Mountain Cacao");
        
        add(ConsumablesAndCharmsEffects.ENDER_DISTORTION, "Ender Distortion");
        add(ConsumablesAndCharmsEffects.SHOCKWAVE, "Shockwave");
        add(ConsumablesAndCharmsEffects.SOARING, "Soaring");
        add(ConsumablesAndCharmsEffects.INFERNO, "Inferno");
    
        add(ConsumablesAndCharmsItemGroup.MAIN, "Consumables and Charms");
    }
}
