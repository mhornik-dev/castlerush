package mod.model.elements;

import mod.interfaces.IsEnergieElement;
import mod.util.GameConstants;

public class Heart extends Treasure implements IsEnergieElement {

    private final int energie = GameConstants.ENERGY_HEART;

    public Heart(Position ort, boolean drawAsTree) {
        super(ort, ElementType.HEART);
        setDrawAsTree(drawAsTree);
    }

    @Override
    public int getEnergie() { return energie; }

}

