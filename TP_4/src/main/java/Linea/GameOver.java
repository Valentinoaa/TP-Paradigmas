package Linea;

public class GameOver extends Turn {

    private final String ErrorMessage;

    public GameOver(String ErrorMessage){
        this.ErrorMessage = ErrorMessage;
    }
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
        throw new RuntimeException(ErrorMessage);
    }
    @Override
    public Turn playBlueChipIn(int column, Linea game) {
        throw new RuntimeException(ErrorMessage);
    }
    @Override
    public boolean finished() {
        return true;
    }


}
