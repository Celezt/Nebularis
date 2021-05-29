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
        copy(ModTags.Blocks.ORES_CRUSTOSE_LICHER, ModTags.Items.ORES_CRUSTOSE_LICHER);
        copy(Tags.Blocks.ORES, Tags.Items.ORES);

        tag(ModTags.Items.RAW_CRUSTOSE_LICHER).add(ModItems.RAW_CRUSTOSE_LICHEN.get());
        tag(Tags.Items.INGOTS).addTag(ModTags.Items.RAW_CRUSTOSE_LICHER);
    }
}
