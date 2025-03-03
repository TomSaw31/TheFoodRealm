package net.tomsaw31.thefoodrealm.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.tomsaw31.thefoodrealm.block.ModBlocks;
import net.tomsaw31.thefoodrealm.block.custom.FoodPortalBlock;
import net.tomsaw31.thefoodrealm.item.ModCreativeModTab;
import net.tomsaw31.thefoodrealm.world.dimension.ModDimensions;

public class CatalystItem extends Item {
    public CatalystItem() {
        super(new Properties()
                .tab(ModCreativeModTab.THE_FOOD_REALM_FOOD)
        );
    }

    @Override
    public InteractionResult useOn(UseOnContext context) {
        if(context.getPlayer() != null) {
            if(context.getPlayer().level.dimension() == ModDimensions.FOOD_REALM_KEY
                    || context.getPlayer().level.dimension() == Level.OVERWORLD) {
                for(Direction direction : Direction.Plane.VERTICAL) {
                    BlockPos framePos = context.getClickedPos().relative(direction);
                    if(((FoodPortalBlock) ModBlocks.FOOD_PORTAl.get()).trySpawnPortal(context.getLevel(), framePos)) {
                        context.getLevel().playSound(context.getPlayer(), framePos,
                                SoundEvents.PORTAL_TRIGGER, SoundSource.BLOCKS, 1.0F, 1.0F);
                        return InteractionResult.CONSUME;
                    }
                    else return InteractionResult.FAIL;
                }
            }
        }
        return InteractionResult.FAIL;
    }
}