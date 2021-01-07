package me.ollie.saltmarsh.ping.cmds;

import me.ollie.saltmarsh.meta.command.CommandContext;
import me.ollie.saltmarsh.meta.command.CommandPermissions;
import me.ollie.saltmarsh.meta.command.CommandResult;
import me.ollie.saltmarsh.meta.command.SimpleCommand;
import me.ollie.saltmarsh.meta.command.info.CommandInfo;
import me.ollie.saltmarsh.ping.PingModule;

public class PingCommand extends SimpleCommand<PingModule> {

    private static final CommandInfo INFO = CommandInfo.builder().usage("!ping").shortDescription("ping pong!").build();

    private static final CommandPermissions PERMISSIONS = new CommandPermissions();

    public PingCommand(PingModule module) {
        super(module, "ping", INFO, PERMISSIONS, "pingpong");
    }

    @Override
    public CommandResult execute(CommandContext context) {
        context.getChannel().sendMessage("pong! Times called: " + module.getCalled().incrementAndGet()).queue();
        return null;
    }

    @Override
    public CommandPermissions getPermissions() {
        return null;
    }
}
