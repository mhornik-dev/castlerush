package mod;

import mod.controller.StartManager;

/**
 * Einstiegspunkt der Anwendung.
 * <p>
 * Diese Klasse enthält die {@code main}-Methode, welche die Anwendung initialisiert,
 * indem sie die Methode {@link StartManager#init()} aus der Klasse {@link StartManager} aufruft.
 */
public class Main {

    /**
     * Startet die Anwendung.
     *
     * @param args Programmargumente
     */
    public static void main(String[] args) {
        StartManager.init();
    }
}

