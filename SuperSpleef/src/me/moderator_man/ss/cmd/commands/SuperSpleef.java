package me.moderator_man.ss.cmd.commands;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.moderator_man.ss.cmd.Command;
import me.moderator_man.ss.cmd.CommandManager;
import me.moderator_man.ss.cmd.commands.sub.Refill;

public class SuperSpleef extends Command
{
	private CommandManager cmdm;
	
	public SuperSpleef()
	{
		super("SuperSpleef", "SuperSpleef command", false);
		
		cmdm = new CommandManager();
		cmdm.register("refill", new Refill());
	}

	@Override
	public boolean run(CommandSender sender, String[] args)
	{
		String command = args[0];
		me.moderator_man.ss.cmd.Command cmnd = cmdm.getCommand(command);
		
		if (cmnd != null)
		{
			if (cmnd.isPlayerOnly() && !(sender instanceof Player))
			{
				ss.sendError(sender, "Only players can use this command!");
				return false;
			}
			
			return cmnd.run(sender, args);
		}
		
		return false;
	}
}
