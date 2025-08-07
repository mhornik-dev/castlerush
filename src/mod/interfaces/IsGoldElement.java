/**
 * Schnittstelle für Spielelemente, die einen Goldwert besitzen.
 * <p>
 * Implementierende Klassen stellen eine Methode zur Verfügung, um den Goldwert des Elements zu ermitteln.
 * 
 * @author Milos Hornik
 */
package mod.interfaces;

public interface IsGoldElement {
    /**
     * Gibt den Goldwert dieses Elements zurück.
     *
     * @return der Goldwert
     */
    int getValue();
}