/*

    Pandaemonium
    TestingBlock.java
    The Testing Block

 */

// TODO: Figure out how to make the testing block play the_testing_block.break when broken

package net.compii.pandaemonium.block;

import net.compii.pandaemonium.Pandaemonium;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class TestingBlock extends Block {

    public TestingBlock(Settings settings) {
        super(settings);
    }

    @Override
    public void onBreak(World world, BlockPos pos, BlockState state, PlayerEntity player) {
        world.playSound(null, player.getX(), player.getY(), player.getZ(), Pandaemonium.TEST_SOUND_EVENT, SoundCategory.BLOCKS, 1.0f, 1.0f);
        super.onBreak(world, pos, state, player);
    }

}
