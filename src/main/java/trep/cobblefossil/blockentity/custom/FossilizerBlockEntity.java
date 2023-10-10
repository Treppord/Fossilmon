package trep.cobblefossil.blockentity.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.util.ClientPlayerTickable;
import net.minecraft.util.math.BlockPos;
import trep.cobblefossil.block.custom.FossilizerBlock;
import trep.cobblefossil.blockentity.ModBlockEntities;

public class FossilizerBlockEntity extends BlockEntity implements ClientPlayerTickable {
    private boolean switchingTextures = false;
    private int textureSwitchTimer = 0;

    public FossilizerBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.FOSSILIZER, pos, state);
    }

    public void startTextureSwitch() {
        if (!switchingTextures) {
            switchingTextures = true;
            textureSwitchTimer = 200; // Adjust the timer duration as needed (200 = 10 seconds)
        }
    }

    @Override
    public void tick() {
        if (switchingTextures) {
            if (textureSwitchTimer > 0) {
                textureSwitchTimer--;
            } else {
                switchingTextures = false;
                toggleTexture(); // Method to switch the block's texture
            }
        }
    }

    private void toggleTexture() {
        if (world != null && !world.isClient) {
            BlockState currentState = world.getBlockState(pos);
            boolean currentVariant = currentState.get(FossilizerBlock.TEXTURE_VARIANT);
            boolean newVariant = !currentVariant;
            world.setBlockState(pos, currentState.with(FossilizerBlock.TEXTURE_VARIANT, newVariant));
        }
    }
}
