package trep.cobblefossil.blockentity.custom;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.client.util.ClientPlayerTickable;
import net.minecraft.entity.ItemEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import trep.cobblefossil.block.custom.FossilizerBlock;
import trep.cobblefossil.blockentity.ModBlockEntities;

public class FossilizerBlockEntity extends BlockEntity implements ClientPlayerTickable {
    private boolean switchingTextures = false;
    private ItemStack displayedItem = ItemStack.EMPTY;
    private int displayTimer = 0;

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
        if (!world.isClient) {
            // Check if there is a displayed item and the timer is active
            if (!displayedItem.isEmpty() && displayTimer > 0) {
                displayTimer--;

                // Calculate the position 3 y-levels above the block
                BlockPos itemPos = pos.up(3);

                // If there's no item at the calculated position, spawn the displayed item
                if (world.getBlockState(itemPos).isAir()) {
                    world.setBlockState(itemPos, Blocks.AIR.getDefaultState(), 2); // Ensure it's air
                    ItemEntity itemEntity = new ItemEntity(world, itemPos.getX() + 0.5, itemPos.getY() + 0.5, itemPos.getZ() + 0.5, displayedItem);
                    world.spawnEntity(itemEntity);
                }

                // If the timer reaches 0, remove the displayed item
                if (displayTimer == 0) {
                    removeDisplayedItem();
                }
            }
        }
    }

    private void removeDisplayedItem() {
        BlockPos itemPos = pos.up(3);
        world.removeBlock(itemPos, false);
        displayedItem = ItemStack.EMPTY;
    }

    public void setDisplayedItem(ItemStack itemStack) {
        displayedItem = itemStack.copy();
    }

    public void startDisplayTimer() {
        displayTimer = 20000; // 200 ticks = 10 seconds
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
