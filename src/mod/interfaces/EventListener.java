/**
 * Schnittstelle für das Empfangen von Ereignismeldungen.
 * <p>
 * Ein {@code EventListener} empfängt Nachrichten zu Spielereignissen (z. B. Bewegungen, Funde, Fehler)
 * und kann diese mit einer bestimmten {@link Color} weiterverarbeiten bzw. anzeigen.
 * 
 * @author Milos Hornik
 */
package mod.interfaces;

import java.awt.Color;

public interface EventListener {
    /**
     * Übermittelt eine neue Ereignismeldung.
     *
     * @param message Die Nachricht zum Ereignis
     * @param color Die Farbe, in der die Nachricht dargestellt werden soll
     */
    void newEventMessage(String message, Color color);
}