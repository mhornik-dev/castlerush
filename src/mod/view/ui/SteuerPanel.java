package mod.view.ui;

import javax.swing.*;
import java.awt.*;


public class SteuerPanel extends JPanel {

    private JLabel lblEnergie, lblGold;
    private JButton btnStarten, btnExit, btnLeft, btnRight, btnUp, btnDown;
    private JLabel lblLogo;

    public SteuerPanel() {   
        initUI();
    }

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

    public void setLblGold(String gold) { lblGold.setText(gold); }
    public void setLblEnergie(String energie) { lblEnergie.setText(energie); }

    public JButton getBtnStarten() { return btnStarten; }
    public JButton getBtnExit() { return btnExit; }
    public JButton getBtnLeft() { return btnLeft; }
    public JButton getBtnRight() { return btnRight; }
    public JButton getBtnUp() { return btnUp; }
    public JButton getBtnDown() { return btnDown; }

}
