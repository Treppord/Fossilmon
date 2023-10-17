package trep.cobblefossil.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import trep.cobblefossil.Cobblefossil;

public class ModItems {



    public static final Item KABUTO_FOSSIL = registerItem("fossil_kabuto", new Item(new FabricItemSettings()));

    public static final Item OMANYTE_FOSSIL = registerItem("fossil_omanyte", new Item(new FabricItemSettings()));

    public static final Item AERODACTYL_FOSSIL = registerItem("fossil_aerodactyl", new Item(new FabricItemSettings()));

    public static final Item NOTE = registerItem("note", new Item(new FabricItemSettings()));


    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, new Identifier(Cobblefossil.MODID, name), item);


    }






    public static void registerModItems() {
        System.out.println("Registering Mod Items for " + Cobblefossil.MODID);


    }


}