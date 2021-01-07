package me.ollie.saltmarsh.meta.module;

import me.ollie.saltmarsh.meta.command.CommandRegistry;
import me.ollie.saltmarsh.meta.command.ICommand;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class SimpleModule implements IModule {

    protected boolean isEnabled;

    private static final Logger LOGGER = LoggerFactory.getLogger(SimpleModule.class);

    public SimpleModule() {
        this.isEnabled = true;
    }

    public void enable() {
        registerCommands();
        onEnable();
    }

    @Override
    public void onEnable() {

    }

    @Override
    public void onDisable() {

    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }

    protected void registerCommand(ICommand<?> command) {
        LOGGER.debug("Registering command " + command.getName() + "...");
        CommandRegistry.getInstance().registerCommand(command);
    }
}
