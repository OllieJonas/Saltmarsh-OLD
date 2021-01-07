package me.ollie.saltmarsh.meta.module;

public interface IModule {

    boolean isEnabled();

    void enable();

    void registerCommands();

    void onEnable();

    void onDisable();
}
