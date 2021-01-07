package me.ollie.saltmarsh.meta.module;

import java.util.HashMap;
import java.util.Map;

public class ModuleRegistry {

    private final Map<Class<? extends IModule>, IModule> modules;

    public ModuleRegistry() {
        this.modules = new HashMap<>();
    }

    public void registerModule(IModule module) {
        this.modules.put(module.getClass(), module);
    }

    public IModule getModule(Class<? extends IModule> clazz) {
        return modules.get(clazz);
    }
}
