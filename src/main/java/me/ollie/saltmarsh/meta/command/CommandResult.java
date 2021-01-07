package me.ollie.saltmarsh.meta.command;

public class CommandResult {

    private String message;

    enum Status {
        SUCCESS("Command successful"),
        FAIL("Command failed!");

        String message;

        Status(String message) {
            this.message = message;
        }
    }
}
