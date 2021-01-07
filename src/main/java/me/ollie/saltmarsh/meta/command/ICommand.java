package me.ollie.saltmarsh.meta.command;

import me.ollie.saltmarsh.meta.command.info.CommandInfo;
import me.ollie.saltmarsh.meta.module.IModule;
import net.dv8tion.jda.api.entities.Member;

public interface ICommand<T extends IModule> {

    T getModule();

    String getName();

    String[] getAliases();

    CommandInfo getInfo();

    boolean isEnabled();

    CommandResult execute(CommandContext context);

    CommandPermissions getPermissions();
}
