package com.jup.consumablesandcharms.proxy;

import com.jup.consumablesandcharms.entities.MatronMotherMeatballEntity;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.SpriteRenderer;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class ClientProxy
{
    public static void init()
    {
        RenderingRegistry.registerEntityRenderingHandler(MatronMotherMeatballEntity.class, manager -> new SpriteRenderer<>(manager, Minecraft.getInstance().getItemRenderer()));
    }
}
