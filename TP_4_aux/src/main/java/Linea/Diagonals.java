package Linea;

public class Diagonals extends GameMode {
    public Diagonals(){
        this.mode = 'B';
    }

    @Override
    public void didPlayerWin(char player, Linea game) {
        if (game.fourInARowInDiagonal(player)) {
            game.setTurn(new GameOver(player + " wins!"));
        }
        else if (game.itsADraw()){
            game.setTurn(new GameOver(DRAW));
        }
    }
}
