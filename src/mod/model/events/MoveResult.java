/**
 * Repräsentiert das Ergebnis einer Bewegungsaktion im Spiel.
 * <p>
 * Enthält die neue Position nach der Bewegung, die verbrauchte Energie,
 * einen Erfolgsindikator und den Grund eines möglichen Fehlschlags.
 * </p>
 * 
 * @author Milos Hornik
 */
package mod.model.events;

import mod.model.elements.Position;

public record MoveResult(
    Position newPosition,
    int energyUsed,
    boolean moved,
    FailReason failReason
) {
    /**
     * Enumeration der möglichen Gründe für das Scheitern einer Bewegung.
     */
    public enum FailReason {
        /** Keine Fehler, Bewegung erfolgreich. */
        NONE,          
        /** Bewegung durch Hindernis blockiert. */
        OBSTACLE,       
        /** Nicht genügend Energie für Bewegung vorhanden. */
        ENERGY_NOT_ENOUGH,
        /** Bewegung führt aus Spielfeld hinaus. */
        OUT_OF_BOUNDS,
    }

    /**
     * Erzeugt ein erfolgreiches Bewegungsergebnis.
     * @param newPosition Die neue Position nach der Bewegung.
     * @param energyUsed Die dabei verbrauchte Energie.
     * @return Ein MoveResult mit Erfolg.
     */
    public static MoveResult success(Position newPosition, int energyUsed) {
        return new MoveResult(newPosition, energyUsed, true, FailReason.NONE);
    }

    /**
     * Erzeugt ein fehlgeschlagenes Bewegungsergebnis.
     * @param playerPosition Die Position des Spielers vor der Bewegung.
     * @param failReason Der Grund des Fehlschlags.
     * @return Ein MoveResult mit Fehlschlag.
     */
    public static MoveResult failure(Position playerPosition, FailReason failReason) {
        return new MoveResult(playerPosition, 0, false, failReason);
    }
}
