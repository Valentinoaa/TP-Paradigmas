package Linea;

import java.util.ArrayList;

public class BlueTurn extends Turn {

    @Override
    public Turn playRedChipIn(int column, Linea game) {
        throw new RuntimeException(NO_ES_TURNO_DE_ROJO);
    }

    @Override
    public Turn playBlueChipIn(int column, Linea game) {
        game.playBlueChipIn(column);
        return new RedTurn();
    }

    @Override
    public boolean finished() {
        return false;
    }
}
