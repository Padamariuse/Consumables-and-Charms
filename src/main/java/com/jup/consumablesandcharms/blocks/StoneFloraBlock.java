package com.jup.consumablesandcharms.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.BushBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.Tags;

public class StoneFloraBlock extends BushBlock
{
    protected StoneFloraBlock(Properties properties)
    {
        super(properties);
    }
    
    @Override
    protected boolean isValidGround(BlockState state, IBlockReader worldIn, BlockPos pos)
    {
        return state.isIn(Tags.Blocks.STONE);
    }
}
