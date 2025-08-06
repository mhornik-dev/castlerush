package mod.interfaces;

import mod.model.elements.Element.ElementType;
import mod.model.elements.Position;

public interface DrawableElement {  
    Position getPosition();
    ElementType getElementType();
}
