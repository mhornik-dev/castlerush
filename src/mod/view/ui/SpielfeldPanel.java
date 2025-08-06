package mod.view.ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

import mod.interfaces.DrawableElement;
import mod.interfaces.KeyMapper;
import mod.util.GameConstants;
import mod.view.service.ElementPainter;
import mod.exceptions.UnknownElementException;

public class SpielfeldPanel extends JPanel {

    private List<DrawableElement> elements = new ArrayList<>();
    private KeyMapper keyMapper;

    public SpielfeldPanel() {
        setPreferredSize(new Dimension(GameConstants.BOARD_WIDTH, GameConstants.BOARD_HEIGHT));
        setBackground(new Color(255, 255, 200));
        setFocusable(true);
        requestFocusInWindow();
        setupKeyBindings();
    }

    public void setKeyMapper(KeyMapper keyMapper) {
        this.keyMapper = keyMapper;
    }

    private void setupKeyBindings() {
        InputMap im = getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap am = getActionMap();

        im.put(KeyStroke.getKeyStroke(GameConstants.KEY1_MOVE_LEFT), "moveLeft");
        im.put(KeyStroke.getKeyStroke(GameConstants.KEY2_MOVE_LEFT), "moveLeft");
        am.put("moveLeft", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (keyMapper != null) keyMapper.moveLeftKey();
            }
        });

        im.put(KeyStroke.getKeyStroke(GameConstants.KEY1_MOVE_RIGHT), "moveRight");
        im.put(KeyStroke.getKeyStroke(GameConstants.KEY2_MOVE_RIGHT), "moveRight");
        am.put("moveRight", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (keyMapper != null) keyMapper.moveRightKey();
            }
        });

        im.put(KeyStroke.getKeyStroke(GameConstants.KEY1_MOVE_UP), "moveUp");
        im.put(KeyStroke.getKeyStroke(GameConstants.KEY2_MOVE_UP), "moveUp");
        am.put("moveUp", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (keyMapper != null) keyMapper.moveUpKey();
            }
        });

        im.put(KeyStroke.getKeyStroke(GameConstants.KEY1_MOVE_DOWN), "moveDown");
        im.put(KeyStroke.getKeyStroke(GameConstants.KEY2_MOVE_DOWN), "moveDown");
        am.put("moveDown", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (keyMapper != null) keyMapper.moveDownKey();
            }
        });
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        ElementPainter.drawGrid(g);

        for (DrawableElement e : elements) {
            try {
                ElementPainter.drawElement(g, e);
            } catch (UnknownElementException ex) {
                System.err.println("Fehler beim Zeichnen eines Elements an Position " + e.getPosition() + ": " + ex.getMessage());
            }
        }
    }

    public void setElementsToDraw(List<DrawableElement> elements) {
        this.elements = elements;
        repaint();
    }
    
}
