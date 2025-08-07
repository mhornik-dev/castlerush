/**
 * Exception, die geworfen wird, wenn ein unbekanntes Element im Spiel gefunden wird.
 * <p>
 * Diese Ausnahme signalisiert, dass ein Element nicht erkannt oder verarbeitet werden konnte.
 *
 * @author Milos Hornik
 */
package mod.exceptions;

/**
 * Konstruktor für die UnknownElementException.
 *
 * @param message Fehlermeldung, die die Ursache beschreibt
 */
public class UnknownElementException extends Exception {
    public UnknownElementException(String message) {
        super(message);
    }
}