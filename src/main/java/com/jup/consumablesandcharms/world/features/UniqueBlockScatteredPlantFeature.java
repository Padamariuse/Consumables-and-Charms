package com.jup.consumablesandcharms.world.features;

import com.mojang.datafixers.Dynamic;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorld;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.GenerationSettings;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;

import java.util.Random;
import java.util.function.Function;

public class UniqueBlockScatteredPlantFeature extends Feature<NoFeatureConfig>
{
    protected final BlockState plant;
    protected final Block block;
    
    public UniqueBlockScatteredPlantFeature(Function<Dynamic<?>, ? extends NoFeatureConfig> configFactoryIn, BlockState plantIn, Block blockIn)
    {
        super(configFactoryIn);
        this.plant = plantIn;
        this.block = blockIn;
    }
    
    public boolean place(IWorld worldIn, ChunkGenerator<? extends GenerationSettings> generator, Random rand, BlockPos pos, NoFeatureConfig config)
    {
        int i = 0;
        
        for(int j = 0; j < 4; ++j) {
            BlockPos blockpos = pos.add(rand.nextInt(8) - rand.nextInt(8), rand.nextInt(4) - rand.nextInt(4), rand.nextInt(8) - rand.nextInt(8));
            if (worldIn.isAirBlock(blockpos) && worldIn.getBlockState(blockpos.down()).getBlock() == block) {
                worldIn.setBlockState(blockpos, this.plant, 2);
                ++i;
            }
        }
        
        return i > 0;
    }
}
