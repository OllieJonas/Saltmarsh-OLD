package me.ollie.saltmarsh.meta.command;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

public class CommandRegistry {

    @Getter
    private static CommandRegistry instance = new CommandRegistry();

    @Getter
    private final Map<String, ICommand<?>> commands = new HashMap<>();

    public void registerCommand(String name, ICommand<?> command) {
        commands.put(name, command);
        instance = this;
    }

    public void registerCommand(ICommand<?> command) {
        commands.put(command.getName(), command);

        for (String alias : command.getAliases()) {
            commands.put(alias, command);
        }
    }

    public ICommand<?> getCommand(String name) {
        return commands.get(name);
    }
}
