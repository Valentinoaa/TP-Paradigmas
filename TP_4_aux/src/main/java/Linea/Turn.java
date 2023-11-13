package Linea;

public abstract class Turn {

    public static final String NOT_REDS_TURN = "It's not red's turn";
    public static final String NOT_BLUES_TURN = "It's not blue's turn";

    public abstract boolean itsRedTurn();

    public abstract boolean itsBlueTurn();

    public abstract Turn playRedChipIn(int column, Linea game);

    public abstract Turn playBlueChipIn(int column, Linea game);

    public abstract boolean finished();
}
