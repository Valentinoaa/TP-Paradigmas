package Linea;

public class RedTurn extends Turn {

    @Override
    public boolean itsRedTurn() {
        return true;
    }

    @Override
    public boolean itsBlueTurn() {
        return false;
    }

    @Override
    public Turn playRedChipIn(int column, Linea game) {
        game.playRedChipIn(column);
        return new BlueTurn();
    }

    @Override
    public Turn playBlueChipIn(int column, Linea game) {
        throw new RuntimeException(NOT_BLUES_TURN);
    }

    @Override
    public boolean finished() {
        return false;
    }
}
