package solutions.cg.devtask;

import io.dropwizard.Application;
import io.dropwizard.setup.Environment;
import solutions.cg.devtask.resources.PlayerResource;

public class PlayerServiceApplication extends Application<PlayerServiceConfiguration> {
    public static void main(String[] args) throws Exception {
        new PlayerServiceApplication().run(args);
    }

    public void run(PlayerServiceConfiguration playerServiceConfiguration, Environment environment) {
        final PlayerResource playerResource = new PlayerResource(playerServiceConfiguration.getPlayersDb());
        environment.jersey().register(playerResource);
    }
}
