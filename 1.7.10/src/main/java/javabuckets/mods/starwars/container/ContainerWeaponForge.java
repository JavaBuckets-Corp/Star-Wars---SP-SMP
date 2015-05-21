package javabuckets.mods.starwars.container;

import javabuckets.mods.starwars.crafting.CraftingManagerWeaponForge;
import javabuckets.mods.starwars.init.ModBlocks;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.InventoryCrafting;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotCrafting;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ContainerWeaponForge extends ContainerBasic
{
	/** The crafting matrix inventory (3x3). */
	public InventoryCrafting craftMatrix = new InventoryCrafting(this, 5, 5);
	public IInventory craftResult = new InventoryCraftResult();
	private World worldObj;
	private int posX;
	private int posY;
	private int posZ;

	public ContainerWeaponForge(InventoryPlayer par1InventoryPlayer, World par1World, int par3, int par4, int par5)
	{
		this.worldObj = par1World;
		this.posX = par3;
		this.posY = par4;
		this.posZ = par5;
		int l;
		int i1;
		
		this.addSlotToContainer(new SlotCrafting(par1InventoryPlayer.player, this.craftMatrix, this.craftResult, 0, 143, 54));
		
		for (l = 0; l < 5; ++l)
		{
			for (i1 = 0; i1 < 5; ++i1)
			{
				this.addSlotToContainer(new Slot(this.craftMatrix, l + i1 * 5, 13 + l * 18, 18 + i1 * 18));
			}
		}
		
		this.addPlayerInventory(par1InventoryPlayer, 36);
		
		
		this.onCraftMatrixChanged(this.craftMatrix);
	}

	/**
	 * Callback for when the crafting matrix is changed.
	 */
	 public void onCraftMatrixChanged(IInventory par1IInventory)
	{
		 this.craftResult.setInventorySlotContents(0, CraftingManagerWeaponForge.getInstance().findMatchingRecipe(this.craftMatrix, this.worldObj));
	}

	 /**
	  * Called when the container is closed.
	  */
	 public void onContainerClosed(EntityPlayer par1EntityPlayer)
	 {
		 super.onContainerClosed(par1EntityPlayer);

		 if (!this.worldObj.isRemote)
		 {
			 for (int i = 0; i < 25; ++i)
			 {
				 ItemStack itemstack = this.craftMatrix.getStackInSlotOnClosing(i);

				 if (itemstack != null)
				 {
					 par1EntityPlayer.dropItem(itemstack.getItem(), 1);
				 }
			 }
		 }
	 }

	 public boolean canInteractWith(EntityPlayer par1EntityPlayer)
	 {
		 return this.worldObj.getBlock(this.posX, this.posY, this.posZ) != ModBlocks.weaponForge ? false : par1EntityPlayer.getDistanceSq((double)this.posX + 0.5D, (double)this.posY + 0.5D, (double)this.posZ + 0.5D) <= 64.0D;
	 }

	 /**
	  * Called when a player shift-clicks on a slot. You must override this or you will crash when someone does that.
	  */
	 public ItemStack transferStackInSlot(EntityPlayer par1EntityPlayer, int par2)
	 {
		 ItemStack itemstack = null;
		 Slot slot = (Slot)this.inventorySlots.get(par2);

//		 if (slot != null && slot.getHasStack())
//		 {
//			 ItemStack itemstack1 = slot.getStack();
//			 itemstack = itemstack1.copy();
//
//			 if (par2 == 0)
//			 {
//				 if (!this.mergeItemStack(itemstack1, 25, 46, true))
//				 {
//					 return null;
//				 }
//
//				 slot.onSlotChange(itemstack1, itemstack);
//			 }
//			 else if (par2 >= 25 && par2 < 37)
//			 {
//				 if (!this.mergeItemStack(itemstack1, 37, 46, false))
//				 {
//					 return null;
//				 }
//			 }
//			 else if (par2 >= 37 && par2 < 46)
//			 {
//				 if (!this.mergeItemStack(itemstack1, 25, 37, false))
//				 {
//					 return null;
//				 }
//			 }
//			 else if (!this.mergeItemStack(itemstack1, 25, 46, false))
//			 {
//				 return null;
//			 }
//
//			 if (itemstack1.stackSize == 0)
//			 {
//				 slot.putStack((ItemStack)null);
//			 }
//			 else
//			 {
//				 slot.onSlotChanged();
//			 }
//
//			 if (itemstack1.stackSize == itemstack.stackSize)
//			 {
//				 return null;
//			 }
//
//			 slot.onPickupFromSlot(par1EntityPlayer, itemstack1);
//		 }

		 return itemstack;
	 }

	 public boolean func_94530_a(ItemStack par1ItemStack, Slot par2Slot)
	 {
		 return par2Slot.inventory != this.craftResult && super.func_94530_a(par1ItemStack, par2Slot);
	 }
}