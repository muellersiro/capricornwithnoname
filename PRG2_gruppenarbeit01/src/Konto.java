
public class Konto implements Comparable<Konto> {

	public Konto konto;
	private int kontoNr;
	private double kontoStand;
	private String pin;
	private Kunde kunde;
	
	//Konto initalisieren
	public Konto(int kontoNr, double kontostand, String pin, int kundenNr) {
		this.kontoNr = kontoNr;
		KundeDAO data = new KundeDAO();
		this.kunde = data.getKunde(kundenNr);
		this.kontoStand = kontostand;
		this.pin = pin;
	}
	
	public String toString() {
		return kontoNr + "";
	}

	public double getKontostand() {
		return kontoStand;
	}
	
	public double getKontoNr() {
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
	public int hashCode(){
	return kontoNr;
	}

	@Override
	public int compareTo(Konto o) {
		return kontoNr - o.kontoNr;
	}
}
