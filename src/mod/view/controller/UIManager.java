/**
 * Zentrale Verwaltungs- und Steuerungsklasse für die Benutzeroberfläche.
 * <p>
 * Der {@code UIManager} verbindet die verschiedenen UI-Controller ({@link SteuerPanelController}, {@link SpielfeldPanelController}, {@link TextAusgabePanelController}) 
 * sowie die Spiellogik ({@link GameController}) miteinander. Er nimmt die Rolle eines Event-Listeners und KeyMappers ein,
 * verarbeitet Benutzereingaben und UI-Ereignisse, und sorgt für die Aktualisierung der Ansicht.
 * <ul>
 *   <li>Verwaltet das Start-Interface und die Controller für Steuerpanel, Spielfeld und Textausgabe
 *   <li>Bietet Zugriff auf alle UI-Komponenten und setzt die Verbindungen zur Spiellogik
 *   <li>Reagiert auf Tastendrücke und UI-Aktionen, steuert Spielfortschritt und UI-Status
 *   <li>Aktualisiert Anzeigen für Gold, Energie und Nachrichten
 *   <li>Kann das Spiel starten, die Steuerung aktivieren/deaktivieren und das Spielfeld aktualisieren
 * </ul>
 *
 * @author Milos Hornik
 */
package mod.view.controller;

import java.util.List;
import java.awt.Color;

import mod.controller.GameController;
import mod.interfaces.DrawableElement;
import mod.interfaces.StartInterface;
import mod.interfaces.EventListener;
import mod.interfaces.KeyMapper;
import mod.model.events.Move;
import mod.util.GameConstants;

public class UIManager implements EventListener, KeyMapper {

    private final StartInterface startInterface;
    private SteuerPanelController steuerPanelController;
    private SpielfeldPanelController spielfeldPanelController;
    private TextAusgabePanelController textAusgabePanelController;
    private GameController gameController;

    /**
     * Erstellt den UI-Manager und initialisiert alle Panel-Controller.
     *
     * @param startInterface Start-Interface zur Spielinitialisierung
     */
    public UIManager(StartInterface startInterface) {
        this.startInterface = startInterface;
        steuerPanelController = new SteuerPanelController(this);
        spielfeldPanelController = new SpielfeldPanelController();
        textAusgabePanelController = new TextAusgabePanelController();
    }

    /**
     * Setzt den {@link GameController} und registriert sich als EventListener.
     * 
     * @param gameController Spiellogik
     */
    public void setGameController(GameController gameController) {
        this.gameController = gameController;
        this.gameController.setEventListener(this);
    }

    /** 
     * Gibt das Start-Interface zurück, das von diesem Manager verwaltet wird.
     * 
     * @return Start-Interface {@link StartInterface} für die Spielinitialisierung
     */
    public StartInterface getStartInterface() { return startInterface; }

    /** 
     * Gibt den Steuerpanel-Controller zurück, der von diesem Manager verwaltet wird.
     *
     * @return Steuerpanel-Controller {@link SteuerPanelController}
     */
    public SteuerPanelController getSteuerPanelController() { return steuerPanelController; }

    /** 
     * Gibt den Spielfeldpanel-Controller zurück, der von diesem Manager verwaltet wird.
     *
     * @return Spielfeldpanel-Controller {@link SpielfeldPanelController}
     */
    public SpielfeldPanelController getSpielfeldPanelController() { return spielfeldPanelController; }

    /** 
     * Gibt den Textausgabepanel-Controller zurück, der von diesem Manager verwaltet wird.
     *
     * @return Textausgabepanel-Controller {@link TextAusgabePanelController}
     */
    public TextAusgabePanelController getTextAusgabePanelController() { return textAusgabePanelController; }

    /**
     * Startet das Spiel und initialisiert UI-Status und Steuerung.
     */
    public void startGame() {
        setKeyMapper();
        updateControlPanel();
        drawFrame();
        setSteuerungAktiv(true);
    }

    /**
     * Wird bei neuen Ereignis-Nachrichten aufgerufen (EventListener).
     * Fügt eine neue Nachricht im Textausgabe-Panel hinzu.
     *
     * @param message die Nachricht
     * @param color   die Textfarbe
     */
    @Override
    public void newEventMessage(String message, Color color) {
        textAusgabePanelController.appendMessage(message, color);
    }

    /**
     * Aktualisiert Gold- und Energie-Anzeigen im Steuerpanel.
     */
    private void updateControlPanel() {
        steuerPanelController.setEnergie(gameController.getPlayer().getEnergie());
        steuerPanelController.setGold(gameController.getPlayer().getGold());
    }

    /**
     * Aktiviert oder deaktiviert die Steuerungsbuttons und den Start-Button.
     * 
     * @param aktiv {@code true} zum aktivieren, {@code false} zum deaktivieren
     */
    public void setSteuerungAktiv(boolean aktiv) {
        steuerPanelController.setSteuerButtonsEnabled(aktiv);
        steuerPanelController.setStartButtonEnabled(!aktiv);
    }

    /**
     * Setzt diesen Manager als KeyMapper für das Spielfeldpanel.
     */
    private void setKeyMapper() {
        spielfeldPanelController.getPanel().setKeyMapper(this);
    }

    /**
     * Zeichnet alle übergebenen Elemente auf das Spielfeld.
     * 
     * @param elements Liste der anzuzeigenden {@link DrawableElement}-Objekte
     */
    private void drawAll(List<DrawableElement> elements) {
        spielfeldPanelController.setDrawableElements(elements);
    }

    /**
     * Löscht alle Elemente vom Spielfeld.
     */
    public void wipe() {
        spielfeldPanelController.wipeDrawableElements();
    }

    /**
     * Zeichnet das gesamte Spielfeld neu (löscht und zeichnet alle Elemente).
     */
    private void drawFrame() {
        wipe();
        drawAll(gameController.getElementsToDraw());
    }

    /**
     * KeyMapper-Methoden: Tastendrücke weiterleiten
     */
    @Override
    public void moveLeftKey() { moveLeft(); }
    @Override
    public void moveRightKey() { moveRight(); }
    @Override
    public void moveUpKey() { moveUp(); }
    @Override
    public void moveDownKey() { moveDown(); }

    /** Führt eine Bewegung nach links aus. */
    public void moveLeft() { movePlayer(new Move(-GameConstants.TILE_SIZE, 0)); }
    /** Führt eine Bewegung nach rechts aus. */
    public void moveRight() { movePlayer(new Move(GameConstants.TILE_SIZE, 0)); }
    /** Führt eine Bewegung nach oben aus. */
    public void moveUp() { movePlayer(new Move(0, -GameConstants.TILE_SIZE)); }
    /** Führt eine Bewegung nach unten aus. */
    public void moveDown() { movePlayer(new Move(0, GameConstants.TILE_SIZE)); }

    /**
     * Übermittelt eine Bewegung an die Spiellogik und aktualisiert Anzeige.
     * 
     * @param bewegung die Bewegung des Spielers
     */
    private void movePlayer(Move bewegung) {
        if (gameController.getIsGameOver()) return;
        gameController.move(bewegung);
        updateControlPanel();
        drawFrame();
    }

    /**
     * Beendet die Anwendung mit dem angegebenen Rückgabewert.
     * 
     * @param code Exit-Code
     */
    public void exit(int code) {
        System.exit(code);
    }
}