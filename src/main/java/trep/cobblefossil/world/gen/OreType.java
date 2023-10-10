package trep.cobblefossil.world.gen;

import net.minecraft.block.Block;
import trep.cobblefossil.block.ModBlocks;
import trep.cobblefossil.config.ModConfigs;

public enum OreType {
    KABUTO(ModBlocks.KABUTO_ORE, ModConfigs.KABUTO_MIN_HEIGHT, ModConfigs.KABUTO_MAX_HEIGHT, ModConfigs.KABUTO_VEIN_COUNT, ModConfigs.KABUTO_VEIN_SIZE, ModConfigs.GENERATE_KABUTO);
    private final Block block;
    private final int minHeight;
    private final int maxHeight;
    private final int veinCount;
    private final int veinSize;
    private final boolean generateOreToggle;

    OreType(Block block, int minHeight, int maxHeight, int veinCount, int veinSize, boolean generateOreToggle) {
        this.block = block;
        this.minHeight = minHeight;
        this.maxHeight = maxHeight;
        this.veinCount = veinCount;
        this.veinSize = veinSize;
        this.generateOreToggle = generateOreToggle;
    }

    public Block getBlock() {
        return block;
    }


    public int getMinHeight() {
        return minHeight;
    }

    public int getMaxHeight() {
        return maxHeight;
    }

    public int getVeinCount() {
        return veinCount;
    }

    public int getVeinSize() {
        return veinSize;
    }

    public boolean getGenerateOreToggle() {
        return generateOreToggle;
    }

    public static OreType get(Block block) {
        for (OreType ore : values()) {
            if (block == ore.block) {
                return ore;
            }
        }
        return null;
    }
}