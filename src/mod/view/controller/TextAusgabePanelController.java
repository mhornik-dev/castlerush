/**
 * Controller für das Textausgabe-Panel.
 * <p>
 * Der {@code TextAusgabePanelController} verwaltet ein {@link TextAusgabePanel}
 * und bietet Methoden, um Nachrichten farbig und mit individueller Schriftgröße im Panel anzuzeigen.
 * Nach jeder Nachricht wird automatisch zum Nachrichtenende gescrollt.
 * <ul>
 *   <li>appendMessage(message, color): Fügt eine Nachricht mit Standardgröße und Farbe hinzu.
 *   <li>appendMessage(message, color, fontSize): Fügt eine Nachricht mit individueller Schriftgröße hinzu.
 * </ul>
 *
 * @author Milos Hornik
 */
package mod.view.controller;

import java.awt.Color;
import javax.swing.text.*;

import mod.util.GameConstants;
import mod.view.ui.TextAusgabePanel;

import javax.swing.JTextPane;

public class TextAusgabePanelController {

    private final TextAusgabePanel textAusgabePanel;

    /**
     * Erstellt den Controller und initialisiert das Panel.
     */
    public TextAusgabePanelController() {
        this.textAusgabePanel = new TextAusgabePanel();
    }

    /** 
     * Gibt das zugehörige TextAusgabePanel zurück.
     *
     * @return das zugehörige TextAusgabePanel
     */
    public TextAusgabePanel getPanel() { return textAusgabePanel; }

    /**
     * Fügt eine Nachricht mit Standard-Schriftgröße und der angegebenen Farbe hinzu.
     *
     * @param message die Nachricht
     * @param color   die Textfarbe
     */
    public void appendMessage(String message, Color color) {
        appendMessage(message, color, GameConstants.TEXT_SIZE_DEFAULT);
    }

    /**
     * Fügt eine Nachricht mit angegebener Farbe und Schriftgröße hinzu.
     * Nach dem Einfügen wird automatisch zum Nachrichtenende gescrollt.
     *
     * @param message  die Nachricht
     * @param color    die Textfarbe
     * @param fontSize die Schriftgröße
     */
    public void appendMessage(String message, Color color, int fontSize) {
        JTextPane textPane = textAusgabePanel.getTextPane();
        StyledDocument doc = textPane.getStyledDocument();

        Style style = textPane.addStyle("ColorStyle", null);
        StyleConstants.setForeground(style, color);
        StyleConstants.setFontSize(style, fontSize);

        try {
            doc.insertString(doc.getLength(), message + "\n", style);
            textPane.setCaretPosition(doc.getLength());
        } catch (BadLocationException e) {
            e.printStackTrace();
        }
    }
}