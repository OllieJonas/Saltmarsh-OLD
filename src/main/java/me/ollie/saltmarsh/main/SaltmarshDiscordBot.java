package me.ollie.saltmarsh.main;

import me.ollie.saltmarsh.meta.bot.SimpleDiscordBot;
import me.ollie.saltmarsh.meta.command.CommandDispatcher;
import me.ollie.saltmarsh.meta.module.ModuleManager;

public class SaltmarshDiscordBot extends SimpleDiscordBot {

    public SaltmarshDiscordBot(String token, ModuleManager moduleManager) {
        super(token, moduleManager);
    }

    @Override
    public void registerListeners() {
        registerListener(new CommandDispatcher());
    }
}
