package edu.neumont.csc150.c.main;

import edu.neumont.csc150.c.models.*;
import edu.neumont.csc150.c.view.ConnectFourUI;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    ConnectFourUI ui;
    List<Player> players;
    List<Piece> pieces;
    Board board;
    Date rng;

    private void run() {
        initializeComponents();
        choosePlayers();
        populatePieces();
        playGame();
    }

    private void playGame() {
         players = determineFirstPlayer();
         boolean hasAWinner = false;
         int i = 0;
         while (!hasAWinner && i < board.getPieces().size() + 1) {
             if (i % 2 == 0)
                 hasAWinner = playerMove(0, board.getPieces().get(i).getColor());
             else
                 hasAWinner = playerMove(1, board.getPieces().get(i).getColor());
             i++;
         }
         boolean userChose = false;
         while(!userChose) {
             ui.displayPrompt("Would you like to play again? [y/n]");
             try {
                 String input = ui.getUserInput();
                 switch(input.toLowerCase()) {
                     case "y":
                         run();
                         break;
                     case "n":
                         ui.displayPrompt("Exiting");
                         userChose = true;
                         break;
                     default:
                         ui.displayPrompt("Please enter a valid answer");
                 }
             } catch(Exception e) {
                ui.displayPrompt("Please enter a valid answer");
             }
         }

    }

    private boolean playerMove(int index, String color) {
        String user = color + players.get(index).getName();
        ui.displayPrompt(
                "\033[0;30m" + "Current Player : " + user + "\033[0m"
        );
        navigatePosition(color);
        boolean hasWinner = checkForWins();
        return hasWinner;
    }

    private boolean checkForWins()  {
        String red ="\033[1;31m";
        String yellow = "\033[1;33m";
        String horiCheck = checkHorizontalWins(red, yellow);
        String vertCheck = checkVerticalWins(red, yellow);
        String digCheck = checkDiagonals(red, yellow);

        if (horiCheck.length() > 0 || vertCheck.length() > 0 || digCheck.length() > 0) {
            if (horiCheck.length() == 3 || vertCheck.length() == 3 || digCheck.length() == 3)
                ui.displayPrompt("It appears that our winner is " + red + players.get(1).getName() + "\033[0m");
            else
                ui.displayPrompt("It appears that our winner is " + yellow + players.get(0).getName() + "\033[0m");
            displayBoard();
            return true;
        } else
            return false;
    }

    private String checkDiagonals(String red, String yellow) {
        String[][] checkBoard = board.getDisplay();
        int redCount = 0, yellowCount = 0;
        String playerWon = "";
        boolean finishedCheck = false;
        while (!finishedCheck) {
            for (int i = 0; i < 6; i++) {
                if (checkBoard[i][i].contains(yellow))
                    yellowCount += 1;
                else
                    yellowCount = 0;

                if (checkBoard[i][i].contains(red))
                    redCount += 1;
                else
                    redCount = 0;

                if (redCount == 4)
                    playerWon = "red";

                if (yellowCount == 4)
                    playerWon = "yellow";
            }

            yellowCount = 0;
            redCount = 0;

            for (int i = 0; i < 6; i++) {
                if (checkBoard[i][i + 1].contains(yellow))
                    yellowCount += 1;
                else
                    yellowCount = 0;

                if (checkBoard[i][i + 1].contains(red))
                    redCount += 1;
                else
                    redCount = 0;

                if (redCount == 4)
                    playerWon = "red";

                if (yellowCount == 4)
                    playerWon = "yellow";
            }

            yellowCount = 0;
            redCount = 0;

            for (int i = 0; i < 5; i++) {
                if (checkBoard[i][i + 2].contains(yellow))
                    yellowCount += 1;
                else
                    yellowCount = 0;

                if (checkBoard[i][i + 2].contains(red))
                    redCount += 1;
                else
                    redCount = 0;

                if (redCount == 4)
                    playerWon = "red";

                if (yellowCount == 4)
                    playerWon = "yellow";
            }

            yellowCount = 0;
            redCount = 0;

            for (int i = 0; i < 4; i++) {
                if (checkBoard[i][i + 3].contains(yellow))
                    yellowCount += 1;
                else
                    yellowCount = 0;

                if (checkBoard[i][i + 3].contains(red))
                    redCount += 1;
                else
                    redCount = 0;

                if (redCount == 4)
                    playerWon = "red";

                if (yellowCount == 4)
                    playerWon = "yellow";
            }

            yellowCount = 0;
            redCount = 0;

            for (int i = 0; i < 4; i++) {
                if (checkBoard[i][i + 3].contains(yellow))
                    yellowCount += 1;
                else
                    yellowCount = 0;

                if (checkBoard[i][i + 3].contains(red))
                    redCount += 1;
                else
                    redCount = 0;

                if (redCount == 4)
                    playerWon = "red";

                if (yellowCount == 4)
                    playerWon = "yellow";
            }

            yellowCount = 0;
            redCount = 0;

            for (int i = 0; i < 4; i++) {
                if (checkBoard[i + 2][i].contains(yellow))
                    yellowCount += 1;
                else
                    yellowCount = 0;

                if (checkBoard[i + 2][i].contains(red))
                    redCount += 1;
                else
                    redCount = 0;

                if (redCount == 4)
                    playerWon = "red";

                if (yellowCount == 4)
                    playerWon = "yellow";
            }

            yellowCount = 0;
            redCount = 0;

            for (int i = 0; i < 5; i++) {
                if (checkBoard[i + 1][i].contains(yellow))
                    yellowCount += 1;
                else
                    yellowCount = 0;

                if (checkBoard[i + 1][i].contains(red))
                    redCount += 1;
                else
                    redCount = 0;

                if (redCount == 4)
                    playerWon = "red";

                if (yellowCount == 4)
                    playerWon = "yellow";
            }

            yellowCount = 0;
            redCount = 0;

////    (2,0)(3,1)(4,2)(5,3)
////    (1,0)(2,1)(3,2)(4,3)(5,4)
////    (0,0)(1,1)(2,2)(3,3)(4,4)(5,5)
////    (0,1)(1,2)(2,3)(3,4)(4,5)(5,6)
////    (0,2)(1,3)(2,4)(3,5)(4,6)
////    (0,3)(1,4)(2,5)(3,6)

            for (int i = 5; i > 0; i--) {
                int counter = i % 5;
                if (i == 0)
                    counter = 5;

                if (checkBoard[i][counter].contains(yellow))
                    yellowCount += 1;
                else
                    yellowCount = 0;

                if (checkBoard[i][counter].contains(red))
                    redCount += 1;
                else
                    redCount = 0;

                if (redCount == 4)
                    playerWon = "red";

                if (yellowCount == 4)
                    playerWon = "yellow";
            }

            yellowCount = 0;
            redCount = 0;

            int counter = 1;
            for (int i = 5; i > 0; i--) {
                if (checkBoard[i][counter].contains(yellow))
                    yellowCount += 1;
                else
                    yellowCount = 0;

                if (checkBoard[i][counter].contains(red))
                    redCount += 1;
                else
                    redCount = 0;

                if (redCount == 4)
                    playerWon = "red";

                if (yellowCount == 4)
                    playerWon = "yellow";

                counter += 1;
            }

            yellowCount = 0;
            redCount = 0;

            counter = 3;
            for (int i = 0; i < 3; i++) {
                if (checkBoard[counter][i].contains(yellow))
                    yellowCount += 1;
                else
                    yellowCount = 0;

                if (checkBoard[counter][i].contains(red))
                    redCount += 1;
                else
                    redCount = 0;

                if (redCount == 4)
                    playerWon = "red";

                if (yellowCount == 4)
                    playerWon = "yellow";

                counter--;
            }

            yellowCount = 0;
            redCount = 0;

            counter = 0;
            for (int i = 4; i > 0; i--) {
                if (checkBoard[i][counter].contains(yellow))
                    yellowCount += 1;
                else
                    yellowCount = 0;

                if (checkBoard[i][counter].contains(red))
                    redCount += 1;
                else
                    redCount = 0;

                if (redCount == 4)
                    playerWon = "red";

                if (yellowCount == 4)
                    playerWon = "yellow";

                counter ++;
            }

            yellowCount = 0;
            redCount = 0;

            for (int i = 0; i < 4; i++) {
                if (checkBoard[i][i + 3].contains(yellow))
                    yellowCount += 1;
                else
                    yellowCount = 0;

                if (checkBoard[i][i + 3].contains(red))
                    redCount += 1;
                else
                    redCount = 0;

                if (redCount == 4)
                    playerWon = "red";

                if (yellowCount == 4)
                    playerWon = "yellow";
            }

            yellowCount = 0;
            redCount = 0;

            counter = 2;
            for (int i = 5; i > 1; i--) {
                if (checkBoard[i][counter].contains(yellow))
                    yellowCount += 1;
                else
                    yellowCount = 0;

                if (checkBoard[i][counter].contains(red))
                    redCount += 1;
                else
                    redCount = 0;

                if (redCount == 4)
                    playerWon = "red";

                if (yellowCount == 4)
                    playerWon = "yellow";

                counter += 1;
            }

            yellowCount = 0;
            redCount = 0;

////    (3,0)(2,1)(1,2)(0,3)
////    (4,0)(3,1)(2,2)(1,3)(0,4)
////    (5,0)(4,1)(3,2)(2,3)(1,4)(0,5)
////    (5,1)(4,2)(3,3)(2,4)(1,5)(0,6)
////    (5,2)(4,3)(3,4)(2,5)(1,6)
////    (5,3)(4,4)(3,5)(2,6)

            counter = 3;
            for (int i = 5; i > 2; i--) {
                if (checkBoard[i][counter].contains(yellow))
                    yellowCount += 1;
                else
                    yellowCount = 0;

                if (checkBoard[i][counter].contains(red))
                    redCount += 1;
                else
                    redCount = 0;

                if (redCount == 4)
                    playerWon = "red";

                if (yellowCount == 4)
                    playerWon = "yellow";

                counter++;
            }

            yellowCount = 0;
            redCount = 0;

            finishedCheck = true;
        }
        return playerWon;
    }

    private String checkVerticalWins(String red, String yellow) {
        String[][] checkBoard = board.getDisplay();
        int yRedCount = 0;
        int yYellowCount = 0;
        String playerWon = "";

        for (int column = 0; column < checkBoard[0].length; column++) {
            for (int row = 0; row < checkBoard.length; row++) {

                if (checkBoard[row][column].contains(yellow))
                    yYellowCount += 1;
                else
                    yYellowCount = 0;

                if (checkBoard[row][column].contains(red))
                    yRedCount += 1;
                else
                    yRedCount = 0;

                if (yYellowCount == 4)
                    playerWon = "yellow";

                if (yRedCount == 4)
                    playerWon = "red";
            }
            yRedCount = 0;
            yYellowCount = 0;
        }
        return playerWon;
    }

    private String checkHorizontalWins(String red, String yellow) {
        String[][] checkBoard = board.getDisplay();

        for (int row = 0; row < checkBoard.length; row++) {
            int xRedCount = 0;
            int xYellowCount = 0;
            for (int column = 0; column < checkBoard[0].length; column++) {

                if (checkBoard[row][column].contains(yellow))
                    xYellowCount += 1;
                else
                    xYellowCount = 0;

                if (xYellowCount == 4)
                    return "yellow";

                if (checkBoard[row][column].contains(red)) {
                    xRedCount += 1;
                } else {
                    xRedCount = 0;
                }
                if (xRedCount == 4) {
                    return "red";
                }
            }
        }
        return "";
    }

    private void navigatePosition(String color) {
        boolean playerFinishedMove = false;
        while (!playerFinishedMove) {
            try {
                String[][] functionBoard = board.getDisplay();
                displayBoard();
                ui.displayIndex();
                int input;

                if (color.equals("\033[1;31m")) {
                    if (players.get(1).getClass().getSimpleName().equals("Computer")) {
                        input = ThreadLocalRandom.current().nextInt(0, 8);
                    } else {
                        ui.displayPrompt("Which column would you like to drop your piece into?");
                        input = Integer.parseInt(ui.getUserInput()) - 1;
                    }
                } else {
                    if (players.get(0).getClass().getSimpleName().equals("Computer")) {
                        input = ThreadLocalRandom.current().nextInt(0, 8);
                    } else {
                        ui.displayPrompt("Which column would you like to drop your piece into?");
                        input = Integer.parseInt(ui.getUserInput()) - 1;
                    }
                }

                switch(input) {
                    case 0:
                    case 1:
                    case 2:
                    case 3:
                    case 4:
                    case 5:
                    case 6: {
                        for (int i = functionBoard.length - 1; i >= 0; i--) {
                            if (functionBoard[i][input].length() == 1) {
                                functionBoard[i][input] = color + functionBoard[i][input] + "\033[0m";
                                playerFinishedMove = true;
                                break;
                            }
                        }
                    }
                    break;
                    default:
                        ui.displayPrompt("Please Enter a valid number");
                        break;
                }
            }
            catch(Exception ex) {
                System.out.println("Please enter a valid number");
            }
        }
    }

    public void displayBoard() {
        String[][] gameBoard = board.getDisplay();

        for (String[] str : gameBoard) {
            for (int column = 0; column < gameBoard[0].length; column++) {
                System.out.print(str[column] + "  ");
            }
            System.out.println();
        }
    }

    private List<Player> determineFirstPlayer() {
        long time = rng.getTime();
        if (time % 2 == 0)
            Collections.reverse(players);
        return players;
    }

    private void populatePieces() {
        String[][] dimensions = board.getDisplay();
        for (int i = 0; i < dimensions.length * dimensions[0].length; i++) {
            if (i % 2 == 0)
                pieces.add(new Piece("\033[1;33m"));
            else
                pieces.add(new Piece("\033[1;31m"));
        }
        board.setPieces(pieces);
    }

    public void choosePlayers() {
        boolean userRequestedExit = false;
        while(!userRequestedExit) {
            try {
                ui.displayPlayerMenu();
                userRequestedExit = chooseGameMode();
            }
            catch(Exception ex) {
                System.out.println("Please enter a valid number");
            }
        }
    }

    private boolean chooseGameMode() {
        boolean userRequestedExit = false;
        while(!userRequestedExit) {
            try {
                int input = Integer.parseInt(ui.getUserInput());
                switch(input) {
                    case 0:
                        ui.displayPrompt("Exiting...");
                        userRequestedExit = true;
                        break;
                    case 1:
                        generatePlayers(2, 0);
                        userRequestedExit = true;
                        break;
                    case 2:
                        generatePlayers(1, 1);
                        userRequestedExit = true;
                        break;
                    case 3:
                        generatePlayers(0, 2);
                        userRequestedExit = true;
                        break;
                    default:
                        System.out.println("Please provide a valid number");
                        break;
                }
            }
            catch(Exception ex) {
                System.out.println("Please enter a valid number");
            }
        }
        return true;
    }

    private void generatePlayers(int human, int computer) {
        for (int i = 0; i < human; i++) {
            generateHuman();
        }

        for (int i = 0; i < computer; i++) {
            generateComputer();
        }
    }

    private void generateHuman() {
        String name = generateName();
        validateName(name, new Human());
    }

    private void generateComputer() {
        String name = generateName();
        validateName(name, new Computer());
    }

    private void validateName(String name, Player player) {
        if (name.length() == 0 || !name.matches("\\S+")) {
            int position = players.size() + 1;
            String type = player.getClass().getSimpleName();
            player.setName(type + position);
            players.add(player);
        } else {
            player.setName(name);
            players.add(player);
        }
    }

    private String generateName() {
        String name = "";
        try {
            ui.displayPrompt("Please enter a name");
            name = ui.getUserInput();
        }
        catch(Exception ex) {
            ex.printStackTrace();
        }
        return name;
    }

    private void initializeComponents() {
        ui = new ConnectFourUI();
        players = new ArrayList<>();
        pieces = new ArrayList<>();
        board = new Board();
        rng = new Date();
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.run();
    }
}