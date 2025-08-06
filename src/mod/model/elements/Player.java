/**
 * Stellt den Spieler im Spiel dar, als spezielles {@link Element} mit
 * Energie- und Goldwerten.
 * <p>
 * Der Spieler startet mit festgelegter Anfangsenergie und Startkapital,
 * welche durch {@link GameConstants} definiert sind. Der Spieler kann sich
 * bewegen, Energie aufnehmen oder verlieren sowie Gold sammeln.
 * </p>
 * 
 * @author Milos Hornik
 */
package mod.model.elements;

import mod.model.events.Move;
import mod.util.GameConstants;

public class Player extends Element {
    private int energie = GameConstants.PLAYER_START_ENERGY;
    private int gold = GameConstants.PLAYER_START_MONEY;

    /**
     * Konstruktor für den Spieler mit Startposition.
     * @param position Die Startposition des Spielers im Spielfeld.
     */
    public Player(Position position) {
        super(position, ElementType.PLAYER);
    }

    /**
     * Gibt die aktuelle Energie des Spielers zurück.
     * @return Die Energie des Spielers.
     */
    public int getEnergie() { return energie; }

    /**
     * Gibt das aktuelle Gold des Spielers zurück.
     * @return Das Gold des Spielers.
     */
    public int getGold() { return gold; }

    /**
     * Verschiebt den Spieler um eine bestimmte {@link Move}-Richtung
     * und reduziert die Energie entsprechend.
     * @param verschiebung Die Richtung der Bewegung.
     */
    public void move(Move verschiebung) {
        this.position = this.position.changePosition(verschiebung);
        reduceEnergie();
    }

    /**
     * Erhöht die Energie des Spielers, maximal bis zum definierten
     * Maximalwert {@link GameConstants#PLAYER_MAX_ENERGY}.
     * @param energie Die zu addierende Energiemenge.
     */
    public void addEnergie(int energie) {
        this.energie = Math.min(this.energie + energie, GameConstants.PLAYER_MAX_ENERGY);
    }

    /**
     * Verringert die Energie des Spielers um den Standardwert
     * {@link GameConstants#PLAYER_MOVE_ENERGY}, mindestens auf 0.
     */
    public void reduceEnergie() {
        this.energie = Math.max(this.energie - GameConstants.PLAYER_MOVE_ENERGY, 0);
    }
    
    /**
     * Verringert die Energie des Spielers um eine angegebene Menge,
     * mindestens auf 0.
     * @param energie Die Energiemenge, um die reduziert wird.
     */
    public void reduceEnergie(int energie) {
        this.energie = Math.max(this.energie - energie, 0);
    }

    /**
     * Erhöht den Goldwert des Spielers um den angegebenen Wert.
     * @param value Die Menge an Gold, die hinzugefügt wird.
     */
    public void addGold(int value) {
        this.gold += value;
    }

    /**
     * Gibt eine String-Repräsentation des Spielers mit Gold- und Energieangaben zurück.
     * @return String mit aktuellem Gold und Energie.
     */
    @Override
    public String toString() {
        return "Gold: " + getGold() +
               ", Energie: " + getEnergie();
    }
}
