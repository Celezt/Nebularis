package com.celezt.nebularis.setup;

import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;

public class ModItems {
    public static final RegistryObject<Item> SILVER_INGOT = Registration.ITEMS.register("silver_ingot", () -> 
        new Item(new Item.Properties().tab(ItemGroup.TAB_MATERIALS)));

    public static void register() {}
}
