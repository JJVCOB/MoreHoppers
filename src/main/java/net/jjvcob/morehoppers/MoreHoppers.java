package net.jjvcob.morehoppers;

import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MoreHoppers implements ModInitializer {
	public static final String MOD_ID = "more-hoppers";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);
	@Override
	public void onInitialize() {
		ModBlocks.initialize();
		ModBlockEntities.initialize();
	}
}