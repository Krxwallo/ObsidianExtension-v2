package me.krxwallo.obsidian_extension.registry;

import me.krxwallo.obsidian_extension.Constants;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SlabBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;

@SuppressWarnings("unused")
public class Blocks {
    public static final Block OBSIDIAN_STAIRS = new /*Stair*/Block(BlockBehaviour.Properties.of(Material.HEAVY_METAL).strength(4.0f));
    public static final Block OBSIDIAN_SLAB = new SlabBlock(BlockBehaviour.Properties.of(Material.HEAVY_METAL).strength(4.0f));
    // TODO

    public static void init() {
        register("obsidian_stairs");
        register("obsidian_slab");
    }

    private static void register(String name) {
        Block block;
        try {
            block = (Block) Blocks.class.getDeclaredField(name.toUpperCase()).get(null);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException("Found no block field for name: " + name);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
        Registry.register(Registry.BLOCK, new ResourceLocation(Constants.MOD_ID, name), block);
    }
}
