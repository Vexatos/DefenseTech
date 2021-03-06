package defense.explosion.ex;

import mekanism.common.recipe.ShapedMekanismRecipe;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import defense.ModelMissileBase;
import defense.explosion.explosive.Explosive;
import defense.explosion.explosive.blast.BlastSonic;
import defense.explosion.model.missiles.ModelHypersonicMissile;
import defense.explosion.model.missiles.ModelSonicMissile;

public class ExSonic extends Explosion
{
    public ExSonic(String mingZi, int tier)
    {
        super(mingZi, tier);
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public ModelMissileBase getMissileModel()
    {
    	if (this.getTier() == 3)
        {
            return new ModelHypersonicMissile();
        }
        else
        {
            return new ModelSonicMissile();
        }
    }

    @Override
    public void init()
    {
        if (this.getTier() == 3)
        {
            GameRegistry.addRecipe(new ShapedMekanismRecipe(this.getItemStack(), new Object[] { " S ", "S S", " S ", 'S', Explosive.sonic.getItemStack() }));
        }
        else
        {
            GameRegistry.addRecipe(new ShapedMekanismRecipe(this.getItemStack(), new Object[] { "@?@", "?R?", "@?@", 'R', Explosive.replsive.getItemStack(), '?', Blocks.noteblock, '@', "ingotBronze" }));
        }
    }

    @Override
    public void doCreateExplosion(World world, double x, double y, double z, Entity entity)
    {
        if (this.getTier() == 3)
        {
            new BlastSonic(world, entity, x, y, z, 20, 35).setShockWave().explode();
        }
        else
        {
            new BlastSonic(world, entity, x, y, z, 15, 30).explode();
        }
    }

}
