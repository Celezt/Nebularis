package com.celezt.nebularis.data;

import com.celezt.nebularis.NebularisMod;
import com.celezt.nebularis.setup.ModItems;
import com.celezt.nebularis.setup.ModTags;

import net.minecraft.data.BlockTagsProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.ItemTagsProvider;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemTagsProvider extends ItemTagsProvider {

    public ModItemTagsProvider(DataGenerator generator, BlockTagsProvider blockTagsProvider, ExistingFileHelper existingFileHelper) {
        super(generator, blockTagsProvider, NebularisMod.MOD_ID, existingFileHelper);
    }
    
    @Override
    protected void addTags() {
        copy(ModTags.Blocks.ORES_NEBULARIUM, ModTags.Items.ORES_NEBULARIUM);
        copy(Tags.Blocks.ORES, Tags.Items.ORES);
        copy(ModTags.Blocks.STORAGE_BLOCKS_NEBULARIUM, ModTags.Items.STORAGE_BLOCKS_NEBULARIUM);
        copy(Tags.Blocks.STORAGE_BLOCKS, Tags.Items.STORAGE_BLOCKS);

        tag(ModTags.Items.RAW_NEBULARIUM).add(ModItems.RAW_NEBULARIUM.get());
        tag(Tags.Items.INGOTS).addTag(ModTags.Items.RAW_NEBULARIUM);
    }
}
