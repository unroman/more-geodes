package com.github.thedeathlycow.moregeodes;

import com.github.thedeathlycow.moregeodes.client.GeodesCutouts;
import com.github.thedeathlycow.moregeodes.client.GeodesEntityRenderers;
import com.github.thedeathlycow.moregeodes.client.ItemColorsSetup;
import net.fabricmc.api.ClientModInitializer;

public class MoreGeodesClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        MoreGeodes.LOGGER.info("Beginning More Geodes client initialization");
        GeodesCutouts.registerCutouts();
        GeodesEntityRenderers.registerEntityRenderers();
        ItemColorsSetup.onInitialize();
        MoreGeodes.LOGGER.info("More Geodes client initialized!");
    }
}