package jaiz.jaizmod.entity.firefly;

import jaiz.jaizmod.JaizMod;
import jaiz.jaizmod.entity.ModModelLayers;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

public class FireflyRenderer<T extends FireFlySwarmEntity> extends MobEntityRenderer<T, FireFlyRenderState, Fireflies> {

    private static final Identifier TEXTURE = Identifier.of(JaizMod.MOD_ID,"textures/entity/fireflies/fireflies.png");

    public FireflyRenderer(EntityRendererFactory.Context context) {
        super(context, new Fireflies(context.getPart(ModModelLayers.FIRE_FLY_SWARM)), 0f);
        this.addFeature(new FireFliesFeatureRenderer<>(this));
    }

    @Override
    public Identifier getTexture(FireFlyRenderState state) {
        return TEXTURE;
    }

    @Override
    public FireFlyRenderState createRenderState() {
        return new FireFlyRenderState();
    }

    public void updateRenderState(FireFlySwarmEntity entity, FireFlyRenderState state, float f) {
        state.flyingAnimationState.copyFrom(entity.fireflyAnimationState);
    }

}
