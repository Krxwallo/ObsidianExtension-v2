package me.krxwallo.obsidian_extension.registry;

import me.krxwallo.obsidian_extension.Constants;
import me.krxwallo.obsidian_extension.blocks.*;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.PressurePlateBlock;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;

import java.util.Map;

public class OEBlocks {
    public static Map<String, Block> obsidianBlocks;
    public static Map<String, Block> cryingObsidianBlocks;

    public static void init() {
        obsidianBlocks = registerFor("obsidian", Blocks.OBSIDIAN);
        cryingObsidianBlocks = registerFor("crying_obsidian", Blocks.CRYING_OBSIDIAN);
    }

    private static BlockBehaviour.Properties properties(Block block) {
        return BlockBehaviour.Properties.copy(block).strength(40F, 1200.0F);
    }

    public static Map<String, Block> registerFor(String name, Block block) {
        var properties = properties(block);
        var map = Map.of(
                name + "_slab", new OESlabBlock(properties),
                name + "_stairs", new OEStairBlock(block.defaultBlockState(), properties),
                name + "_wall", new WallBlock(properties),
                name + "_door", new OEDoorBlock(properties),
                name + "_pressure_plate", new OEPressurePlateBlock(PressurePlateBlock.Sensitivity.MOBS, properties),
                name + "_button", new OEStoneButtonBlock(properties)
        );
        // TODO custom tab
        map.forEach((n, b) -> register(n, b, CreativeModeTab.TAB_MISC));
        return map;
    }

    private static void register(String name, Block block, CreativeModeTab tab) {
        var id = new ResourceLocation(Constants.MOD_ID, name);
        Registry.register(Registry.BLOCK, id, block);
        Registry.register(Registry.ITEM, id, new BlockItem(block, new Item.Properties().tab(tab)));
    }
}
