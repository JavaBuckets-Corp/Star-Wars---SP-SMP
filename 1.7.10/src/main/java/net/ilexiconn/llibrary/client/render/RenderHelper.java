package net.ilexiconn.llibrary.client.render;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.ilexiconn.llibrary.client.render.entity.PlayerOffsetRenderer;
import net.ilexiconn.llibrary.client.render.item.Item3dRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.ItemRenderer;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.texture.TextureManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IIcon;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.MinecraftForgeClient;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

import java.util.List;
import java.util.Map;

/**
 * Render helper class for basic render operations and the IModelExtension.
 *
 * @author iLexiconn & Gegy1000
 */
@SideOnly(Side.CLIENT)
public class RenderHelper
{
    private static Map<Class<? extends ModelBase>, List<IModelExtension>> modelExtensions = Maps.newHashMap();

    private static ResourceLocation glintTexture = new ResourceLocation("textures/misc/enchanted_item_glint.png");

    /**
     * Registers the given IModelExtension.
     *
     * @param modelExtension
     */
    public static void registerModelExtension(IModelExtension modelExtension)
    {
        registerModelExtension(ModelBiped.class, modelExtension);
    }

    /**
     * Registers the given IModelExtension to a specific model.
     *
     * @param modelClazz
     * @param modelExtension
     */
    private static void registerModelExtension(Class<? extends ModelBase> modelClazz, IModelExtension modelExtension)
    {
        List<IModelExtension> extensionsForModel = modelExtensions.get(modelClazz);

        if (extensionsForModel == null)
        {
            extensionsForModel = Lists.newArrayList();
        }

        extensionsForModel.add(modelExtension);

        modelExtensions.put(modelClazz, extensionsForModel);
    }

    /**
     * @param clazz
     * @returns a list of ModelExtensions for the given model class.
     */
    public static List<IModelExtension> getModelExtensionsFor(Class<? extends ModelBase> clazz)
    {
        return modelExtensions.get(clazz);
    }

    public static void setPlayerYOffset(EntityPlayer player, float offset)
    {
        PlayerOffsetRenderer.setOffsetY(player, offset);
    }

    /**
     * Renders the given ItemStack in 3D.
     *
     * @param stack the ItemStack you want to render.
     */
    public static void renderItemIn3d(ItemStack stack)
    {
        TextureManager textureManager = Minecraft.getMinecraft().getTextureManager();
        if (textureManager == null) return;
        Item item = stack.getItem();
        GL11.glPushMatrix();
        Tessellator tessellator = Tessellator.instance;
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        GL11.glRotatef(180f, 0f, 0f, 1f);
        GL11.glTranslatef(-0.5f, -0.5f, 1 / 32f);
        GL11.glColor4f(1f, 1f, 1f, 1f);
        int passes = item.getRenderPasses(stack.getItemDamage());

        for (int pass = 0; pass < passes; pass++)
        {
            if (stack.getItemSpriteNumber() == 0) textureManager.bindTexture(TextureMap.locationBlocksTexture);
            else textureManager.bindTexture(TextureMap.locationItemsTexture);
            IIcon icon = item.getIcon(stack, pass);
            float minU = icon.getMinU();
            float maxU = icon.getMaxU();
            float minV = icon.getMinV();
            float maxV = icon.getMaxV();
            setColorFromInt(item.getColorFromItemStack(stack, pass));
            ItemRenderer.renderItemIn2D(tessellator, maxU, minV, minU, maxV, icon.getIconWidth(), icon.getIconHeight(), 0625f);
        }

        if (stack.hasEffect(0))
        {
            GL11.glDepthFunc(GL11.GL_EQUAL);
            GL11.glDisable(GL11.GL_LIGHTING);
            textureManager.bindTexture(glintTexture);
            GL11.glEnable(GL11.GL_BLEND);
            GL11.glBlendFunc(GL11.GL_SRC_COLOR, GL11.GL_ONE);
            float f7 = 0.76f;
            GL11.glColor4f(0.5f * f7, 0.25f * f7, 0.8f * f7, 1f);
            GL11.glMatrixMode(GL11.GL_TEXTURE);
            GL11.glPushMatrix();
            float f8 = 0.125f;
            GL11.glScalef(f8, f8, f8);
            float f9 = Minecraft.getSystemTime() % 3000l / 3000f * 8f;
            GL11.glTranslatef(f9, 0f, 0f);
            GL11.glRotatef(-50f, 0f, 0f, 1f);
            ItemRenderer.renderItemIn2D(tessellator, 0f, 0f, 1f, 1f, 256, 256, 0625f);
            GL11.glPopMatrix();
            GL11.glPushMatrix();
            GL11.glScalef(f8, f8, f8);
            f9 = Minecraft.getSystemTime() % 4873l / 4873f * 8f;
            GL11.glTranslatef(-f9, 0f, 0f);
            GL11.glRotatef(10f, 0f, 0f, 1f);
            ItemRenderer.renderItemIn2D(tessellator, 0f, 0f, 1f, 1f, 256, 256, 0625f);
            GL11.glPopMatrix();
            GL11.glMatrixMode(GL11.GL_MODELVIEW);
            GL11.glDisable(GL11.GL_BLEND);
            GL11.glEnable(GL11.GL_LIGHTING);
            GL11.glDepthFunc(GL11.GL_LEQUAL);
        }

        GL11.glDisable(GL12.GL_RESCALE_NORMAL);
        GL11.glPopMatrix();
    }

    private static void setColorFromInt(int color)
    {
        float r = (color >> 16 & 255) / 255f;
        float g = (color >> 8 & 255) / 255f;
        float b = (color & 255) / 255f;
        GL11.glColor4f(r, g, b, 1f);
    }

    public static void registerItem3dRenderer(Item item, ModelBase model, ResourceLocation texture)
    {
        MinecraftForgeClient.registerItemRenderer(item, new Item3dRenderer(item, model, texture));
    }
}
