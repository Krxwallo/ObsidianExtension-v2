package me.krxwallo.obsidian_extension;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;

public class FabricManager implements ModInitializer {
    
    @Override
    public void onInitialize() {

        Constants.LOG.info("Hello Fabric world!");
        CommonClass.init();

        ItemTooltipCallback.EVENT.register(CommonClass::onItemTooltip);
    }
}
