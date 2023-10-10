package trep.cobblefossil;

import net.fabricmc.api.ModInitializer;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import trep.cobblefossil.block.ModBlocks;
import trep.cobblefossil.blockentity.ModBlockEntities;
import trep.cobblefossil.config.ModConfigs;
import trep.cobblefossil.item.ModItems;
import trep.cobblefossil.world.gen.OreGeneration;

public class Cobblefossil implements ModInitializer {
	public static final String MODID = "cobblefossil";
    public static final Logger LOGGER = LoggerFactory.getLogger("cobblefossil");

	@Override
	public void onInitialize() {
		ModConfigs.registerConfigs();

		ModItems.registerModItems();
		ModBlocks.registerModBlocks();
		ModBlockEntities.registerAllBlockEntities();
		//OreGeneration.registerOreGeneration();


		LOGGER.info("CobbleFossils Mod is Running Properly");
	}
}