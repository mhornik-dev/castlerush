/**
 * Controller für das Spielfeld-Panel.
 * <p>
 * Der {@code SpielfeldPanelController} verwaltet ein {@link SpielfeldPanel}
 * und eine Liste von {@link DrawableElement}-Objekten, die darauf angezeigt werden.
 * Er bietet Methoden zum Hinzufügen, Ersetzen und Entfernen von Elementen sowie zur Anbindung eines {@link KeyMapper}.
 * Nach jeder Änderung wird das Panel automatisch aktualisiert.
 *
 * @author Milos Hornik
 */
package mod.view.controller;

import java.util.ArrayList;
import java.util.List;

import mod.interfaces.DrawableElement;
import mod.interfaces.KeyMapper;
import mod.view.ui.SpielfeldPanel;

public class SpielfeldPanelController {

    private final SpielfeldPanel panel;
    private final List<DrawableElement> elements;

    /**
     * Konstruktor: Initialisiert Panel und Elementliste.
     */
    public SpielfeldPanelController() {
        this.panel = new SpielfeldPanel();
        this.elements = new ArrayList<>();
    }

    /** 
     * Verwaltet das Spielfeld-Panel.
     * 
     * @return Spielfeldpanel {@link SpielfeldPanel} für die Anzeige von Spielelementen
     */
    public SpielfeldPanel getPanel() { return panel; }

    /** 
     * Setzt einen KeyMapper für Tastatureingaben. 
     * 
     * @param keyMapper der zu verwendende KeyMapper {@link KeyMapper} für Tastatureingaben
     */
    public void setKeyMapper(KeyMapper keyMapper) { panel.setKeyMapper(keyMapper); }

    /** 
     * Fügt ein neues Element hinzu und aktualisiert die Anzeige. 
     * 
     * @param element das hinzuzufügende {@link DrawableElement}
     */
    public void addDrawableElement(DrawableElement element) {
        elements.add(element);
        updateView();
    }

    /** 
     * Ersetzt die Elementliste und aktualisiert die Anzeige. 
     * 
     * @param elements die neue Liste von {@link DrawableElement}-Objekten
     */
    public void setDrawableElements(List<DrawableElement> elements) {
        this.elements.clear();
        this.elements.addAll(elements);
        updateView();
    }

    /** 
     * Entfernt alle Elemente vom Panel. 
     */
    public void wipeDrawableElements() {
        elements.clear();
        updateView();
    }

    /** 
     * Aktualisiert die Anzeige im Panel. 
     */
    private void updateView() {
        panel.setElementsToDraw(new ArrayList<>(elements));
    }
}