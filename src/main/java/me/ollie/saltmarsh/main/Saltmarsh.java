package me.ollie.saltmarsh.main;

import me.ollie.saltmarsh.meta.bot.DiscordBot;
import lombok.Getter;
import me.ollie.saltmarsh.meta.module.ModuleManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.security.auth.login.LoginException;

public class Saltmarsh {

    private static final Logger LOGGER = LoggerFactory.getLogger(Saltmarsh.class);

    @Getter
    private DiscordBot discordBot;

    @Getter
    private ModuleManager moduleManager;

    private final String token;

    public Saltmarsh(String token) {
        this.token = token;
    }

    public void init() {
        LOGGER.info("Initialising Saltmarsh...");
        this.moduleManager = new ModuleManager();
        this.discordBot = new SaltmarshDiscordBot(token, moduleManager);

        try {
            discordBot.init();
        } catch (LoginException e) {
            LOGGER.debug("Unable to login! See stack trace below...");
            e.printStackTrace();
        }

        LOGGER.info("Initialised!");
    }

    public void run() {
        LOGGER.info("Running saltmarsh");
    }
}
