package Linea.gameMode;

import Linea.Linea;
import Linea.gameMode.GameMode;

public class Full extends GameMode {
    public Full(){
        this.mode = 'C';
    }

    @Override
    public void didPlayerWin(char player, Linea game) {
        if (game.fourInARowInDiagonal(player) || game.fourInARowInRow(player) || game.fourInARowInColumn(player)){
            game.setTurn(new Linea.turn.gameOver.Winner(player));
        }
    }


}
