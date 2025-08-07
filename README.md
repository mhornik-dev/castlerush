# Castle Rush - Forest of Secrets

**Castle Rush** ist ein Java-Spiel, das eine geheimnisvolle Reise durch einen verwunschenen Wald und ein Schloss bietet.  
Im Zentrum stehen Strategie, Sammeln von Gold und Energie, und das geschickte Navigieren über ein Spielfeld.

---

## 🕹️ Features

- **GUI-basiertes Spiel**
- **Farbliche und formatierte Textausgabe**
- **Komfortable Steuerung:**
- **Modulares MVC-Design**  
- **Einfache Erweiterbarkeit**

---

## 🏛️ Projektstruktur

mod/
├── controller/         # Spiellogik, Event-Verarbeitung
├── exceptions/         # Eigene Ausnahmen
├── interfaces/         # Zentrale Schnittstellen
├── model/              # Spielmodelle
│   ├── elements/       # Spielfigur, Elemente
│   └── events/         # Spielbezogene Events
├── util/               # Konstanten, Hilfsklassen
├── view/
│   ├── controller/     # Controller für UI-Elemente
│   ├── service/        # UI-nahe Services
│   └── ui/             # GUI-Komponenten
└── Main.java           # Einstiegspunkt

---

## ✨ Architektur-Überblick

- **UI-Manager:** Zentrale Steuerung der Benutzeroberfläche und Spiel-Events  
- **Panels:**  
  - *SteuerPanel*: Buttons, Gold/Energie-Anzeige  
  - *SpielfeldPanel*: Spielfeld & Zeichnen von Elementen  
  - *TextAusgabePanel*: Farbliche Nachrichten  
- **Controller:** Vermitteln zwischen UI und Spiellogik  
- **Interfaces:** Klare Abstraktionen für Erweiterbarkeit  

---

## ⌨️ Steuerung

| Aktion         | Taste/Schaltfläche |
| -------------- | ------------------ |
| Links          | ←, A, Button `<`   |
| Rechts         | →, D, Button `>`   |
| Hoch           | ↑, W, Button `^`   |
| Runter         | ↓, S, Button `v`   |
| Spiel starten  | Button "Starten"   |
| Spiel beenden  | Button "Beenden"   |

---

**Viel Spaß beim Erkunden des Waldes!**
