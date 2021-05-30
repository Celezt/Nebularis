package com.celezt.nebularis.data;

import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import com.celezt.nebularis.setup.ModBlocks;
import com.celezt.nebularis.setup.ModItems;
import com.celezt.nebularis.setup.Registration;
import com.google.common.collect.ImmutableList;
import com.mojang.datafixers.util.Pair;

import net.minecraft.block.Block;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.LootTableProvider;
import net.minecraft.data.loot.BlockLootTables;
import net.minecraft.loot.LootParameterSet;
import net.minecraft.loot.LootParameterSets;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.LootTableManager;
import net.minecraft.loot.ValidationTracker;
import net.minecraft.loot.LootTable.Builder;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.RegistryObject;

public class ModLootTableProvider extends LootTableProvider {

    public ModLootTableProvider(DataGenerator generator) {
        super(generator);
    }
    
    @Override
    protected List<Pair<Supplier<Consumer<BiConsumer<ResourceLocation, Builder>>>, LootParameterSet>> getTables() {
        return ImmutableList.of(
            Pair.of(ModBlockLootTables::new, LootParameterSets.BLOCK)
        );
    }

    @Override
    protected void validate(Map<ResourceLocation, LootTable> map, ValidationTracker validationtracker) {
        map.forEach((p_218507_2_, p_218507_3_) -> LootTableManager.validate(validationtracker, p_218507_2_, p_218507_3_));
    }

    public static class ModBlockLootTables extends BlockLootTables{
        @Override
        protected void addTables() {
            dropSelf(ModBlocks.RAW_NEBULARIUM_BLOCK.get());

            add(ModBlocks.NEBULARIUM_ORE.get(), (block) -> {
                return createOreDrop(block, ModItems.RAW_NEBULARIUM.get());
            });      
        }

        @Override
        protected Iterable<Block> getKnownBlocks() {
            return Registration.BLOCKS.getEntries().stream().map(RegistryObject::get).collect(Collectors.toList());
        }
    }
}
