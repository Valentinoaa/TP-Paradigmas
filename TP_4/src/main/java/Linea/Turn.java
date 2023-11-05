package Linea;

public class Turn {
    public String turn;

    public void setTurn(String turn){
        this.turn = turn;
    }

    public String getTurn(){
        return turn;
    }

    public void changeTurn(){
        if (turn == "R"){
            turn = "B";
        } else {
            turn = "R";
        }
    }

}
