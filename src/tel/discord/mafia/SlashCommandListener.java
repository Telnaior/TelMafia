package tel.discord.mafia;

import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class SlashCommandListener extends ListenerAdapter
{
	@Override
	public void onSlashCommandInteraction(SlashCommandInteractionEvent event)
	{
		//If it's a global command, the global handler will deal with it
		if(event.isGlobalCommand())
		{
			GlobalCommandHandler.handleGlobalCommand(event);
			return;
		}
		else
		{
			//If it's not a global command, then it's a guild command, and we'll find the relevant controller to handle it
			for(GuildController next : TelMafiaBot.guildList)
			{
				if(event.getGuild().getId().equals(next.getGuildID()))
				{
					next.handleCommand(event);
					return;
				}
			}
		}
		//If we make it here, something's gone wrong and we're going to throw a tantrum about it
		event.reply("Something went wrong - command not acknowledged.").queue();
	}
}
