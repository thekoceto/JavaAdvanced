package guildList;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Guild {

    private String name;
    private int capacity;
    private List<Player> roster;

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        roster = new ArrayList<>();
    }

    public void addPlayer(Player player) {
        if (count() < capacity) {
            roster.add(player);
        }
    }

    public int count() {
        return roster.size();
    }

    public boolean removePlayer(String name) {
        return roster.removeIf(player -> name.equals(player.getName()));
    }

    public void promotePlayer(String name) {
        roster.stream()
                .filter(player -> name.equals(player.getName()))
                .forEach(player -> player.setRank("Member"));
    }

    public void demotePlayer(String name) {
        roster.stream()
                .filter(player -> name.equals(player.getName()))
                .forEach(player -> player.setRank("Trial"));
    }

    public Player[] kickPlayersByClass(String clazz) {
        Player[] removed = roster.stream()
                .filter(player -> clazz.equals(player.getClazz()))
                .toArray(Player[]::new);

        for (Player player : removed) {
            roster.remove(player);
        }

        return removed;
    }

    public String report() {
        return String.format(
                "Players in the guild: %s:%n%s", name,
                roster.stream()
                        .map(Player::toString)
                        .collect(Collectors.joining(System.lineSeparator())))
                .trim();
    }
}