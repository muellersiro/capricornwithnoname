
public class Konto {

	private int kontoNr;
	private double kontoStand;
	private Kunde inhaber;
	private String pin;

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
		if (eingabe.equals(this.pin)) {
			System.out.println("PIN korrekt");
			return true;
		} else {
			return false;
		}
	}

	public void einzahlen(double betrag) {
		if (betrag > 0) {
			kontoStand += betrag;
			System.out.println("Betrag " + betrag + " wurde erfolgreich einbezahlt");
		} else {
			System.out.println("Betrag muss grösser als 0 sein!");
		}
	}

	public void auszahlen(double betrag) {
		if (betrag > 0) {
			kontoStand -= betrag;
			System.out.println("Betrag " + betrag + " wurde erfolgreich ausbezahlt");
		} else {
			System.out.println("Betrag muss grösser als 0 sein!");
		}
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
