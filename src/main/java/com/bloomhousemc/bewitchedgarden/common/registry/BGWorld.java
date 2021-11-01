package com.bloomhousemc.bewitchedgarden.common.registry;

import com.bloomhousemc.bewitchedgarden.BewitchedGarden;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.BuiltinRegistries;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.ConfiguredFeatures;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;

public class BGWorld {

    // Herbs
    public static final ConfiguredFeature<?, ?> MINT = register("mint", Feature.RANDOM_PATCH.configure(ConfiguredFeatures.Configs.GRASS_CONFIG).decorate(ConfiguredFeatures.Decorators.SQUARE_HEIGHTMAP_SPREAD_DOUBLE).repeat(5));

    private static <FC extends FeatureConfig> ConfiguredFeature<FC, ?> register(String id, ConfiguredFeature<FC, ?> feature) {
        return Registry.register(BuiltinRegistries.CONFIGURED_FEATURE, new Identifier(BewitchedGarden.MODID, id), feature);
    }

    public static void init() {

    }
}