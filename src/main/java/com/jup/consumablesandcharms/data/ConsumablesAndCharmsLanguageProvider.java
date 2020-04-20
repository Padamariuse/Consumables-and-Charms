package com.jup.consumablesandcharms.data;

import net.minecraft.data.DataGenerator;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.data.LanguageProvider;

public abstract class ConsumablesAndCharmsLanguageProvider extends LanguageProvider
{
    public ConsumablesAndCharmsLanguageProvider(DataGenerator gen, String modid, String locale)
    {
        super(gen, modid, locale);
    }
    
    protected void add(ItemGroup key, String value)
    {
        add(key.getTranslationKey(), value);
    }
}
