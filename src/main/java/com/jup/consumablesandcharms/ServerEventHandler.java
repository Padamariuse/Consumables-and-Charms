package com.jup.consumablesandcharms;

import com.jup.consumablesandcharms.items.ConsumablesAndCharmsItems;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.data.LootTableProvider;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.ItemEntity;
import net.minecraft.entity.monster.ZombiePigmanEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Rarity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraft.world.storage.loot.*;
import net.minecraftforge.common.Tags;
import net.minecraftforge.event.LootTableLoadEvent;
import net.minecraftforge.event.entity.living.EnderTeleportEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.Random;

@Mod.EventBusSubscriber(modid = ConsumablesAndCharms.MOD_ID, bus=Mod.EventBusSubscriber.Bus.FORGE)
public class ServerEventHandler
{
    @SubscribeEvent
    public static void onEndermanTeleport(EnderTeleportEvent event)
    {
        LivingEntity e = event.getEntityLiving();
        if(e.getRNG().nextFloat() < 0.02F)
        {
            e.world.addEntity(new ItemEntity(e.world, event.getTargetX(), event.getTargetY(), event.getTargetZ(), new ItemStack(ConsumablesAndCharmsItems.OTHERWORDLY_RESIDUE)));
        }
    }
    
    @SubscribeEvent
    public static void onLivingDeath(LivingDeathEvent event)
    {
        Random ran = new Random();
        Entity e = event.getEntity();
        if(e instanceof PlayerEntity)
        {
            if(ran.nextFloat() < 0.04)
                e.world.addEntity(new ItemEntity(e.world, e.posX, e.posY, e.posZ, new ItemStack(ConsumablesAndCharmsItems.BATED_BREATH)));
        }
    }
    
    @SubscribeEvent
    public static void onBlockBreak(BlockEvent.BreakEvent event)
    {
        BlockState s = event.getState();
        Random ran = new Random();
        double x = event.getPos().getX();
        double y = event.getPos().getY();
        double z = event.getPos().getZ();
        
        if(!event.getPlayer().isCreative())
        {
            if(s == Blocks.BLUE_ICE.getDefaultState() && ran.nextFloat() < 0.2)
            {
                event.getWorld().addEntity(new ItemEntity(event.getPlayer().world, x, y, z, new ItemStack(ConsumablesAndCharmsItems.GLACIER_MINT)));
            }
    
            if(s.isIn(Tags.Blocks.ORES_COAL) && ran.nextFloat() < 0.06)
            {
                event.getWorld().addEntity(new ItemEntity(event.getPlayer().world, x, y, z, new ItemStack(ConsumablesAndCharmsItems.WITCHING_POWDER)));
            }
    
            if((s == Blocks.GRASS.getDefaultState() || s == Blocks.TALL_GRASS.getDefaultState()) && ran.nextFloat() < 0.04)
            {
                event.getWorld().addEntity(new ItemEntity(event.getPlayer().world, x, y, z, new ItemStack(ConsumablesAndCharmsItems.FOREST_SALT)));
            }
        }
    }
    
    @SubscribeEvent
    public static void onMobDrops(LivingDropsEvent event)
    {
        double x = event.getEntity().posX;
        double y = event.getEntity().posY;
        double z = event.getEntity().posZ;
        
        if(event.getEntity() instanceof ZombiePigmanEntity)
        {
            event.getDrops().add(new ItemEntity(event.getEntity().world, x, y, z, new ItemStack(ConsumablesAndCharmsItems.HELL_MEAT)));
        }
    }
    
    @SubscribeEvent
    public static void onLootLoad(LootTableLoadEvent event)
    {
        if(event.getName().equals(LootTables.CHESTS_SIMPLE_DUNGEON) || event.getName().equals(LootTables.CHESTS_JUNGLE_TEMPLE) ||
                event.getName().equals(LootTables.CHESTS_DESERT_PYRAMID) || event.getName().equals(LootTables.CHESTS_ABANDONED_MINESHAFT) ||
                event.getName().equals(LootTables.CHESTS_WOODLAND_MANSION) || event.getName().equals(LootTables.CHESTS_BURIED_TREASURE) ||
                event.getName().equals(LootTables.CHESTS_IGLOO_CHEST) || event.getName().equals(LootTables.CHESTS_NETHER_BRIDGE) ||
                event.getName().equals(LootTables.CHESTS_SHIPWRECK_TREASURE))
        {
            event.getTable().addPool(LootPool.builder().addEntry(TableLootEntry.builder(new ResourceLocation(ConsumablesAndCharms.MOD_ID, "chests/vanilla_loot"))).build());
            System.out.println("if this works i can die peacefully");
        }
    }
}
