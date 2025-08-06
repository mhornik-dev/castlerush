package mod.view.service;

import java.awt.*;

import mod.exceptions.UnknownElementException;
import mod.interfaces.DrawableElement;
import mod.model.elements.Position;
import mod.util.GameConstants;

public class ElementPainter {

    private ElementPainter() {}

    public static void drawElement(Graphics g, DrawableElement e) throws UnknownElementException {
        Position p = e.getPosition();
        switch (e.getElementType()) {
            case TREE -> drawTree(g, p);
            case APPLE -> drawApple(g, p);
            case BONE -> drawBone(g, p);
            case PLAYER -> drawPlayer(g, p);
            case CASTLE -> drawCastle(g, p);
            case HEART -> drawHeart(g, p);
            case DIAMOND -> drawDiamond(g, p);
            case COIN -> drawCoin(g, p);
            case NONE -> drawUnknownElement(g, p);
            default -> {drawUnknownElement(g, p);
                        throw new UnknownElementException("Unbekanntes Element: " + e.getElementType());}
        }
    }

    public static void drawGrid(Graphics g) {
        g.setColor(Color.GRAY);
        for (int i = 0; i <= GameConstants.BOARD_WIDTH; i += GameConstants.TILE_SIZE) {
            g.drawLine(i, 0, i, GameConstants.BOARD_HEIGHT);
            g.drawLine(0, i, GameConstants.BOARD_WIDTH, i);
        }
    }

    private static void drawApple(Graphics g, Position p) {
        int x = p.getX();
        int y = p.getY() + 1;

        g.setColor(Color.RED);
        g.fillOval(x + 5, y + 8, 20, 20);
        g.setColor(new Color(139, 69, 19));
        g.fillRect(x + 15, y + 3, 4, 5);
        g.setColor(Color.GREEN);
        int[] leafX = { x + 18, x + 23, x + 18 };
        int[] leafY = { y + 3, y, y + 7 };
        g.fillPolygon(leafX, leafY, 3);
    }

    private static void drawBone(Graphics g, Position p) {
        int x = p.getX();
        int y = p.getY();
        g.setColor(Color.WHITE);
        g.fillOval(x + 5, y + 5, 20, 20);
        g.setColor(Color.BLACK);
        g.drawOval(x + 5, y + 5, 20, 20);
        g.fillOval(x + 9, y + 12, 3, 3);
        g.fillOval(x + 19, y + 12, 3, 3);
    }

    private static void drawPlayer(Graphics g, Position p) {
        int x = p.getX();
        int y = p.getY();
        g.setColor(Color.DARK_GRAY);
        g.fillOval(x, y, 30, 30);
    }

    private static void drawCastle(Graphics g, Position p) {
        int x = p.getX();
        int y = p.getY();
        g.setColor(Color.GRAY);
        g.fillRect(x + 5, y + 10, 20, 18);
        g.setColor(Color.DARK_GRAY);
        g.fillRect(x + 3, y + 5, 5, 10);
        g.fillRect(x + 22, y + 5, 5, 10);
        g.setColor(Color.BLACK);
        g.fillRect(x + 5, y + 10, 4, 4);
        g.fillRect(x + 11, y + 10, 4, 4);
        g.fillRect(x + 17, y + 10, 4, 4);
    }

    private static void drawHeart(Graphics g, Position p) {
        int x = p.getX();
        int y = p.getY();
        g.setColor(Color.RED);
        g.fillOval(x + 5, y + 5, 10, 10);
        g.fillOval(x + 15, y + 5, 10, 10);
        int[] triangleX = { x + 5, x + 15, x + 25 };
        int[] triangleY = { y + 12, y + 28, y + 12 };
        g.fillPolygon(triangleX, triangleY, 3);
    }

    private static void drawDiamond(Graphics g, Position p) {
        int x = p.getX();
        int y = p.getY();
        g.setColor(Color.CYAN);
        int[] xPoints = { x + 15, x + 25, x + 15, x + 5 };
        int[] yPoints = { y + 5, y + 15, y + 25, y + 15 };
        g.fillPolygon(xPoints, yPoints, 4);
    }

    private static void drawCoin(Graphics g, Position p) {
        int x = p.getX();
        int y = p.getY();
        g.setColor(new Color(212, 175, 55));
        g.fillOval(x + 7, y + 7, 18, 18);
        g.setColor(Color.BLACK);
        g.drawString("$", x + 13, y + 20);
    }

    private static void drawTree(Graphics g, Position p) {
        g.setColor(new Color(34, 139, 34));
        g.fillOval(p.getX() + 5, p.getY() + 0, 20, 20);
        g.setColor(new Color(139, 69, 19));
        g.fillRect(p.getX() + 12, p.getY() + 20, 5, 10);
    }

    private static void drawUnknownElement(Graphics g, Position p) {
    int x = p.getX();
    int y = p.getY();

    // Roter Kreis
    g.setColor(Color.RED);
    g.fillOval(x + 7, y + 7, 22, 22);

    // Weißes Fragezeichen zentriert
    g.setColor(Color.WHITE);
    g.setFont(new Font("SansSerif", Font.BOLD, 14));
    g.drawString("?", x + 13, y + 20);  // Feinjustierung wie bei drawCoin
}


}

