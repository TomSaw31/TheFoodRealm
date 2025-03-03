package net.tomsaw31.thefoodrealm.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraftforge.items.ItemHandlerHelper;
import net.tomsaw31.thefoodrealm.item.ModItems;

public class GoldenCarrotDrillItem extends PickaxeItem {
    boolean isEmpty = false;
    public static final BooleanProperty EMPTY = BooleanProperty.create("empty");

    public GoldenCarrotDrillItem(Tier p_42961_, int p_42962_, float p_42963_, Properties p_42964_, Boolean isempty) {
        super(p_42961_, p_42962_, p_42963_, p_42964_);
        this.isEmpty=isempty;
    }

    @Override
    public boolean mineBlock(ItemStack itemStack, Level level, BlockState state, BlockPos blockPos, LivingEntity livingEntity) {
        if (!isEmpty) {
            if (!level.isClientSide && state.getDestroySpeed(level, blockPos) != 0.0F) {
                itemStack.hurtAndBreak(1, livingEntity, (p_40992_) -> {
                    p_40992_.broadcastBreakEvent(EquipmentSlot.MAINHAND);
                    isEmpty = true;
                    itemStack.getOrCreateTag().putBoolean("empty", true);
                    if (livingEntity instanceof Player player) {
                        ItemHandlerHelper.giveItemToPlayer(player, new ItemStack(ModItems.GOLDEN_CARROT_DRILL.get()));
                    }
                });
            }
        }
        return true;
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        if (isEmpty) {
            if (!context.getLevel().isClientSide) {
                if (context.getPlayer().getInventory().contains(new ItemStack(Items.GOLDEN_CARROT))) {
                    context.getItemInHand().getOrCreateTag().putBoolean("empty", false);
                    isEmpty = false;
                }
            }
        }
        return super.useOn(context);
    }
}

