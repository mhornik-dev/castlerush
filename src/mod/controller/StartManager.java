package mod.controller;

import mod.interfaces.StartInterface;
import mod.view.controller.UIManager;
import mod.view.ui.GameUI;

public class StartManager implements StartInterface {

    private static StartManager instance;

    private UIManager uiController;
    private GameUI gameUI;
    private GameController gameController;

    private StartManager() {
        uiController = new UIManager(this);
        gameUI = new GameUI(
            uiController.getSteuerPanelController().getPanel(),
            uiController.getSpielfeldPanelController().getPanel(),
            uiController.getTextAusgabePanelController().getPanel()
        );
        gameUI.setVisible(true);
    }

    public static void init() {
        getInstance();
    }

    private static StartManager getInstance() {
        if (instance == null) {
            instance = new StartManager();
        }
        return instance;
    }

    @Override
    public void startNewGame() {
        gameController = new GameController(uiController);
        uiController.setGameController(gameController);
        uiController.startGame();
    }
}
