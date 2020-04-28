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
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;

import static com.jup.consumablesandcharms.blocks.ConsumablesAndCharmsBlocks.*;

@ObjectHolder(ConsumablesAndCharms.MOD_ID)
public class ConsumablesAndCharmsItems
{
    public static final Item CANDYCICLE = null;
    public static final Item HOLY_COW = null;
    public static final Item GUNPOWDER_GANACHE_CAKE = null;
    public static final Item POPCHORUS = null;
    public static final Item ROCKET_COLA = null;
    public static final Item PLANET_COLA = null;
    public static final Item SOUP_OF_SINKING = null;
    public static final Item HARDENED_OATMEAL_COOKIE = null;
    public static final Item MATRON_MOTHER_MEATBALL = null;
    public static final Item COMFORT_CHILI = null;
    public static final Item CHORUS_FRUIT_JUICE = null;
    public static final Item SOARING_STEW = null;
    
    public static final Item HELL_MEAT = null;
    public static final Item FOREST_SALT = null;
    public static final Item GLACIER_MINT = null;
    public static final Item WITCHING_POWDER = null;
    public static final Item EARTHEN_FLOUR = null;
    public static final Item DIVINE_POWER = null;
    public static final Item STONE_CACAO = null;
    public static final Item BATED_BREATH = null;
    public static final Item OTHERWORDLY_RESIDUE = null;
    public static final Item SPIRIT_OF_ADVENTURE = null;
    
    public static Item HELL_STEAK = null;
    
    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event)
    {
        IForgeRegistry<Item> registry = event.getRegistry();
        
        //Consumables
        registry.register(new CandycicleItem(new Item.Properties().group(ConsumablesAndCharmsItemGroup.MAIN).food(ConsumablesAndCharmsFoods.CANDYCICLE)).setRegistryName(location("candycicle")));
        registry.register(new HolyCowItem(new Item.Properties().group(ConsumablesAndCharmsItemGroup.MAIN).food(ConsumablesAndCharmsFoods.HOLY_COW)).setRegistryName(location("holy_cow")));
        registry.register(new GunpowderGanacheCakeItem(new Item.Properties().group(ConsumablesAndCharmsItemGroup.MAIN).food(ConsumablesAndCharmsFoods.GUNPOWDER_GANACHE_CAKE)).setRegistryName(location("gunpowder_ganache_cake")));
        registry.register(new PopchorusItem(new Item.Properties().group(ConsumablesAndCharmsItemGroup.MAIN).food(ConsumablesAndCharmsFoods.POPCHORUS)).setRegistryName(location("popchorus")));
        registry.register(new RocketColaItem(new Item.Properties().group(ConsumablesAndCharmsItemGroup.MAIN).food(ConsumablesAndCharmsFoods.ROCKET_COLA)).setRegistryName(location("rocket_cola")));
        registry.register(new PlanetColaItem(new Item.Properties().group(ConsumablesAndCharmsItemGroup.MAIN).food(ConsumablesAndCharmsFoods.PLANET_COLA)).setRegistryName(location("planet_cola")));
        registry.register(new SoupOfSinkingItem(new Item.Properties().group(ConsumablesAndCharmsItemGroup.MAIN).food(ConsumablesAndCharmsFoods.SOUP_OF_SINKING)).setRegistryName(location("soup_of_sinking")));
        registry.register(new GiveEffectItem(() -> ConsumablesAndCharmsEffects.SHOCKWAVE, 100, 0, false, true, new Item.Properties().group(ConsumablesAndCharmsItemGroup.MAIN).food(ConsumablesAndCharmsFoods.HARDENED_OATMEAL_COOKIE)).setRegistryName(location("hardened_oatmeal_cookie")));
        registry.register(new MatronMotherMeatballItem(new Item.Properties().group(ConsumablesAndCharmsItemGroup.MAIN)).setRegistryName(location("matron_mother_meatball")));
        registry.register(new ComfortChiliItem(new Item.Properties().group(ConsumablesAndCharmsItemGroup.MAIN).food(ConsumablesAndCharmsFoods.COMFORT_CHILI)).setRegistryName(location("comfort_chili")));
        //registry.register(new ChorusFruitJuice(new Item.Properties().group(ConsumablesAndCharmsItemGroup.MAIN).food(ConsumablesAndCharmsFoods.CHORUS_FRUIT_JUICE)).setRegistryName(location("chorus_fruit_juice")));
        registry.register(new GiveEffectItem(() -> ConsumablesAndCharmsEffects.SOARING, 600, 0, false, true, new Item.Properties().group(ConsumablesAndCharmsItemGroup.MAIN).food(ConsumablesAndCharmsFoods.SOARING_STEW)).setRegistryName(location("soaring_stew")));
        
        //Ingredients
        registry.register(new Item(new Item.Properties().group(ConsumablesAndCharmsItemGroup.MAIN)).setRegistryName(location("hell_meat")));
        registry.register(new Item(new Item.Properties().group(ConsumablesAndCharmsItemGroup.MAIN)).setRegistryName(location("forest_salt")));
        registry.register(new Item(new Item.Properties().group(ConsumablesAndCharmsItemGroup.MAIN)).setRegistryName(location("glacier_mint")));
        registry.register(new Item(new Item.Properties().group(ConsumablesAndCharmsItemGroup.MAIN)).setRegistryName(location("witching_powder")));
        registry.register(new Item(new Item.Properties().group(ConsumablesAndCharmsItemGroup.MAIN)).setRegistryName(location("earthen_flour")));
        registry.register(new Item(new Item.Properties().group(ConsumablesAndCharmsItemGroup.MAIN)).setRegistryName(location("divine_power")));
        registry.register(new Item(new Item.Properties().group(ConsumablesAndCharmsItemGroup.MAIN)).setRegistryName(location("stone_cacao")));
        registry.register(new Item(new Item.Properties().group(ConsumablesAndCharmsItemGroup.MAIN)).setRegistryName(location("bated_breath")));
        registry.register(new Item(new Item.Properties().group(ConsumablesAndCharmsItemGroup.MAIN)).setRegistryName(location("otherwordly_residue")));
        registry.register(new Item(new Item.Properties().group(ConsumablesAndCharmsItemGroup.MAIN).food(ConsumablesAndCharmsFoods.HELL_STEAK)).setRegistryName(location("spirit_of_adventure")));
        
        //Food
        registry.register(new Item(new Item.Properties().group(ConsumablesAndCharmsItemGroup.MAIN)).setRegistryName("hell_steak"));
        
        //Blocks
        registerBlockItem(registry, new BlockItem(ARCANOKITCHEN, new Item.Properties().group(ConsumablesAndCharmsItemGroup.MAIN)));
        registerBlockItem(registry, new BlockItem(MOUNTAIN_CACAO, new Item.Properties().group(ConsumablesAndCharmsItemGroup.MAIN)));
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
