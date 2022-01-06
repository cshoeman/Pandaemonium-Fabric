package net.compii.pandaemonium.sound;

import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.sound.SoundEvent;

public class CustomBlockSoundGroup {
    public static final BlockSoundGroup TESTING_BLOCKS = new BlockSoundGroup(1.0f, 1.0f,
            CustomSoundEvents.BLOCK_TESTING_BLOCK_BREAK,
            CustomSoundEvents.BLOCK_TESTING_BLOCK_BREAK,
            CustomSoundEvents.BLOCK_TESTING_BLOCK_BREAK,
            CustomSoundEvents.BLOCK_TESTING_BLOCK_BREAK,
            CustomSoundEvents.BLOCK_TESTING_BLOCK_BREAK);
    public final float volume;
    public final float pitch;
    private final SoundEvent breakSound;
    private final SoundEvent stepSound;
    private final SoundEvent placeSound;
    private final SoundEvent hitSound;
    private final SoundEvent fallSound;

    public CustomBlockSoundGroup(float volume, float pitch, SoundEvent breakSound, SoundEvent stepSound, SoundEvent placeSound, SoundEvent hitSound, SoundEvent fallSound) {
        this.volume = volume;
        this.pitch = pitch;
        this.breakSound = breakSound;
        this.stepSound = stepSound;
        this.placeSound = placeSound;
        this.hitSound = hitSound;
        this.fallSound = fallSound;
    }

    public float getVolume() {
        return this.volume;
    }

    public float getPitch() {
        return this.pitch;
    }

    public SoundEvent getBreakSound() {
        return this.breakSound;
    }

    public SoundEvent getStepSound() {
        return this.stepSound;
    }

    public SoundEvent getPlaceSound() {
        return this.placeSound;
    }

    public SoundEvent getHitSound() {
        return this.hitSound;
    }

    public SoundEvent getFallSound() {
        return this.fallSound;
    }
}
