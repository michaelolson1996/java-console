package edu.neumont.csc150.c.models;

import java.util.List;

public interface Game {
    Board generateBoard();
    List<Player> generatePlayers();
    Piece generatePiece();
}