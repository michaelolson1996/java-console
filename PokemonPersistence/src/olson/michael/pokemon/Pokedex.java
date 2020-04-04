package olson.michael.pokemon;

import olson.michael.pokemon.controller.PokedexManager;

import java.io.IOException;

public class Pokedex {
    public static void main(String[] args) throws IOException {
        new PokedexManager().run();
    }
}
