package mod.model.elements;
import mod.interfaces.IsGoldElement;
import mod.util.GameConstants;

public class Diamond extends Treasure implements IsGoldElement {

    private final int value = GameConstants.GOLD_DIAMOND;

    public Diamond(Position ort, boolean drawAsTree) {
        super(ort, ElementType.DIAMOND);
        setDrawAsTree(drawAsTree);
    }

    @Override
    public int getValue() { return value; }

}
