/**
 * Panel für die Steuerungselemente am Rand des Spiels.
 * <p>
 * Das {@code SteuerPanel} enthält:
 * <ul>
 *   <li>Ein Logo-Bild
 *   <li>Gold- und Energieanzeigen
 *   <li>Buttons zum Starten und Beenden des Spiels
 *   <li>Richtungsbuttons für die Bewegung
 * </ul>
 * Die Komponenten werden mit {@link GridBagLayout} übersichtlich angeordnet.
 *
 * @author Milos Hornik
 */
package mod.view.ui;

import javax.swing.*;
import java.awt.*;

public class SteuerPanel extends JPanel {

    private JLabel lblEnergie, lblGold;
    private JButton btnStarten, btnExit, btnLeft, btnRight, btnUp, btnDown;
    private JLabel lblLogo;

    /**
     * Erstellt das Steuerpanel und initialisiert die UI-Komponenten.
     */
    public SteuerPanel() {   
        initUI();
    }

    /**
     * Initialisiert das Layout und alle Steuerelemente.
     */
    private void initUI() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(5, 5, 5, 5);

        ImageIcon icon = new ImageIcon("src/logo.png");
        lblLogo = new JLabel(icon);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(lblLogo, gbc);

        gbc.insets = new Insets(150, 5, 5, 5);
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;

        lblGold = new JLabel("0");
        lblGold.setOpaque(true);
        lblGold.setBackground(Color.WHITE);
        lblGold.setHorizontalAlignment(SwingConstants.TRAILING);

        lblEnergie = new JLabel("0");
        lblEnergie.setOpaque(true);
        lblEnergie.setBackground(Color.WHITE);
        lblEnergie.setHorizontalAlignment(SwingConstants.TRAILING);

        btnStarten = new JButton("Starten");
        btnExit = new JButton("Beenden");

        btnLeft = new JButton("<");
        btnRight = new JButton(">");
        btnUp = new JButton("^");
        btnDown = new JButton("v");

        btnLeft.setEnabled(false);
        btnRight.setEnabled(false);
        btnUp.setEnabled(false);
        btnDown.setEnabled(false);

        gbc.gridx = 0; gbc.gridy = 1; add(new JLabel("Gold:"), gbc);
        gbc.gridx = 1; gbc.gridy = 1; add(lblGold, gbc);

        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0; gbc.gridy = 2; add(new JLabel("Energie:"), gbc);
        gbc.gridx = 1; gbc.gridy = 2; add(lblEnergie, gbc);

        gbc.gridx = 0; gbc.gridy = 3; add(btnStarten, gbc);
        gbc.gridx = 1; gbc.gridy = 3; add(btnExit, gbc);

        gbc.gridx = 0; gbc.gridy = 4; add(btnLeft, gbc);
        gbc.gridx = 1; gbc.gridy = 4; add(btnRight, gbc);
        gbc.gridx = 0; gbc.gridy = 5; add(btnUp, gbc);
        gbc.gridx = 1; gbc.gridy = 5; add(btnDown, gbc);

    }

     /**
     * Aktualisiert die Gold-Anzeige.
     * @param gold der aktuelle Goldwert als String
     */
    public void setLblGold(String gold) { lblGold.setText(gold); }

    /**
     * Aktualisiert die Energie-Anzeige.
     * @param energie der aktuelle Energiewert als String
     */
    public void setLblEnergie(String energie) { lblEnergie.setText(energie); }

    /**
     * Liefert den Button zum Starten eines neuen Spiels.
     * @return Start-Button
     */
    public JButton getBtnStarten() { return btnStarten; }

    /**
     * Liefert den Button zum Beenden des Spiels.
     * @return Exit-Button
     */
    public JButton getBtnExit() { return btnExit; }

    /**
     * Liefert den Button für die Bewegung nach links.
     * @return Linkstaste
     */
    public JButton getBtnLeft() { return btnLeft; }

    /**
     * Liefert den Button für die Bewegung nach rechts.
     * @return Rechtstaste
     */
    public JButton getBtnRight() { return btnRight; }

    /**
     * Liefert den Button für die Bewegung nach oben.
     * @return Obentaste
     */
    public JButton getBtnUp() { return btnUp; }

    /**
     * Liefert den Button für die Bewegung nach unten.
     * @return Untentaste
     */
    public JButton getBtnDown() { return btnDown; }

}