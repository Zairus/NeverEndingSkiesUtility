package zairus.nesu;

import org.apache.logging.log4j.Logger;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import zairus.nesu.util.NESUEventHandler;

@Mod(modid = NESUConstants.MOD_ID, name = NESUConstants.MOD_NAME, version = NESUConstants.MOD_VERSION)
public class NeverEndingSkiesUtility
{
	private static Logger logger;
	
	@SidedProxy(clientSide = NESUConstants.MOD_CLIENT_PROXY, serverSide = NESUConstants.MOD_COMMON_PROXY)
	public static NESUProxy proxy;
	
	@Mod.Instance(NESUConstants.MOD_ID)
	public static NeverEndingSkiesUtility instance;
	
	public static CreativeTabs creativeTabMain = new CreativeTabs("megaLootTabMain") {
		@Override
		public ItemStack getTabIconItem()
		{
			return new ItemStack(Blocks.CRAFTING_TABLE);
		}
	};
	
	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		logger = event.getModLog();
		
		NeverEndingSkiesUtility.proxy.preInit(event);
		
		NESUConfig.init(event.getSuggestedConfigurationFile());
	}
	
	@Mod.EventHandler
	public void init(FMLInitializationEvent event)
	{
		NeverEndingSkiesUtility.proxy.init(event);
		
		NESUEventHandler eventHandler = new NESUEventHandler();
		
		MinecraftForge.EVENT_BUS.register(eventHandler);
		
		NESUItems.register();
	}
	
	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		NeverEndingSkiesUtility.proxy.postInit(event);
	}
	
	public static void logInfo(String message)
	{
		logger.info(message);
	}
}
