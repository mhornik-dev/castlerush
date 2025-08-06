/**
 * Stellt ein Diamant-Element im Spiel dar, welches eine Art von {@link Treasure} ist
 * und einen hohen Goldwert für den Spieler besitzt. Implementiert {@link IsGoldElement}.
 * <p>
 * Der Goldwert eines Diamanten ist durch {@link GameConstants#GOLD_DIAMOND} definiert.
 * </p>
 * 
 * @author Milos Hornik
 */
package mod.model.elements;

import mod.interfaces.IsGoldElement;
import mod.util.GameConstants;

public class Diamond extends Treasure implements IsGoldElement {

    private final int value = GameConstants.GOLD_DIAMOND;

    /**
     * Konstruktor für ein Diamant-Element.
     * @param ort Die Position des Diamanten im Spielfeld.
     * @param drawAsTree Gibt an, ob der Diamant als Baum dargestellt werden soll.
     */
    public Diamond(Position ort, boolean drawAsTree) {
        super(ort, ElementType.DIAMOND);
        setDrawAsTree(drawAsTree);
    }

    /**
     * Gibt den Goldwert des Diamanten zurück.
     * @return Der Goldwert des Diamanten.
     */
    @Override
    public int getValue() { return value; }

}
