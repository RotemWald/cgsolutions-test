package solutions.cg.devtask.db;

import solutions.cg.devtask.core.Player;

import java.util.*;

public class PlayerStorage {
    private List<Player> playerListById;
    private SortedSet<Player> playerListByName;

    public PlayerStorage() {
        this.playerListById = new LinkedList<>();
        this.playerListByName = new TreeSet<>(Comparator.comparing(Player::getName));
    }

    public synchronized void addPlayer(Player p) {
        this.playerListById.add(p); // O(1)
        this.playerListByName.add(p); // O(log n)
    }

    public synchronized List<Player> getPlayerListById() {
        return playerListById;
    }

    public synchronized SortedSet<Player> getPlayerListByName() {
        return playerListByName;
    }
}
