package com.jup.consumablesandcharms.items;

import com.jup.consumablesandcharms.ConsumablesAndCharms;
import com.jup.consumablesandcharms.items.foods.*;
import com.jup.consumablesandcharms.items.foods.CandycicleItem;
import com.jup.consumablesandcharms.items.foods.PopchorusItem;
import com.jup.consumablesandcharms.potions.ConsumablesAndCharmsEffects;
import net.minecraft.item.*;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistry;

import static com.jup.consumablesandcharms.blocks.ConsumablesAndCharmsBlocks.*;

public class ConsumablesAndCharmsItems
{
    public static Item CANDYCICLE;
    public static Item HOLY_COW;
    public static Item GUNPOWDER_GANACHE_CAKE;
    public static Item POPCHORUS;
    public static Item ROCKET_COLA;
    public static Item SOUP_OF_SINKING;
    public static Item HARDENED_OATMEAL_COOKIE;
    public static Item MATRON_MOTHER_MEATBALL;
    
    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event)
    {
        IForgeRegistry<Item> registry = event.getRegistry();
        
        registerBlockItem(registry, new BlockItem(ARCANOKITCHEN, new Item.Properties().group(ConsumablesAndCharmsItemGroup.MAIN)));
        
        registry.register(CANDYCICLE = new CandycicleItem(new Item.Properties().group(ConsumablesAndCharmsItemGroup.MAIN).food(ConsumablesAndCharmsFoods.CANDYCICLE)).setRegistryName(location("candycicle")));
        registry.register(HOLY_COW = new HolyCowItem(new Item.Properties().group(ConsumablesAndCharmsItemGroup.MAIN).food(ConsumablesAndCharmsFoods.HOLY_COW)).setRegistryName(location("holy_cow")));
        registry.register(GUNPOWDER_GANACHE_CAKE = new GunpowderGanacheCakeItem(new Item.Properties().group(ConsumablesAndCharmsItemGroup.MAIN).food(ConsumablesAndCharmsFoods.GUNPOWDER_GANACHE_CAKE)).setRegistryName(location("gunpowder_ganache_cake")));
        registry.register(POPCHORUS = new PopchorusItem(new Item.Properties().group(ConsumablesAndCharmsItemGroup.MAIN).food(ConsumablesAndCharmsFoods.POPCHORUS)).setRegistryName(location("popchorus")));
        registry.register(ROCKET_COLA = new RocketColaItem(new Item.Properties().group(ConsumablesAndCharmsItemGroup.MAIN).food(ConsumablesAndCharmsFoods.ROCKET_COLA)).setRegistryName(location("rocket_cola")));
        registry.register(SOUP_OF_SINKING = new SoupOfSinkingItem(new Item.Properties().group(ConsumablesAndCharmsItemGroup.MAIN).food(ConsumablesAndCharmsFoods.SOUP_OF_SINKING)).setRegistryName(location("soup_of_sinking")));
        registry.register(HARDENED_OATMEAL_COOKIE = new GiveEffectItem(() -> ConsumablesAndCharmsEffects.SHOCKWAVE, 100, 0, false, true, new Item.Properties().group(ConsumablesAndCharmsItemGroup.MAIN).food(ConsumablesAndCharmsFoods.HARDENED_OATMEAL_COOKIE)).setRegistryName(location("hardened_oatmeal_cookie")));
        registry.register(MATRON_MOTHER_MEATBALL = new MatronMotherMeatballItem(new Item.Properties().group(ConsumablesAndCharmsItemGroup.MAIN)).setRegistryName(location("matron_mother_meatball")));
    }
    
    private static Item registerBlockItem(IForgeRegistry<Item> registry, BlockItem item)
    {
        registry.register(item.setRegistryName(item.getBlock().getRegistryName()));
        return item;
    }
    
    private static ResourceLocation location(String name)
    {
        return new ResourceLocation(ConsumablesAndCharms.MOD_ID, name);
    }
}
