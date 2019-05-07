/**
 * Kunde Data Access Object Klasse
 * Gruppenarbeit 01 - PRG2
 * Klasse 2o
 * 
 * @authors Glauser Michel; Müller Siro; Marco Weber
 * @version 1.0
 */
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class KundeDAO {
	List<Kunde> all = new LinkedList<Kunde>();

	/**
	 * Erstellung der Kundenliste
	 * 
	 */
	public KundeDAO() {
		all.add(new Kunde(1000000, "Meier", "Gabi"));
		all.add(new Kunde(2000000, "Maurer", "Rolf"));
		all.add(new Kunde(1000001, "Wirth", "Nicola"));
		all.add(new Kunde(1000002, "Casutt", "Ralf"));
		all.add(new Kunde(1000003, "Breset", "Maurice"));
		all.add(new Kunde(4000000, "Schindler", "Ueli"));
		all.add(new Kunde(1999999, "Leuthard", "Dora"));
	}

	/**
	 * Alle Kunden auf einmal zurückgeben
	 * 
	 * @return Kundenliste
	 */
	public List<Kunde> getAll() {
		LinkedList<Kunde> rc = new LinkedList<Kunde>(all);
		Collections.sort(rc);
		return rc;
	}

	/**
	 * ein ganz bestimmter Kunde zurückgebens, falls dieser existert (null, falls
	 * nicht)
	 * 
	 * @return Kunde
	 */
	public Kunde getKunde(int kundenNr) {
		Kunde rc = null;
		for (Kunde k : all)
			if (k.getKundenNr() == kundenNr)
				return k;
		return rc;
	}

}