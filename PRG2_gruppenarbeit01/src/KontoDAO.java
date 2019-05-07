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
		allKontos.add(new Konto(333001, 50000.0, "1234", 1000000));
		allKontos.add(new Konto(333002, 10000.0, "9988", 2000000));
		allKontos.add(new Konto(333003, 20000.0, "9966", 1000001));
		allKontos.add(new Konto(333004, 70000.0, "4321", 1000002));
		allKontos.add(new Konto(333005, 110000.0, "6666", 1000003));
		allKontos.add(new Konto(333006, 25000.0, "7777", 4000000));
		allKontos.add(new Konto(333007, 2500000.0, "3333", 1999999));
		allKontos.add(new Konto(333008, 1500000.0, "2222", 4000000));
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
