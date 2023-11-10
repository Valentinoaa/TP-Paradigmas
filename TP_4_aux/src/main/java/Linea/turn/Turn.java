package Linea.turn;

import Linea.Linea;

public abstract class Turn {

    public static final String YA_TERMINO_EL_JUEGO = "Ya termino el juego";
    public static final String NO_ES_TURNO_DE_ROJO = "No es turno de rojo";
    public static final String NO_ES_TURNO_DE_AZUL = "No es turno de azul";
    public String turn;

    public void setTurn(String turn){
        this.turn = turn;
    }

    public String getTurn(){
        return turn;
    }


    public abstract boolean itsRedTurn();

    public abstract boolean itsBlueTurn();

    public abstract Turn playRedChipIn(int column, Linea game);

    public abstract Turn playBlueChipIn(int column, Linea game);

    public abstract boolean finished();
}
