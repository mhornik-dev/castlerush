/**
 * Hauptfenster der Spieloberfläche.
 * <p>
 * Die {@code GameUI}-Klasse erweitert {@link JFrame} und bündelt die drei zentralen UI-Komponenten:
 * {@link SteuerPanel}, {@link SpielfeldPanel} und {@link TextAusgabePanel}. 
 * Die Panels werden in verschachtelten {@link JSplitPane} angeordnet, um eine übersichtliche Struktur zu schaffen.
 * 
 * <ul>
 *   <li>Oben: Steuerungsbereich (links) und Spielfeld (rechts)
 *   <li>Unten: Textausgabe für Spielnachrichten
 * </ul>
 * Die Größe und weitere Fenstereigenschaften werden über {@link GameConstants} gesteuert.
 * 
 * @author Milos Hornik
 */
package mod.view.ui;

import javax.swing.*;
import mod.util.GameConstants;

public class GameUI extends JFrame {

    private final SteuerPanel steuerPanel;
    private final SpielfeldPanel spielfeldPanel;
    private final TextAusgabePanel textAusgabePanel;

    /**
     * Erstellt das Hauptfenster und initialisiert die GUI-Komponenten.
     *
     * @param steuerPanel Steuerungs-Panel (links oben)
     * @param spielfeldPanel Spielfeld-Panel (rechts oben)
     * @param textAusgabePanel Textausgabe-Panel (unten)
     */
    public GameUI(SteuerPanel steuerPanel, SpielfeldPanel spielfeldPanel, TextAusgabePanel textAusgabePanel) {
        this.steuerPanel = steuerPanel;
        this.spielfeldPanel = spielfeldPanel;
        this.textAusgabePanel = textAusgabePanel;

        setTitle("Castle Rush - Forest of Secrets");
        setSize(GameConstants.WINDOW_WIDTH, GameConstants.WINDOW_HEIGHT);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        JSplitPane obenSplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, steuerPanel, spielfeldPanel);
        obenSplit.setDividerLocation(185);
        obenSplit.setDividerSize(5);
        obenSplit.setEnabled(false);

        JSplitPane hauptSplit = new JSplitPane(JSplitPane.VERTICAL_SPLIT, obenSplit, textAusgabePanel);
        hauptSplit.setDividerLocation(GameConstants.HAUPTSPLIT_DIVIDER_LOCATION);
        hauptSplit.setDividerSize(5);
        hauptSplit.setEnabled(false);

        add(hauptSplit);
    }

}