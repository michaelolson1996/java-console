package edu.neumont.csc150.c.models;

import java.util.List;

public class Board {

    private List<Piece> pieces;
    private String[][] display = {
            {"O", "O", "O", "O", "O", "O", "O"},
            {"O", "O", "O", "O", "O", "O", "O"},
            {"O", "O", "O", "O", "O", "O", "O"},
            {"O", "O", "O", "O", "O", "O", "O"},
            {"O", "O", "O", "O", "O", "O", "O"},
            {"O", "O", "O", "O", "O", "O", "O"}
    };

    public Board() {}

    public Board(List<Piece> pieces) {
        setPieces(pieces);
    }

    public List<Piece> getPieces() {
        return pieces;
    }

    public void setPieces(List<Piece> pieces) {
        this.pieces = pieces;
    }

    public String[][] getDisplay() {
        return display;
    }

    public void setDisplay(String[][] display) {
        this.display = display;
    }

    @Override
    public String toString() {
        return "Board{" +
                "pieces=" + pieces +
                '}';
    }
}
