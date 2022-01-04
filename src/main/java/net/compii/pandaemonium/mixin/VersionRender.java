/*

    Pandaemonium
    VersionRender.java
    Displays version number on screen

 */

// TODO: Find out why it's not working anymore

package net.compii.pandaemonium.mixin;

import java.awt.Color;
import com.mojang.blaze3d.systems.RenderSystem;
import net.compii.pandaemonium.Pandaemonium;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.DrawableHelper;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.player.PlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import net.compii.pandaemonium.util.VerVector;

@Environment(EnvType.CLIENT)
@Mixin(InGameHud.class)
public abstract class VersionRender {

    private TextRenderer textRenderer = null;

    @Accessor("client")
    protected abstract MinecraftClient getClient();

    @Inject(
            method = "render(Lnet/minecraft/client/util/math/MatrixStack;F)V",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/gui/hud/InGameHud;renderStatusEffectOverlay(Lnet/minecraft/client/util/math/MatrixStack;)V",
                    shift = At.Shift.AFTER
            ),
            cancellable = true
    )
    private void renderVersion(MatrixStack matrices, float tickDelta, CallbackInfo info) {
        MinecraftClient client = getClient();
        PlayerEntity playerEntity = client.player;

        if (textRenderer == null)
            textRenderer = client.textRenderer;

        String verStr = String.format("Pandaemonium v", Pandaemonium.MODVER);

        int textWidth = textRenderer.getWidth(verStr);
        VerVector screenPos = getVerScreenPos(client, textWidth);

        Color foreColor = new Color(224,224,224, 255);

        RenderSystem.enableBlend();
        RenderSystem.defaultBlendFunc();
        DrawableHelper.fill(matrices, screenPos.getX() - 2, screenPos.getY() - 2, screenPos.getX() + textWidth + 2, screenPos.getY() + 11, client.options.getTextBackgroundColor(0));
        textRenderer.drawWithShadow(matrices, verStr, ((float)screenPos.getX() - 1), (float)screenPos.getY(), foreColor.getRGB());
        RenderSystem.disableBlend();
    }

    private VerVector getVerScreenPos(MinecraftClient client, int textWidth) {
        //return new VerVector(client.getWindow().getScaledWidth() - (textWidth + 3), 2);
        return new VerVector(3, 2);
    }
}
