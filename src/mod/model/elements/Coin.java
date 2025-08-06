/**
 * Stellt ein Münz-Element im Spiel dar, welches eine Art von {@link Treasure} ist
 * und einen Goldwert für den Spieler besitzt. Implementiert {@link IsGoldElement}.
 * <p>
 * Der Goldwert einer Münze ist durch {@link GameConstants#GOLD_COIN} definiert.
 * </p>
 * 
 * @author Milos Hornik
 */
package mod.model.elements;

import mod.interfaces.IsGoldElement;
import mod.util.GameConstants;

public class Coin extends Treasure implements IsGoldElement {

    private final int value = GameConstants.GOLD_COIN;

    /**
     * Konstruktor für ein Münz-Element.
     * @param ort Die Position der Münze im Spielfeld.
     * @param drawAsTree Gibt an, ob die Münze als Baum dargestellt werden soll.
     */
    public Coin(Position ort, boolean drawAsTree) {
        super(ort, ElementType.COIN);
        setDrawAsTree(drawAsTree);
    }

    /**
     * Gibt den Goldwert der Münze zurück.
     * @return Der Goldwert der Münze.
     */
    @Override
    public int getValue() { return value; }

}
