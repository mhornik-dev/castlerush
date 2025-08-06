/**
 * Stellt ein Knochen-Element im Spiel dar, welches eine Art von {@link Treasure} ist
 * und dem Spieler Energie liefert. Implementiert {@link IsEnergieElement}.
 * <p>
 * Der Energiewert eines Knochens ist durch {@link GameConstants#ENERGY_BONE} definiert.
 * </p>
 * 
 * @author Milos Hornik
 */
package mod.model.elements;

import mod.interfaces.IsEnergieElement;
import mod.util.GameConstants;

public class Bone extends Treasure implements IsEnergieElement {

    private final int energie = GameConstants.ENERGY_BONE;

    /**
     * Konstruktor für ein Knochen-Element.
     * @param ort Die Position des Knochens im Spielfeld.
     * @param drawAsTree Gibt an, ob der Knochen als Baum dargestellt werden soll.
     */
    public Bone(Position ort, boolean drawAsTree) {
        super(ort, ElementType.BONE);
        setDrawAsTree(drawAsTree);
    }

    /**
     * Gibt den Energiewert des Knochens zurück.
     * @return Der Energiewert des Knochens.
     */
    @Override
    public int getEnergie() { return energie; }

}
