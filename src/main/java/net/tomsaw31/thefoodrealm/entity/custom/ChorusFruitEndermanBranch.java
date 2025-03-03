package net.tomsaw31.thefoodrealm.entity.custom;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.Pose;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;
import software.bernie.geckolib.core.animation.AnimationController;

public class ChorusFruitEndermanBranch extends net.minecraftforge.entity.PartEntity<ChorusFruitEndermanEntity>{
    public final ChorusFruitEndermanEntity parentMob;
    public final String name;
    private final EntityDimensions size;

    public ChorusFruitEndermanBranch(ChorusFruitEndermanEntity chorusFruitEndermanEntity, String p_31015_, float p_31016_, float p_31017_) {
        super(chorusFruitEndermanEntity);
        this.size = EntityDimensions.scalable(p_31016_, p_31017_);
        this.refreshDimensions();
        this.parentMob = chorusFruitEndermanEntity;
        this.name = p_31015_;
    }

    protected void defineSynchedData() {
    }

    protected void readAdditionalSaveData(CompoundTag p_31025_) {
    }

    protected void addAdditionalSaveData(CompoundTag p_31028_) {
    }

    public boolean isPickable() {
        return true;
    }

    public boolean hurt(DamageSource damageSource, float p_31021_) {
        return this.isInvulnerableTo(damageSource) ? false : this.parentMob.hurt(damageSource, p_31021_);
    }

    public boolean is(Entity p_31031_) {
        return this == p_31031_ || this.parentMob == p_31031_;
    }


    public EntityDimensions getDimensions(Pose p_31023_) {
        return this.size;
    }

    public boolean shouldBeSaved() {
        return false;
    }

}
