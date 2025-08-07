/**
 * Schnittstelle zur Abbildung von Tastendrücken auf Bewegungsaktionen.
 * <p>
 * Die {@code KeyMapper}-Schnittstelle definiert Methoden, die jeweils einer
 * Bewegungsrichtung entsprechen und bei der Betätigung der zugeordneten Taste
 * aufgerufen werden.
 *
 * @author Milos Hornik
 */
package mod.interfaces;

public interface KeyMapper {
    /**
     * Wird aufgerufen, wenn die Taste für die Bewegung nach links gedrückt wird.
     */
    void moveLeftKey();

    /**
     * Wird aufgerufen, wenn die Taste für die Bewegung nach rechts gedrückt wird.
     */
    void moveRightKey();

    /**
     * Wird aufgerufen, wenn die Taste für die Bewegung nach oben gedrückt wird.
     */
    void moveUpKey();

    /**
     * Wird aufgerufen, wenn die Taste für die Bewegung nach unten gedrückt wird.
     */
    void moveDownKey();
}