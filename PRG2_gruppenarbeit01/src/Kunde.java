public class Kunde implements Comparable<Kunde> {
	private int kundenNr;
	private String name;
	private String vorname;

	public Kunde(int kundenNr, String name, String vorname) {
		if (kundenNr < 1000000 || kundenNr > 9999999)
			throw new IllegalArgumentException("Kundennummer ist nicht erlaubt: " + kundenNr);
		this.kundenNr = kundenNr;
		this.name = name;
		this.vorname = vorname;
	}

	public int getKundenNr() {
		return kundenNr;
	}

	public String toString() {
		return name + ", " + vorname + " (" + kundenNr + ")";
	}

	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (o == null || o.getClass() != getClass())
			return false;
		Kunde that = (Kunde) o;
		return kundenNr == that.kundenNr;
	}

	@Override
	public int hashCode() {
		return kundenNr;
	}

	@Override
	public int compareTo(Kunde o) {
		return kundenNr - o.kundenNr;
	}
}
