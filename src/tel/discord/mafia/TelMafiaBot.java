package tel.discord.mafia;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

public class TelMafiaBot
{
	static JDA jda;
	static String ownerID;
	public static ArrayList<GuildController> guildList = new ArrayList<>(5);
	
	public static void main(String[] args) throws IOException, LoginException, InterruptedException
	{
		//Read initial config file to get important things
		List<String> list = Files.readAllLines(Paths.get("config.txt"));
		String token = list.get(0);
		String owner = list.get(1);
		ownerID = owner;
		JDABuilder builder = JDABuilder.createDefault(token);
		builder.addEventListeners(new SlashCommandListener());
		jda = builder.build();
		//Once the bot is ready, make sure the global command list is correct
		jda.awaitReady();
		GlobalCommandHandler.refreshCommandList(jda);
		jda.getPresence().setActivity(Activity.playing("Type /help"));
		//TODO then for each guild, check what we're doing
	}

}
