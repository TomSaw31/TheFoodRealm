package net.tomsaw31.thefoodrealm.entity.custom;

import java.util.Comparator;
import java.util.EnumSet;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.BodyRotationControl;
import net.minecraft.world.entity.ai.control.LookControl;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.targeting.TargetingConditions;
import net.minecraft.world.entity.animal.Cat;
import net.minecraft.world.entity.monster.Enemy;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.phys.Vec3;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

public class GrapeDragonEntity extends FlyingMob implements Enemy, IAnimatable {
    private AnimationFactory factory = new AnimationFactory(this);
    private static final EntityDataAccessor<Integer> ID_SIZE = SynchedEntityData.defineId(GrapeDragonEntity.class, EntityDataSerializers.INT);
    Vec3 moveTargetPoint = Vec3.ZERO;
    BlockPos anchorPoint = BlockPos.ZERO;
    AttackPhase attackPhase = AttackPhase.CIRCLE;

    private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {
            event.getController().setAnimation(new AnimationBuilder().addAnimation("flying", true));
            return PlayState.CONTINUE;
    }

    @Override
    public void registerControllers(AnimationData data) {
        data.addAnimationController(new AnimationController(this, "controller",
                0, this::predicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }

    public GrapeDragonEntity(EntityType<? extends GrapeDragonEntity> p_33101_, Level p_33102_) {
        super(p_33101_, p_33102_);
        this.xpReward = 5;
        this.moveControl = new GrapeDragonMoveControl(this);
        this.lookControl = new GrapeDragonLookControl(this);
    }

    protected BodyRotationControl createBodyControl() {
        return new GrapeDragonBodyRotationControl(this);
    }

    public static AttributeSupplier setAttributes() {
        return TamableAnimal.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 10.00)
                .add(Attributes.MOVEMENT_SPEED, 0.1f)
                .add(Attributes.ATTACK_DAMAGE, 2f)
                .add(Attributes.ATTACK_SPEED, 0.2f).build();

    }
    
    
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new GrapeDragonAttackStrategyGoal());
        this.goalSelector.addGoal(2, new GrapeDragonSweepAttackGoal());
        this.goalSelector.addGoal(3, new GrapeDragonCircleAroundAnchorGoal());
        this.targetSelector.addGoal(1, new GrapeDragonAttackPlayerTargetGoal());
    }

    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(ID_SIZE, 0);
    }

    public void setGrapeDragonSize(int p_33109_) {
        this.entityData.set(ID_SIZE, Mth.clamp(p_33109_, 0, 64));
    }

    private void updateGrapeDragonSizeInfo() {
        this.refreshDimensions();
        this.getAttribute(Attributes.ATTACK_DAMAGE).setBaseValue((double)(6 + this.getGrapeDragonSize()));
    }

    public int getGrapeDragonSize() {
        return this.entityData.get(ID_SIZE);
    }

    protected float getStandingEyeHeight(Pose p_33136_, EntityDimensions p_33137_) {
        return p_33137_.height * 0.35F;
    }

    public void onSyncedDataUpdated(EntityDataAccessor<?> p_33134_) {
        if (ID_SIZE.equals(p_33134_)) {
            this.updateGrapeDragonSizeInfo();
        }

        super.onSyncedDataUpdated(p_33134_);
    }



    protected boolean shouldDespawnInPeaceful() {
        return true;
    }


    protected void customServerAiStep() {
        super.customServerAiStep();
    }

    public SpawnGroupData finalizeSpawn(ServerLevelAccessor p_33126_, DifficultyInstance p_33127_, MobSpawnType p_33128_, @Nullable SpawnGroupData p_33129_, @Nullable CompoundTag p_33130_) {
        this.anchorPoint = this.blockPosition().above(5);
        this.setGrapeDragonSize(0);
        return super.finalizeSpawn(p_33126_, p_33127_, p_33128_, p_33129_, p_33130_);
    }

    public void readAdditionalSaveData(CompoundTag p_33132_) {
        super.readAdditionalSaveData(p_33132_);
        if (p_33132_.contains("AX")) {
            this.anchorPoint = new BlockPos(p_33132_.getInt("AX"), p_33132_.getInt("AY"), p_33132_.getInt("AZ"));
        }

        this.setGrapeDragonSize(p_33132_.getInt("Size"));
    }

    public void addAdditionalSaveData(CompoundTag p_33141_) {
        super.addAdditionalSaveData(p_33141_);
        p_33141_.putInt("AX", this.anchorPoint.getX());
        p_33141_.putInt("AY", this.anchorPoint.getY());
        p_33141_.putInt("AZ", this.anchorPoint.getZ());
        p_33141_.putInt("Size", this.getGrapeDragonSize());
    }

    public boolean shouldRenderAtSqrDistance(double p_33107_) {
        return true;
    }

    public SoundSource getSoundSource() {
        return SoundSource.HOSTILE;
    }

    protected SoundEvent getAmbientSound() {
        return SoundEvents.PHANTOM_AMBIENT;
    }

    protected SoundEvent getHurtSound(DamageSource p_33152_) {
        return SoundEvents.PHANTOM_HURT;
    }

    protected SoundEvent getDeathSound() {
        return SoundEvents.PHANTOM_DEATH;
    }

    public MobType getMobType() {
        return MobType.UNDEAD;
    }

    protected float getSoundVolume() {
        return 1.0F;
    }

    public boolean canAttackType(EntityType<?> p_33111_) {
        return true;
    }

    public EntityDimensions getDimensions(Pose p_33113_) {
        int i = this.getGrapeDragonSize();
        EntityDimensions entitydimensions = super.getDimensions(p_33113_);
        float f = (entitydimensions.width + 0.2F * (float)i) / entitydimensions.width;
        return entitydimensions.scale(f);
    }

    static enum AttackPhase {
        CIRCLE,
        SWOOP;
    }

    class GrapeDragonAttackPlayerTargetGoal extends Goal {
        private final TargetingConditions attackTargeting = TargetingConditions.forCombat().range(64.0D);
        private int nextScanTick = reducedTickDelay(20);

        public boolean canUse() {
            if (this.nextScanTick > 0) {
                --this.nextScanTick;
                return false;
            } else {
                this.nextScanTick = reducedTickDelay(60);
                List<Player> list = GrapeDragonEntity.this.level.getNearbyPlayers(this.attackTargeting, GrapeDragonEntity.this, GrapeDragonEntity.this.getBoundingBox().inflate(16.0D, 64.0D, 16.0D));
                if (!list.isEmpty()) {
                    list.sort(Comparator.<Entity, Double>comparing(Entity::getY).reversed());

                    for(Player player : list) {
                        if (GrapeDragonEntity.this.canAttack(player, TargetingConditions.DEFAULT)) {
                            GrapeDragonEntity.this.setTarget(player);
                            return true;
                        }
                    }
                }

                return false;
            }
        }

        public boolean canContinueToUse() {
            LivingEntity livingentity = GrapeDragonEntity.this.getTarget();
            return livingentity != null ? GrapeDragonEntity.this.canAttack(livingentity, TargetingConditions.DEFAULT) : false;
        }
    }

    class GrapeDragonAttackStrategyGoal extends Goal {
        private int nextSweepTick;

        public boolean canUse() {
            LivingEntity livingentity = GrapeDragonEntity.this.getTarget();
            return livingentity != null ? GrapeDragonEntity.this.canAttack(livingentity, TargetingConditions.DEFAULT) : false;
        }

        public void start() {
            this.nextSweepTick = this.adjustedTickDelay(10);
            GrapeDragonEntity.this.attackPhase = AttackPhase.CIRCLE;
            this.setAnchorAboveTarget();
        }

        public void stop() {
            GrapeDragonEntity.this.anchorPoint = GrapeDragonEntity.this.level.getHeightmapPos(Heightmap.Types.MOTION_BLOCKING, GrapeDragonEntity.this.anchorPoint).above(10 + GrapeDragonEntity.this.random.nextInt(20));
        }

        public void tick() {
            if (GrapeDragonEntity.this.attackPhase == AttackPhase.CIRCLE) {
                --this.nextSweepTick;
                if (this.nextSweepTick <= 0) {
                    GrapeDragonEntity.this.attackPhase = AttackPhase.SWOOP;
                    this.setAnchorAboveTarget();
                    this.nextSweepTick = this.adjustedTickDelay((8 + GrapeDragonEntity.this.random.nextInt(4)) * 20);
                    GrapeDragonEntity.this.playSound(SoundEvents.PHANTOM_SWOOP, 10.0F, 0.95F + GrapeDragonEntity.this.random.nextFloat() * 0.1F);
                }
            }

        }

        private void setAnchorAboveTarget() {
            GrapeDragonEntity.this.anchorPoint = GrapeDragonEntity.this.getTarget().blockPosition().above(20 + GrapeDragonEntity.this.random.nextInt(20));
            if (GrapeDragonEntity.this.anchorPoint.getY() < GrapeDragonEntity.this.level.getSeaLevel()) {
                GrapeDragonEntity.this.anchorPoint = new BlockPos(GrapeDragonEntity.this.anchorPoint.getX(), GrapeDragonEntity.this.level.getSeaLevel() + 1, GrapeDragonEntity.this.anchorPoint.getZ());
            }

        }
    }

    class GrapeDragonBodyRotationControl extends BodyRotationControl {
        public GrapeDragonBodyRotationControl(Mob p_33216_) {
            super(p_33216_);
        }

        public void clientTick() {
            GrapeDragonEntity.this.yHeadRot = GrapeDragonEntity.this.yBodyRot;
            GrapeDragonEntity.this.yBodyRot = GrapeDragonEntity.this.getYRot();
        }
    }

    class GrapeDragonCircleAroundAnchorGoal extends GrapeDragonMoveTargetGoal {
        private float angle;
        private float distance;
        private float height;
        private float clockwise;

        public boolean canUse() {
            return GrapeDragonEntity.this.getTarget() == null || GrapeDragonEntity.this.attackPhase == AttackPhase.CIRCLE;
        }

        public void start() {
            this.distance = 5.0F + GrapeDragonEntity.this.random.nextFloat() * 10.0F;
            this.height = -4.0F + GrapeDragonEntity.this.random.nextFloat() * 9.0F;
            this.clockwise = GrapeDragonEntity.this.random.nextBoolean() ? 1.0F : -1.0F;
            this.selectNext();
        }

        public void tick() {
            if (GrapeDragonEntity.this.random.nextInt(this.adjustedTickDelay(350)) == 0) {
                this.height = -4.0F + GrapeDragonEntity.this.random.nextFloat() * 9.0F;
            }

            if (GrapeDragonEntity.this.random.nextInt(this.adjustedTickDelay(250)) == 0) {
                ++this.distance;
                if (this.distance > 15.0F) {
                    this.distance = 5.0F;
                    this.clockwise = -this.clockwise;
                }
            }

            if (GrapeDragonEntity.this.random.nextInt(this.adjustedTickDelay(450)) == 0) {
                this.angle = GrapeDragonEntity.this.random.nextFloat() * 2.0F * (float)Math.PI;
                this.selectNext();
            }

            if (this.touchingTarget()) {
                this.selectNext();
            }

            if (GrapeDragonEntity.this.moveTargetPoint.y < GrapeDragonEntity.this.getY() && !GrapeDragonEntity.this.level.isEmptyBlock(GrapeDragonEntity.this.blockPosition().below(1))) {
                this.height = Math.max(1.0F, this.height);
                this.selectNext();
            }

            if (GrapeDragonEntity.this.moveTargetPoint.y > GrapeDragonEntity.this.getY() && !GrapeDragonEntity.this.level.isEmptyBlock(GrapeDragonEntity.this.blockPosition().above(1))) {
                this.height = Math.min(-1.0F, this.height);
                this.selectNext();
            }

        }

        private void selectNext() {
            if (BlockPos.ZERO.equals(GrapeDragonEntity.this.anchorPoint)) {
                GrapeDragonEntity.this.anchorPoint = GrapeDragonEntity.this.blockPosition();
            }

            this.angle += this.clockwise * 15.0F * ((float)Math.PI / 180F);
            GrapeDragonEntity.this.moveTargetPoint = Vec3.atLowerCornerOf(GrapeDragonEntity.this.anchorPoint).add((double)(this.distance * Mth.cos(this.angle)), (double)(-4.0F + this.height), (double)(this.distance * Mth.sin(this.angle)));
        }
    }

    class GrapeDragonLookControl extends LookControl {
        public GrapeDragonLookControl(Mob p_33235_) {
            super(p_33235_);
        }

        public void tick() {
        }
    }

    class GrapeDragonMoveControl extends MoveControl {
        private float speed = 0.1F;

        public GrapeDragonMoveControl(Mob p_33241_) {
            super(p_33241_);
        }

        public void tick() {
            if (GrapeDragonEntity.this.horizontalCollision) {
                GrapeDragonEntity.this.setYRot(GrapeDragonEntity.this.getYRot() + 180.0F);
                this.speed = 0.1F;
            }

            double d0 = GrapeDragonEntity.this.moveTargetPoint.x - GrapeDragonEntity.this.getX();
            double d1 = GrapeDragonEntity.this.moveTargetPoint.y - GrapeDragonEntity.this.getY();
            double d2 = GrapeDragonEntity.this.moveTargetPoint.z - GrapeDragonEntity.this.getZ();
            double d3 = Math.sqrt(d0 * d0 + d2 * d2);
            if (Math.abs(d3) > (double)1.0E-5F) {
                double d4 = 1.0D - Math.abs(d1 * (double)0.7F) / d3;
                d0 *= d4;
                d2 *= d4;
                d3 = Math.sqrt(d0 * d0 + d2 * d2);
                double d5 = Math.sqrt(d0 * d0 + d2 * d2 + d1 * d1);
                float f = GrapeDragonEntity.this.getYRot();
                float f1 = (float)Mth.atan2(d2, d0);
                float f2 = Mth.wrapDegrees(GrapeDragonEntity.this.getYRot() + 90.0F);
                float f3 = Mth.wrapDegrees(f1 * (180F / (float)Math.PI));
                GrapeDragonEntity.this.setYRot(Mth.approachDegrees(f2, f3, 4.0F) - 90.0F);
                GrapeDragonEntity.this.yBodyRot = GrapeDragonEntity.this.getYRot();
                if (Mth.degreesDifferenceAbs(f, GrapeDragonEntity.this.getYRot()) < 3.0F) {
                    this.speed = Mth.approach(this.speed, 1.8F, 0.005F * (1.8F / this.speed));
                } else {
                    this.speed = Mth.approach(this.speed, 0.2F, 0.025F);
                }

                float f4 = (float)(-(Mth.atan2(-d1, d3) * (double)(180F / (float)Math.PI)));
                GrapeDragonEntity.this.setXRot(f4);
                float f5 = GrapeDragonEntity.this.getYRot() + 90.0F;
                double d6 = (double)(this.speed * Mth.cos(f5 * ((float)Math.PI / 180F))) * Math.abs(d0 / d5);
                double d7 = (double)(this.speed * Mth.sin(f5 * ((float)Math.PI / 180F))) * Math.abs(d2 / d5);
                double d8 = (double)(this.speed * Mth.sin(f4 * ((float)Math.PI / 180F))) * Math.abs(d1 / d5);
                Vec3 vec3 = GrapeDragonEntity.this.getDeltaMovement();
                GrapeDragonEntity.this.setDeltaMovement(vec3.add((new Vec3(d6, d8, d7)).subtract(vec3).scale(0.2D)));
            }

        }
    }

    abstract class GrapeDragonMoveTargetGoal extends Goal {
        public GrapeDragonMoveTargetGoal() {
            this.setFlags(EnumSet.of(Flag.MOVE));
        }

        protected boolean touchingTarget() {
            return GrapeDragonEntity.this.moveTargetPoint.distanceToSqr(GrapeDragonEntity.this.getX(), GrapeDragonEntity.this.getY(), GrapeDragonEntity.this.getZ()) < 4.0D;
        }
    }

    class GrapeDragonSweepAttackGoal extends GrapeDragonMoveTargetGoal {
        private static final int CAT_SEARCH_TICK_DELAY = 20;
        private boolean isScaredOfCat;
        private int catSearchTick;

        public boolean canUse() {
            return GrapeDragonEntity.this.getTarget() != null && GrapeDragonEntity.this.attackPhase == AttackPhase.SWOOP;
        }

        public boolean canContinueToUse() {
            LivingEntity livingentity = GrapeDragonEntity.this.getTarget();
            if (livingentity == null) {
                return false;
            } else if (!livingentity.isAlive()) {
                return false;
            } else {
                if (livingentity instanceof Player) {
                    Player player = (Player)livingentity;
                    if (livingentity.isSpectator() || player.isCreative()) {
                        return false;
                    }
                }

                if (!this.canUse()) {
                    return false;
                } else {
                    if (GrapeDragonEntity.this.tickCount > this.catSearchTick) {
                        this.catSearchTick = GrapeDragonEntity.this.tickCount + 20;
                        List<Cat> list = GrapeDragonEntity.this.level.getEntitiesOfClass(Cat.class, GrapeDragonEntity.this.getBoundingBox().inflate(16.0D), EntitySelector.ENTITY_STILL_ALIVE);

                        for(Cat cat : list) {
                            cat.hiss();
                        }

                        this.isScaredOfCat = !list.isEmpty();
                    }

                    return !this.isScaredOfCat;
                }
            }
        }

        public void start() {
        }

        public void stop() {
            GrapeDragonEntity.this.setTarget((LivingEntity)null);
            GrapeDragonEntity.this.attackPhase = AttackPhase.CIRCLE;
        }

        public void tick() {
            LivingEntity livingentity = GrapeDragonEntity.this.getTarget();
            if (livingentity != null) {
                GrapeDragonEntity.this.moveTargetPoint = new Vec3(livingentity.getX(), livingentity.getY(0.5D), livingentity.getZ());
                if (GrapeDragonEntity.this.getBoundingBox().inflate((double)0.2F).intersects(livingentity.getBoundingBox())) {
                    GrapeDragonEntity.this.doHurtTarget(livingentity);
                    GrapeDragonEntity.this.attackPhase = AttackPhase.CIRCLE;
                    if (!GrapeDragonEntity.this.isSilent()) {
                        GrapeDragonEntity.this.level.levelEvent(1039, GrapeDragonEntity.this.blockPosition(), 0);
                    }
                } else if (GrapeDragonEntity.this.horizontalCollision || GrapeDragonEntity.this.hurtTime > 0) {
                    GrapeDragonEntity.this.attackPhase = AttackPhase.CIRCLE;
                }

            }
        }
    }
}
