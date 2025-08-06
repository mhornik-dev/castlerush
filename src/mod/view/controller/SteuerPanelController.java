package mod.view.controller;

import mod.view.ui.SteuerPanel;

@SuppressWarnings("unused") // e von ActionListener

public class SteuerPanelController {

    private final SteuerPanel panel;
    private final UIManager uiController;

    public SteuerPanelController(UIManager uiController) {
        this.uiController = uiController;
        this.panel = new SteuerPanel();

        panel.getBtnStarten().addActionListener(e -> onStart());
        panel.getBtnExit().addActionListener(e -> onExit());
        panel.getBtnLeft().addActionListener(e -> onLeft());
        panel.getBtnRight().addActionListener(e -> onRight());
        panel.getBtnUp().addActionListener(e -> onUp());
        panel.getBtnDown().addActionListener(e -> onDown());
    }

    public SteuerPanel getPanel() { return panel; }

    public void setGold(int gold) {
        panel.setLblGold(String.valueOf(gold));
    }

    public void setEnergie(int energie) {
        panel.setLblEnergie(String.valueOf(energie));
    }

    public void setSteuerButtonsEnabled(boolean enabled) {
        panel.getBtnLeft().setEnabled(enabled);
        panel.getBtnRight().setEnabled(enabled);
        panel.getBtnUp().setEnabled(enabled);
        panel.getBtnDown().setEnabled(enabled);
    }

    public void setStartButtonEnabled(boolean enabled) {
        panel.getBtnStarten().setEnabled(enabled);
    }

    // Action-Listener Methoden
    private void onStart() { uiController.getStartInterface().startNewGame(); }
    private void onExit() { uiController.exit(0); }
    private void onLeft() { uiController.moveLeft(); }
    private void onRight() { uiController.moveRight(); }
    private void onUp() { uiController.moveUp(); }
    private void onDown() { uiController.moveDown(); }
}
