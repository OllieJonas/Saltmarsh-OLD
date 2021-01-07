package me.ollie.saltmarsh.meta.command.info;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CommandInfo {

    private final String usage;

    private final String[] detailedDescription;

    private final String shortDescription;
}
