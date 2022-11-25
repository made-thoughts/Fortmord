package club.devcord.gamejam.devmarkt_working_group.fortmord;

import club.devcord.gamejam.devmarkt_working_group.fortmord.level.TestCommand;
import club.devcord.gamejam.devmarkt_working_group.fortmord.micropaper.event.OnDisableEvent;
import club.devcord.gamejam.devmarkt_working_group.fortmord.micropaper.event.OnEnableEvent;
import club.devcord.gamejam.devmarkt_working_group.fortmord.micropaper.MicronautJavaPlugin;
import io.micronaut.runtime.event.annotation.EventListener;
import jakarta.inject.Singleton;

@Singleton
public class FortMord extends MicronautJavaPlugin {

    @EventListener
    public void onEnable(OnEnableEvent event) {
        getLogger().info("Weeeeee");

        getServer().getPluginCommand("test").setExecutor(bean(TestCommand.class));
    }

    @EventListener
    public void onDisable(OnDisableEvent event) {
        getLogger().info("bye... *sad fortmord noises*");
    }

}
