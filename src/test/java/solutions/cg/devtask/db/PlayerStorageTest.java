package solutions.cg.devtask.db;

import org.junit.Test;
import solutions.cg.devtask.core.Player;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertFalse;

public class PlayerStorageTest {
    private static final PlayerStorage playerStorage = new PlayerStorage();

    @Test
    public void insertionAndDeletion() {
        Player player = new Player(1, "Rotem Wald");
        playerStorage.addPlayer(player);

        assertTrue(playerStorage.getPlayerListById().contains(player));
        assertTrue(playerStorage.getPlayerListByName().contains(player));

        playerStorage.removePlayer(player);

        assertFalse(playerStorage.getPlayerListById().contains(player));
        assertFalse(playerStorage.getPlayerListByName().contains(player));
    }
}
