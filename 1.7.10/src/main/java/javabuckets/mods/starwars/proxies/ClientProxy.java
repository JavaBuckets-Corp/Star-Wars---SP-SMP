package javabuckets.mods.starwars.proxies;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.MinecraftForgeClient;
import javabuckets.mods.starwars.entity.*;
import javabuckets.mods.starwars.entity.item.EntityLightsaber;
import javabuckets.mods.starwars.init.ModWeapons;
import javabuckets.mods.starwars.model.armor.*;
import javabuckets.mods.starwars.renderer.*;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ClientProxy extends ServerProxy
{
	private static final ModelJetpack modelJetpack = new ModelJetpack(1.0F);
	private static final ModelMandalorian modelMandalorianArmor = new ModelMandalorian(1.0F);
	
	@SideOnly(Side.CLIENT)
	private float zoom = 0;
	
	@Override
	@SideOnly(Side.CLIENT)
	public void registerProxyInformation()
	{
		MinecraftForgeClient.registerItemRenderer(ModWeapons.blueLightsaber, new RenderLightsaber());
		MinecraftForgeClient.registerItemRenderer(ModWeapons.redLightsaber, new RenderLightsaber());
		MinecraftForgeClient.registerItemRenderer(ModWeapons.greenLightsaber, new RenderLightsaber());
		MinecraftForgeClient.registerItemRenderer(ModWeapons.purpleLightsaber, new RenderLightsaber());
		
		MinecraftForgeClient.registerItemRenderer(ModWeapons.blueDoubleLightsaber, new RenderDoubleLightsaber());
		MinecraftForgeClient.registerItemRenderer(ModWeapons.redDoubleLightsaber, new RenderDoubleLightsaber());
		MinecraftForgeClient.registerItemRenderer(ModWeapons.greenDoubleLightsaber, new RenderDoubleLightsaber());
		MinecraftForgeClient.registerItemRenderer(ModWeapons.purpleDoubleLightsaber, new RenderDoubleLightsaber());
		
		/*MinecraftForgeClient.registerItemRenderer(StarWarsObjectLoader.jetpack.itemID, new RenderJetpack());
		MinecraftForgeClient.registerItemRenderer(StarWarsObjectLoader.bobaFettJetpack.itemID, new RenderJetpack());*/

		MinecraftForgeClient.registerItemRenderer(ModWeapons.e_11BlasterRifle, new RenderE11Blaster());
		MinecraftForgeClient.registerItemRenderer(ModWeapons.scoutSniperRifle, new RenderScout());
		MinecraftForgeClient.registerItemRenderer(ModWeapons.z_6RotaryBlasterCannon, new RenderZ6RotaryBlasterCannon());
		MinecraftForgeClient.registerItemRenderer(ModWeapons.dc_17HandBlaster, new RenderDC17HandBlaster());

		RenderingRegistry.registerEntityRenderingHandler(EntityBlasterBolt.class, new RenderBlasterBolt());
		RenderingRegistry.registerEntityRenderingHandler(EntityLightsaber.class, new RenderLightsaberEntity());
		//RenderingRegistry.registerEntityRenderingHandler(EntitySpaceshipTest.class, new RenderSpaceshipTest());

		//RenderingRegistry.registerEntityRenderingHandler(EntityPlayer.class, new RenderCustomPlayer());
	}
	
	@SideOnly(Side.CLIENT)
	public float getZoom()
	{
		return zoom;
	}
	
	@SideOnly(Side.CLIENT)
	public float setZoom(float zoom)
	{
		return this.zoom = zoom;
	}
	
	@Override
	public ModelBiped getArmorModel(String par1String)
	{
		if (par1String.equals("jetpack"))
		{
			return modelJetpack;
		}
		else if (par1String.equals("mandalorian"))
		{
			return modelMandalorianArmor;
		}
		else
		{
			return null;
		}
	}
}