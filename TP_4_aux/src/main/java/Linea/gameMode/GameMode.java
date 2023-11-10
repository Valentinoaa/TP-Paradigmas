package Linea.gameMode;

import Linea.Linea;
import Linea.RowsAndColumns;

import java.util.List;
import java.util.Arrays;


public abstract class GameMode {

    public static final String invalidTypeOfGame = "Invalid type of game";
    public char mode;

    public GameMode(){}

    public static List<GameMode> availableModes = Arrays.asList(
            new RowsAndColumns(),
            new Diagonals(),
            new Full());

    public static GameMode modeFor(Character key){
        return availableModes.stream()
                .filter(game -> game.equalsType(key))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(invalidTypeOfGame));

    }

    public boolean equalsType(Character key){
        return key == mode;
    }

    public boolean finished() {
        return false;
    }

    public char getMode() {
        return mode;
    }

    public abstract void didPlayerWin(char player, Linea game);
}
