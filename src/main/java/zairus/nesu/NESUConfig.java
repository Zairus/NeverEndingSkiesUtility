package zairus.nesu;

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class NESUConfig
{
	public static Configuration configuration;
	
	public static void init(File cFile)
	{
		configuration = new Configuration(cFile);
		
		configuration.load();
		configuration.save();
	}
}
