package net.tomsaw31.thefoodrealm.entity.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.phys.Vec3;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animatable.instance.SingletonAnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;

import javax.annotation.Nullable;
import java.util.List;
import java.util.function.Predicate;


public class ChorusFruitEndermanEntity extends Monster implements GeoEntity {
    private AnimatableInstanceCache factory = new SingletonAnimatableInstanceCache(this);
    private boolean Casting = false;
    public final ChorusFruitEndermanBranch branch;

    public ChorusFruitEndermanEntity(EntityType<? extends Monster> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.branch = new ChorusFruitEndermanBranch(this, "branch", 1.0F, 1.0F);
    }
    @Override
    public void setId(int p_20235_) {
        super.setId(p_20235_);
        this.branch.setId(p_20235_+1);
    }



        public static AttributeSupplier setAttributes() {
        return Monster.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 20.0D)
                .add(Attributes.ATTACK_DAMAGE, 3f)
                .add(Attributes.ATTACK_SPEED, 1.5f)
                .add(Attributes.MOVEMENT_SPEED, 3f).build();
    }

    protected void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.0D, false));
        this.goalSelector.addGoal(2, new EndermanCast(this));
        this.goalSelector.addGoal(3, new WaterAvoidingRandomStrollGoal(this, 1.0D));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 8.0F));
        this.goalSelector.addGoal(8, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, true));
    }



    private PlayState predicate(AnimationState animationState) {
        if (animationState.isMoving()) {
            animationState.getController().setAnimation(RawAnimation.begin().then("chorus_fruit_enderman.model.walk", Animation.LoopType.LOOP));
        } else {
            animationState.getController().setAnimation(RawAnimation.begin().then("chorus_fruit_enderman.model.idle", Animation.LoopType.LOOP));

        }
        return PlayState.CONTINUE;
    }

    static class EndermanCast extends Goal {
        private final ChorusFruitEndermanEntity enderman;
        @Nullable
        private LivingEntity target;

        public EndermanCast(ChorusFruitEndermanEntity p_32550_) {
            this.enderman = p_32550_;
        }

        public boolean canUse() {
            this.target = this.enderman.getTarget();
            if (!(this.target instanceof Player)) {
                return false;
            } else {
                double d0 = this.target.distanceToSqr(this.enderman);
                return d0 < 500.0D && d0 > 300;
            }
        }

        public void start() {
            this.enderman.getNavigation().stop();
        }

        public void tick() {
            enderman.Casting=true;
                if (!this.enderman.level.isClientSide) {
                    List<LivingEntity> list = this.enderman.level.getEntitiesOfClass(LivingEntity.class, this.enderman.getBoundingBox().inflate(4.0D, 2.0D, 4.0D));
                    AreaEffectCloud areaeffectcloud = new AreaEffectCloud(this.enderman.level, this.enderman.getX(), this.enderman.getY(), this.enderman.getZ());
                        areaeffectcloud.setOwner((LivingEntity)this.enderman);
                    areaeffectcloud.setParticle(ParticleTypes.DRAGON_BREATH);
                    areaeffectcloud.setRadius(3.0F);
                    areaeffectcloud.setDuration(600);
                    areaeffectcloud.setRadiusPerTick((7.0F - areaeffectcloud.getRadius()) / (float)areaeffectcloud.getDuration());
                    areaeffectcloud.addEffect(new MobEffectInstance(MobEffects.HARM, 1, 1));
                    if (!list.isEmpty()) {
                        for(LivingEntity livingentity : list) {
                            double d0 = this.enderman.distanceToSqr(livingentity);
                            if (d0 < 16.0D) {
                                areaeffectcloud.setPos(livingentity.getX(), livingentity.getY(), livingentity.getZ());
                                break;
                            }
                        }
                    }

                    this.enderman.level.levelEvent(2006, this.enderman.blockPosition(), this.enderman.isSilent() ? -1 : 1);
                    this.enderman.level.addFreshEntity(areaeffectcloud);
                    this.enderman.discard();
                }
            this.enderman.Casting=false;

        }
    }



    static class EndermanLookForPlayerGoal extends NearestAttackableTargetGoal<Player> {
        private final ChorusFruitEndermanEntity enderman;
        @Nullable
        private Player pendingTarget;
        private int aggroTime;
        private int teleportTime;
        private final TargetingConditions startAggroTargetConditions;
        private final TargetingConditions continueAggroTargetConditions = TargetingConditions.forCombat().ignoreLineOfSight();

        public EndermanLookForPlayerGoal(ChorusFruitEndermanEntity p_32573_, @Nullable Predicate<LivingEntity> p_32574_) {
            super(p_32573_, Player.class, 10, false, false, p_32574_);
            this.enderman = p_32573_;
            this.startAggroTargetConditions = TargetingConditions.forCombat().range(this.getFollowDistance()).selector((p_32578_) -> {
                return p_32573_.isLookingAtMe((Player) p_32578_);
            });
        }
        public boolean canUse() {
            this.pendingTarget = this.enderman.level.getNearestPlayer(this.startAggroTargetConditions, this.enderman);
            return this.pendingTarget != null;
        }

        public void start() {
            this.aggroTime = this.adjustedTickDelay(5);
            this.teleportTime = 0;
        }

        public void stop() {
            this.pendingTarget = null;
            super.stop();
        }

        public boolean canContinueToUse() {
            if (this.pendingTarget != null) {
                if (!this.enderman.isLookingAtMe(this.pendingTarget)) {
                    return false;
                } else {
                    this.enderman.lookAt(this.pendingTarget, 10.0F, 10.0F);
                    return true;
                }
            } else {
                return this.target != null && this.continueAggroTargetConditions.test(this.enderman, this.target) ? true : super.canContinueToUse();
            }
        }
    public void tick() {
        if (this.enderman.getTarget() == null) {
            super.setTarget((LivingEntity)null);
        }

        if (this.pendingTarget != null) {
            if (--this.aggroTime <= 0) {
                this.target = this.pendingTarget;
                this.pendingTarget = null;
                super.start();
            }
        } else {
            if (this.target != null && !this.enderman.isPassenger()) {
            }
            else if (this.target.distanceToSqr(this.enderman) > 256.0D && this.teleportTime++ >= this.adjustedTickDelay(30) && this.enderman.teleportTowards(this.target)) {
                    this.teleportTime = 0;
                }
            }

            super.tick();
        }

    }
    boolean isLookingAtMe(Player p_32535_) {
        ItemStack itemstack = p_32535_.getInventory().armor.get(3);
            Vec3 vec3 = p_32535_.getViewVector(1.0F).normalize();
            Vec3 vec31 = new Vec3(this.getX() - p_32535_.getX(), this.getEyeY() - p_32535_.getEyeY(), this.getZ() - p_32535_.getZ());
            double d0 = vec31.length();
            vec31 = vec31.normalize();
            double d1 = vec3.dot(vec31);
            return d1 > 1.0D - 0.025D / d0 ? p_32535_.hasLineOfSight(this) : false;
    }


    public boolean hurt(DamageSource p_32494_, float p_32495_) {
        if (this.isInvulnerableTo(p_32494_)) {
            return false;
        }  else {
            boolean flag = super.hurt(p_32494_, p_32495_);
            if (!this.level.isClientSide() && !(p_32494_.getEntity() instanceof LivingEntity) && this.random.nextInt(10) != 0) {
                this.teleport();
            }

            return flag;
        }
    }


    protected boolean teleport() {
        if (!this.level.isClientSide() && this.isAlive()) {
            double d0 = this.getX() + (this.random.nextDouble() - 0.5D) * 64.0D;
            double d1 = this.getY() + (double)(this.random.nextInt(64) - 32);
            double d2 = this.getZ() + (this.random.nextDouble() - 0.5D) * 64.0D;
            return this.teleport(d0, d1, d2);
        } else {
            return false;
        }
    }

    boolean teleportTowards(Entity p_32501_) {
        Vec3 vec3 = new Vec3(this.getX() - p_32501_.getX(), this.getY(0.5D) - p_32501_.getEyeY(), this.getZ() - p_32501_.getZ());
        vec3 = vec3.normalize();
        double d0 = 16.0D;
        double d1 = this.getX() + (this.random.nextDouble() - 0.5D) * 8.0D - vec3.x * 16.0D;
        double d2 = this.getY() + (double)(this.random.nextInt(16) - 8) - vec3.y * 16.0D;
        double d3 = this.getZ() + (this.random.nextDouble() - 0.5D) * 8.0D - vec3.z * 16.0D;
        return this.teleport(d1, d2, d3);
    }

    private boolean teleport(double p_32544_, double p_32545_, double p_32546_) {
        BlockPos.MutableBlockPos blockpos$mutableblockpos = new BlockPos.MutableBlockPos(p_32544_, p_32545_, p_32546_);

        while(blockpos$mutableblockpos.getY() > this.level.getMinBuildHeight() && !this.level.getBlockState(blockpos$mutableblockpos).getMaterial().blocksMotion()) {
            blockpos$mutableblockpos.move(Direction.DOWN);
        }

        BlockState blockstate = this.level.getBlockState(blockpos$mutableblockpos);
        boolean flag = blockstate.getMaterial().blocksMotion();
        boolean flag1 = blockstate.getFluidState().is(FluidTags.WATER);
        if (flag && !flag1) {
            net.minecraftforge.event.entity.EntityTeleportEvent.EnderEntity event = net.minecraftforge.event.ForgeEventFactory.onEnderTeleport(this, p_32544_, p_32545_, p_32546_);
            if (event.isCanceled()) return false;
            Vec3 vec3 = this.position();
            boolean flag2 = this.randomTeleport(event.getTargetX(), event.getTargetY(), event.getTargetZ(), true);
            if (flag2) {
                this.level.gameEvent(GameEvent.TELEPORT, vec3, GameEvent.Context.of(this));
                if (!this.isSilent()) {
                    this.level.playSound((Player)null, this.xo, this.yo, this.zo, SoundEvents.ENDERMAN_TELEPORT, this.getSoundSource(), 1.0F, 1.0F);
                    this.playSound(SoundEvents.ENDERMAN_TELEPORT, 1.0F, 1.0F);
                }
            }

            return flag2;
        } else {
            return false;
        }
    }



    private PlayState castPredicate(software.bernie.geckolib.core.animation.AnimationState state) {
        System.out.println(Casting);
        if(Casting==true) {
            state.getController().forceAnimationReset();
            state.getController().setAnimation(RawAnimation.begin().then("chorus_fruit_enderman.model.cast", Animation.LoopType.PLAY_ONCE));
        }
        return PlayState.CONTINUE;}







    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController(this, "controller",
                0, this::predicate));
        controllers.add(new AnimationController(this, "attackController",
                0, this::attackPredicate));
        controllers.add(new AnimationController(this, "castController",
                0, this::castPredicate));
    }

    private PlayState attackPredicate(software.bernie.geckolib.core.animation.AnimationState state) {
        if(this.swinging && state.getController().getAnimationState().equals(AnimationController.State.STOPPED)) {
            state.getController().forceAnimationReset();
            state.getController().setAnimation(RawAnimation.begin().then("chorus_fruit_enderman.model.attack", Animation.LoopType.PLAY_ONCE));
            this.swinging=false;
        }

        return PlayState.CONTINUE;}

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {return factory;}

    protected SoundEvent getAmbientSound() {
        return SoundEvents.ENDERMAN_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource damageSourceIn) {
        return SoundEvents.ENDER_DRAGON_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.ENDERMAN_DEATH;
    }

    protected float getSoundVolume() {
        return 0.5F;
    }

}
