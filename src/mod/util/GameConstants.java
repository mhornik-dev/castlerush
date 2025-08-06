/**
 * Enthält alle Konstanten, die für das Spiel relevant sind,
 * wie Spielfeld- und Fenstergrößen, Anzahl und Werte der Elemente,
 * Einstellungen für den Spieler, Tastenbelegung, Nachrichten und Farben.
 * <p>
 * Diese Klasse ist final und besitzt einen privaten Konstruktor,
 * um eine Instanziierung zu verhindern.
 * </p>
 * 
 * @author Milos Hornik
 */
package mod.util;

import java.awt.Color;

public final class GameConstants {

    private GameConstants() {}

    // Spielfeldgröße
    public static final int BOARD_WIDTH = 510;
    public static final int BOARD_HEIGHT = 420;
    public static final int TILE_SIZE = 30;
    public static final int BOARD_ROWS = BOARD_HEIGHT / TILE_SIZE;
    public static final int BOARD_COLS = BOARD_WIDTH / TILE_SIZE;

    // Fenstereinstellungen
    public static final int WINDOW_WIDTH = BOARD_WIDTH + 210;
    public static final int WINDOW_HEIGHT = BOARD_HEIGHT + 160;
    public static final int HAUPTSPLIT_DIVIDER_LOCATION = BOARD_HEIGHT + 5;

    // Anzahl der Elemente
    public static final int APPLE_COUNT = 20;
    public static final int BONE_COUNT = 8;
    public static final int HEART_COUNT = 8;
    public static final int DIAMOND_COUNT = 4;
    public static final int COIN_COUNT = 6;

    // Positive Energie-Werte
    public static final int ENERGY_APPLE = 60;
    public static final int ENERGY_HEART = 300;

    // Negative Energie-Werte
    public static final int ENERGY_BONE = 600;

    // Gold-Werte
    public static final int GOLD_DIAMOND = 500;
    public static final int GOLD_COIN = 100;

    // Player-Einstellungen
    public static final int PLAYER_MOVE_ENERGY = 30;
    public static final int PLAYER_START_ENERGY = 3000;
    public static final int PLAYER_MAX_ENERGY = 3000;
    public static final int PLAYER_START_MONEY = 0;

    // Tastenbelegung (Primär)
    public static final String KEY1_MOVE_LEFT = "LEFT";
    public static final String KEY1_MOVE_RIGHT = "RIGHT";
    public static final String KEY1_MOVE_UP = "UP";
    public static final String KEY1_MOVE_DOWN = "DOWN";

    // Tastenbelegung (Sekundär)
    public static final char KEY2_MOVE_LEFT = 'a';
    public static final char KEY2_MOVE_RIGHT = 'd';
    public static final char KEY2_MOVE_UP = 'w';
    public static final char KEY2_MOVE_DOWN = 's';

    // Nachrichten
    public static final String MESSAGE_ENERGY_NOT_ENOUGH = "Bewegung nicht möglich, Energie reicht nicht aus.";
    public static final String MESSAGE_OUT_OF_BOUNDS = "Bewegung nicht möglich, Spielfeldgrenze erreicht.";
    public static final String MESSAGE_OUT_OF_ENERGY = "Deine Energie ist leer! Das Spiel ist vorbei.";
    public static final String MESSAGE_BONE_FOUND = "Du wurdest von einem Skelett angegriffen ➜ Energie ";
    public static final String MESSAGE_APPLE_FOUND = "Du hast einen Apfel gefunden ➜ Energie +";
    public static final String MESSAGE_HEART_FOUND = "Du hast ein Herz gefunden ➜ Energie +";
    public static final String MESSAGE_DIAMOND_FOUND = "Du hast einen Diamanten gefunden! +";
    public static final String MESSAGE_COIN_FOUND = "Du hast eine Münze gefunden! +";
    public static final String MESSAGE_CASTLE_FOUND = "Du hast das Schloss gefunden!";
    public static final String MESSAGE_NOT_ENOUGH_MONEY = "Du hast leider nicht genügend Geld. Komme wieder, wenn du 1000 Gold gesammelt hast!";
    public static final String MESSAGE_ENOUGH_MONEY = "Du hast ausreichend Gold. Du darfst eintreten!";
    public static final String MESSAGE_SUCCESS = "Du hast das Spiel gewonnen! Herzlichen Glückwunsch!";

    // Textfarben
    public static final Color COLOR_DEFAULT = new Color(0, 0, 0);
    public static final Color COLOR_RED = new Color(255, 0, 0);
    public static final Color COLOR_GREEN = new Color(0, 128, 0);
    public static final Color COLOR_BLUE = new Color(0, 0, 255);

    // Textgröße
    public static final int TEXT_SIZE_DEFAULT = 14;

    // Endgame
    public static final int ENDGAME_MONEY_THRESHOLD = 1000;

}
