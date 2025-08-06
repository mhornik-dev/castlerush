/**
 * Repräsentiert eine Position im zweidimensionalen Koordinatensystem.
 * <p>
 * Die Position besteht aus x- und y-Koordinaten und kann durch eine
 * {@link Move}-Verschiebung verändert werden.
 * </p>
 * 
 * @author Milos Hornik
 */
package mod.model.elements;

import mod.model.events.Move;

public class Position {
    
    private int x;
    private int y;

    /**
     * Standardkonstruktor, initialisiert Position mit (0,0).
     */
    public Position() {
        this(0, 0);
    }

    /**
     * Konstruktor mit spezifischen Koordinaten.
     * @param x Die x-Koordinate.
     * @param y Die y-Koordinate.
     */
    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Gibt die x-Koordinate zurück.
     * @return Die x-Koordinate.
     */
    public int getX() { return x; }

    /**
     * Setzt die x-Koordinate.
     * @param x Die neue x-Koordinate.
     */
    public void setX(int x) {
        this.x = x;
    }

    /**
     * Gibt die y-Koordinate zurück.
     * @return Die y-Koordinate.
     */
    public int getY() { return y; }

    /**
     * Setzt die y-Koordinate.
     * @param y Die neue y-Koordinate.
     */
    public void setY(int y) {
        this.y = y;
    }

    /**
     * Erzeugt eine neue Position, die durch Verschiebung der aktuellen Position
     * um die Werte aus {@link Move} entsteht.
     * @param verschiebung Die Verschiebung der Position.
     * @return Die neue Position nach der Verschiebung.
     */
    public Position changePosition(Move verschiebung) {
        return new Position(this.x + verschiebung.getX(), this.y + verschiebung.getY());
    }

    /**
     * Gibt eine String-Repräsentation der Position im Format (x|y) zurück.
     * @return String-Darstellung der Position.
     */
    @Override
    public String toString() {
        return "(" + x + "|" + y + ")";
    }

    /**
     * Prüft, ob diese Position gleich einer anderen ist.
     * Zwei Positionen sind gleich, wenn x- und y-Koordinaten identisch sind.
     * @param obj Das zu vergleichende Objekt.
     * @return {@code true}, wenn gleich; sonst {@code false}.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Position)) return false;
        Position other = (Position) obj;
        return this.x == other.x && this.y == other.y;
    }

    /**
     * Berechnet den Hashcode basierend auf x- und y-Koordinate.
     * @return Der Hashcode der Position.
     */
    @Override
    public int hashCode() {
        return 3 * x + y;
    }
    
}
