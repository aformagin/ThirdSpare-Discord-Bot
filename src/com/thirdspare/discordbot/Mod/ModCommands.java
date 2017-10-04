package com.thirdspare.discordbot.Mod;

import com.thirdspare.discordbot.Ref;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;
import org.json.JSONObject;

import javax.management.relation.Role;

public class ModCommands extends ListenerAdapter {
    public void onGuildMessageReceived(GuildMessageReceivedEvent event){
        String[] command = event.getMessage().getContent().split(" ");

        if (!command[0].startsWith(Ref.PREFIX))
            return;
        JSONObject config = ConfigManager.getConfig(event.getGuild().getId());

        if(config != null){
            net.dv8tion.jda.core.entities.Role mod = event.getGuild().getRoleById(config.getString("mod"));
            if(!event.getMember().getRoles().contains(mod) && !event.getMember().isOwner()){
                return;
            }

        }

    }
}
