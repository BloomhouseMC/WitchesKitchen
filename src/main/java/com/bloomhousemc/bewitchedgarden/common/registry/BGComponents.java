package com.bloomhousemc.bewitchedgarden.common.registry;

import com.bloomhousemc.bewitchedgarden.BewitchedGarden;
import com.bloomhousemc.bewitchedgarden.common.components.EffigyComponent;
import com.bloomhousemc.bewitchedgarden.common.entity.EffigyEntity;
import dev.onyxstudios.cca.api.v3.component.ComponentKey;
import dev.onyxstudios.cca.api.v3.component.ComponentRegistryV3;
import dev.onyxstudios.cca.api.v3.entity.EntityComponentFactoryRegistry;
import dev.onyxstudios.cca.api.v3.entity.EntityComponentInitializer;
import dev.onyxstudios.cca.api.v3.entity.RespawnCopyStrategy;
import dev.onyxstudios.cca.api.v3.world.WorldComponentFactoryRegistry;
import dev.onyxstudios.cca.api.v3.world.WorldComponentInitializer;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Identifier;

public class BGComponents implements EntityComponentInitializer, WorldComponentInitializer {
    public static final ComponentKey<EffigyComponent> EFFIGY_COMPONENT = ComponentRegistryV3.INSTANCE.getOrCreate(new Identifier(BewitchedGarden.MODID, "effigy"), EffigyComponent.class);

    @Override
    public void registerEntityComponentFactories(EntityComponentFactoryRegistry registry) {
        registry.beginRegistration(EffigyEntity.class, EFFIGY_COMPONENT).impl(EffigyComponent.class).respawnStrategy(RespawnCopyStrategy.LOSSLESS_ONLY).end(EffigyComponent::new);

    }

    @Override
    public void registerWorldComponentFactories(WorldComponentFactoryRegistry registry) {

    }
}
