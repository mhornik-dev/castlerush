/**
 * Controller für das Steuerpanel.
 * <p>
 * Der {@code SteuerPanelController} verbindet das {@link SteuerPanel} mit den Aktionen der Spiellogik, 
 * die über einen {@link UIManager} bereitgestellt werden. Er leitet Benutzerinteraktionen (Button-Klicks) 
 * an die entsprechenden Methoden des UIManagers weiter und bietet Methoden, um die Anzeige und Steuerung 
 * des Steuerpanels zu aktualisieren.
 * <ul>
 *   <li>Bindet Listener an alle Steuerungsbuttons des Panels.
 *   <li>Kann Gold- und Energiewerte setzen.
 *   <li>Steuert die Aktivierung der Bewegungs- und Startbuttons.
 * </ul>
 *
 * @author Milos Hornik
 */
package mod.view.controller;

import mod.view.ui.SteuerPanel;

public class SteuerPanelController {

    private final SteuerPanel panel;
    private final UIManager uiController;

    /**
     * Konstruktor: Initialisiert das Panel und verbindet alle Buttons mit Aktionen.
     *
     * @param uiController zentrale Steuereinheit für Spiellogik
     */
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

    /** 
     * Gibt das Steuerpanel zurück, das von diesem Controller verwaltet wird.
     *
     * @return das gesteuerte SteuerPanel {@link SteuerPanel}
     */
    public SteuerPanel getPanel() { return panel; }

    /** 
     * Setzt den aktuellen Goldwert. 
     * 
     * @param gold der aktuelle Goldwert als String
     */
    public void setGold(int gold) {
        panel.setLblGold(String.valueOf(gold));
    }

    /** 
     * Setzt den aktuellen Energiewert. 
     * 
     * @param energie der aktuelle Energiewert als String
     */
    public void setEnergie(int energie) {
        panel.setLblEnergie(String.valueOf(energie));
    }

    /** 
     * Aktiviert oder deaktiviert die Bewegungsbuttons. 
     * 
     * @param enabled {@code true} zum Aktivieren, {@code false} zum Deaktivieren
     */
    public void setSteuerButtonsEnabled(boolean enabled) {
        panel.getBtnLeft().setEnabled(enabled);
        panel.getBtnRight().setEnabled(enabled);
        panel.getBtnUp().setEnabled(enabled);
        panel.getBtnDown().setEnabled(enabled);
    }

    /** 
     * Aktiviert oder deaktiviert den Start-Button.
     *
     * @param enabled {@code true} zum Aktivieren, {@code false} zum Deaktivieren
     */
    public void setStartButtonEnabled(boolean enabled) {
        panel.getBtnStarten().setEnabled(enabled);
    }

    /** 
     * Startet ein neues Spiel. 
     */
    private void onStart() { uiController.getStartInterface().startNewGame(); }

    /** 
     * Beendet die Anwendung. 
     */
    private void onExit() { uiController.exit(0); }

    /** 
     * Führt eine Bewegung nach links aus. 
     */
    private void onLeft() { uiController.moveLeft(); }

    /** 
     * Führt eine Bewegung nach rechts aus. 
     */
    private void onRight() { uiController.moveRight(); }

    /** 
     * Führt eine Bewegung nach oben aus. 
     */
    private void onUp() { uiController.moveUp(); }

    /** 
     * Führt eine Bewegung nach unten aus. 
     */
    private void onDown() { uiController.moveDown(); }
}