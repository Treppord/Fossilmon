package trep.cobblefossil.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import trep.cobblefossil.Cobblefossil;
import trep.cobblefossil.block.custom.FossilizerBlock;
import trep.cobblefossil.block.custom.FossilizerBottomBlock;
import trep.cobblefossil.block.custom.FossilizerTopBlock;

public class ModBlocks {

    public static final Block KABUTO_ORE;
    public static final Block OMANYTE_ORE;
    public static final Block AERODACTYL_ORE;
    public static final Block FOSSILIZER;

    public static final Block FOSSILIZER_BOTTOM;
    public static final Block FOSSILIZER_TOP;



    static {
        KABUTO_ORE = registerBlock("fossil_kabuto_ore",
                new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));

        OMANYTE_ORE = registerBlock("fossil_aerodactyl_ore",
                new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));

        AERODACTYL_ORE = registerBlock("fossil_omanyte_ore",
                new Block(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));

        FOSSILIZER = registerBlock("fossilizer",
                new FossilizerBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));

        FOSSILIZER_BOTTOM = registerBlock("fossilizer_bottom",
                new FossilizerBottomBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));

        FOSSILIZER_TOP = registerBlock("fossilizer_top",
                new FossilizerTopBlock(FabricBlockSettings.copyOf(Blocks.IRON_BLOCK)));
    }

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, new Identifier(Cobblefossil.MODID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, new Identifier(Cobblefossil.MODID, name),
                new BlockItem(block, new FabricItemSettings()));
    }

    public static void registerModBlocks() {
        Cobblefossil.LOGGER.info("Registering ModBlocks for " + Cobblefossil.MODID);
    }

}