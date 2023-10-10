package trep.cobblefossil.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.block.OreBlock;
import net.minecraft.item.BlockItem;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.UniformIntProvider;
import net.minecraft.util.registry.Registry;
import trep.cobblefossil.Cobblefossil;
import trep.cobblefossil.block.custom.FossilizerBlock;
import trep.cobblefossil.block.custom.FossilizerBottomBlock;
import trep.cobblefossil.block.custom.FossilizerTopBlock;
import trep.cobblefossil.item.ModItemGroup;

public class ModBlocks {

    public static final Block KABUTO_ORE;
    public static final Block OMANYTE_ORE;
    public static final Block AERODACTYL_ORE;
    public static final Block FOSSILIZER;

    public static final Block FOSSILIZER_BOTTOM;
    public static final Block FOSSILIZER_TOP;



    static {
        KABUTO_ORE = registerBlock("fossil_kabuto_ore",
                new OreBlock(FabricBlockSettings.of(Material.STONE).requiresTool().strength(5.0F, 5.0F)
                        , UniformIntProvider.create(3, 7)));

        OMANYTE_ORE = registerBlock("fossil_aerodactyl_ore",
                new OreBlock(FabricBlockSettings.of(Material.STONE).requiresTool().strength(1.0F, 1.0F)
                        , UniformIntProvider.create(3, 7)));

        AERODACTYL_ORE = registerBlock("fossil_omanyte_ore",
                new OreBlock(FabricBlockSettings.of(Material.STONE).requiresTool().strength(0.1F, 0.1F)
                        , UniformIntProvider.create(3, 7)));

        FOSSILIZER = registerBlock("fossilizer",
                new FossilizerBlock());

        FOSSILIZER_BOTTOM = registerBlock("fossilizer_bottom",
                new FossilizerBottomBlock());

        FOSSILIZER_TOP = registerBlock("fossilizer_top",
                new FossilizerTopBlock());
    }

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registry.BLOCK, new Identifier(Cobblefossil.MODID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registry.ITEM, new Identifier(Cobblefossil.MODID, name),
                new BlockItem(block, new FabricItemSettings().group(ModItemGroup.FOSSILS)));
    }

    public static void registerModBlocks() {
        Cobblefossil.LOGGER.info("Registering ModBlocks for " + Cobblefossil.MODID);
    }

}