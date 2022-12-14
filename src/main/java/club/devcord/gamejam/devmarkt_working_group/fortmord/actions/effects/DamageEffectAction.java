package club.devcord.gamejam.devmarkt_working_group.fortmord.actions.effects;

import club.devcord.gamejam.devmarkt_working_group.fortmord.FortMord;
import club.devcord.gamejam.devmarkt_working_group.fortmord.actions.AbstractLevelAction;
import club.devcord.gamejam.devmarkt_working_group.fortmord.actions.LevelAction;
import io.micronaut.context.annotation.Parameter;
import org.bukkit.entity.Player;

import javax.annotation.PostConstruct;
import java.util.concurrent.ThreadLocalRandom;

@LevelAction(value = 50, levelBound = true)
public class DamageEffectAction extends AbstractLevelAction {
    public DamageEffectAction(@Parameter Player player, FortMord fortMord, @Parameter int level) {
        super(player, level, fortMord);
    }

    @PostConstruct
    void start() {
        runTaskTimer(this::apply, 5, () -> random(descLevel(), 257) * 10L);
    }

    private void apply() {
        if(ThreadLocalRandom.current().nextBoolean() && player().getHealth() > 10) {
            player().damage(ThreadLocalRandom.current().nextDouble(2));
        }
    }
}
