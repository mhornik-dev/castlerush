package mod.model.elements;

import mod.interfaces.IsEnergieElement;
import mod.util.GameConstants;

public class Apple extends Treasure implements IsEnergieElement {

    private final int energie = GameConstants.ENERGY_APPLE;

    public Apple(Position ort, boolean drawAsTree) {
        super(ort, ElementType.APPLE);
        setDrawAsTree(drawAsTree);
    }

    @Override
    public int getEnergie() { return energie; }

}

