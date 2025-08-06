package mod.model.elements;
import mod.interfaces.IsGoldElement;
import mod.util.GameConstants;

public class Coin extends Treasure implements IsGoldElement {

    private final int value = GameConstants.GOLD_COIN;

    public Coin(Position ort, boolean drawAsTree) {
        super(ort, ElementType.COIN);
        setDrawAsTree(drawAsTree);
    }

    @Override
    public int getValue() { return value; }

}
