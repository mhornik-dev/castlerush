/**
 * Schnittstelle für Spielelemente, die Energie liefern oder verbrauchen.
 * <p>
 * Implementierende Klassen stellen eine Methode zur Verfügung, um den Energiewert des Elements zu ermitteln.
 * 
 * @author Milos Hornik
 */
package mod.interfaces;

public interface IsEnergieElement {
    /**
     * Gibt den Energiewert dieses Elements zurück.
     *
     * @return der Energiewert (positiv oder negativ)
     */
    int getEnergie();
}