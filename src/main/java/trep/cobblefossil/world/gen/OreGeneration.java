package trep.cobblefossil.world.gen;

public class OreGeneration  {
/*
    private static void generateOres() {
        for (OreType ore : OreType.values()) {
            if (ore.getGenerateOreToggle()) {
                List<OreFeatureConfig.Target> ORES = List.of(
                        OreFeatureConfig.createTarget(OreConfiguredFeatures.STONE_ORE_REPLACEABLES, ore.getBlock().getDefaultState())
                );

                ConfiguredFeature<?, ?> ORE_TYPE = ConfiguredFeatures.register(
                        ore.getBlock().getTranslationKey(), Feature.ORE.generate(new OreFeatureConfig(ORES, ore.getVeinSize()))
                );

                PlacedFeature ORE_PLACED_FEATURE = ORE_TYPE.withPlacement(
                        modifiersWithCount(ore.getVeinCount(), HeightRangePlacementModifier.trapezoid(YOffset.fixed(ore.getMinHeight()), YOffset.fixed(ore.getMaxHeight())))
                );

                generateOre(ore.getBlock(), ORE_PLACED_FEATURE);
            }
        }
    }

    private static void generateOre(Block block, PlacedFeature placedFeature) {
        RegistryKey<PlacedFeature> ore = RegistryKey.of(Registry.PLACED_FEATURE_KEY, new Identifier(Cobblefossil.MODID, block.getTranslationKey()));
        Registry.register(BuiltinRegistries.PLACED_FEATURE, ore.getValue(), placedFeature);
        BiomeModifications.addFeature(BiomeSelectors.foundInOverworld(), GenerationStep.Feature.UNDERGROUND_ORES, ore);
    }

    private static List<PlacementModifier> modifiers(PlacementModifier countModifier, PlacementModifier heightModifier) {
        return List.of(countModifier, SquarePlacementModifier.of(), heightModifier, BiomePlacementModifier.of());
    }

    private static List<PlacementModifier> modifiersWithCount(int count, PlacementModifier heightModifier) {
        return modifiers(CountPlacementModifier.of(count), heightModifier);
    }

    public static void registerOreGeneration() {
        Cobblefossil.LOGGER.info("Registering OreGeneration for " + Cobblefossil.MODID);
        generateOres();
    }
*/
}