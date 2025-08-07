/**
 * Die zentrale Steuerungsklasse für das Spiel.
 * <p>
 * Der {@code GameController} verwaltet den Spieler, die Spielelemente und die Spiellogik.
 * Er initialisiert das Spielfeld, prüft Bewegungen, verarbeitet Ereignisse und hält den Spielzustand.
 * Die Klasse interagiert mit dem {@link UIManager} zur Anzeige und nutzt verschiedene Modellelemente
 * wie {@link Player}, {@link Treasure}, {@link Castle}, {@link Apple}, {@link Bone}, {@link Heart}, {@link Diamond} und {@link Coin}.
 * 
 * @author Milos Hornik
 */
package mod.controller;

import java.util.List;
import java.util.Set;

import mod.interfaces.DrawableElement;
import mod.interfaces.IsEnergieElement;
import mod.interfaces.IsGoldElement;
import mod.interfaces.EventListener;
import mod.model.elements.Apple;
import mod.model.elements.Bone;
import mod.model.elements.Castle;
import mod.model.elements.Coin;
import mod.model.elements.Diamond;
import mod.model.elements.Element;
import mod.model.elements.Heart;
import mod.model.elements.Player;
import mod.model.elements.Position;
import mod.model.elements.Treasure;
import mod.model.events.Move;
import mod.model.events.MoveResult;
import mod.util.GameConstants;
import mod.view.controller.UIManager;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class GameController {

    private Player player;
    private UIManager uiController;
    private List<Element> elements;
    private EventListener eventListener;
    private Random random = new Random();
    private boolean gameOver = false;

    /**
     * Erstellt einen neuen GameController und initialisiert das Spielfeld mit Spieler und Elementen.
     *
     * @param uiController Referenz auf den UIManager zur Steuerung der Oberfläche
     */
    public GameController(UIManager uiController) {
        this.uiController = uiController;

        elements = new ArrayList<>();
        Set<Position> usedPositions = new HashSet<>();

        Position startPosition = getRandomPosition(usedPositions);
        player = new Player(startPosition);

        for (int i = 0; i < GameConstants.APPLE_COUNT; i++) {
            Position pos = getRandomPosition(usedPositions);
            elements.add(new Apple(pos, true));
        }

        for (int i = 0; i < GameConstants.BONE_COUNT; i++) {
            Position pos = getRandomPosition(usedPositions);
            elements.add(new Bone(pos, true));
        }

        Position castlePos = getRandomPosition(usedPositions);
        elements.add(new Castle(castlePos, true));

        for (int i = 0; i < GameConstants.HEART_COUNT; i++) {
            Position pos = getRandomPosition(usedPositions);
            elements.add(new Heart(pos, true));
        }

        for (int i = 0; i < GameConstants.DIAMOND_COUNT; i++) {
            Position pos = getRandomPosition(usedPositions);
            elements.add(new Diamond(pos, true));
        }

        for (int i = 0; i < GameConstants.COIN_COUNT; i++) {
            Position pos = getRandomPosition(usedPositions);
            elements.add(new Coin(pos, true));
        }
    }

    /**
     * Gibt zurück, ob das Spiel beendet ist.
     *
     * @return {@code true}, wenn das Spiel vorbei ist, sonst {@code false}
     */
    public boolean getIsGameOver() {
        return gameOver;
    }

    /**
     * Setzt den EventListener für Ereignisbenachrichtigungen.
     *
     * @param listener der zu setzende EventListener
     */
    public void setEventListener(EventListener listener) {
        this.eventListener = listener;
    }

    /**
     * Gibt den Spieler zurück.
     *
     * @return Spielerobjekt {@link Player} des Spiels
     */
    public Player getPlayer() {
        return player;
    }

    /**
     * Gibt alle Elemente zurück, die gezeichnet werden sollen (inkl. Spieler).
     *
     * @return Liste von {@link DrawableElement}
     */
    public List<DrawableElement> getElementsToDraw() {
        List<DrawableElement> alleElemente = new ArrayList<>();

        for (Element e : elements) {
            alleElemente.add(e);
        }

        alleElemente.add(player);

        return alleElemente;
    }

    /**
     * Führt eine Spielerbewegung aus und verarbeitet die Folgen.
     *
     * @param bewegung die gewünschte Bewegung
     */
    public void move(Move bewegung) {
        MoveResult result = checkMove(bewegung);

        if (result.moved()) {
            player.move(bewegung);
            Position pos = result.newPosition();
            eventListener.newEventMessage("Spieler bewegt sich nach (" + pos.getX() + ", " + pos.getY() + "), Energie verbraucht: " + result.energyUsed(), GameConstants.COLOR_DEFAULT);
            checkPositionForEvent(pos);
            checkEnergieAfterMove();

            if (gameOver) {
                uiController.setSteuerungAktiv(false);
            }

        } else {
            switch (result.failReason()) {
                case ENERGY_NOT_ENOUGH -> eventListener.newEventMessage(GameConstants.MESSAGE_ENERGY_NOT_ENOUGH, GameConstants.COLOR_RED);
                case OUT_OF_BOUNDS -> eventListener.newEventMessage(GameConstants.MESSAGE_OUT_OF_BOUNDS, GameConstants.COLOR_RED);
                default -> eventListener.newEventMessage("Bewegung nicht möglich.", GameConstants.COLOR_RED);
            }
        }
    }

    /**
     * Erzeugt eine zufällige, noch nicht belegte Position auf dem Spielfeld.
     *
     * @param usedPositions bereits belegte Positionen
     * @return neue zufällige Position {@link Position}
     */
    private Position getRandomPosition(Set<Position> usedPositions) {
        Position pos;
        do {
            int x = random.nextInt(GameConstants.BOARD_COLS) * GameConstants.TILE_SIZE;
            int y = random.nextInt(GameConstants.BOARD_ROWS) * GameConstants.TILE_SIZE;
            pos = new Position(x, y);
        } while (usedPositions.contains(pos));
        usedPositions.add(pos);
        return pos;
    }
    
    /**
     * Prüft, ob eine Position gültig ist (im Spielfeldbereich liegt).
     *
     * @param position zu prüfende Position
     * @return {@code true}, wenn die Position gültig ist
     */
    private boolean isValidPosition(Position position) {
        int maxX = GameConstants.BOARD_WIDTH - GameConstants.TILE_SIZE;
        int maxY = GameConstants.BOARD_HEIGHT - GameConstants.TILE_SIZE;

        return position.getX() >= 0 && position.getX() <= maxX &&
            position.getY() >= 0 && position.getY() <= maxY;
    }

    /**
     * Prüft, ob der Spieler vor der Bewegung genügend Energie hat.
     *
     * @param energieVerbrauch benötigte Energie
     * @return {@code true}, wenn genügend Energie vorhanden ist
     */
    private boolean checkEnergyBeforeMove(int energieVerbrauch) {
        return player.getEnergie() >= energieVerbrauch;
    }

    /**
     * Prüft, ob die gewünschte Bewegung möglich ist und gibt das Ergebnis zurück.
     *
     * @param bewegung die Bewegung
     * @return Ergebnis der Bewegung als {@link MoveResult}
     */
    private MoveResult checkMove(Move bewegung) {
        Position neuePosition = player.getPosition().changePosition(bewegung);

        if (!isValidPosition(neuePosition)) {
            return MoveResult.failure(player.getPosition(), MoveResult.FailReason.OUT_OF_BOUNDS);
        }

        if (!checkEnergyBeforeMove(GameConstants.PLAYER_MOVE_ENERGY)) {
            return MoveResult.failure(player.getPosition(), MoveResult.FailReason.ENERGY_NOT_ENOUGH);
        }

        return MoveResult.success(neuePosition, GameConstants.PLAYER_MOVE_ENERGY);
    }

    /**
     * Prüft nach einer Bewegung auf besondere Ereignisse an der aktuellen Position.
     *
     * @param position aktuelle Position des Spielers
     */
    private void checkPositionForEvent(Position position) {
        for (Element e : elements) {
            if (e instanceof Treasure treasure) {
                if (treasure.getPosition().equals(position)) {

                    checkForCastle(e);
                    
                    if (!treasure.getIsFound()) {
                        
                        treasure.setIsFound(true);
                        treasure.setDrawAsTree(false);

                        if (e instanceof IsEnergieElement energieElement) {
                            if (e instanceof Bone) {
                                player.reduceEnergie(energieElement.getEnergie());
                                eventListener.newEventMessage(GameConstants.MESSAGE_BONE_FOUND + energieElement.getEnergie(), GameConstants.COLOR_RED);
                            } else if (e instanceof Apple) {
                                player.addEnergie(energieElement.getEnergie());
                                eventListener.newEventMessage(GameConstants.MESSAGE_APPLE_FOUND + energieElement.getEnergie(), GameConstants.COLOR_GREEN);
                            } else if (e instanceof Heart) {
                                player.addEnergie(energieElement.getEnergie());
                                eventListener.newEventMessage(GameConstants.MESSAGE_HEART_FOUND + energieElement.getEnergie(), GameConstants.COLOR_GREEN);
                            }
                        } else if (e instanceof IsGoldElement moneyElement) {
                            player.addGold(moneyElement.getValue());
                            if (e instanceof Coin) {
                                eventListener.newEventMessage(GameConstants.MESSAGE_COIN_FOUND + moneyElement.getValue() + " Gold (" + player.getGold() + ")", GameConstants.COLOR_BLUE);
                            } else if (e instanceof Diamond) {
                                eventListener.newEventMessage(GameConstants.MESSAGE_DIAMOND_FOUND + moneyElement.getValue() + " Gold (" + player.getGold() + ")", GameConstants.COLOR_BLUE);
                            }
                        } 
                    }
                    break;
                }
            }
        }
    }

    /**
     * Prüft, ob das aktuelle Element das Schloss ist, und behandelt das Spielende.
     *
     * @param element geprüftes Element
     */
    private void checkForCastle(Element element) {
        if (element instanceof Castle castle) {
            if (!castle.getIsFound()) {
                eventListener.newEventMessage(GameConstants.MESSAGE_CASTLE_FOUND, GameConstants.COLOR_GREEN);
                castle.setIsFound(true);
                castle.setDrawAsTree(false);
            }
            if(hasEnoughGold()) {
                eventListener.newEventMessage(GameConstants.MESSAGE_ENOUGH_MONEY, GameConstants.COLOR_GREEN);
                eventListener.newEventMessage(GameConstants.MESSAGE_SUCCESS, GameConstants.COLOR_GREEN);
                gameOver = true;
            } else {
                eventListener.newEventMessage(GameConstants.MESSAGE_NOT_ENOUGH_MONEY, GameConstants.COLOR_RED);
            }
        }
    }

    /**
     * Prüft nach jedem Zug, ob der Spieler noch Energie hat, sonst beendet das Spiel.
     */
    private void checkEnergieAfterMove() {
        if (player.getEnergie() <= 0 && !gameOver) {
            gameOver = true;
            eventListener.newEventMessage(GameConstants.MESSAGE_OUT_OF_ENERGY, GameConstants.COLOR_RED);
        }
    }

    /**
     * Prüft, ob der Spieler genügend Gold für das Spielende hat.
     *
     * @return {@code true}, wenn genug Gold vorhanden ist
     */
    private Boolean hasEnoughGold() {
        if (player.getGold() >= GameConstants.ENDGAME_MONEY_THRESHOLD && !gameOver) {
            return true;
        }
        return false;
    }

}