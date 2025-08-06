package mod.model.elements;


public abstract class Treasure extends Element {
    
    private boolean drawAsTree = false;
    private boolean isFound = false;

    public Treasure(Position position, ElementType elementType) {
        super(position, elementType);
    }

    public boolean getDrawAsTree() { return drawAsTree; }

    public void setDrawAsTree(boolean drawAsTree) { 
        this.drawAsTree = drawAsTree; 
    }

    public boolean getIsFound() { return isFound; }

    public void setIsFound(boolean found) {
        isFound = found;
    }

    @Override
    public ElementType getElementType() {
        return getDrawAsTree() ? ElementType.TREE : super.getElementType();
    }
    
}
