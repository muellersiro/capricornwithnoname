/**
 * Bankomat
 * Gruppenarbeit 01 - PRG2
 * Klasse 2o
 * 
 * @authors Glauser Michel; Müller Siro; Marco Weber
 * @version 1.0
 */
import java.util.Scanner;

public class Bankomat {
	Scanner scanner = new Scanner(System.in);
	
	/**
	 * Startmethode
	 *
	 * @param bankKonto Bankkonto, das geöffnet werden soll
	 */
	public void starten(int bankKonto) {
		System.out.println("Bitte Bankkarte einschieben");
		System.out.println("Bankkarte mit Konto wird gelesen...");

		// Alle Konten einlesen
		KontoDAO kontoData = new KontoDAO();
		// Spezifisches Konto öffnen - Hier wird angenommen, dass die Kontonummer der
		// eingeschobenen Bankkarte entnommen werden kann
		Konto konto = kontoData.getKonto(bankKonto);
		System.out.println("Konto wird geöffnet");
		System.out.println("Das Konto mit " + konto + " wurde geöffnet");

		// drei Versuche für die PIN Eingabe
		System.out.println("PIN: ");
		for (int i = 0; i < 3; i++) {
			if (konto.checkPin(LineEingabe())) { // PIN Check
				System.out.println("PIN korrekt");
				while (true) {
					System.out.println("Mögliche Aktionen: Einzahlung(E), Auszahlung(A), Kontoabfrage(K), Abbruch(X)");
					String eingabe = scanner.next().toUpperCase();

					// Abbruch
					if (eingabe.equals("X")) {
						System.out.println("Bitte Karte entnehmen");
						System.exit(0);
					}

					switch (eingabe) {
					case "E": // Einzahlung
						System.out.println("Welchen Betrag möchten Sie einzahlen?");
						if (konto.einzahlen(scanner.next())) {
							System.out.println("Betrag wurde erfolgreich einbezahlt");
							// List aktualisieren
							kontoData.updateKonto(konto);
							System.out.println("Neuer Kontostand: " + konto.getKontostand() + konto.getWaehrung());
						} else {
							System.out.println("Betrag konnte nicht einbezahlt werden");
						}
						break;

					case "A": // Auszahlung
						System.out.println("Welchen Betrag möchten Sie auszahlen?");
						if (konto.auszahlen(scanner.next())) {
							System.out.println("Betrag wurde erfolgreich ausbezahlt");
							// List aktualisieren
							kontoData.updateKonto(konto);
							System.out.println("Neuer Kontostand: " + konto.getKontostand() + konto.getWaehrung());
						} else {
							System.out.println("Betrag konnte nicht ausbezahlt werden");
						}
						break;

					case "K": // Kontoabfrage
						System.out.println(konto.getKontostand() + konto.getWaehrung());
						break;
					default:
						System.out.println("Ungültige Eingabe");
						break;
					}
				}

			} else {
				System.out.println("PIN falsch - noch " + (2 - i) + " Versuche");
			}
		}

		System.out.println("Zu viele Fehlversuche - Karte ist gesperrt");
		System.out.println("Bitte Karte entnehmen");
		System.exit(0);
	}

	/**
	 * Gibt die eingegebene Zeile zurück
	 *
	 * @return Zeile
	 */
	private String LineEingabe() {
		return scanner.nextLine();
	}
}