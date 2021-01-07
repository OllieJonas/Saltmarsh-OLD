package me.ollie.saltmarsh.meta.bot;

import net.dv8tion.jda.api.JDA;

import javax.security.auth.login.LoginException;

public interface DiscordBot {

    void init() throws LoginException;

    JDA getJda();

    void registerListeners();
}
