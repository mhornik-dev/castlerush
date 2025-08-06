package mod.model.elements;

public class Castle extends Treasure {
    public Castle(Position ort, boolean drawAsTree) {
        super(ort, ElementType.CASTLE);
        setDrawAsTree(drawAsTree);
    }

}
