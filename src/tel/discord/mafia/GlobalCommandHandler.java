package tel.discord.mafia;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;

public class GlobalCommandHandler
{
	enum GlobalCommand
	{
		HELP("help",
				"Get help on any part of the game (you're reading this now!)");
		
		final String name;
		final String description;
		GlobalCommand(String name, String description)
		{
			this.name = name;
			this.description = description;
		}
	}
	
	static void refreshCommandList(JDA jda)
	{
		//TODO
	}
	
	static void handleGlobalCommand(SlashCommandInteractionEvent event)
	{
		//TODO
	}
}
