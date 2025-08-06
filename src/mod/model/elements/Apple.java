/**
 * Stellt ein Apfel-Element im Spiel dar, welches eine Art von {@link Treasure} ist
 * und dem Spieler Energie liefert. Implementiert {@link IsEnergieElement}.
 * <p>
 * Der Energiewert eines Apfels ist durch {@link GameConstants#ENERGY_APPLE} definiert.
 * </p>
 *
 * @author Milos Hornik
 */
package mod.model.elements;

import mod.interfaces.IsEnergieElement;
import mod.util.GameConstants;

public class Apple extends Treasure implements IsEnergieElement {

    private final int energie = GameConstants.ENERGY_APPLE;

    /**
     * Konstruktor für ein Apfel-Element.
     * @param ort Die Position des Apfels im Spielfeld.
     * @param drawAsTree Gibt an, ob der Apfel als Baum dargestellt werden soll.
     */
    public Apple(Position ort, boolean drawAsTree) {
        super(ort, ElementType.APPLE);
        setDrawAsTree(drawAsTree);
    }
    /**
     * Konstruktor für ein Apfel-Element mit Standardposition.
     * @param drawAsTree Gibt an, ob der Apfel als Baum dargestellt werden soll.
     */
    public Apple(boolean drawAsTree) {
        this(new Position(0, 0), drawAsTree);
    }
    
    /**
     * Gibt den Energiewert des Apfels zurück.
     * @return Der Energiewert des Apfels.
     */
    @Override
    public int getEnergie() { return energie; }

}