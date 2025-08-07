/**
 * Schnittstelle zum Starten eines neuen Spiels.
 * <p>
 * Implementierende Klassen müssen die Methode {@link #startNewGame()} bereitstellen, 
 * um ein neues Spiel zu initialisieren und zu starten.
 * 
 * @author Milos Hornik
 */
package mod.interfaces;

public interface StartInterface {
    /**
     * Startet ein neues Spiel und setzt die Anwendung in den Anfangszustand zurück.
     */
    void startNewGame();
}