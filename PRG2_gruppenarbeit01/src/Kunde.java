/**
 * Kunde Gruppenarbeit 01 - PRG2 Klasse 2o
 * 
 * @authors Glauser Michel; Müller Siro; Marco Weber
 * @version 1.0
 */
public class Kunde implements Comparable<Kunde> {
	private int kundenNr;
	private String name;
	private String vorname;

	/**
	 * Kunde initalisieren
	 *
	 * @param kundenNr Kundennummer
	 * @param name     Nachname
	 * @param vorname  Vorname
	 */
	public Kunde(int kundenNr, String name, String vorname) {
		if (kundenNr < 1000000 || kundenNr > 9999999)
			throw new IllegalArgumentException("Kundennummer ist nicht erlaubt: " + kundenNr);
		this.kundenNr = kundenNr;
		this.name = name;
		this.vorname = vorname;
	}

	/**
	 * Kundenummer Getter
	 *
	 * @return Kundenummer
	 */
	public int getKundenNr() {
		return kundenNr;
	}

	/**
	 * to String
	 *
	 * @return String
	 */
	public String toString() {
		return name + ", " + vorname + " ( Kundennummer: " + kundenNr + ")";
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
		Kunde that = (Kunde) o;
		return kundenNr == that.kundenNr;
	}

	/**
	 * Überschriebene hashCode-Methode
	 *
	 * @return Kontonummer
	 */
	@Override
	public int hashCode() {
		return kundenNr;
	}

	/**
	 * Überschriebene Compare-Methode Für Sortierung
	 *
	 * @return Kontonummer
	 */
	@Override
	public int compareTo(Kunde o) {
		return kundenNr - o.kundenNr;
	}
}