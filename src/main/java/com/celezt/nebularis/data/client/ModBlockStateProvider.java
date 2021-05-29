package com.celezt.nebularis.data.client;

import com.celezt.nebularis.NebularisMod;
import com.celezt.nebularis.setup.ModBlocks;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockStateProvider extends BlockStateProvider {

    public ModBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, NebularisMod.MOD_ID, exFileHelper);      
    }

    @Override
    protected void registerStatesAndModels() {
        simpleBlock(ModBlocks.CRUSTOSE_LICHEN_STONE.get());
    }  
}
