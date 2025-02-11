
package jaiz.jaizmod.entity.firefly;
import jaiz.jaizmod.entity.animation.PlantsAndJunkModAnimations;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;

public class Fireflies extends EntityModel<FireFlyRenderState> {
	private final ModelPart swarm;

	public Fireflies(ModelPart root) {
        super(root);
        this.swarm = root.getChild("swarm");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData Swarm = modelPartData.addChild("swarm", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData firefly = Swarm.addChild("firefly", ModelPartBuilder.create().uv(8, 4).cuboid(-1.0F, -0.5F, 0.0F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -9.5F, 0.0F));

		ModelPartData cube_r1 = firefly.addChild("cube_r1", ModelPartBuilder.create().uv(8, 4).cuboid(-1.0F, -0.5F, -0.0005F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0005F, 0.0F, 3.1416F, 0.0F));

		ModelPartData firefly2 = Swarm.addChild("firefly2", ModelPartBuilder.create().uv(4, 8).cuboid(-1.0F, -0.5F, 0.0F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -9.5F, 0.0F));

		ModelPartData cube_r2 = firefly2.addChild("cube_r2", ModelPartBuilder.create().uv(8, 4).cuboid(-1.0F, -0.5F, -0.0005F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0005F, 0.0F, 3.1416F, 0.0F));

		ModelPartData firefly3 = Swarm.addChild("firefly3", ModelPartBuilder.create().uv(8, 3).cuboid(-1.0F, -0.5F, 0.0F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -9.5F, 0.0F));

		ModelPartData cube_r3 = firefly3.addChild("cube_r3", ModelPartBuilder.create().uv(8, 4).cuboid(-1.0F, -0.5F, -0.0005F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0005F, 0.0F, 3.1416F, 0.0F));

		ModelPartData firefly4 = Swarm.addChild("firefly4", ModelPartBuilder.create().uv(8, 2).cuboid(-1.0F, -0.5F, 0.0F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -9.5F, 0.0F));

		ModelPartData cube_r4 = firefly4.addChild("cube_r4", ModelPartBuilder.create().uv(8, 4).cuboid(-1.0F, -0.5F, -0.0005F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0005F, 0.0F, 3.1416F, 0.0F));

		ModelPartData firefly5 = Swarm.addChild("firefly5", ModelPartBuilder.create().uv(8, 1).cuboid(-1.0F, -0.5F, 0.0F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -9.5F, 0.0F));

		ModelPartData cube_r5 = firefly5.addChild("cube_r5", ModelPartBuilder.create().uv(8, 4).cuboid(-1.0F, -0.5F, -0.0005F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0005F, 0.0F, 3.1416F, 0.0F));

		ModelPartData firefly6 = Swarm.addChild("firefly6", ModelPartBuilder.create().uv(8, 0).cuboid(-1.0F, -0.5F, 0.0F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -9.5F, 0.0F));

		ModelPartData cube_r6 = firefly6.addChild("cube_r6", ModelPartBuilder.create().uv(8, 4).cuboid(-1.0F, -0.5F, -0.0005F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0005F, 0.0F, 3.1416F, 0.0F));

		ModelPartData firefly7 = Swarm.addChild("firefly7", ModelPartBuilder.create().uv(0, 8).cuboid(-1.0F, -0.5F, 0.0F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -9.5F, 0.0F));

		ModelPartData cube_r7 = firefly7.addChild("cube_r7", ModelPartBuilder.create().uv(8, 4).cuboid(-1.0F, -0.5F, -0.0005F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0005F, 0.0F, 3.1416F, 0.0F));

		ModelPartData firefly8 = Swarm.addChild("firefly8", ModelPartBuilder.create().uv(4, 7).cuboid(-1.0F, -0.5F, 0.0F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -9.5F, 0.0F));

		ModelPartData cube_r8 = firefly8.addChild("cube_r8", ModelPartBuilder.create().uv(8, 4).cuboid(-1.0F, -0.5F, -0.0005F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0005F, 0.0F, 3.1416F, 0.0F));

		ModelPartData firefly9 = Swarm.addChild("firefly9", ModelPartBuilder.create().uv(0, 7).cuboid(-1.0F, -0.5F, 0.0F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -9.5F, 0.0F));

		ModelPartData cube_r9 = firefly9.addChild("cube_r9", ModelPartBuilder.create().uv(8, 4).cuboid(-1.0F, -0.5F, -0.0005F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0005F, 0.0F, 3.1416F, 0.0F));

		ModelPartData firefly10 = Swarm.addChild("firefly10", ModelPartBuilder.create().uv(4, 6).cuboid(-1.0F, -0.5F, 0.0F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -9.5F, 0.0F));

		ModelPartData cube_r10 = firefly10.addChild("cube_r10", ModelPartBuilder.create().uv(8, 4).cuboid(-1.0F, -0.5F, -0.0005F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0005F, 0.0F, 3.1416F, 0.0F));

		ModelPartData firefly11 = Swarm.addChild("firefly11", ModelPartBuilder.create().uv(0, 6).cuboid(-1.0F, -0.5F, 0.0F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -9.5F, 0.0F));

		ModelPartData cube_r11 = firefly11.addChild("cube_r11", ModelPartBuilder.create().uv(8, 4).cuboid(-1.0F, -0.5F, -0.0005F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0005F, 0.0F, 3.1416F, 0.0F));

		ModelPartData firefly12 = Swarm.addChild("firefly12", ModelPartBuilder.create().uv(4, 5).cuboid(-1.0F, -0.5F, 0.0F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -9.5F, 0.0F));

		ModelPartData cube_r12 = firefly12.addChild("cube_r12", ModelPartBuilder.create().uv(8, 4).cuboid(-1.0F, -0.5F, -0.0005F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0005F, 0.0F, 3.1416F, 0.0F));

		ModelPartData firefly13 = Swarm.addChild("firefly13", ModelPartBuilder.create().uv(0, 5).cuboid(-1.0F, -0.5F, 0.0F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -9.5F, 0.0F));

		ModelPartData cube_r13 = firefly13.addChild("cube_r13", ModelPartBuilder.create().uv(8, 4).cuboid(-1.0F, -0.5F, -0.0005F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0005F, 0.0F, 3.1416F, 0.0F));

		ModelPartData firefly14 = Swarm.addChild("firefly14", ModelPartBuilder.create().uv(4, 4).cuboid(-1.0F, -0.5F, 0.0F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -9.5F, 0.0F));

		ModelPartData cube_r14 = firefly14.addChild("cube_r14", ModelPartBuilder.create().uv(8, 4).cuboid(-1.0F, -0.5F, -0.0005F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0005F, 0.0F, 3.1416F, 0.0F));

		ModelPartData firefly15 = Swarm.addChild("firefly15", ModelPartBuilder.create().uv(4, 3).cuboid(-1.0F, -0.5F, 0.0F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -9.5F, 0.0F));

		ModelPartData cube_r15 = firefly15.addChild("cube_r15", ModelPartBuilder.create().uv(8, 4).cuboid(-1.0F, -0.5F, -0.0005F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0005F, 0.0F, 3.1416F, 0.0F));

		ModelPartData firefly16 = Swarm.addChild("firefly16", ModelPartBuilder.create().uv(4, 2).cuboid(-1.0F, -0.5F, 0.0F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -9.5F, 0.0F));

		ModelPartData cube_r16 = firefly16.addChild("cube_r16", ModelPartBuilder.create().uv(8, 4).cuboid(-1.0F, -0.5F, -0.0005F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0005F, 0.0F, 3.1416F, 0.0F));

		ModelPartData firefly17 = Swarm.addChild("firefly17", ModelPartBuilder.create().uv(4, 1).cuboid(-1.0F, -0.5F, 0.0F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -9.5F, 0.0F));

		ModelPartData cube_r17 = firefly17.addChild("cube_r17", ModelPartBuilder.create().uv(8, 4).cuboid(-1.0F, -0.5F, -0.0005F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0005F, 0.0F, 3.1416F, 0.0F));

		ModelPartData firefly18 = Swarm.addChild("firefly18", ModelPartBuilder.create().uv(4, 0).cuboid(-1.0F, -0.5F, 0.0F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -9.5F, 0.0F));

		ModelPartData cube_r18 = firefly18.addChild("cube_r18", ModelPartBuilder.create().uv(8, 4).cuboid(-1.0F, -0.5F, -0.0005F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0005F, 0.0F, 3.1416F, 0.0F));

		ModelPartData firefly19 = Swarm.addChild("firefly19", ModelPartBuilder.create().uv(0, 4).cuboid(-1.0F, -0.5F, 0.0F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -9.5F, 0.0F));

		ModelPartData cube_r19 = firefly19.addChild("cube_r19", ModelPartBuilder.create().uv(8, 4).cuboid(-1.0F, -0.5F, -0.0005F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0005F, 0.0F, 3.1416F, 0.0F));

		ModelPartData firefly20 = Swarm.addChild("firefly20", ModelPartBuilder.create().uv(0, 3).cuboid(-1.0F, -0.5F, 0.0F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -9.5F, 0.0F));

		ModelPartData cube_r20 = firefly20.addChild("cube_r20", ModelPartBuilder.create().uv(8, 4).cuboid(-1.0F, -0.5F, -0.0005F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0005F, 0.0F, 3.1416F, 0.0F));

		ModelPartData firefly21 = Swarm.addChild("firefly21", ModelPartBuilder.create().uv(0, 2).cuboid(-1.0F, -0.5F, 0.0F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -9.5F, 0.0F));

		ModelPartData cube_r21 = firefly21.addChild("cube_r21", ModelPartBuilder.create().uv(8, 4).cuboid(-1.0F, -0.5F, -0.0005F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0005F, 0.0F, 3.1416F, 0.0F));

		ModelPartData firefly22 = Swarm.addChild("firefly22", ModelPartBuilder.create().uv(0, 1).cuboid(-1.0F, -0.5F, 0.0F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -9.5F, 0.0F));

		ModelPartData cube_r22 = firefly22.addChild("cube_r22", ModelPartBuilder.create().uv(8, 4).cuboid(-1.0F, -0.5F, -0.0005F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0005F, 0.0F, 3.1416F, 0.0F));

		ModelPartData firefly23 = Swarm.addChild("firefly23", ModelPartBuilder.create().uv(0, 0).cuboid(-1.0F, -0.5F, 0.0F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.pivot(0.0F, -9.5F, 0.0F));

		ModelPartData cube_r23 = firefly23.addChild("cube_r23", ModelPartBuilder.create().uv(8, 4).cuboid(-1.0F, -0.5F, -0.0005F, 2.0F, 1.0F, 0.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, 0.0F, 0.0005F, 0.0F, 3.1416F, 0.0F));
		return TexturedModelData.of(modelData, 16, 16);
	}
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		swarm.render(matrices, vertexConsumer, light, overlay);
	}

	public ModelPart getPart() {
		return swarm;
	}

	@Override
	public void setAngles(FireFlyRenderState entity) {
		super.setAngles(entity);
		this.getPart().traverse().forEach(ModelPart::resetTransform);
		this.animate(entity.flyingAnimationState, PlantsAndJunkModAnimations.FIRE_FLY_SWARM, entity.age);
	}
}