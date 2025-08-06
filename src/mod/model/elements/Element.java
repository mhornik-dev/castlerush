package mod.model.elements;

import mod.interfaces.DrawableElement;

public abstract class Element implements DrawableElement {
    
    protected Position position;
    private ElementType elementType;

    public Element(Position position, ElementType elementType) {
        this.position = position;
        this.elementType = elementType;
    }

    public Element() {
        this(new Position(0, 0), ElementType.NONE);
    }

    @Override
    public Position getPosition() { return this.position; }

    @Override
    public ElementType getElementType() { return this.elementType; }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setElementType(ElementType elementType) {
        this.elementType = elementType;
    }

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

