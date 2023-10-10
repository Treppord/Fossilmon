package trep.cobblefossil.item;

import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import trep.cobblefossil.Cobblefossil;

public class ModItemGroup {
    public static final ItemGroup FOSSILS = FabricItemGroupBuilder.build(
            new Identifier(Cobblefossil.MODID, "fossils"), () -> new ItemStack(ModItems.KABUTO_FOSSIL));
}