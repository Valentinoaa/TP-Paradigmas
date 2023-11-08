package Linea;

public class Finished extends Turn {

    @Override
    public Turn playRedChipIn(int column, Linea game) {
        throw new RuntimeException(YA_TERMINO_EL_JUEGO);
    }

    @Override
    public Turn playBlueChipIn(int column, Linea game) {
        throw new RuntimeException(YA_TERMINO_EL_JUEGO);
    }

    @Override
    public boolean finished() {
        return true;
    }
}
