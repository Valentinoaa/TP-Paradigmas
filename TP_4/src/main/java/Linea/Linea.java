package Linea;

import Linea.Chips.Chip;
import Linea.Chips.Red;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class Linea {

    public ArrayList<ArrayList> board = new ArrayList<>();

    public int altura;
    public int base;

    public char modo;

    public Linea(int base, int altura, char modo) {
        IntStream.range(0, base).forEach(i -> {
            board.add(new ArrayList<Chip>());
        });

        this.altura = altura;
        this.base = base;
        this.modo = modo;
    }
    public int boardColumns() {
        return base;
    }

    public int columnChips(int column) {
        return board.get(column).size();
    }

    public String show() {
        String result = "";

        for (int i = 0; i < altura; i++) {
            String line = "| ";
            for (int j = 0; j < base; j++){
                if (board.get(j).size() >= altura - i) {
                    line += " X "; // deberia recivir el valor de la ficha
                } else {
                    line += " A "; // vacio
                }
            }
            result += line + " |\n";
        }
        result += "| ";
        for (int i = 0; i < base; i++) {
            result += " ^ ";
        }
        result += " |\n";

        return result;
    }

    public boolean finished() {
        return false;
    }

    public void playRedkAt(int prompt) {
    }

    public void playBlueAt(int prompt) {
    }

    public void playRedAt(int i) {
        board.get(i).add(new Red());
    }


}
