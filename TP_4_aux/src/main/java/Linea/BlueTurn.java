package Linea;

public class BlueTurn extends Turn {

    @Override
    public boolean itsRedTurn() {
        return false;
    }

    @Override
    public boolean itsBlueTurn() {
        return true;
    }

    @Override
    public Turn playRedChipIn(int column, Linea game) {
        throw new RuntimeException(NOT_REDS_TURN);
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
