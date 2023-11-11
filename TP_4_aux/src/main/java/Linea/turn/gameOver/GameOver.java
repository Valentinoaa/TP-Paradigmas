package Linea.turn.gameOver;

import Linea.Linea;
import Linea.turn.Turn;

public class GameOver extends Turn {
    @Override
    public boolean itsRedTurn() {
        return false;
    }

    @Override
    public boolean itsBlueTurn() {
        return false;
    }

    @Override
    public Turn playRedChipIn(int column, Linea game) {
        throw new RuntimeException(YA_TERMINO_EL_JUEGO);
    }
    @Override
    public Turn playBlueChipIn(int column, Linea game) {
        throw new RuntimeException(YA_TERMINO_EL_JUEGO);
    }
    @Override
    public boolean finished() {
        return true;
    }


}
