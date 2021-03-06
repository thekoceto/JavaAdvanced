package guildMap;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Guild {

    private String name;
    private int capacity;
    private Map<String, Player> roster;

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        roster = new LinkedHashMap<>();
    }

    public void addPlayer(Player player) {
        if (count() < capacity) {
            roster.putIfAbsent(player.getName(), player);
        }
    }

    public int count() {
        return roster.size();
    }

    public boolean removePlayer(String name) {
        return roster.remove(name) != null;
    }

    public void promotePlayer(String name) {
        roster.computeIfPresent(name, Guild::promotePlayer);
    }

    private static Player promotePlayer(String name, guildMap.Player player) {
        player.setRank("Member");
        return player;
    }

    public void demotePlayer(String name) {
        roster.computeIfPresent(name, Guild::demotePlayer);
    }

    private static Player demotePlayer(String name, Player player) {
        player.setRank("Trial");
        return player;
    }

    public guildMap.Player[] kickPlayersByClass(String clazz) {
        guildMap.Player[] removed = roster.values().stream()
                .filter(player -> clazz.equals(player.getClazz()))
                .toArray(guildMap.Player[]::new);

        for (Player player : removed) {
            roster.remove(player.getName());
        }

        return removed;
    }

    public String report() {
        return String.format(
                "Players in the guild: %s:%n%s", name,
                roster.values().stream()
                        .map(Player::toString)
                        .collect(Collectors.joining(System.lineSeparator())));
    }
}