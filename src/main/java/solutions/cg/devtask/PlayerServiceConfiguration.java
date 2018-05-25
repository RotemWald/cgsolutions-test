package solutions.cg.devtask;

import io.dropwizard.Configuration;
import solutions.cg.devtask.db.PlayerStorage;

public class PlayerServiceConfiguration extends Configuration {
    private final PlayerStorage playersDb = new PlayerStorage();

    public PlayerStorage getPlayersDb() {
        return playersDb;
    }
}
