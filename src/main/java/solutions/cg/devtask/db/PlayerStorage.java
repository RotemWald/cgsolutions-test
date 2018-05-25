package solutions.cg.devtask.db;

import solutions.cg.devtask.core.Player;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class PlayerStorage {
    private List<Player> playerList;

    public PlayerStorage() {
        this.playerList = new LinkedList<>();
    }

    public synchronized void addPlayer(Player p) {
        this.playerList.add(p);
    }

    public synchronized List<Player> getPlayerList() {
        return playerList;
    }

    public synchronized List<Player> getPlayerListSortedByName() {
        return playerList.stream().sorted(Comparator.comparing(Player::getName)).collect(Collectors.toList());
    }
}
