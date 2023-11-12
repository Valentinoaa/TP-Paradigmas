package Linea;
import Linea.gameMode.GameMode;
import Linea.turn.RedTurn;
import Linea.turn.Turn;

import java.util.ArrayList;
import java.util.stream.IntStream;

public class Linea {

    public static final char RED_CHAR = 'R';
    public static final char BLUE_CHAR = 'B';
    public static final String TIE = "Draw!";
    public static final String INVALID_COLUMN = "Invalid column!";
    public ArrayList<ArrayList> board = new ArrayList<>();

    public int height;
    public int base;
    public GameMode mode;
    public Turn turn = new RedTurn();

    public Linea(int base, int height, char mode) {
        IntStream.range(0, base).forEach(i -> {
            board.add(new ArrayList<Character>());
        });

        this.height = height;
        this.base = base;
        this.mode = setMode(mode);
    }

    public String show() {
        return IntStream.range(0 , height)
                .mapToObj(i -> IntStream.range(0, base)
                        .mapToObj(j -> " " + getChar(height - i, base - j) + " ")
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
        column --;
        turn = turn.playRedChipIn(column, this);
        checkGameIsFinished(RED_CHAR);
    }

    public void playBlueAt(int column) {
        column --;

        turn = turn.playBlueChipIn(column, this);
        checkGameIsFinished(BLUE_CHAR);

    }

    public void playBlueChipIn(int column) {
        // Codigo repetido
        if (column >= base || column < 0 || columnIsFull(column)) {
            throw new RuntimeException(INVALID_COLUMN);
        }
        getColumn(column).add(BLUE_CHAR);
    }
    public void playRedChipIn(int column) {
        if (column >= base || column < 0 || columnIsFull(column)) {
            throw new RuntimeException(INVALID_COLUMN);
        }
        getColumn(column).add(RED_CHAR);
    }
    private void checkGameIsFinished(char player) {
        mode.didPlayerWin(player, this);
    }

    private boolean columnIsFull(int column) {
        return getColumn(column).size() == height;
    }

    public boolean itsRedsTurn() {
        return turn.itsRedTurn();
    }

    public boolean itsBluesTurn() {
        return turn.itsBlueTurn();
    }


    public boolean fourInARowInColumn(char player) {
        return IntStream.range(0, boardColumns())
                .anyMatch(i -> IntStream.range(0, getColumn(i).size() - 3)
                        .anyMatch(j ->
                                IntStream.range(0, 4)
                                        .allMatch(k -> getChar(i, j + k) == player)
                        )
                );
    }

    public boolean fourInARowInRow(char player) {
        return IntStream.range(0, boardColumns())
                .anyMatch(i -> IntStream.range(0, boardColumns() - 3)
                        .anyMatch(j ->
                                IntStream.range(0, 4)
                                        .allMatch(k -> getChar(j + k, i) == player)
                        )
                );
    }

    public boolean fourInARowInDiagonal(char player) {
        return IntStream.range(0, boardColumns())
                .anyMatch(i -> IntStream.range(0, boardColumns())
                        .anyMatch(j ->
                                IntStream.range(0, 4)
                                        .allMatch(k -> getChar(j + k, i + k) == player)
                        )
                )
                || IntStream.range(0, boardColumns())
                .anyMatch(i -> IntStream.range(0, boardColumns() - 3)
                .anyMatch(j -> IntStream.range(0, 4)
                .allMatch(k -> getChar(j + k, i - k) == player)));
    }

    public boolean itsADraw() {
        return IntStream.range(1, boardColumns() + 1)
                .allMatch(i -> columnChips(i) == height);
    }


    private Character getChar(int x, int y) {
        if (x >= 0 && x < base && y >= 0 && y < base) {
            if (getColumn(x).size() > y) {
                return getColumn(x).get(y);
            }
        }
        return '-';
    }

    private GameMode setMode(char mode) {
        return GameMode.modeFor(mode);
    }
    public void setTurn(Turn turn) {
        this.turn = turn;
    }

    public boolean lastChipInColumnIsRed(int i) {
        i -= 1;
        return getColumn(i).get(getColumn(i).size() - 1) == RED_CHAR;
    }

    public boolean lastChipInColumnIsBlue(int i) {
        i -= 1;
        return getColumn(i).get(getColumn(i).size() - 1) == BLUE_CHAR;
    }

    public char getGameMode() {
        return mode.getMode();
    }

    public boolean isEmpty() {
        return IntStream.range(0, boardColumns())
                .allMatch(column -> getColumn(column).isEmpty());
    }
}
