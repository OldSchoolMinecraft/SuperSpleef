package me.moderator_man.ss;

import org.bukkit.Material;

public class Util
{
	private static SpleefRegion tempRegion = new SpleefRegion();
	
	public static void newTempRegion()
	{
		tempRegion = new SpleefRegion();
	}
	
	public static void setTempPos1(int x, int y, int z)
	{
		tempRegion.firstPosX = x;
		tempRegion.firstPosY = y;
		tempRegion.firstPosZ = z;
	}
	
	public static void setTempPos2(int x, int y, int z)
	{
		tempRegion.secondPosX = x;
		tempRegion.secondPosY = y;
		tempRegion.secondPosZ = z;
	}
	
	public static SpleefRegion getTempRegion()
	{
		return tempRegion;
	}
	
	public static void slowRefill(SpleefRegion region)
	{
		for (int x = 0; x < region.firstPosX; x++)
		{
			for (int y = 0; y < region.firstPosY; y++)
			{
				for (int z = 0; z < region.firstPosZ; z++)
				{
					//TODO: allow the block type to be configured
					region.world.getBlockAt(x, y, z).setType(Material.SNOW);
				}
			}
		}
	}
}
