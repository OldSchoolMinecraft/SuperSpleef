package me.moderator_man.ss.cmd.commands.sub;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.moderator_man.ss.SpleefRegion;
import me.moderator_man.ss.Util;
import me.moderator_man.ss.cmd.Command;

public class Refill extends Command
{
	public Refill()
	{
		super("Refill", "Refill the region", true);
	}

	@Override
	public boolean run(CommandSender sender, String[] args)
	{
		Player ply = (Player) sender;
		
		if (!ply.isOp() && !ply.hasPermission("ss.refill"))
		{
			ss.sendError(sender, "You don't have permission to refill the arena!");
			return true;
		}
		
		//TODO: get region from disk
		Util.slowRefill(new SpleefRegion());
		
		return true;
	}
}
