package me.ollie.saltmarsh.meta.module;

public enum ModuleCategory {
    RANDOM("Random");

    String name;

    ModuleCategory(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
