package net.ilexiconn.llibrary.client.render.item;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.ilexiconn.llibrary.common.event.Render3dItemEvent;
import net.minecraft.client.model.ModelBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.IItemRenderer;
import net.minecraftforge.common.MinecraftForge;

import static org.lwjgl.opengl.GL11.*;

@SideOnly(Side.CLIENT)
public class Item3dRenderer implements IItemRenderer
{
    public Item item;
    public ModelBase model;
    public ResourceLocation texture;

    public Item3dRenderer(Item i, ModelBase m, ResourceLocation t)
    {
        item = i;
        model = m;
        texture = t;
    }

    public boolean handleRenderType(ItemStack item, ItemRenderType type)
    {
        return type != ItemRenderType.FIRST_PERSON_MAP;
    }

    public boolean shouldUseRenderHelper(ItemRenderType type, ItemStack item, ItemRendererHelper helper)
    {
        return helper != ItemRendererHelper.BLOCK_3D;
    }

    public void renderItem(ItemRenderType type, ItemStack item, Object... data)
    {
        switch (type)
        {
            case ENTITY:
                renderBlock(0f, 1.5f, 0f);
                break;
            case EQUIPPED:
                renderBlock(0.5f, 1.5f, 0.5f);
                break;
            case EQUIPPED_FIRST_PERSON:
                renderBlock(0.5f, 1.5f, 0.5f);
                break;
            case INVENTORY:
                glRotatef(180f, 0f, 1f, 0f);
                renderBlock(0f, 1f, 0f);
                break;
            default: /** EQUIPPED **/
                renderBlock(0.5f, 1.5f, 0.5f);
                break;
        }
    }

    public void renderBlock(float x, float y, float z)
    {
        glPushMatrix();
        FMLClientHandler.instance().getClient().renderEngine.bindTexture(texture);

        if (!MinecraftForge.EVENT_BUS.post(new Render3dItemEvent(item, model, texture, x, y, z)))
        {
            glTranslatef(x, y, z);
            glScalef(-1f, -1f, 1f);
            model.render(null, 0f, 0f, 0f, 0f, 0f, 0.0625f);
        }

        glPopMatrix();
    }
}
