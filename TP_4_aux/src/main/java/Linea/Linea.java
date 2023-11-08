package Linea;
import java.util.ArrayList;
import java.util.stream.IntStream;

public class Linea {

    public static final char RED_CHAR = 'R';
    public static final char BLUE_CHAR = 'B';

    public char winner;
    public ArrayList<ArrayList> board = new ArrayList<>();

    public int altura;
    public int base;
    public GameMode mode;
    public Turn turn = new RedTurn();

    public Linea(int base, int altura, char mode) {
        IntStream.range(0, base).forEach(i -> {
            board.add(new ArrayList<Character>());
        });

        this.altura = altura;
        this.base = base;
        this.mode = setMode(mode);
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
        return turn.finished();
    }

    public void playRedAt(int column) {
        if (column >= base || column < 0 || columnIsFull(column)) {
            throw new RuntimeException("Columna invalida");
        }

        turn = turn.playRedChipIn(column, this);

        this.didPlayerWin(RED_CHAR, this);
    }

    private void didPlayerWin(char player, Linea game) {
        mode.didPlayerWin(player, this);
    }


    public void playBlueAt(int column) {
        if (column >= base || column < 0 || columnIsFull(column)) {
            throw new RuntimeException("Columna invalida");
        }

        turn = turn.playBlueChipIn(column, this);

        didPlayerWin(BLUE_CHAR, this);
    }

    private boolean columnIsFull(int column) {
        return getColumn(column).size() == altura;
    }


    public boolean itsRedsTurn() {
        return turn.itsRedTurn();
    }

    public boolean itsBluesTurn() {
        return turn.itsBlueTurn();
    }

    public boolean lastChipInColumnIsRed(int i) {
        return getColumn(i).get(getColumn(i).size() - 1) == RED_CHAR;
    }

    public boolean lastChipInColumnIsBlue(int i) {
        return getColumn(i).get(getColumn(i).size() - 1) == BLUE_CHAR;
    }

    public void playRedChipIn(int column) {
        getColumn(column).add(RED_CHAR);
    }

    public void playBlueChipIn(int column) {
        getColumn(column).add(BLUE_CHAR);
    }

    public boolean fourInARowInColumn(char chip) {
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
        return false;

}

    public char getGameMode() {
        return mode.getMode();
    }

    public void setWinner(char player) {
        winner = player;
        turn = new Finished();
    }

    public boolean fourInARowInDiagonal(char player) {
        for (int i = 0; i < altura; i++){
            for (int j = 0; j < base; j++){

            }
        }
    }
}
