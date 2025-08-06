package mod.view.controller;

import java.awt.Color;
import javax.swing.text.*;

import mod.util.GameConstants;
import mod.view.ui.TextAusgabePanel;

import javax.swing.JTextPane;

public class TextAusgabePanelController {

    private final TextAusgabePanel textAusgabePanel;

    public TextAusgabePanelController() {
        this.textAusgabePanel = new TextAusgabePanel();
    }

    public TextAusgabePanel getPanel() { return textAusgabePanel; }

    public void appendMessage(String message, Color color) {
        appendMessage(message, color, GameConstants.TEXT_SIZE_DEFAULT);
    }

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

