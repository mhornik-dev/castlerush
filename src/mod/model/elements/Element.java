/**
 * Abstrakte Basisklasse für alle Elemente im Spiel, die zeichnungsfähig sind.
 * Implementiert {@link DrawableElement} und enthält grundlegende Eigenschaften wie Position
 * und Typ des Elements.
 * <p>
 * Konkrete Unterklassen sind {@code Player} und {@code Treasure}.
 * </p>
 * 
 * @author Milos Hornik
 */
package mod.model.elements;

import mod.interfaces.DrawableElement;

public abstract class Element implements DrawableElement {
    
    protected Position position;
    private ElementType elementType;

    /**
     * Konstruktor für ein Element mit gegebener Position und Typ.
     * @param position Die Position des Elements im Spielfeld.
     * @param elementType Der Typ des Elements.
     */
    public Element(Position position, ElementType elementType) {
        this.position = position;
        this.elementType = elementType;
    }

    /**
     * Standardkonstruktor für ein Element mit Position (0,0) und Typ {@code NONE}.
     */
    public Element() {
        this(new Position(0, 0), ElementType.NONE);
    }

    /**
     * Gibt die aktuelle Position des Elements zurück.
     * @return Die Position des Elements.
     */
    @Override
    public Position getPosition() { return this.position; }

    /**
     * Gibt den Typ des Elements zurück.
     * @return Der {@link ElementType} dieses Elements.
     */
    @Override
    public ElementType getElementType() { return this.elementType; }

    /**
     * Setzt die Position des Elements.
     * @param position Die neue Position.
     */
    public void setPosition(Position position) {
        this.position = position;
    }

    /**
     * Setzt den Typ des Elements.
     * @param elementType Der neue Elementtyp.
     */
    public void setElementType(ElementType elementType) {
        this.elementType = elementType;
    }

    /**
     * Aufzählung aller möglichen Elementtypen im Spiel.
     */
    public enum ElementType {
        APPLE,
        BONE,
        HEART,
        CASTLE,
        DIAMOND,
        COIN,
        PLAYER,
        TREE,
        NONE,
    }

}
