
public class Konto {

	private int kontoNr;
	private double kontoStand;
	private String pin;
	private Kunde inhaber;

	public Konto(int kontoNr) {
		this.kontoNr = kontoNr;
		// this.inhaber = ;
		this.kontoStand = 0.0;
		this.pin = "123";
	}

	public String toString() {
		return kontoNr + "";
	}

	public double getKontostand() {
		return kontoStand;
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
		if(kontoStand < betrag) {
			return false;
		}
		if (betrag > 0) {
			kontoStand -= betrag;
			System.out.println("Betrag " + betrag + " wurde erfolgreich ausbezahlt");
		} else {
			System.out.println("Betrag muss grösser als 0 sein!");
		}
		return true;
	}

	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (o == null || o.getClass() != getClass())
			return false;
		Konto that = (Konto) o;
		return kontoNr == that.kontoNr;
	}

	public int hashCode(){
	return kontoNr;
	}
}
