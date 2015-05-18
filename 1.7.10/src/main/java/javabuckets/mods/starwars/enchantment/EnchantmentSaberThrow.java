package javabuckets.mods.starwars.enchantment;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.item.ItemStack;

public class EnchantmentSaberThrow extends Enchantment
{
    public EnchantmentSaberThrow(int par1, int par2, String par3)
    {
        super(par1, par2, EnumEnchantmentType.weapon);
        this.setName(par3);
    }

    public int getMinEnchantability(int par1)
    {
        return 15;
    }

    public int getMaxEnchantability(int par1)
    {
        return super.getMinEnchantability(par1) + 50;
    }

    public int getMaxLevel()
    {
        return 1;
    }

    /*public boolean canApply(ItemStack par1ItemStack)
    {
        return par1ItemStack.getItem() instanceof ItemLightsaber;
    }*/
}