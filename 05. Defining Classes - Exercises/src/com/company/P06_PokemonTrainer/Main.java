package com.company.P06_PokemonTrainer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args)throws IOException {
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        Map<String, Trainer> trainers = new LinkedHashMap<>();
        String command;
        while (!"Tournament".equals(command = console.readLine())){
            String[] token = command.split("\\s+");
            String trainerName = token[0];
            String pokemonName = token[1];
            String pokemonElement = token[2];
            int pokemonHealth = Integer.parseInt(token[3]);

            trainers.putIfAbsent(trainerName, new Trainer(trainerName));
            trainers.get(trainerName).pokemons.add( new Pokemon(pokemonName, pokemonElement, pokemonHealth));
        }
        while (!"End".equals(command = console.readLine())){
            for (Map.Entry<String, Trainer> entry : trainers.entrySet()) {
                boolean found = false;
                List<Pokemon> pokemons = entry.getValue().getPokemons();
                for (Pokemon pokemon : pokemons) {
                    if (pokemon.getElement().equals(command)) {
                        entry.getValue().increaseBadgesBy1();
                        found = true;
                        break;
                    }
                }
                if (!found) {
                    for (int i = 0; i < pokemons.size(); i++) {
                        if (pokemons.get(i).decreaseHealthBy10AndCheck())
                            pokemons.remove(i--);
                    }
                }
            }
        }
        trainers
                .entrySet()
                .stream()
                .sorted((t1, t2) -> t2.getValue().getBadges() - t1.getValue().getBadges())
                .forEach(t ->
                        System.out.println(t.getKey()
                                + " " + t.getValue().getBadges()
                                + " " + t.getValue().getPokemons().size()));
    }
}
