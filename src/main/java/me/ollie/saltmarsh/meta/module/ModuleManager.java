package me.ollie.saltmarsh.meta.module;

import lombok.Getter;
import org.reflections.Reflections;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationTargetException;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

public class ModuleManager {

    private final ModuleRegistry modules;

    private static final Logger LOGGER = LoggerFactory.getLogger(ModuleManager.class);

    @Getter
    private static ModuleManager instance;

    public ModuleManager() {
        this.modules = new ModuleRegistry();
        registerModules();

        instance = this;
    }

    protected void registerModules() {
        Reflections reflections = new Reflections("me.ollie.saltmarsh");

        Set<Class<?>> moduleAnnos = reflections.getTypesAnnotatedWith(Module.class);
        Set<IModule> moduleSet = getValidModules(moduleAnnos);

        moduleSet.forEach(this::enableModule);
    }

    private void enableModule(IModule module) {
        LOGGER.info("Enabling module " + module.getClass().getSimpleName() + "...");
        System.out.println("Enabling module " + module.getClass().getSimpleName() + "...");

        module.enable();
        modules.registerModule(module);
    }

    public Set<IModule> getValidModules(Collection<Class<?>> moduleAnnos) {
        return moduleAnnos.stream()
                .filter(IModule.class::isAssignableFrom)
                .map(this::newInstance)
                .collect(Collectors.toSet());
    }

    private IModule newInstance(Class<?> clazz) {
        try {
            return (IModule) clazz.getConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }

    public IModule getModule(Class<? extends IModule> clazz) {
        return modules.getModule(clazz);
    }
}
