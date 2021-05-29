package com.celezt.nebularis.data.client;

import com.celezt.nebularis.NebularisMod;

import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {

    public ModItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, NebularisMod.MOD_ID, existingFileHelper);

    }

    @Override
    protected void registerModels() {
        withExistingParent("crustose_lichen_stone", modLoc("block/crustose_lichen_stone"));

        ModelFile itemGenerated = getExistingFile(mcLoc("item/generated"));

        builder(itemGenerated, "raw_crustose_lichen");
    }

    private ItemModelBuilder builder(ModelFile itemGenerated, String name){
        return getBuilder(name).parent(itemGenerated).texture("layer0", "item/" + name);
    }
}
