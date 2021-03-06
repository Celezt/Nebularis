package com.celezt.nebularis.setup;

import java.util.function.Supplier;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.fml.RegistryObject;

public class ModBlocks {
    public static final RegistryObject<Block> NEBULARIUM_ORE = register("nebularium_ore", () ->
        new Block(AbstractBlock.Properties.of(Material.STONE)
            .strength(3, 10)
            .harvestLevel(2)
            .requiresCorrectToolForDrops()
            .sound(SoundType.STONE)));

    public static final RegistryObject<Block> RAW_NEBULARIUM_BLOCK = register("raw_nebularium_block", () ->
        new Block(AbstractBlock.Properties.of(Material.METAL)
            .strength(4, 20)
            .harvestLevel(2)
            .requiresCorrectToolForDrops()
            .sound(SoundType.METAL)));

    public static void register() {}

    private static <T extends Block> RegistryObject<T> registerNoTiem(String name, Supplier<T> block){
        return Registration.BLOCKS.register(name, block);
    }

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block){
        RegistryObject<T> ret = registerNoTiem(name, block);
        Registration.ITEMS.register(name, () -> new BlockItem(ret.get(), new Item.Properties().tab(ItemGroup.TAB_BUILDING_BLOCKS)));
        return ret;
    }
}
