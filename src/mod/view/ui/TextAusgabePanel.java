package mod.view.ui;

import javax.swing.*;
import java.awt.*;

public class TextAusgabePanel extends JPanel {

    private JTextPane tpNachricht;

    public TextAusgabePanel() {
        initUI();
    }

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

    public JTextPane getTextPane() {
        return tpNachricht;
    }
}
