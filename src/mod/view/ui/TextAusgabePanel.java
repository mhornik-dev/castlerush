/**
 * Panel zur Textausgabe von Nachrichten und Ereignissen im Spiel.
 * <p>
 * Das {@code TextAusgabePanel} ist ein {@link JPanel}, das eine nicht-editierbare {@link JTextPane} 
 * zur Anzeige von Nachrichten enthält. Es wird typischerweise am unteren Rand der Spieloberfläche verwendet.
 * Die TextPane ist scrollbar und optisch leicht gepolstert.
 * 
 * @author Milos Hornik
 */
package mod.view.ui;

import javax.swing.*;
import java.awt.*;

public class TextAusgabePanel extends JPanel {

    private JTextPane tpNachricht;

    /**
     * Erstellt das Panel und initialisiert die UI-Komponenten.
     */
    public TextAusgabePanel() {
        initUI();
    }

    /**
     * Initialisiert das Layout und die Textanzeige-Komponenten.
     */
    private void initUI() {
        setLayout(new BorderLayout());

        tpNachricht = new JTextPane();
        tpNachricht.setEditable(false);
        tpNachricht.setFocusable(false);
        tpNachricht.setBackground(Color.WHITE);
        tpNachricht.setMargin(new Insets(5,5,5,5));

        JScrollPane scrollPane = new JScrollPane(tpNachricht);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));

        add(scrollPane, BorderLayout.CENTER);
    }

    /**
     * Gibt das zugrunde liegende Nachrichtenfeld zurück.
     *
     * @return das Nachrichtenfeld {@link JTextPane} für Textausgaben
     */
    public JTextPane getTextPane() {
        return tpNachricht;
    }
}