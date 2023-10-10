package trep.cobblefossil.config;

import com.mojang.datafixers.util.Pair;
import trep.cobblefossil.Cobblefossil;

public class ModConfigs {
    public static SimpleConfig CONFIG;
    private static ModConfigProvider configs;
    public static int KABUTO_MIN_HEIGHT;
    public static int KABUTO_MAX_HEIGHT;
    public static int KABUTO_VEIN_COUNT;
    public static int KABUTO_VEIN_SIZE;
    public static boolean GENERATE_KABUTO;

    private static void createConfigs() {
        configs.addKeyValuePair(new Pair<>("ore_gen.kabuto_fossil_ore.ruby_min_height", -80), "int");
        configs.addKeyValuePair(new Pair<>("ore_gen.kabuto_fossil_ore.ruby_max_height", 16), "int");
        configs.addKeyValuePair(new Pair<>("ore_gen.kabuto_fossil_ore.ruby_vein_count", 3), "int");
        configs.addKeyValuePair(new Pair<>("ore_gen.kabuto_fossil_ore.ruby_vein_size", 3), "int");
        configs.addKeyValuePair(new Pair<>("ore_gen.kabuto_fossil_ore.generate_ruby", true), "boolean");

    }

    private static void assignConfigs() {
        KABUTO_MIN_HEIGHT = CONFIG.getOrDefault("ore_gen.kabuto_fossil_ore.ruby_min_height", -80);
        KABUTO_MAX_HEIGHT = CONFIG.getOrDefault("ore_gen.kabuto_fossil_ore.ruby_max_height", 16);
        KABUTO_VEIN_COUNT = CONFIG.getOrDefault("ore_gen.kabuto_fossil_ore.ruby_vein_count", 3);
        KABUTO_VEIN_SIZE = CONFIG.getOrDefault("ore_gen.kabuto_fossil_ore.ruby_vein_size", 3);
        GENERATE_KABUTO = CONFIG.getOrDefault("ore_gen.kabuto_fossil_ore.generate_ruby", true);


        System.out.println("All " + configs.getConfigsList().size() + " have been set properly");
    }

    public static void registerConfigs() {
        configs = new ModConfigProvider();
        createConfigs();

        CONFIG = SimpleConfig.of(Cobblefossil.MODID + "config").provider(configs).request();

        assignConfigs();
    }


}