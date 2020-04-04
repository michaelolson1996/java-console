package olson.michael.pokemon.controller;

import olson.michael.pokemon.Pokedex;
import olson.michael.pokemon.model.Pokemon;
import olson.michael.pokemon.view.PokedexUI;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PokedexManager {

    private final static String pokedexFile = "pokedex.txt";
    private PokedexUI ui = new PokedexUI();
    private List<Pokemon> pokemonList = new ArrayList<>();

    public PokedexManager() throws IOException {
        try {
            loadPokemon();
        } catch(FileNotFoundException ex) {
            ui.displayMessage("No existing pokedex: starting fresh");
        }
    }

    public void run() throws IOException {
        boolean exitRequested = false;

        while(!exitRequested) {
            PokedexUI.MenuItem selection = ui.promptMenuSelection();
            switch (selection) {
                case EXIT:
                    exitRequested = true;
                    break;
                case CREATE_POKEMON:
                    createPokemon();
                    break;
                case VIEW_POKEMON:
                    viewPokemon();
                    break;
                case SEARCH_POKEMON:
                    searchPokemon();
                    break;
                case LOAD_FROM_FILE:
                    String loadFileName = ui.promptLoadFileName();
                    try {
                        loadPokemon(loadFileName);
                    } catch (Exception ex) {
                        ui.displayError("failed to load from file " + loadFileName);
                    }
                    break;
            }
        }

    }

    private void createPokemon() throws IOException {
        Pokemon p = new Pokemon();
        p.setName(ui.promptPokemonName());
        p.setLevel(ui.promptPokemonLevel());
        p.setCaptureDate(ui.promptCaptureDate());
        pokemonList.add(p);
        savePokemon();
    }

    private void viewPokemon() {
        ui.displayMessage(this.pokemonList.toString());
    }

    private void searchPokemon() throws IOException {
        ui.displayMessage("enter the min level");
        int min = ui.readInt(0, 100);
        ui.displayMessage("Enter max");
        int max = ui.readInt(min, 100);
        List<Pokemon> searchResults = new ArrayList<>();

        for (Pokemon p : this.pokemonList) {
            if (p.getLevel() >= min && p.getLevel() <= max) {
                searchResults.add(p);
            }
        }
        ui.displayMessage(searchResults.toString());
    }

    public void savePokemon() throws FileNotFoundException {
        PrintStream outFile = new PrintStream(pokedexFile);
        try {
             for(Pokemon p : pokemonList) {
                 outFile.println(p.serialize());
             }
        } finally {
            outFile.close();
        }
    }

    public void loadPokemon() throws IOException {
        loadPokemon(null);
    }

    public void loadPokemon(String userFileName) throws IOException {

        if (userFileName == null) {
            userFileName = pokedexFile;
        }
        BufferedReader inFile = new BufferedReader(new InputStreamReader(
                new FileInputStream(userFileName)));
        this.pokemonList.clear();
        try {
            while (inFile.ready()) {
                String line = inFile.readLine();
                if (!line.trim().isEmpty()) {
                    Pokemon p = new Pokemon();
                    p.deserialize(line);
                    this.pokemonList.add(p);
                }
            }
        } finally {
            inFile.close();
        }
    }
}
