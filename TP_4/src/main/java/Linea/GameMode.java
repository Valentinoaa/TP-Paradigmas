package Linea;

import java.util.List;
import java.util.Arrays;


public abstract class GameMode {

    public static final String INVALID_MODE = "Invalid mode";
    public static final String DRAW = "Draw!";
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
                .orElseThrow(() -> new IllegalArgumentException(INVALID_MODE));

    }

    public boolean equalsType(Character key){
        return key == mode;
    }

    public char getMode() {
        return mode;
    }

    public abstract void didPlayerWin(char player, Linea game);
}
