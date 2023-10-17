package trep.cobblefossil.blockentity;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import trep.cobblefossil.Cobblefossil;
import trep.cobblefossil.block.ModBlocks;
import trep.cobblefossil.blockentity.custom.FossilizerBlockEntity;

public class ModBlockEntities {
    public static BlockEntityType<FossilizerBlockEntity> FOSSILIZER;




    public static void registerAllBlockEntities() {
        FOSSILIZER = Registry.register(Registries.BLOCK_ENTITY_TYPE,
                new Identifier(Cobblefossil.MODID, "fossilizer"),
                FabricBlockEntityTypeBuilder.create(FossilizerBlockEntity::new,
                        ModBlocks.FOSSILIZER).build(null));

    }
    }
