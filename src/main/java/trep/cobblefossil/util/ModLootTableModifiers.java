package trep.cobblefossil.util;

import net.fabricmc.fabric.api.loot.v2.LootTableEvents;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.RandomChanceLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LootPoolEntry;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.ConstantLootNumberProvider;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.util.Identifier;
import trep.cobblefossil.item.ModItems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ModLootTableModifiers {

    private static final Identifier KABUTO =
            new Identifier("minecraft", "archaeology/desert_pyramid");

    private static final Identifier AERODACTYL =
            new Identifier("minecraft", "archaeology/desert_well");

    private static final Identifier OMANYTE =
            new Identifier("minecraft", "archaeology/ocean_ruin_warm");

    public static void modifyLootTables() {


        LootTableEvents.REPLACE.register((resourceManager, lootManager, id, original, source) -> {
             if(KABUTO.equals(id)) {
                 List<LootPoolEntry> entries = new ArrayList<>(Arrays.asList(original.pools[0].entries));
                 entries.add(ItemEntry.builder(ModItems.KABUTO_FOSSIL).build());
                 LootPool.Builder pool = LootPool.builder().with(entries);
                 return LootTable.builder().pool(pool).build();
             }

            return null;
        });

        LootTableEvents.REPLACE.register((resourceManager, lootManager, id, original, source) -> {
            if(AERODACTYL.equals(id)) {
                List<LootPoolEntry> entries = new ArrayList<>(Arrays.asList(original.pools[0].entries));
                entries.add(ItemEntry.builder(ModItems.AERODACTYL_FOSSIL).build());
                LootPool.Builder pool = LootPool.builder().with(entries);
                return LootTable.builder().pool(pool).build();
            }

            return null;
        });

        LootTableEvents.REPLACE.register((resourceManager, lootManager, id, original, source) -> {
            if(OMANYTE.equals(id)) {
                List<LootPoolEntry> entries = new ArrayList<>(Arrays.asList(original.pools[0].entries));
                entries.add(ItemEntry.builder(ModItems.OMANYTE_FOSSIL).build());
                LootPool.Builder pool = LootPool.builder().with(entries);
                return LootTable.builder().pool(pool).build();
            }

            return null;
        });
    }
}