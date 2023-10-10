package trep.cobblefossil.block.custom;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;

public class FossilizerTopBlock extends Block {
    public FossilizerTopBlock() {
        super(FabricBlockSettings.of(Material.STONE).hardness(1.0f));
    }
}