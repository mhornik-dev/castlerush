package mod.view.ui;

import javax.swing.*;
import mod.util.GameConstants;

@SuppressWarnings("unused") // steuerPanel, spielfeldPanel, textAusgabePanel

public class GameUI extends JFrame {

    private final SteuerPanel steuerPanel;
    private final SpielfeldPanel spielfeldPanel;
    private final TextAusgabePanel textAusgabePanel;

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
