package net.tomsaw31.thefoodrealm.screen;

import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import net.tomsaw31.thefoodrealm.TheFoodRealm;

public class CookingPotScreen extends AbstractContainerScreen<CookingPotMenu> {
    private static final ResourceLocation TEXTURE =
            new ResourceLocation(TheFoodRealm.MOD_ID, "textures/gui/cooking_pot_gui.png");
    public CookingPotScreen(CookingPotMenu cookingPotMenu, Inventory inventory, Component component) {
        super(cookingPotMenu, inventory, component);
    }

    @Override
    protected void init() {
        super.init();
    }

    @Override
    protected void renderBg(PoseStack stack, float pPartialTick, int pMouseX, int pMouseY) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, TEXTURE);
        int x = (width - imageWidth) / 2;
        int y = (height - imageHeight) / 2;
        this.blit(stack, x, y, 0, 0, imageWidth, imageHeight);
        renderProgressArrow(stack,x,y);
    }

    private void renderProgressArrow(PoseStack pPoseStack, int x, int y) {
        if(menu.isCrafting()) {
            blit(pPoseStack, x + 105, y + 33, 176, 14, menu.getScaledProgress(),17 );
            blit(pPoseStack, x + 63, y + 79-menu.getScaledProgressFire(), 176, 14-menu.getScaledProgressFire(), 14,menu.getScaledProgressFire());
        }
    }


    @Override
    public void render(PoseStack pPoseStack, int mouseX, int mouseY, float delta) {
        renderBackground(pPoseStack);
        super.render(pPoseStack, mouseX, mouseY, delta);
        renderTooltip(pPoseStack, mouseX, mouseY);
    }
}