package me.ollie.saltmarsh.meta.command;

import lombok.AllArgsConstructor;
import lombok.Getter;
import net.dv8tion.jda.api.entities.*;

@Getter
@AllArgsConstructor
public class CommandContext {

    private final String aliasUsed;

    private final String[] args;

    private final Member member;

    private final User author;

    private final Guild guild;

    private final TextChannel channel;

    public CommandContext(String aliasUsed, String[] args, Message message) {
        this.aliasUsed = aliasUsed;
        this.args = args;
        this.member = message.getMember();
        this.author = message.getAuthor();
        this.guild = message.getGuild();
        this.channel = message.getTextChannel();
    }

}
