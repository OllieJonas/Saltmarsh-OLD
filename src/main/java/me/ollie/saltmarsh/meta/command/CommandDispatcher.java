package me.ollie.saltmarsh.meta.command;

import net.dv8tion.jda.api.entities.Member;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Optional;

public class CommandDispatcher extends ListenerAdapter {

    private static final Logger LOGGER = LoggerFactory.getLogger(CommandDispatcher.class);

    @Override
    public void onMessageReceived(MessageReceivedEvent event) {
        Message message = event.getMessage();
        String messageRaw = message.getContentRaw();

        if (!isValidCommandSyntax(messageRaw)) // if message isn't a command
            return;

        String head = getCommandHeadFrom(messageRaw);
        System.out.println(head);
        CommandRegistry.getInstance().getCommands().forEach((s, c) -> System.out.println(s));
        Optional<ICommand<?>> commandOptional = getCommandFrom(head);

        if (commandOptional.isEmpty()) { // command doesn't exist
            System.out.println("not present");
            return;
        }

        ICommand<?> command = commandOptional.get();

        if (!command.isEnabled()) { // command is disabled
            return;
        }

        Member sender = event.getMember();
        CommandPermissions permissions = command.getPermissions();

        if (permissions != null && !permissions.hasPermission(sender)) { // doesn't have permission
            return;
        }

        String[] args = getArgsFromMessage(messageRaw);

        CommandContext context = new CommandContext(head, args, message);
        CommandResult result = command.execute(context);
    }

    private boolean isValidCommandSyntax(String message) {
        return message.length() > 0 && message.charAt(0) == '!';
    }

    private String[] getArgsFromMessage(String messageRaw) {
        return Arrays.copyOfRange(messageRaw.split(" "), 1, messageRaw.length());
    }

    private Optional<ICommand<?>> getCommandFrom(String command) {
        return Optional.ofNullable(CommandRegistry.getInstance().getCommand(command));
    }

    private String getCommandHeadFrom(String messageRaw) {
        String[] split = messageRaw.split(" ");
        return split.length > 0 ? split[0].substring(1) : null;
    }
}
