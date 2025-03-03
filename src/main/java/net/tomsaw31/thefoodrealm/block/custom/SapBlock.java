package net.tomsaw31.thefoodrealm.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.tomsaw31.thefoodrealm.item.ModItems;

public class SapBlock extends Block {
    public final Integer integer;
    public SapBlock(Properties properties, Integer integer) {
        super(properties);
        this.integer = integer;
    }

    @Override
    public void stepOn(Level pLevel, BlockPos pPos, BlockState pState, Entity pEntity) {
        if(!pLevel.isClientSide()){
            if(pEntity instanceof LivingEntity) {
                LivingEntity livingEntity = ((LivingEntity) pEntity);
                switch (integer) {
                    case 0: livingEntity.addEffect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 60));
                         break;
                    case 1: livingEntity.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, 60));
                        break;
                    case 2: livingEntity.addEffect(new MobEffectInstance(MobEffects.REGENERATION, 60));
                        break;
                    case 3: livingEntity.addEffect(new MobEffectInstance(MobEffects.DIG_SPEED, 60));
                        break;
                    case 4: livingEntity.addEffect(new MobEffectInstance(MobEffects.GLOWING, 60));
                        break;
                    case 5: livingEntity.addEffect(new MobEffectInstance(MobEffects.DARKNESS, 60));
                        break;
                    case 6: livingEntity.addEffect(new MobEffectInstance(MobEffects.WATER_BREATHING, 60));
                        break;
                    case 7: livingEntity.addEffect(new MobEffectInstance(MobEffects.JUMP, 60));
                        break;
                }
            }
        }

        super.stepOn(pLevel, pPos, pState, pEntity);}
}

