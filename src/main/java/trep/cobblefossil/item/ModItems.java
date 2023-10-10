package trep.cobblefossil.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import trep.cobblefossil.Cobblefossil;

public class ModItems {



    public static final Item KABUTO_FOSSIL = registerItem("fossil_kabuto",
            new Item(new FabricItemSettings().group(ModItemGroup.FOSSILS)));

    public static final Item OMANYTE_FOSSIL = registerItem("fossil_omanyte",
            new Item(new FabricItemSettings().group(ModItemGroup.FOSSILS)));

    public static final Item AERODACTYL_FOSSIL = registerItem("fossil_aerodactyl",
            new Item(new FabricItemSettings().group(ModItemGroup.FOSSILS)));

    public static final Item NOTE = registerItem("note",
            new Item(new FabricItemSettings().group(ModItemGroup.FOSSILS)));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registry.ITEM, new Identifier(Cobblefossil.MODID, name), item);


    }






    public static void registerModItems() {
        System.out.println("Registering Mod Items for " + Cobblefossil.MODID);


    }


}