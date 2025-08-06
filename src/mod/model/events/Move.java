/**
 * Repräsentiert eine Verschiebung bzw. Bewegung in einem zweidimensionalen
 * Koordinatensystem.
 * <p>
 * Die Bewegung wird durch x- und y-Komponenten definiert, die
 * positive oder negative Werte annehmen können.
 * </p>
 * 
 * @author Milos Hornik
 */
package mod.model.events;

public class Move {
    private int x;
    private int y;

    /**
     * Standardkonstruktor, initialisiert die Bewegung mit (0,0).
     */
    public Move() {
        this(0, 0);
    }

    /**
     * Konstruktor für eine Bewegung mit spezifischen x- und y-Werten.
     * @param x Die Verschiebung auf der x-Achse.
     * @param y Die Verschiebung auf der y-Achse.
     */
    public Move(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Gibt die Verschiebung auf der x-Achse zurück.
     * @return Die x-Komponente der Bewegung.
     */
    public int getX() { return x; }

    /**
     * Gibt die Verschiebung auf der y-Achse zurück.
     * @return Die y-Komponente der Bewegung.
     */
    public int getY() { return y; }

}
