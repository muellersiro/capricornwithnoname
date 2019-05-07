/**
 * Konto Gruppenarbeit 01 - PRG2 Klasse 2o
 * 
 * @authors Glauser Michel; Müller Siro; Marco Weber
 * @version 1.0
 */
public class Konto implements Comparable<Konto> {

	private int kontoNr;
	private double kontoStand;
	private String pin;
	private Kunde kunde;

	/**
	 * Konto initalisieren
	 *
	 * @param kontoNr    Kontonummer
	 * @param kontostand Kontostand
	 * @param pin        PIN
	 * @param kundenNr   Kundennummer
	 */
	public Konto(int kontoNr, double kontostand, String pin, int kundenNr) {
		this.kontoNr = kontoNr;
		// Kundendaten lesen
		KundeDAO kundendaten = new KundeDAO();
		// Konto mit Kunde verknüpfen
		this.kunde = kundendaten.getKunde(kundenNr);
		this.kontoStand = kontostand;
		this.pin = pin;
	}

	/**
	 * to String
	 *
	 * @return String
	 */
	public String toString() {
		return "Kontonummer: " + kontoNr + ", Kontostand: " + kontoStand + " von Kunde (" + kunde + ")";
	}

	/**
	 * PIN Überprüfung (Eingabe mit Pin in List)
	 *
	 * @param eingabe PIN Eingabe
	 * @return true/false
	 */
	public Boolean checkPin(String eingabe) {
		return eingabe.equals(this.pin);
	}

	/**
	 * Betrag einzahlen Überprüfung, ob Betrag möglich ist
	 *
	 * @param betrag Höhe des Betrags
	 * @return Transaktionserfolg true/false
	 */
	public Boolean einzahlen(double betrag) {
		if (betrag > 0) {
			kontoStand += betrag;
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Betrag auszahlen Überprüfung, ob Betrag möglich ist Überprüfung, ob der
	 * gewünschte Betrag kleiner ist als der Kontostand
	 *
	 * @param betrag Höhe des Betrags
	 * @return Transaktionserfolg true/false
	 */
	public Boolean auszahlen(double betrag) {
		if (kontoStand < betrag) {
			return false;
		}
		if (betrag > 0) {
			kontoStand -= betrag;
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Pin Getter
	 *
	 * @return pin
	 */
	public String getPin() {
		return pin;
	}

	/**
	 * Pin Setter
	 * 
	 * @param pin
	 */
	public void setPin(String pin) {
		this.pin = pin;
	}

	/**
	 * Kontostand Getter
	 *
	 * @return Kontostand
	 */
	public double getKontostand() {
		return kontoStand;
	}

	/**
	 * Pin Setter
	 * 
	 * @param Kontostand
	 */
	public void setKontoStand(double kontoStand) {
		this.kontoStand = kontoStand;
	}

	/**
	 * Kontonummer Getter
	 *
	 * @return Kontonummer
	 */
	public int getKontoNr() {
		return kontoNr;
	}

	/**
	 * Überschriebene equals-Methode
	 *
	 * @return ist gleich
	 */
	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (o == null || o.getClass() != getClass())
			return false;
		Konto that = (Konto) o;
		return kontoNr == that.kontoNr;
	}

	/**
	 * Überschriebene hashCode-Methode
	 *
	 * @return Kontonummer
	 */
	@Override
	public int hashCode() {
		return kontoNr;
	}

	/**
	 * Überschriebene Compare-Methode Für Sortierung
	 *
	 * @return Kontonummer
	 */
	@Override
	public int compareTo(Konto o) {
		return kontoNr - o.kontoNr;
	}
}