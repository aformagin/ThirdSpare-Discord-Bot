package com.thirdspare.discordbot;

import net.dv8tion.jda.core.EmbedBuilder;
import net.dv8tion.jda.core.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import java.awt.*;

public class Commands extends ListenerAdapter {
    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent event) {

        String[] command = event.getMessage().getContent().split(" ");
        //String message = event.getMessage().getContent();

        if (!command[0].startsWith(Ref.PREFIX))
            return;
        if(command[0].equalsIgnoreCase("!ping")){
            String msg = "Pong! `" + event.getJDA().getPing() + "`";
            if(command.length == 1){
                event.getChannel().sendMessage(msg).queue();
            }else if (command.length == 2 && command[1].equalsIgnoreCase("-e")){
                EmbedBuilder eb = new EmbedBuilder();
                eb.setColor(Color.cyan);
                eb.setDescription(msg);
                event.getChannel().sendMessage(eb.build()).queue();
            }

        if(command[0].equalsIgnoreCase("!rolld")){
            String msg1 = ("`This will be a roll soon`");
            if (command.length==1){

                event.getChannel().sendMessage(msg1).queue();
            }


        }

            //1,2,3,4

        }
    }

}
