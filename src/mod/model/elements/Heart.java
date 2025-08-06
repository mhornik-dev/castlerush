/**
 * Stellt ein Herz-Element im Spiel dar, welches eine Art von {@link Treasure} ist
 * und dem Spieler Energie liefert. Implementiert {@link IsEnergieElement}.
 * <p>
 * Der Energiewert eines Herzens ist durch {@link GameConstants#ENERGY_HEART} definiert.
 * </p>
 * 
 * @author Milos Hornik
 */
package mod.model.elements;

import mod.interfaces.IsEnergieElement;
import mod.util.GameConstants;

public class Heart extends Treasure implements IsEnergieElement {

    private final int energie = GameConstants.ENERGY_HEART;

    /**
     * Konstruktor für ein Herz-Element.
     * @param ort Die Position des Herzens im Spielfeld.
     * @param drawAsTree Gibt an, ob das Herz als Baum dargestellt werden soll.
     */
    public Heart(Position ort, boolean drawAsTree) {
        super(ort, ElementType.HEART);
        setDrawAsTree(drawAsTree);
    }

    /**
     * Gibt den Energiewert des Herzens zurück.
     * @return Der Energiewert des Herzens.
     */
    @Override
    public int getEnergie() { return energie; }

}
