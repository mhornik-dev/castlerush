/**
 * Abstrakte Basisklasse für Schatz-Elemente im Spiel.
 * Erbt von {@link Element} und erweitert um Eigenschaften,
 * ob das Schatz-Element als Baum dargestellt wird und ob es
 * bereits gefunden wurde.
 * <p>
 * Wird von den konkreten Schatztypen {@code Apple}, {@code Bone}, {@code Castle}, {@code Coin}, {@code Diamond} und {@code Heart} erweitert.
 * </p>
 * 
 * @author Milos Hornik
 */
package mod.model.elements;

public abstract class Treasure extends Element {
    
    private boolean drawAsTree = false;
    private boolean isFound = false;

    /**
     * Konstruktor für ein Schatz-Element mit Position und Typ.
     * @param position Die Position des Schatzes im Spielfeld.
     * @param elementType Der Typ des Schatzes.
     */
    public Treasure(Position position, ElementType elementType) {
        super(position, elementType);
    }

    /**
     * Gibt zurück, ob das Schatz-Element als Baum dargestellt wird.
     * @return {@code true}, wenn als Baum gezeichnet wird; sonst {@code false}.
     */
    public boolean getDrawAsTree() { return drawAsTree; }

    /**
     * Setzt, ob das Schatz-Element als Baum dargestellt werden soll.
     * @param drawAsTree {@code true} für Baum-Darstellung, sonst {@code false}.
     */
    public void setDrawAsTree(boolean drawAsTree) { 
        this.drawAsTree = drawAsTree; 
    }

    /**
     * Gibt zurück, ob das Schatz-Element bereits gefunden wurde.
     * @return {@code true}, wenn gefunden; sonst {@code false}.
     */
    public boolean getIsFound() { return isFound; }

    /**
     * Setzt den Status, ob das Schatz-Element gefunden wurde.
     * @param found {@code true}, wenn gefunden; sonst {@code false}.
     */
    public void setIsFound(boolean found) {
        isFound = found;
    }

    /**
     * Überschreibt den Elementtyp: Wenn das Element als Baum dargestellt wird,
     * wird {@link ElementType#TREE} zurückgegeben, ansonsten der normale Typ.
     * @return Der aktuelle Elementtyp oder {@link ElementType#TREE} bei Baum-Darstellung.
     */
    @Override
    public ElementType getElementType() {
        return getDrawAsTree() ? ElementType.TREE : super.getElementType();
    }
    
}
