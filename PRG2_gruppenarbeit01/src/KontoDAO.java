import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Konto Data Access Objekt
 *
 * @author Siro Müller, Marco Weber, Michel Glauser
 * @version 1.1
 */
public class KontoDAO {
	List<Konto> allKontos = new LinkedList<Konto>();

	public KontoDAO() {// diese Konten sollen existieren
		allKontos.add(new Konto(333444, 50000.0, "9988", 4000000));
		allKontos.add(new Konto(333445, 60000.0, "9977", 1000003));
		allKontos.add(new Konto(333446, 70000.0, "9966", 1000005));
	}

	// alle auf einmal
	public List<Konto> getAll() {
		LinkedList<Konto> rc = new LinkedList<Konto>(allKontos);
		Collections.sort(rc);
		return rc;
	}

	// ein ganz bestimmter Kunde, falls dieser existert (null, falls nicht)
	public Konto getKonto(int kontoNr) {
		Konto rc = null;
		for (Konto k : allKontos)
			if (k.getKontoNr() == kontoNr)
				return k;
		return rc;
	}

	public void updateKonto(Konto konto) {
		allKontos.set(allKontos.indexOf(konto), konto);
	}

	public void deleteKonto(Konto konto) {
		allKontos.remove(konto.getKontoNr());
	}
}
