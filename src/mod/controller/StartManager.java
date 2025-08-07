/**
 * Einstiegspunkt-Manager für die Anwendung.
 * <p>
 * Die Klasse {@code StartManager} ist als Singleton ausgelegt und verwaltet die Initialisierung und den Neustart der Anwendung.
 * Sie koordiniert das Zusammenspiel zwischen {@link UIManager}, {@link GameUI} und {@link GameController} und implementiert das {@link StartInterface}.
 * 
 * Die Initialisierung der Anwendung erfolgt über die statische Methode {@link #init()}.
 * 
 * @author Milos Hornik
 */
package mod.controller;

import mod.interfaces.StartInterface;
import mod.view.controller.UIManager;
import mod.view.ui.GameUI;

public class StartManager implements StartInterface {

    private static StartManager instance;

    private UIManager uiController;
    private GameUI gameUI;
    private GameController gameController;

    /**
     * Privater Konstruktor zur Singleton-Implementierung.
     * Initialisiert UIManager und GameUI, zeigt die Oberfläche an.
     */
    private StartManager() {
        uiController = new UIManager(this);
        gameUI = new GameUI(
            uiController.getSteuerPanelController().getPanel(),
            uiController.getSpielfeldPanelController().getPanel(),
            uiController.getTextAusgabePanelController().getPanel()
        );
        gameUI.setVisible(true);
    }

    /**
     * Initialisiert den {@code StartManager} und damit die Anwendung.
     * Sollte beim Programmstart aufgerufen werden.
     */
    public static void init() {
        getInstance();
    }

    /**
     * Gibt die Singleton-Instanz des {@code StartManager} zurück.
     * Wird bei Bedarf erzeugt.
     *
     * @return die Singleton-Instanz des {@code StartManager}
     */
    private static StartManager getInstance() {
        if (instance == null) {
            instance = new StartManager();
        }
        return instance;
    }

    /**
     * Startet ein neues Spiel, indem ein neuer {@link GameController} erstellt
     * und dem {@link UIManager} übergeben wird.
     */
    @Override
    public void startNewGame() {
        gameController = new GameController(uiController);
        uiController.setGameController(gameController);
        uiController.startGame();
    }
}