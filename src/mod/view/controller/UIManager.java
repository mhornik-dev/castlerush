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

    public UIManager(StartInterface startInterface) {
        this.startInterface = startInterface;
        steuerPanelController = new SteuerPanelController(this);
        spielfeldPanelController = new SpielfeldPanelController();
        textAusgabePanelController = new TextAusgabePanelController();
    }

    public void setGameController(GameController gameController) {
        this.gameController = gameController;
        this.gameController.setEventListener(this);
    }

    public StartInterface getStartInterface() { return startInterface; }
    public SteuerPanelController getSteuerPanelController() { return steuerPanelController; }
    public SpielfeldPanelController getSpielfeldPanelController() { return spielfeldPanelController; }
    public TextAusgabePanelController getTextAusgabePanelController() { return textAusgabePanelController; }

    public void startGame() {
        setKeyMapper();
        updateControlPanel();
        drawFrame();
        setSteuerungAktiv(true);
    }

    @Override
    public void newEventMessage(String message, Color color) {
        textAusgabePanelController.appendMessage(message, color);
    }

    private void updateControlPanel() {
        steuerPanelController.setEnergie(gameController.getPlayer().getEnergie());
        steuerPanelController.setGold(gameController.getPlayer().getGold());
    }

    public void setSteuerungAktiv(boolean aktiv) {
        steuerPanelController.setSteuerButtonsEnabled(aktiv);
        steuerPanelController.setStartButtonEnabled(!aktiv);
    }

    private void setKeyMapper() {
        spielfeldPanelController.getPanel().setKeyMapper(this);
    }

    private void drawAll(List<DrawableElement> elements) {
        spielfeldPanelController.setDrawableElements(elements);
    }

    public void wipe() {
        spielfeldPanelController.wipeDrawableElements();
    }

    private void drawFrame() {
        wipe();
        drawAll(gameController.getElementsToDraw());
    }

    @Override
    public void moveLeftKey() { moveLeft(); }
    @Override
    public void moveRightKey() { moveRight(); }
    @Override
    public void moveUpKey() { moveUp(); }
    @Override
    public void moveDownKey() { moveDown(); }

    public void moveLeft() { movePlayer(new Move(-GameConstants.TILE_SIZE, 0)); }
    public void moveRight() { movePlayer(new Move(GameConstants.TILE_SIZE, 0)); }
    public void moveUp() { movePlayer(new Move(0, -GameConstants.TILE_SIZE)); }
    public void moveDown() { movePlayer(new Move(0, GameConstants.TILE_SIZE)); }

    private void movePlayer(Move bewegung) {
        if (gameController.getIsGameOver()) return;
        gameController.move(bewegung);
        updateControlPanel();
        drawFrame();
    }

    public void exit(int code) {
        System.exit(code);
    }
}
