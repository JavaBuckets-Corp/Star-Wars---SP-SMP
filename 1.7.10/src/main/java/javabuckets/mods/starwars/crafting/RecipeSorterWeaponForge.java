package javabuckets.mods.starwars.crafting;

import java.util.Comparator;

import net.minecraft.item.crafting.IRecipe;

public class RecipeSorterWeaponForge implements Comparator
{
    final CraftingManagerWeaponForge craftingManager;

    public RecipeSorterWeaponForge(CraftingManagerWeaponForge par1CraftingManager)
    {
        this.craftingManager = par1CraftingManager;
    }

    public int compareRecipes(IRecipe par1IRecipe, IRecipe par2IRecipe)
    {
        return par1IRecipe instanceof ShapelessRecipesWeaponForge && par2IRecipe instanceof ShapedRecipesWeaponForge ? 1 : (par2IRecipe instanceof ShapelessRecipesWeaponForge && par1IRecipe instanceof ShapedRecipesWeaponForge ? -1 : (par2IRecipe.getRecipeSize() < par1IRecipe.getRecipeSize() ? -1 : (par2IRecipe.getRecipeSize() > par1IRecipe.getRecipeSize() ? 1 : 0)));
    }

    public int compare(Object par1Obj, Object par2Obj)
    {
        return this.compareRecipes((IRecipe)par1Obj, (IRecipe)par2Obj);
    }
}