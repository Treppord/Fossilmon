package trep.cobblefossil.block.custom;

import com.mojang.brigadier.ParseResults;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;
import trep.cobblefossil.blockentity.custom.FossilizerBlockEntity;
import trep.cobblefossil.item.ModItems;

import java.util.Random;

public class FossilizerBlock extends Block {


    private static final VoxelShape COLLISION_SHAPE = Block.createCuboidShape(1.0, 0.0, 1.0, 15.0, 16.0, 15.0);

    private static final VoxelShape OUTLINE_SHAPE = Block.createCuboidShape(1.0, 0.0, 1.0, 15.0, 16.0, 15.0);


    public static final BooleanProperty HAS_NOTE = BooleanProperty.of("has_note");
    public static final DirectionProperty FACING = DirectionProperty.of("facing", Direction.NORTH, Direction.SOUTH, Direction.EAST, Direction.WEST);

    public static final BooleanProperty TEXTURE_VARIANT = BooleanProperty.of("texture_variant");

    public FossilizerBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(HAS_NOTE, false).with(FACING, Direction.NORTH).with(TEXTURE_VARIANT, false));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(HAS_NOTE, FACING, TEXTURE_VARIANT);
    }


    @Override
    public VoxelShape getCollisionShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return COLLISION_SHAPE;
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return OUTLINE_SHAPE;
    }


    @Nullable
    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        Direction playerLookDirection = ctx.getPlayerLookDirection();
        Direction placedDirection = playerLookDirection.getAxis().isHorizontal() ? playerLookDirection.getOpposite() : Direction.NORTH;

        return this.getDefaultState().with(FACING, placedDirection);
    }

    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (!world.isClient && hand == Hand.MAIN_HAND) {
            ItemStack heldItem = player.getStackInHand(hand);

            // Check if the held item is one of the allowed items
            if (heldItem.getItem() == ModItems.KABUTO_FOSSIL ||
                    heldItem.getItem() == ModItems.AERODACTYL_FOSSIL ||
                    heldItem.getItem() == ModItems.OMANYTE_FOSSIL) {








            if (heldItem.getItem() == ModItems.KABUTO_FOSSIL && !state.get(HAS_NOTE)) {
                if (!player.getAbilities().creativeMode) {
                    heldItem.decrement(1);
                }

                // Create a block entity to control the displayed item
                FossilizerBlockEntity blockEntity = (FossilizerBlockEntity) world.getBlockEntity(pos);
                if (blockEntity instanceof FossilizerBlockEntity) {
                    ((FossilizerBlockEntity) blockEntity).startTextureSwitch();
                }

                // Get a random level between 1 and 10
                Random random = new Random();
                int randomLevel = random.nextInt(10) + 1;

                // Construct the command with the random level
                String command = "givepokemon kabuto level=" + randomLevel;

                // Get the MinecraftServer and execute the GivePokemon command
                MinecraftServer server = world.getServer();
                if (server != null) {
                    ServerCommandSource source = player.getCommandSource();
                    ParseResults<ServerCommandSource> parseResults = server.getCommandManager().getDispatcher().parse(command, source);
                    try {
                        // Use the server's command manager to execute the command
                        server.getCommandManager().execute(parseResults, command);
                    } catch (Exception e) {
                        // Handle any exceptions that may occur during command execution
                        e.printStackTrace();
                    }
                }




                if (blockEntity != null) {
                    // Store the item in the block entity and start the timer
                    blockEntity.setDisplayedItem(heldItem);
                    blockEntity.startDisplayTimer();
                }


                return ActionResult.SUCCESS;
            }
            if (heldItem.getItem() == ModItems.AERODACTYL_FOSSIL && !state.get(HAS_NOTE)) {
                if (!player.getAbilities().creativeMode) {
                    heldItem.decrement(1);
                }

                // Get the block entity and start the texture switch
                FossilizerBlockEntity blockEntity = (FossilizerBlockEntity) world.getBlockEntity(pos);
                if (blockEntity instanceof FossilizerBlockEntity) {
                    ((FossilizerBlockEntity) blockEntity).startTextureSwitch();
                }

                // Get a random level between 1 and 10
                Random random = new Random();
                int randomLevel = random.nextInt(10) + 1;

                // Construct the command with the random level
                String command = "givepokemon aerodactyl level=" + randomLevel;

                // Get the MinecraftServer and execute the GivePokemon command
                MinecraftServer server = world.getServer();
                if (server != null) {
                    ServerCommandSource source = player.getCommandSource();
                    ParseResults<ServerCommandSource> parseResults = server.getCommandManager().getDispatcher().parse(command, source);
                    try {
                        // Use the server's command manager to execute the command
                        server.getCommandManager().execute(parseResults, command);
                    } catch (Exception e) {
                        // Handle any exceptions that may occur during command execution
                        e.printStackTrace();
                    }
                }



                if (blockEntity != null) {
                    // Store the item in the block entity and start the timer
                    blockEntity.setDisplayedItem(heldItem);
                    blockEntity.startDisplayTimer();
                }

                return ActionResult.SUCCESS;
            }
            if (heldItem.getItem() == ModItems.OMANYTE_FOSSIL && !state.get(HAS_NOTE)) {
                if (!player.getAbilities().creativeMode) {
                    heldItem.decrement(1);
                }

                // Get the block entity and start the texture switch
                FossilizerBlockEntity blockEntity = (FossilizerBlockEntity) world.getBlockEntity(pos);
                if (blockEntity instanceof FossilizerBlockEntity) {
                    ((FossilizerBlockEntity) blockEntity).startTextureSwitch();
                }

                // Get a random level between 1 and 10
                Random random = new Random();
                int randomLevel = random.nextInt(10) + 1;

                // Construct the command with the random level
                String command = "givepokemon omanyte level=" + randomLevel;

                // Get the MinecraftServer and execute the GivePokemon command
                MinecraftServer server = world.getServer();
                if (server != null) {
                    ServerCommandSource source = player.getCommandSource();
                    ParseResults<ServerCommandSource> parseResults = server.getCommandManager().getDispatcher().parse(command, source);
                    try {
                        // Use the server's command manager to execute the command
                        server.getCommandManager().execute(parseResults, command);
                    } catch (Exception e) {
                        // Handle any exceptions that may occur during command execution
                        e.printStackTrace();
                    }
                }



                if (blockEntity != null) {
                    // Store the item in the block entity and start the timer
                    blockEntity.setDisplayedItem(heldItem);
                    blockEntity.startDisplayTimer();
                }
                return ActionResult.SUCCESS;
            }
        }
            return ActionResult.SUCCESS;
            }
        return ActionResult.PASS;
    }

}
