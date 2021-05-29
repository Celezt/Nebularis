package com.celezt.nebularis.data;

import com.celezt.nebularis.NebularisMod;
import com.celezt.nebularis.setup.ModBlocks;
import com.celezt.nebularis.setup.ModTags;

import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModBlockTagsProvider extends BlockTagsProvider {
    public ModBlockTagsProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, NebularisMod.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        tag(ModTags.Blocks.ORES_NEBULARIUM).add(ModBlocks.NEBULARIUM_ORE.get());
        tag(Tags.Blocks.ORES).addTag(ModTags.Blocks.ORES_NEBULARIUM);
        tag(ModTags.Blocks.STORAGE_BLOCKS_NEBULARIUM).add(ModBlocks.NEBULARIUM_BLOCK.get());
        tag(Tags.Blocks.STORAGE_BLOCKS).addTag(ModTags.Blocks.STORAGE_BLOCKS_NEBULARIUM);
    }
}
