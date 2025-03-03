package net.tomsaw31.thefoodrealm.enchant;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.tomsaw31.thefoodrealm.effect.ModEffects;

public class PutrefiedStrikeEnchantment extends Enchantment {
    public PutrefiedStrikeEnchantment(Rarity pRarity, EnchantmentCategory pCategory, EquipmentSlot... pApplicableSlots) {
        super(pRarity, pCategory, pApplicableSlots);
    }



    @Override
    public void doPostAttack(LivingEntity pAttacker, Entity pTarget, int pLevel) {
        if(!pAttacker.level.isClientSide()) {
                ((LivingEntity)pTarget).addEffect(new MobEffectInstance(ModEffects.ROTTING.get(), 100*pLevel), pAttacker);
                if (((Mob)pTarget).getMobType() == MobType.UNDEAD) {((Mob)pTarget).addEffect(new MobEffectInstance(MobEffects.HEAL, 100*pLevel), pAttacker);}
        }
        super.doPostAttack(pAttacker, pTarget, pLevel);
    }

    @Override
    public int getMaxLevel() {
        return 5;
    }
}
