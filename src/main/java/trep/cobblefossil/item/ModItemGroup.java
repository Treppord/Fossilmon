package trep.cobblefossil.item;


import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import trep.cobblefossil.Cobblefossil;
import trep.cobblefossil.block.ModBlocks;

public class ModItemGroup {

    public static final ItemGroup FOSSILS = Registry.register(Registries.ITEM_GROUP,
            new Identifier(Cobblefossil.MODID, "fossils"),
            FabricItemGroup.builder().displayName(Text.translatable("itemgroup.fossils"))
                    .icon(() -> new ItemStack(ModItems.KABUTO_FOSSIL)).entries((displayContext, entries) -> {
                        entries.add(ModBlocks.FOSSILIZER);
                        entries.add(ModBlocks.AERODACTYL_ORE);
                        entries.add(ModItems.AERODACTYL_FOSSIL);
                        entries.add(ModBlocks.KABUTO_ORE);
                        entries.add(ModItems.KABUTO_FOSSIL);
                        entries.add(ModBlocks.OMANYTE_ORE);
                        entries.add(ModItems.OMANYTE_FOSSIL);





                    }).build());

    public static void registerItemGroups() {
        Cobblefossil.LOGGER.info("Registering Fossilmon Mod Item Group");
    }

}
