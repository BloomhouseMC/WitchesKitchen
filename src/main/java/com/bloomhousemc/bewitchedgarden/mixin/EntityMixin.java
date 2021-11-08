package com.bloomhousemc.bewitchedgarden.mixin;

import com.bloomhousemc.bewitchedgarden.common.world.BGWorldState;
import net.minecraft.entity.Entity;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.UUID;

@Mixin(Entity.class)
public abstract class EntityMixin {
    @Shadow
    public World world;

    @Shadow
    public abstract UUID getUuid();

    @Inject(method = "remove", at = @At("TAIL"))
    private void remove(CallbackInfo callbackInfo) {
        if (!world.isClient) {
            BGWorldState universalWorldState = BGWorldState.get(world);
            for (int i = universalWorldState.effigies.size() - 1; i >= 0; i--) {
                if (getUuid().equals(universalWorldState.effigies.get(i).getRight().getUuid("UUID"))) {
                    universalWorldState.effigies.remove(i);
                    universalWorldState.markDirty();
                    break;
                }
            }
        }
    }
}