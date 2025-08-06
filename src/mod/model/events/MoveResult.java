package mod.model.events;

import mod.model.elements.Position;

public record MoveResult(
    Position newPosition,
    int energyUsed,
    boolean moved,
    FailReason failReason
) {
    public enum FailReason {
        NONE,          
        OBSTACLE,       
        ENERGY_NOT_ENOUGH,
        OUT_OF_BOUNDS,
    }

    public static MoveResult success(Position newPosition, int energyUsed) {
        return new MoveResult(newPosition, energyUsed, true, FailReason.NONE);
    }

    public static MoveResult failure(Position playerPosition, FailReason failReason) {
        return new MoveResult(playerPosition, 0, false, failReason);
    }
}