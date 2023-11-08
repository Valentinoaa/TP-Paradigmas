package Linea;

import java.util.List;

public class RowsAndColumns extends GameMode{
    public RowsAndColumns(){
        this.mode = 'A';
    }

    @Override
    public void didPlayerWin(char player, Linea game) {
        if (game.fourInARowInRow(player) || game.fourInARowInColumn(player)){
            game.setWinner(player);
        }
    }

}
