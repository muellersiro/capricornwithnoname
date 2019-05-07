import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/**
 * Kunde Data Access Object
 *
 * @author Siro Müller, Marco Weber, Michel Glauser
 * @version 1.1
 */
public class KundeDAO {
	List<Kunde> all = new LinkedList<Kunde>();

	public KundeDAO() {// diese Kunden sollen existieren
		all.add(new Kunde(1000000, "Meier", "Gabi"));
		all.add(new Kunde(2000000, "Maurer", "Rolf"));
		all.add(new Kunde(1000001, "Wirth", "Nicola"));
		all.add(new Kunde(1000002, "Casutt", "Ralf"));
		all.add(new Kunde(1000003, "Breset", "Maurice"));
		all.add(new Kunde(4000000, "Schindler", "Ueli"));
		all.add(new Kunde(1999999, "Leuthard", "Dora"));
	}

	// alle auf einmal
	public List<Kunde> getAll() {
		LinkedList<Kunde> rc = new LinkedList<Kunde>(all);
		Collections.sort(rc);
		return rc;
	}

	// ein ganz bestimmter Kunde, falls dieser existert (null, falls nicht)
	public Kunde getKunde(int kundenNr) {
		Kunde rc = null;
		for (Kunde k : all)
			if (k.getKundenNr() == kundenNr)
				return k;
		return rc;
	}

}
