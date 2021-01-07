package me.ollie.saltmarsh.meta.command;

import me.ollie.saltmarsh.meta.command.info.CommandInfo;
import lombok.Getter;
import lombok.Setter;
import me.ollie.saltmarsh.meta.module.IModule;
import net.dv8tion.jda.api.entities.TextChannel;

@Getter
public abstract class SimpleCommand<T extends IModule> implements ICommand<T> {

    protected final T module;

    protected final String name;

    protected final CommandInfo info;

    protected final CommandPermissions permissions;

    protected final String[] aliases;


    @Setter
    protected boolean isEnabled = true;

    public SimpleCommand(T module, String name, CommandInfo info, CommandPermissions permissions, String... aliases) {
        this.module = module;
        this.name = name;
        this.info = info;
        this.permissions = permissions;
        this.aliases = aliases;
    }

    @Override
    public T getModule() {
        return module;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String[] getAliases() {
        return aliases;
    }

    @Override
    public CommandInfo getInfo() {
        return info;
    }

    @Override
    public CommandPermissions getPermissions() {
        return permissions;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }

    protected void sendMessage(TextChannel channel, String message) {
        channel.sendMessage(message).queue();
    }
}
