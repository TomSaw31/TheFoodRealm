package net.tomsaw31.thefoodrealm.block.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import net.tomsaw31.thefoodrealm.block.entity.ModBlockEntities;
import net.tomsaw31.thefoodrealm.item.custom.JarItem;
import net.tomsaw31.thefoodrealm.networking.ModMessages;
import net.tomsaw31.thefoodrealm.networking.packet.ItemStackSyncS2CPacket;
import net.tomsaw31.thefoodrealm.recipe.CookingPotRecipe;
import net.tomsaw31.thefoodrealm.screen.CookingPotMenu;
import net.tomsaw31.thefoodrealm.util.ModTags;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.annotation.Nonnull;
import java.util.Optional;

public class CookingPotBlockEntity extends BlockEntity implements MenuProvider {
    private final ItemStackHandler itemStackHandler = new ItemStackHandler(7) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
            if(!level.isClientSide()) {
                ModMessages.sendToClients(new ItemStackSyncS2CPacket(this, worldPosition));
            }
        }
    };
    private LazyOptional<IItemHandler> lazyItemHandler= LazyOptional.empty();

    protected final ContainerData data;
    private int progress = 0;
    private int maxprogress = 100;

    public CookingPotBlockEntity(BlockPos blockPos, BlockState state) {
        super(ModBlockEntities.COOKING_POT_ENTITY.get(), blockPos, state);
        this.data= new ContainerData() {
            @Override
            public int get(int index) {
                return switch (index) {
                    case 0 -> CookingPotBlockEntity.this.progress;
                    case 1 -> CookingPotBlockEntity.this.maxprogress;
                    default -> 0;
                };
            }

            @Override
            public void set(int index, int value) {
                switch (index) {
                    case 0 -> CookingPotBlockEntity.this.progress = value;
                    case 1 -> CookingPotBlockEntity.this.maxprogress = value;
                }
            }

            @Override
            public int getCount() {
                return 7;
            }
        };
    }

    public ItemStack getRenderStack() {
        ItemStack stack;
        stack = itemStackHandler.getStackInSlot(0);
        if(!itemStackHandler.getStackInSlot(6).isEmpty()) {
            stack = itemStackHandler.getStackInSlot(6);
        } else {
            for (int i = 0; i < 6; i++) {
                if(!itemStackHandler.getStackInSlot(i).isEmpty()) {
                    stack = itemStackHandler.getStackInSlot(i);
                    break;
                }
            }
        }

        return stack;
    }

    @Override
    public Component getDisplayName() {
        return Component.literal("Cooking Pot");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
        return new CookingPotMenu(id, inventory,this,this.data);
    }


    @Override
    public @NotNull <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if(cap == ForgeCapabilities.ITEM_HANDLER) {
            return lazyItemHandler.cast();
        }
        return super.getCapability(cap, side);
    }

    @Override
    public void onLoad() {
        super.onLoad();
        lazyItemHandler = LazyOptional.of(()-> itemStackHandler);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        lazyItemHandler.invalidate();
    }

    @Override
    protected void saveAdditional(CompoundTag compoundTag) {
        compoundTag.put("inventory", itemStackHandler.serializeNBT());
        compoundTag.putInt("cooking_pot.progress", this.progress);
        super.saveAdditional(compoundTag);
    }

    @Override
    public void load(CompoundTag compoundTag) {
        super.load(compoundTag);
        itemStackHandler.deserializeNBT(compoundTag.getCompound("inventory"));
        progress=compoundTag.getInt("cooking_pot.progress");
    }



    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemStackHandler.getSlots());
        for (int i = 0; i < itemStackHandler.getSlots(); i++) {
            inventory.setItem(i, itemStackHandler.getStackInSlot(i));
        }

        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    public static void tick(Level level, BlockPos blockPos, BlockState state, CookingPotBlockEntity pEntity) {
        if(level.isClientSide()) {
            return;
        }

        if(hasRecipe(pEntity)) {
            pEntity.progress++;
            setChanged(level, blockPos, state);

            if (pEntity.progress >= pEntity.maxprogress) {
                craftItem(pEntity);
            }
        } else {
            pEntity.resetProgress();
            setChanged(level, blockPos,state);
        }
    }
    private void resetProgress() {
        this.progress = 0;
    }
    private static void craftItem(CookingPotBlockEntity pEntity) {
        Level level = pEntity.level;
        SimpleContainer inventory = new SimpleContainer(pEntity.itemStackHandler.getSlots());
        for (int i = 0; i < pEntity.itemStackHandler.getSlots(); i++) {
            inventory.setItem(i, pEntity.itemStackHandler.getStackInSlot(i));
        }

        Optional<CookingPotRecipe> recipe = level.getRecipeManager().getRecipeFor(CookingPotRecipe.Type.INSTANCE, inventory,level);
        if(hasRecipe(pEntity)) {
            for (int i = 0; i < 6; i++) {
                if (pEntity.itemStackHandler.getStackInSlot(i).getItem() instanceof JarItem jarItem) {
                    pEntity.itemStackHandler.setStackInSlot(i,jarItem.UseItem(pEntity.itemStackHandler.getStackInSlot(i)));
                } else {
                    pEntity.itemStackHandler.extractItem(i, 1, false);
                }
            }
            pEntity.itemStackHandler.setStackInSlot(6,new ItemStack(recipe.get().getResultItem().getItem(),
                pEntity.itemStackHandler.getStackInSlot(6).getCount() + 1));
            pEntity.resetProgress();
            inventory.setChanged();
        }
    }
    private static boolean hasRecipe(CookingPotBlockEntity pEntity) {
        Level level = pEntity.level;
        SimpleContainer inventory = new SimpleContainer(pEntity.itemStackHandler.getSlots());
        for (int i = 0; i < pEntity.itemStackHandler.getSlots(); i++) {
            inventory.setItem(i, pEntity.itemStackHandler.getStackInSlot(i));
        }

        Optional<CookingPotRecipe> recipe = level.getRecipeManager().getRecipeFor(CookingPotRecipe.Type.INSTANCE, inventory,level);
        return  recipe.isPresent() && isLit(pEntity) && canInsertAmountIntoOutputSlot(inventory) && canInsertItemIntoOutputSlot(inventory,recipe.get().getResultItem());
    }

    private static boolean isLit(CookingPotBlockEntity pEntity) {
        BlockState block = pEntity.level.getBlockState(new BlockPos(pEntity.getBlockPos().getX(),pEntity.getBlockPos().getY()-1,pEntity.getBlockPos().getZ()));
        if (!block.is(ModTags.Blocks.COOKING_POT_FIRE)) {
            block = pEntity.level.getBlockState(new BlockPos(pEntity.getBlockPos().getX(),pEntity.getBlockPos().getY()-2,pEntity.getBlockPos().getZ()));
        }
        return block.is(ModTags.Blocks.COOKING_POT_FIRE);
    }

    private static boolean canInsertItemIntoOutputSlot(SimpleContainer inventory, ItemStack itemStack) {
        return inventory.getItem(6).getItem() == itemStack.getItem() || inventory.getItem(6).isEmpty();
    }

    private static boolean canInsertAmountIntoOutputSlot(SimpleContainer inventory) {
        return inventory.getItem(6).getMaxStackSize() > inventory.getItem(6).getCount();
    }


    public void setHandler(ItemStackHandler itemStackHandler) {
        for (int i = 0; i < itemStackHandler.getSlots(); i++) {
            itemStackHandler.setStackInSlot(i, itemStackHandler.getStackInSlot(i));
        }
    }

}
