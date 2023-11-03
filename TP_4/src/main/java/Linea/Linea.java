package Linea;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class Linea {

    public ArrayList<ArrayList> tablero = new ArrayList<>();

    public int altura;
    public int base;

    public char modo;

    public Linea(int base, int altura, char modo) {
        IntStream.range(0, altura).forEach(i -> {
            tablero.add(new ArrayList());
        });

        this.altura = altura;
        this.base = base;
        this.modo = modo;
    }

    public String show() {
        String result = "";

        tablero.get(0).add(1); // testing
        
        for (int i = 0; i < altura; i++) {
            String line = "| ";
            for (int j = 0; j < base; j++){
                if (tablero.get(j).size() >= altura - i) {
                    line += " X "; // deberia recivir el valor de la ficha
                } else {
                    line += " A "; // vacio
                }
            }
            result += line + " |\n";
        }
        
        return result;
    }

    public boolean finished() {
        return false;
    }

    public void playRedkAt(int prompt) {
    }

    public void playBlueAt(int prompt) {
    }
}
