package mod.model.elements;

import mod.interfaces.IsEnergieElement;
import mod.util.GameConstants;

public class Bone extends Treasure implements IsEnergieElement {

    private final int energie = GameConstants.ENERGY_BONE;

    public Bone(Position ort, boolean drawAsTree) {
        super(ort, ElementType.BONE);
        setDrawAsTree(drawAsTree);
    }

    @Override
    public int getEnergie() { return energie; }

}
