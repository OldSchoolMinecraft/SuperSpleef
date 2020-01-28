package me.moderator_man.ss;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import me.moderator_man.ss.cmd.CommandManager;

public class SuperSpleef extends JavaPlugin
{
	public static SuperSpleef instance;
	
	public CommandManager cmdm;
	
	public void onEnable()
	{
		instance = this;
		
		cmdm = new CommandManager();
		cmdm.register("superspleef", new me.moderator_man.ss.cmd.commands.SuperSpleef(), "ss");
		
		System.out.println("SuperSpleef enabled.");
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		String command = cmd.getName().toLowerCase();
		me.moderator_man.ss.cmd.Command cmnd = cmdm.getCommand(command);
		
		if (cmnd != null)
		{
			if (cmnd.isPlayerOnly() && !(sender instanceof Player))
			{
				sendError(sender, "Only players can use this command!");
				return false;
			}
			
			return cmnd.run(sender, args);
		}
		
		return false;
	}
	
	public void sendError(CommandSender sender, String msg)
	{
		if (sender != null)
			sender.sendMessage(ChatColor.RED + msg);
	}
	
	public void sendSuccess(CommandSender sender, String msg)
	{
		if (sender != null)
			sender.sendMessage(ChatColor.GREEN + msg);
	}
	
	public void onDisable()
	{
		System.out.println("SuperSpleef disabled.");
	}
}
