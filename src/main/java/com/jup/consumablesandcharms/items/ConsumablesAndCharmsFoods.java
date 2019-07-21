package com.jup.consumablesandcharms.items;

import net.minecraft.item.Food;

public class ConsumablesAndCharmsFoods
{
    public static final Food candycicle = (new Food.Builder()).hunger(3).saturation(0.2F).build();
    public static final Food holyCow = (new Food.Builder()).hunger(9).saturation(0.9F).build();
    public static final Food gunpowderGanacheCake = (new Food.Builder()).hunger(6).saturation(0.5F).build();
    public static final Food popchorus = (new Food.Builder()).hunger(1).saturation(0.0F).fastToEat().build();
}
