package net.tomsaw31.thefoodrealm.item;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ModFoods {
    public static final FoodProperties FIRE_PEPPER = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.2F).build();
    public static final FoodProperties BLUEBERRIES = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.1F).effect(new MobEffectInstance(MobEffects.WATER_BREATHING, 50, 0),1.0F).build();
    public static final FoodProperties BLACKBERRIES = (new FoodProperties.Builder()).fast().nutrition(2).saturationMod(0.2F).effect(new MobEffectInstance(MobEffects.DARKNESS, 50, 0),1.0F).build();
    public static final FoodProperties STRAWBERRIES = (new FoodProperties.Builder()).fast().nutrition(2).saturationMod(0.2F).effect(new MobEffectInstance(MobEffects.ABSORPTION, 50, 0),1.0F).build();
    public static final FoodProperties RASPBERRIES = (new FoodProperties.Builder()).fast().nutrition(2).saturationMod(0.2F).effect(new MobEffectInstance(MobEffects.REGENERATION, 50, 0),1.0F).build();
    public static final FoodProperties DONUT = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.6F).build();
    public static final FoodProperties CROISSANT = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.6F).build();
    public static final FoodProperties CHOCOLATINE = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.7F).build();
    public static final FoodProperties CUPCAKE = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.5F).build();
    public static final FoodProperties MANGO = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).build();
    public static final FoodProperties SUSHI = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.1F).build();
    public static final FoodProperties CARAMEL_APPLE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).effect(new MobEffectInstance(MobEffects.JUMP, 1200, 2), 1.0F).effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1200, 2), 1.0F).alwaysEat().build();
    public static final FoodProperties BERRY_SKEWER = (new FoodProperties.Builder()).nutrition(8).saturationMod(0.8F).effect(new MobEffectInstance(MobEffects.WATER_BREATHING, 50, 0), 1.0F).effect(new MobEffectInstance(MobEffects.GLOWING, 50, 0), 1.0F).effect(new MobEffectInstance(MobEffects.NIGHT_VISION, 50, 0), 1.0F).alwaysEat().build();
    public static final FoodProperties MUSHROOM_OMELET = (new FoodProperties.Builder()).nutrition(9).saturationMod(0.5F).build();
    public static final FoodProperties APPLE_PIE = (new FoodProperties.Builder()).nutrition(8).saturationMod(0.3F).build();
    public static final FoodProperties CHEESE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.6F).build();
    public static final FoodProperties JUICE = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.2F).build();
    public static final FoodProperties FRUIT = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).build();
}

