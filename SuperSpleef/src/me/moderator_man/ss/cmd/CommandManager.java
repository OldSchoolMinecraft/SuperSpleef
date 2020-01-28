package me.moderator_man.ss.cmd;

import me.moderator_man.ss.AliasMap;

public class CommandManager
{
	private AliasMap<String, Command> commands;
	
	public CommandManager()
	{
		commands = new AliasMap<String, Command>();
	}
	
	public void onEnable()
	{
		// register commands
		
		// admin only
	}
	
	public void register(String realKey, Command command, String...aliases)
	{
		commands.put(realKey, command);
		for (String alias : aliases)
			commands.alias(realKey, alias);
	}
	
	public Command getCommand(String call)
	{
		return commands.get(call);
	}
}
