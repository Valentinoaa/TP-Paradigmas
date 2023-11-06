package Linea.Modo;

import java.util.List;
import java.util.Arrays;
import java.util.stream.Stream;


public abstract class GameMode {

    public static final String invalidTypeOfGame = "Invalid type of game";
    protected Character mode;

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
}
