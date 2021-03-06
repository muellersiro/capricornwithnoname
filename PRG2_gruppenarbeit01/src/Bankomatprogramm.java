/**
 * Hauptprogramm
 * 
 * Funktionen:
 *  - Betrag von Konto abheben
 *  - Betrag von Konto einzahlen
 *  - Kontostand überprüfen
 *  - Plausibilitätsprüfungen Einzahlung und Auszahlung
 *  - KontenListe wird aktualisiert
 *  - Konten können von der Kontenliste gelöscht werden
 *  
 * Wie Testen:
 * Pin zum Testkonto: 7777
 * Es existieren Kunden und Kontos zu finden in der jeweiligen DAO-Klasse (KundeDAO bzw. KontoDAO).
 * Es wird angenommen, dass die Kontonummer auf der Bankkarte gespeichert ist.
 * Vor dem Start des Programms mit der Klasse "Bankomatprogramm" muss das gewünschte Konto in der Source ausgewählt werden
 * 
 * Gruppenarbeit 01 - PRG2
 * Klasse 2o
 * 
 * @author Glauser Michel; Müller Siro; Marco Weber
 * @version 1.0
 */
public class Bankomatprogramm {

	/**
	 * Hauptmethode
	 *
	 * @param args Kommandozeilenparameter
	 */
	public static void main(String[] args) {
		Bankomat bankomat = new Bankomat();
		bankomat.starten(333006); // Programmstart mit Konto 333006
	}

}