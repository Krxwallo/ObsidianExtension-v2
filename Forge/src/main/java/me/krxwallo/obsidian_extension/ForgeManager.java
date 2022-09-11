package me.krxwallo.obsidian_extension;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegisterEvent;

@Mod(Constants.MOD_ID)
public class ForgeManager {
    
    public ForgeManager() {
    
        // This method is invoked by the Forge mod loader when it is ready
        // to load your mod. You can access Forge and Common code in this
        // project.
    
        // Use Forge to bootstrap the Common mod.
        Constants.LOG.info("Hello Forge world!");
        Manager.init();
    
        // Some code like events require special initialization from the
        // loader specific code.
        MinecraftForge.EVENT_BUS.addListener(this::onItemTooltip);
        MinecraftForge.EVENT_BUS.addListener(this::onRegister);

    }

    private void onItemTooltip(ItemTooltipEvent event) {
        
        Manager.onItemTooltip(event.getItemStack(), event.getFlags(), event.getToolTip());
    }

    private void onRegister(RegisterEvent event) {
        Manager.register();
    }
}