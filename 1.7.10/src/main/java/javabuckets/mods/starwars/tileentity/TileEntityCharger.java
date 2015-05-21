package javabuckets.mods.starwars.tileentity;

import javabuckets.mods.starwars.init.ModMaterials;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.tileentity.TileEntity;

public class TileEntityCharger extends TileEntity implements ISidedInventory
{
	private ItemStack[] chargerItemStacks = new ItemStack[3];
	public int chargerChargeTime;
	public static final int maxChargeTime = 600;
	
	public void updateEntity()
    {
        if (!this.worldObj.isRemote)
        {
            if (this.canCharge() && this.chargerItemStacks[2] == null)
            {
            	if (this.chargerChargeTime < this.maxChargeTime)
            	{
                	++this.chargerChargeTime;
            	}
            	else
            	{
            		this.chargeItem();
            	}
            }
            else
            {
            	this.chargerChargeTime = 0;
            }
        }
    }
	
	public ItemStack getResult(ItemStack par1ItemStack)
	{
		if (par1ItemStack.getItemDamage() == 4) {return new ItemStack(ModMaterials.blueCrystal);}
		else if (par1ItemStack.getItemDamage() == 10) {return new ItemStack(ModMaterials.greenCrystal);}
		else if (par1ItemStack.getItemDamage() == 1) {return new ItemStack(ModMaterials.redCrystal);}
		else if (par1ItemStack.getItemDamage() == 5) {return new ItemStack(ModMaterials.purpleCrystal);}
		else
		{
			return null;
		}
	}
	
	public int getChargerChargeTime()
	{
		return chargerChargeTime;
	}
	
	public void chargeItem()
    {
        if (this.canCharge())
        {
            ItemStack itemstack = this.getResult(this.chargerItemStacks[0]);

            if (this.chargerItemStacks[2] == null)
            {
                this.chargerItemStacks[2] = itemstack.copy();
            }
            else if (this.chargerItemStacks[2].isItemEqual(itemstack))
            {
                chargerItemStacks[2].stackSize += itemstack.stackSize;
            }

            --this.chargerItemStacks[0].stackSize;
            --this.chargerItemStacks[1].stackSize;
            this.chargerChargeTime = 0;
            
            if (this.chargerItemStacks[0].stackSize <= 0)
            {
                this.chargerItemStacks[0] = null;
            }
            if (this.chargerItemStacks[1].stackSize <= 0)
            {
                this.chargerItemStacks[1] = null;
            }
        }
    }
	
	public boolean canCharge()
	{
		if (this.chargerItemStacks[0] != null && this.chargerItemStacks[1] != null && this.chargerItemStacks[1].getItem() == ModMaterials.unchargedCrystal)
		{
			if (this.chargerItemStacks[0].getItem() == Items.dye)
			{
				if (this.chargerItemStacks[0].getItemDamage() == 4) {return true;}
				else if (this.chargerItemStacks[0].getItemDamage() == 1) {return true;}
				else if (this.chargerItemStacks[0].getItemDamage() == 10) {return true;}
				else if (this.chargerItemStacks[0].getItemDamage() == 5) {return true;}
				else
				{
					return false;
				}
			}
			else
			{
				return false;
			}
		}
		else
		{
			return false;
		}
	}
	
	public int getSizeInventory() 
	{
		return chargerItemStacks.length;
	}
	
	public ItemStack getStackInSlot(int i) 
	{
		return chargerItemStacks[i];
	}
	
	public ItemStack decrStackSize(int par1, int par2)
    {
        if (this.chargerItemStacks[par1] != null)
        {
            ItemStack itemstack;

            if (this.chargerItemStacks[par1].stackSize <= par2)
            {
                itemstack = this.chargerItemStacks[par1];
                this.chargerItemStacks[par1] = null;
                return itemstack;
            }
            else
            {
                itemstack = this.chargerItemStacks[par1].splitStack(par2);

                if (this.chargerItemStacks[par1].stackSize == 0)
                {
                    this.chargerItemStacks[par1] = null;
                }

                return itemstack;
            }
        }
        else
        {
            return null;
        }
    }
	
	public void readFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readFromNBT(par1NBTTagCompound);
        NBTTagList nbttaglist = par1NBTTagCompound.getTagList("Items", 0);
        this.chargerItemStacks = new ItemStack[this.getSizeInventory()];

        for (int i = 0; i < nbttaglist.tagCount(); ++i)
        {
            NBTTagCompound nbttagcompound1 = (NBTTagCompound)nbttaglist.getCompoundTagAt(i);
            byte b0 = nbttagcompound1.getByte("Slot");

            if (b0 >= 0 && b0 < this.chargerItemStacks.length)
            {
                this.chargerItemStacks[b0] = ItemStack.loadItemStackFromNBT(nbttagcompound1);
            }
        }

        this.chargerChargeTime = par1NBTTagCompound.getShort("ChargeTime");
    }

    public void writeToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setShort("ChargeTime", (short)this.chargerChargeTime);
        NBTTagList nbttaglist = new NBTTagList();

        for (int i = 0; i < this.chargerItemStacks.length; ++i)
        {
            if (this.chargerItemStacks[i] != null)
            {
                NBTTagCompound nbttagcompound1 = new NBTTagCompound();
                nbttagcompound1.setByte("Slot", (byte)i);
                this.chargerItemStacks[i].writeToNBT(nbttagcompound1);
                nbttaglist.appendTag(nbttagcompound1);
            }
        }

        par1NBTTagCompound.setTag("Items", nbttaglist);
    }

	public ItemStack getStackInSlotOnClosing(int i) 
	{	
		if (this.chargerItemStacks[i] != null)
		{
			ItemStack itemstack = this.chargerItemStacks[i];
			this.chargerItemStacks[i] = null;
			return itemstack;
		}
		else
		{
			return null;
		}
	}
	
	public void setInventorySlotContents(int par1, ItemStack par2ItemStack)
    {
        this.chargerItemStacks[par1] = par2ItemStack;

        if (par2ItemStack != null && par2ItemStack.stackSize > this.getInventoryStackLimit())
        {
            par2ItemStack.stackSize = this.getInventoryStackLimit();
        }
    }
	
	public String getInvName() 
	{		
		return "Charger";
	}
	
	public boolean isInvNameLocalized() 
	{		
		return false;
	}
	
	public int getInventoryStackLimit() 
	{		
		return 64;
	}
	
	public boolean isUseableByPlayer(EntityPlayer entityplayer) 
	{		
		return true;
	}

	public void openChest() {}
	public void closeChest() {}

	public boolean isItemValidForSlot(int i, ItemStack itemstack) 
	{
		return true;
	}

	public int[] getAccessibleSlotsFromSide(int var1) 
	{	
		return null;
	}

	public boolean canInsertItem(int i, ItemStack itemstack, int j) 
	{
		return true;
	}

	public boolean canExtractItem(int i, ItemStack itemstack, int j) 
	{
		return false;
	}

	public String getInventoryName() 
	{
		return "Crystal Charger";
	}

	public boolean hasCustomInventoryName() 
	{
		return true;
	}

	public void openInventory() 
	{	
		
	}

	public void closeInventory() 
	{
		
	}
}