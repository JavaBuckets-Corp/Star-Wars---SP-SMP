package javabuckets.mods.starwars.enchantment;

import javabuckets.mods.starwars.interfaces.IBlaster;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.item.ItemStack;

public class EnchantmentBlasterBurst extends Enchantment
{
    public EnchantmentBlasterBurst(int par1, int par2, String par3)
    {
        super(par1, par2, EnumEnchantmentType.weapon);
        this.setName(par3);
    }

    public int getMinEnchantability(int par1)
    {
        return par1 == 0 ? 10 : 20;
    }

    public int getMaxEnchantability(int par1)
    {
        return super.getMinEnchantability(par1) + 50;
    }

    public int getMaxLevel()
    {
        return 2;
    }

    public boolean canApply(ItemStack par1ItemStack)
    {
        return par1ItemStack.getItem() instanceof IBlaster;
    }
}