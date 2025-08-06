/**
 * Stellt ein Schloss-Element im Spiel dar, welches eine Art von {@link Treasure} ist.
 * Schlösser sind besondere Spielfeldelemente, die als Ziel oder Dekoration dienen können.
 * <p>
 * Sie besitzen keine Energie-Funktionalität.
 * </p>
 * 
 * @author Milos Hornik
 */
package mod.model.elements;

public class Castle extends Treasure {
    /**
     * Konstruktor für ein Schloss-Element.
     * @param ort Die Position des Schlosses im Spielfeld.
     * @param drawAsTree Gibt an, ob das Schloss als Baum dargestellt werden soll.
     */
    public Castle(Position ort, boolean drawAsTree) {
        super(ort, ElementType.CASTLE);
        setDrawAsTree(drawAsTree);
    }

}
