package Linea;

import Linea.Linea;
import Linea.GameOver;

public class RowsAndColumns extends GameMode {
    public RowsAndColumns(){
        this.mode = 'A';
    }

    @Override
    public void didPlayerWin(char player, Linea game) {
        if (game.fourInARowInRow(player) || game.fourInARowInColumn(player)){
            game.setTurn(new GameOver(player + " wins!"));
        }
        else if (game.itsADraw()){
            game.setTurn(new GameOver(DRAW));
        }
    }

}
