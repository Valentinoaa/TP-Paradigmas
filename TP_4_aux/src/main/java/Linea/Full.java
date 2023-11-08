package Linea;

public class Full extends GameMode{
    public Full(){
        this.mode = 'C';
    }

    @Override
    public void didPlayerWin(char player, Linea game) {
        if (game.fourInARowInDiagonal(player) || game.fourInARowInRow(player) || game.fourInARowInColumn(player)){
            game.setWinner(player);
        }
    }


}
