/**
 * Panel für das Spielfeld im Spiel.
 * <p>
 * Das {@code SpielfeldPanel} ist ein benutzerdefiniertes {@link JPanel},
 * das alle darzustellenden {@link DrawableElement}-Objekte grafisch rendert und
 * Tasteneingaben (über definierte Key Bindings) an einen {@link KeyMapper} weiterleitet.
 * 
 * <ul>
 *   <li>Stellt die Spielfläche mit Gitter und Elementen dar.
 *   <li>Verarbeitet Tastendrücke für Spielerbewegung.
 *   <li>Kann jederzeit eine neue Liste von Elementen zum Zeichnen erhalten.
 * </ul>
 * 
 * @author Milos Hornik
 */
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

    /**
     * Erstellt das Spielfeld-Panel, setzt Größe, Hintergrund und Key Bindings.
     */
    public SpielfeldPanel() {
        setPreferredSize(new Dimension(GameConstants.BOARD_WIDTH, GameConstants.BOARD_HEIGHT));
        setBackground(new Color(255, 255, 200));
        setFocusable(true);
        requestFocusInWindow();
        setupKeyBindings();
    }

    /**
     * Setzt die {@link KeyMapper}-Implementierung für Tastaturereignisse.
     *
     * @param keyMapper der zu verwendende KeyMapper
     */
    public void setKeyMapper(KeyMapper keyMapper) {
        this.keyMapper = keyMapper;
    }

    /**
     * Initialisiert die Tastaturkürzel für die Spielfeldsteuerung
     * und verknüpft sie mit Methoden im {@link KeyMapper}.
     */
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

    /**
     * Zeichnet das Spielfeld, das Gitter und alle übergebenen Elemente.
     *
     * @param g das Graphics-Objekt
     */
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

    /**
     * Aktualisiert die Liste der zu zeichnenden Elemente und fordert eine Neudarstellung an.
     *
     * @param elements die neuen Spielelemente
     */
    public void setElementsToDraw(List<DrawableElement> elements) {
        this.elements = elements;
        repaint();
    }
    
}