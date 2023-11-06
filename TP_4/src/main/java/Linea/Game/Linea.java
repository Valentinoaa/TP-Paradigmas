package Linea.Game;
import Linea.Modo.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Linea {

    public ArrayList<ArrayList> board = new ArrayList<>();

    public int altura;
    public int base;
    public GameMode mode;

    public boolean finished = false;
    public Turn turn = new Turn();

    public Linea(int base, int altura, char mode) {
        IntStream.range(0, base).forEach(i -> {
            board.add(new ArrayList<Character>());
        });

        this.altura = altura;
        this.base = base;
        this.mode = setMode(mode);
        this.turn.setTurn("R");
    }

    private GameMode setMode(char mode) {
        return GameMode.modeFor(mode);

    }

    public String show() {
        String result = "";

        for (int i = 0; i < altura; i++) {
            String line = "| ";
            for (int j = 0; j < base; j++) {
                if (board.get(j).size() >= altura - i) {
                    line += " X ";
                } else {
                    line += " A ";
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

    public int boardColumns() {
        return base;
    }

    public int columnChips(int column) {
        return board.get(column).size();
    }

    public ArrayList<Character> getColumn(int column) {
        return board.get(column);
    }


    public boolean finished() {
        return finished;
    }

    public void playRedAt(int column) {
        if (finished()) {
            throw new RuntimeException("El juego ya termino");
        }
        if (turn.itsBlueTurn()) {
            throw new RuntimeException("No es turno de rojo");
        } else {
            playRedChipIn(column);
            if (fourInARowInColumn('R') {
                finished = true;
            }
            setTurn("B");
        }
    }


    public void playBlueAt(int column) {
        if (finished) throw new RuntimeException("El juego ya termino");
        if (turn.itsRedTurn()) {
            throw new RuntimeException("No es turno de azul");
        } else {
            playBlueChipIn(column);
            if (fourInARowInColumn('B')) {
                finished = true;
            }
            setTurn("R");
        }
    }


    public void setTurn(String t) {
        turn.setTurn(t);
    }

    public boolean itsRedsTurn() {
        return turn.itsRedTurn();
    }

    public boolean itsBluesTurn() {
        return turn.itsBlueTurn();
    }

    public boolean lastChipInColumnIsRed(int i) {
        return getColumn(i).get(getColumn(i).size() - 1) == 'R';
    }

    public boolean lastChipInColumnIsBlue(int i) {
        return getColumn(i).get(getColumn(i).size() - 1) == 'B';
    }

    public void playRedChipIn(int column) {
        getColumn(column).add('R');
    }

    public void playBlueChipIn(int column) {
        getColumn(column).add('B');
    }

    private boolean fourInARowInColumn(char chip) {
        for (int i = 0; i < boardColumns(); i++) {
            ArrayList<Character> column = getColumn(i);
            int counter = 0;

            for (int j = 0; j < column.size(); j++) {
                if (column.get(j).equals(chip)) {
                    counter += 1;
                } else {
                    counter = 0;
                }

            }
            if (counter >= 4) {
                return true;
            }
        }
        return false;
    }

    public boolean fourInARowInRow(Character chip) {
        for (int i = 0; i < boardColumns(); i++) {
            for (int j = 0; i < boardColumns(); i++) {
                if (board.get(i).get(j) == (chip)) {
                    return true;
                }
            }
    }
}
