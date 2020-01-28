package me.moderator_man.ss.cmd.commands.sub;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.moderator_man.ss.Util;
import me.moderator_man.ss.cmd.Command;

public class SetPos1 extends Command
{
	public SetPos1(String name, String desc, boolean adminOnly)
	{
		super("SetPos1", "Set first position for arena", true);
	}

	@Override
	public boolean run(CommandSender sender, String[] args)
	{
		Player ply = (Player) sender;
		
		if (!ply.isOp() && !ply.hasPermission("ss.select"))
		{
			ss.sendError(sender, "You don't have permission to select a region!");
			return true;
		}
		
		int x = ply.getLocation().getBlockX();
		int y = ply.getLocation().getBlockY() - 1; // subtract one to get block player is standing on
		int z = ply.getLocation().getBlockZ();
		
		Util.newTempRegion();
		Util.setTempPos1(x, y, z);
		
		ss.sendSuccess(sender, String.format("Selected first position (x=%s,y=%s,z=%s)", x, y, z));
		
		return true;
	}
}
