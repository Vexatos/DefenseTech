package defense;

import java.io.File;

import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.common.Loader;

/** Settings class for various configuration settings.
 * 
 * @author Calclavia */
public class Settings
{
    /** Configuration file */
    public static final Configuration CONFIGURATION = new Configuration(new File(Loader.instance().getConfigDir(), Reference.NAME.replace(" ", "") + ".cfg"));

    public static boolean USE_FUEL = true;
    public static boolean LOAD_CHUNKS = true;
    public static int MAX_MISSILE_DISTANCE = 10000;
    public static int ANTIMATTER_SIZE = 55;
    public static boolean DESTROY_BEDROCK = true;
    public static int MAX_ROCKET_LAUCNHER_TIER = 2;
    public static boolean GENERATE_SULFUR = true;
    public static int MAX_REDMATTER_LIFESPAN = 3600;
    public static boolean DO_REDMATTER_DESPAWN = true;
    public static boolean CREEPER_DROP_SULFER = true;
    public static boolean CREEPER_BLOW_UP_IN_FIRE = true;

    @Deprecated
    public static void initiate()
    {
        CONFIGURATION.load();
        USE_FUEL = CONFIGURATION.get(Configuration.CATEGORY_GENERAL, "Use Fuel", Settings.USE_FUEL).getBoolean(Settings.USE_FUEL);
        LOAD_CHUNKS = Settings.CONFIGURATION.get(Configuration.CATEGORY_GENERAL, "Allow Chunk Loading", LOAD_CHUNKS).getBoolean(LOAD_CHUNKS);
        MAX_MISSILE_DISTANCE = Settings.CONFIGURATION.get(Configuration.CATEGORY_GENERAL, "Max Missile Distance", Settings.MAX_MISSILE_DISTANCE).getInt(Settings.MAX_MISSILE_DISTANCE);
        ANTIMATTER_SIZE = Settings.CONFIGURATION.get(Configuration.CATEGORY_GENERAL, "Antimatter Explosion Size", ANTIMATTER_SIZE).getInt(ANTIMATTER_SIZE);
        DESTROY_BEDROCK = Settings.CONFIGURATION.get(Configuration.CATEGORY_GENERAL, "Antimatter Destroy Bedrock", DESTROY_BEDROCK).getBoolean(DESTROY_BEDROCK);
        MAX_ROCKET_LAUCNHER_TIER = Settings.CONFIGURATION.get(Configuration.CATEGORY_GENERAL, "Limits the max missile tier for rocket launcher item", MAX_ROCKET_LAUCNHER_TIER).getInt(MAX_ROCKET_LAUCNHER_TIER);
        GENERATE_SULFUR = Settings.CONFIGURATION.get(Configuration.CATEGORY_GENERAL, "Generate Sulfur Ore", GENERATE_SULFUR).getBoolean(GENERATE_SULFUR);
        MAX_REDMATTER_LIFESPAN = Settings.CONFIGURATION.get(Configuration.CATEGORY_GENERAL, "RedMatter Life Span in ticks", MAX_REDMATTER_LIFESPAN).getInt(MAX_REDMATTER_LIFESPAN);
        DO_REDMATTER_DESPAWN = Settings.CONFIGURATION.get(Configuration.CATEGORY_GENERAL, "RedMatter despawn", DO_REDMATTER_DESPAWN).getBoolean(DO_REDMATTER_DESPAWN);
        CREEPER_DROP_SULFER = Settings.CONFIGURATION.get(Configuration.CATEGORY_GENERAL, "Creepers Drop Sulfur", CREEPER_DROP_SULFER).getBoolean(CREEPER_DROP_SULFER);
        CREEPER_BLOW_UP_IN_FIRE = Settings.CONFIGURATION.get(Configuration.CATEGORY_GENERAL, "Creepers Blow up in Fire", CREEPER_BLOW_UP_IN_FIRE).getBoolean(CREEPER_BLOW_UP_IN_FIRE);
        CONFIGURATION.save();
    }
}
