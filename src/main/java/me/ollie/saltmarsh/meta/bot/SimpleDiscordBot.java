package me.ollie.saltmarsh.meta.bot;

import me.ollie.saltmarsh.meta.module.ModuleManager;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import javax.security.auth.login.LoginException;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

public abstract class SimpleDiscordBot implements DiscordBot {

    private final String token;

    private AtomicReference<JDA> jda;

    private final Set<ListenerAdapter> listeners;

    public SimpleDiscordBot(String token, ModuleManager moduleManager) {
        this.token = token;
        this.listeners = new HashSet<>();
    }

    @Override
    public void init() throws LoginException {
        registerListeners();
        this.jda = new AtomicReference<>(buildJda());
    }

    @Override
    public JDA getJda() {
        return jda.get();
    }

    protected void registerListener(ListenerAdapter listener) {
        this.listeners.add(listener);
    }

    private JDA buildJda() throws LoginException {
        return JDABuilder.createDefault(token).addEventListeners(listeners.toArray(new Object[0])).build();
    }
}
