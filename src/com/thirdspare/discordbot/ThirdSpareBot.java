package com.thirdspare.discordbot;

import net.dv8tion.jda.core.AccountType;
import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.entities.Game;
import net.dv8tion.jda.core.events.guild.GuildJoinEvent;
import net.dv8tion.jda.core.exceptions.RateLimitedException;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;


public class ThirdSpareBot extends ListenerAdapter {
    private static JDA api;

    public static void main (String[] args){
        try{
            api = new JDABuilder(AccountType.BOT).setToken(BotTokens.DEV_BOT).buildBlocking();
            api.getPresence().setGame(Game.of("I am a Bot!"));
            api.addEventListener(new Commands());
            api.addEventListener(new ThirdSpareBot());
        }catch (LoginException|IllegalArgumentException|InterruptedException|RateLimitedException e){
            e.printStackTrace();
        }

    }


    public void onGuildJoinEvent(GuildJoinEvent event) {
        System.out.printf("[+] %s",event.getGuild().getName(),event.getGuild().getMembers().size());

    }
}
