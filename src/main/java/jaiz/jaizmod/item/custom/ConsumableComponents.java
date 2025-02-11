package jaiz.jaizmod.item.custom;


import net.minecraft.component.type.ConsumableComponent;
import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.consume.ApplyEffectsConsumeEffect;

import static net.minecraft.component.type.ConsumableComponents.drink;
import static net.minecraft.component.type.ConsumableComponents.food;

public class ConsumableComponents {
    public static final ConsumableComponent RARE_SPICES = food()
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 200, 0), 0.5F))
            .build();
    public static final ConsumableComponent GOURMET_MEAL = food()
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 200, 0), 0.25F))
            .build();
    public static final ConsumableComponent TEA = drink()
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 80, 0), 0.1F))
            .build();

    public static final ConsumableComponent COCOON = food()
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.NAUSEA, 120, 0), 1.0F))
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.POISON, 120, 0), 1.0F))
            .build();

    public static final ConsumableComponent WITHER_ROSE_TEA = drink()
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.INSTANT_DAMAGE, 1, 0), 1.0F))
            .build();
    public static final ConsumableComponent SPORE_BLOSSOM_TEA = drink()
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 400, 0), 1.0F))
            .build();
    public static final ConsumableComponent GLOW_BERRY_TEA = drink()
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.GLOWING, 100, 0), 1.0F))
            .build();
    public static final ConsumableComponent TORCH_FLOWER_TEA = drink()
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 1200, 0), 1.0F))
            .build();
    public static final ConsumableComponent PITCHER_PLANT_TEA = drink()
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 1200, 0), 1.0F))
            .build();
    public static final ConsumableComponent NETHER_FUNGAL_TEA = drink()
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.FIRE_RESISTANCE, 1200, 0), 1.0F))
            .build();
    public static final ConsumableComponent CHORUS_TEA = drink()
            .consumeEffect(new ApplyEffectsConsumeEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 120, 0), 1.0F))
            .build();
}
