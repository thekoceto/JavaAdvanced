package guild;

import java.util.*;

public class Guild {
    private List<Player> roster;
    private String name;
    private int capacity;



    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    public List<Player> getRoster() {
        return this.roster;
    }

    public void setRoster(List<Player> roster) {
        this.roster = roster;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public void addPlayer(Player player) {
        if (this.count() < this.capacity){
            this.roster.add(player);
        }
    }

    public int count() {
        return roster.size();
    }
    //•   Method removePlayer(String name) - removes a player by given name, if such exists, and returns boolean
    public boolean removePlayer(String name) {
        for (Player player : roster) {
            if (player.getName().equals(name))
                return roster.remove(player);
        }
        return false;
    }
    //promote (set his rank to "Member") the first player with the given name. If the player is already a "Member", do nothing.
    public void promotePlayer(String name) {
        for (Player player : this.roster) {
            if (player.getName().equals(name)) {
                player.setRank("Member");
                break;
            }
        }
    }

    public void demotePlayer(String name){
        for (Player player : roster) {
            if (player.getName().equals(name)) {
                player.setRank("Trial");
                break;
            }
        }
    }
    //•   Method kickPlayersByClass(String clazz) - removes all the players by the given class and returns all removed players from that class as an array
    public Player[] kickPlayersByClass(String clazz) {

        ArrayList<Player> list = new ArrayList<>();
        for (Player pl : roster) {
            if (pl.getClazz().equals(clazz)){
                list.add(pl);
            }
        }
        Player[] players = new Player[list.size()];
        for (int i = 0; i < players.length; i++) {
            players[i] = list.get(i);
            roster.remove(list.get(i));
        }
        return players;
    }


    public String report() {
        //Players in the guild: {guildName}:
        //{Player1}
        //{Player2}
        //(…)"
        StringBuilder sb = new StringBuilder();
        for (Player player : roster) {
            sb.append(player);
            sb.append(System.lineSeparator());
        }
        return "Players in the guild: " + this.name  + ":" + System.lineSeparator() + sb.toString().trim();

    }
}