/**
 * Schnittstelle für grafisch darstellbare Spielelemente.
 * <p>
 * Ein {@code DrawableElement} besitzt eine Position und einen Elementtyp ({@link ElementType}).
 * Diese Schnittstelle wird von allen Spielelementen implementiert, die auf dem Spielfeld angezeigt werden können.
 * 
 * @author Milos Hornik
 */
package mod.interfaces;

import mod.model.elements.Element.ElementType;
import mod.model.elements.Position;

public interface DrawableElement {  
    /**
     * Gibt die Position des Elements auf dem Spielfeld zurück.
     *
     * @return die {@link Position} des Elements
     */
    Position getPosition();

    /**
     * Gibt den Typ des Elements zurück.
     *
     * @return der {@link ElementType} des Elements
     */
    ElementType getElementType();
}