package com.jup.consumablesandcharms.entities;

import com.jup.consumablesandcharms.ConsumablesAndCharms;
import net.minecraft.entity.EntityClassification;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.MobEntity;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.IForgeRegistry;
import net.minecraftforge.registries.ObjectHolder;

import javax.annotation.Nonnull;

@ObjectHolder(ConsumablesAndCharms.MOD_ID)
@Mod.EventBusSubscriber(modid = ConsumablesAndCharms.MOD_ID, bus=Mod.EventBusSubscriber.Bus.MOD)
public final class ConsumablesAndCharmsEntityTypes
{
    public static final EntityType<RisenSkeletonEntity> RISEN_SKELETON = getNull();
    public static final EntityType<MatronMotherMeatballEntity> MATRON_MOTHER_MEATBALL= getNull();
    
    @Nonnull
    private static <T> T getNull()
    {
        return null;
    }
    
    @SubscribeEvent
    public static void registerEntities(final RegistryEvent.Register<EntityType<?>> event)
    {
        IForgeRegistry<EntityType<?>> registry = event.getRegistry();
        
        register(registry, EntityType.Builder.<RisenSkeletonEntity>create(RisenSkeletonEntity::new, EntityClassification.MONSTER).size(0.51F, 0.51F), "risen_skeleton");
        register(registry, EntityType.Builder.<MatronMotherMeatballEntity>create(MatronMotherMeatballEntity::new, EntityClassification.MISC), "matron_mother_meatball");
    }
    
    public static void registerPlacements()
    {
    }
    
    private static void register(IForgeRegistry<EntityType<?>> registry, EntityType.Builder<?> builder, String name)
    {
        EntityType<?> type = builder.build(ConsumablesAndCharms.MOD_ID + ":" + name);
        registry.register(type.setRegistryName(name));
    }
}
