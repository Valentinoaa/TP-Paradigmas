package Linea.Game;

public class Turn {
    public String turn;

    public void setTurn(String turn){
        this.turn = turn;
    }

    public String getTurn(){
        return turn;
    }


    public boolean itsRedTurn() {
        return turn == "R";
    }

    public boolean itsBlueTurn() {
        return turn == "B";
    }
}
