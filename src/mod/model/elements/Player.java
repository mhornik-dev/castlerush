package mod.model.elements;

import mod.model.events.Move;
import mod.util.GameConstants;

public class Player extends Element {
    private int energie = GameConstants.PLAYER_START_ENERGY;
    private int gold = GameConstants.PLAYER_START_MONEY;

    public Player(Position position) {
        super(position, ElementType.PLAYER);
    }

    public int getEnergie() { return energie; }
    public int getGold() { return gold; }

    public void move(Move verschiebung) {
        this.position = this.position.changePosition(verschiebung);
        reduceEnergie();
    }

    public void addEnergie(int energie) {
        this.energie = Math.min(this.energie + energie, GameConstants.PLAYER_MAX_ENERGY);
    }

    public void reduceEnergie() {
        this.energie = Math.max(this.energie - GameConstants.PLAYER_MOVE_ENERGY, 0);
    }
    
    public void reduceEnergie(int energie) {
        this.energie = Math.max(this.energie - energie, 0);
    }

    public void addGold(int value) {
        this.gold += value;
    }

    @Override
    public String toString() {
        return "Gold: " + getGold() +
               ", Energie: " + getEnergie();
    }
}
