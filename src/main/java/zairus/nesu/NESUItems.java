package zairus.nesu;

import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;

public class NESUItems
{
	static
	{
		;
	}
	
	public static Item initItem(Item item, String id)
	{
		item.setRegistryName(new ResourceLocation(NESUConstants.MOD_ID, id));
		item.setUnlocalizedName(id);
		
		return item;
	}
	
	public static final void register()
	{
		;
	}
}
