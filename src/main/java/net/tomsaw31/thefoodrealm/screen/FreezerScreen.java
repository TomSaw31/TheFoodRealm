package net.tomsaw31.thefoodrealm.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.tomsaw31.thefoodrealm.TheFoodRealm;

public class FreezerScreen extends AbstractContainerScreen<FreezerMenu> {
    private static final ResourceLocation TEXTURE =
            new ResourceLocation(TheFoodRealm.MOD_ID, "textures/gui/freezer_gui.png");

    public FreezerScreen(FreezerMenu Menu, Inventory inventory, Component component) {
        super(Menu, inventory, component);
    }

    @Override
    protected void renderBg(PoseStack pPoseStack, float pPartialTick, int pMouseX, int pMouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;

        this.blit(pPoseStack, x, y, 0, 0, imageWidth, imageHeight);

        if(menu.isCrafting()) {
            blit(pPoseStack, x + 67, y + 39, 176, 0, 8, menu.getScaledProgress());
            blit(pPoseStack, x + 112, y + 54, 184, 0, 12, menu.getScaledProgressElectric());
        }
    }



    @Override
    public void render(PoseStack pPoseStack, int mouseX, int mouseY, float delta) {
        renderBackground(pPoseStack);
        super.render(pPoseStack, mouseX, mouseY, delta);
        renderTooltip(pPoseStack, mouseX, mouseY);
    }
}
