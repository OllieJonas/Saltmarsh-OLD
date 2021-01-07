package me.ollie.saltmarsh.ping;

import lombok.Getter;
import lombok.Setter;
import me.ollie.saltmarsh.meta.module.Module;
import me.ollie.saltmarsh.meta.module.ModuleCategory;
import me.ollie.saltmarsh.meta.module.SimpleModule;
import me.ollie.saltmarsh.ping.cmds.PingCommand;

import java.util.concurrent.atomic.AtomicInteger;

@Module(name = "Ping", category = ModuleCategory.RANDOM)
public class PingModule extends SimpleModule {

    @Getter
    @Setter
    private AtomicInteger called = new AtomicInteger(0);

    @Override
    public void registerCommands() {
        registerCommand(new PingCommand(this));
    }
}
