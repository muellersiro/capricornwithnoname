/**
 * Kontoklasse
 *
 * @author Siro Müller, Marco Weber, Michel Glauser
 * @version 1.1
 */
public class Konto implements Comparable<Konto> {

	private int kontoNr;
	private double kontoStand;
	private String pin;
	private Kunde kunde;

	// Konto initalisieren
	public Konto(int kontoNr, double kontostand, String pin, int kundenNr) {
		this.kontoNr = kontoNr;
		KundeDAO data = new KundeDAO();
		this.kunde = data.getKunde(kundenNr);
		this.kontoStand = kontostand;
		this.pin = pin;
	}

	public String toString() {
		return "Kontonummer: " + kontoNr + ", Kontostand: " + kontoStand + " (" + kunde + ")";
	}

	public double getKontostand() {
		return kontoStand;
	}

	public int getKontoNr() {
		return kontoNr;
	}

	public Boolean checkPin(String eingabe) {
		return eingabe.equals(this.pin);
	}

	public Boolean einzahlen(double betrag) {
		if (betrag > 0) {
			kontoStand += betrag;
			return true;
		} else {
			return false;
		}
	}

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

	public void setKontoStand(double kontoStand) {
		this.kontoStand = kontoStand;
	}

	public String getPin() {
		return pin;
	}

	public void setPin(String pin) {
		this.pin = pin;
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (o == null || o.getClass() != getClass())
			return false;
		Konto that = (Konto) o;
		return kontoNr == that.kontoNr;
	}

	@Override
	public int hashCode() {
		return kontoNr;
	}

	@Override
	public int compareTo(Konto o) {
		return kontoNr - o.kontoNr;
	}
}
