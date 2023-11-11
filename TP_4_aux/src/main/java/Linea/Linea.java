package Linea;
import Linea.gameMode.GameMode;
import Linea.turn.Finished;
import Linea.turn.RedTurn;
import Linea.turn.Turn;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class Linea {

    public static final char RED_CHAR = 'R';
    public static final char BLUE_CHAR = 'B';
    public static final String TIE = "Es un empate";
    public static final String INVALID_COLUMN = "Columna invalida";
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

 /*   public String show() {
        String result = "";

        for (int i = altura - 1; i >= 0; i--) {
            String line = "| ";
            for (int j = 0; j < base; j++) {
                    line += " " + buscarCoord(j,i) + " ";
            }
            result += line + " |\n";
        }
        result += "| ";
        for (int i = 0; i < base; i++) {
            result += " ^ ";
        }
        result += " |\n";

        return result;
    }*/

    public String show() {
        return IntStream.range(0 , altura)
                .mapToObj(i -> IntStream.range(0, base)
                        .mapToObj(j -> " " + buscarCoord(altura - i, base - j) + " ")
                        .reduce("| ", (a, b) -> a + b) + " |\n")
                .reduce("", (a, b) -> a + b) + "| " + IntStream.range(0, base).mapToObj(i -> " ^ ").reduce("", (a, b) -> a + b) + " |\n";
    }


    public int boardColumns() {
        return base;
    }

    public int columnChips(int column) {
        return board.get(column - 1).size();
    }

    public ArrayList<Character> getColumn(int column) {
        return board.get(column);
    }

    public boolean finished() {
        return turn.finished();
    }

    public void playRedAt(int column) {
        column -= 1;
        if (column >= base || column < 0 || columnIsFull(column)) {
            throw new RuntimeException(INVALID_COLUMN);
        }
        turn = turn.playRedChipIn(column, this);
        didPlayerWin(RED_CHAR, this);

        // Se puede sacar esto
        if (itsADraw()) {
            turn = new Finished();
            throw new RuntimeException(TIE);
        }
    }
    public void playBlueAt(int column) {
        column -= 1;
        if (column >= base || column < 0 || columnIsFull(column)) {
            throw new RuntimeException(INVALID_COLUMN);
        }
        turn = turn.playBlueChipIn(column, this);
        didPlayerWin(BLUE_CHAR, this);
        // Lo mismo acá
        if (itsADraw()) {
            turn = new Finished();
            throw new RuntimeException(TIE);
        }
    }

    private void didPlayerWin(char player, Linea game) {
        mode.didPlayerWin(player, this);
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
        i -= 1;
        return getColumn(i).get(getColumn(i).size() - 1) == RED_CHAR;
    }

    public boolean lastChipInColumnIsBlue(int i) {
        i -= 1;
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
            int counter = 0;
            for (int j = 0; j < boardColumns(); j++) {
                if (!(i >= getColumn(j).size())) {
                    if (getColumn(j).get(i) == (chip)) {
                        counter += 1;
                    } else {
                        counter = 0;
                    }
                    if (counter >= 4) {
                        return true;
                    }
                }

            }
        }
        return false;
    }

/*    public boolean fourInARowInDiagonal(char player) {
        for (int r = 0; r < base; r++){
            int counter = 0;
            for (int h = 0; h < base; h++ ){
                if (buscarCoord(r + h, h) == player){
                    counter += 1;
                    if (counter >= 4){
                        return true;
                    }
                }
                else {
                    counter = 0;
                }
            }
        }
        return false;
    }*/

 /*   public boolean fourInARowInColumn(char player) {
        return IntStream.range(0, boardColumns())
                .anyMatch(i -> IntStream.range(0, getColumn(i).size() - 3)
                        .anyMatch(j ->
                                IntStream.range(0, 4)
                                        .allMatch(k -> buscarCoord(i, j + k) == player)
                        )
                );
    }
    public boolean fourInARowInRow(char player) {
        return IntStream.range(0, boardColumns())
                .anyMatch(i -> IntStream.range(0, boardColumns() - 3)
                        .anyMatch(j ->
                                IntStream.range(0, 4)
                                        .allMatch(k -> buscarCoord(j + k, i) == player)
                        )
                );
    }*/
    public boolean fourInARowInDiagonal(char player) {
        return IntStream.range(0, boardColumns())
                .anyMatch(i -> IntStream.range(0, boardColumns() - 3)
                        .anyMatch(j ->
                                IntStream.range(0, 4)
                                        .allMatch(k -> buscarCoord(j + k, i + k) == player)
                        )
                )
                || IntStream.range(0, boardColumns())
                .anyMatch(i -> IntStream.range(0, boardColumns() - 3)
                .anyMatch(j -> IntStream.range(0, 4)
                .allMatch(k -> buscarCoord(j + k, i - k) == player)));
    }

    public char getGameMode() {
        return mode.getMode();
    }

    public void setWinner(char player) {
        winner = player;
        turn = new Finished();
    }


    private Character buscarCoord(int x, int y) {
        if (x >= 0 && x < base && y >= 0 && y < base) {
            if (getColumn(x).size() > y) {
                return getColumn(x).get(y);
            }
        }
        return '-';
    }

    public boolean itsADraw() {
        return IntStream.range(0, boardColumns())
                .allMatch(i -> getColumn(i).size() == altura);
    }
}
