/**
 * Konto Data Access Object Klasse
 * Gruppenarbeit 01 - PRG2
 * Klasse 2o
 * 
 * @authors Glauser Michel; Müller Siro; Marco Weber
 * @version 1.0
 */
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class KontoDAO {
	List<Konto> allKontos = new LinkedList<Konto>();

	/**
	 * Erstellung der Kontoliste
	 * 
	 */
	public KontoDAO() {
		allKontos.add(new Konto(333001, 50000.0, "CHF", "1234", 1000000));
		allKontos.add(new Konto(333002, 10000.0, "USD", "9988", 2000000));
		allKontos.add(new Konto(333003, 20000.0, "EUR","9966", 1000001));
		allKontos.add(new Konto(333004, 70000.0, "CHF","4321", 1000002));
		allKontos.add(new Konto(333005, 110000.0,"CHF", "6666", 1000003));
		allKontos.add(new Konto(333006, 25000.0, "CHF","7777", 4000000));
		allKontos.add(new Konto(333007, 2500000.0,"EUR", "3333", 1999999));
		allKontos.add(new Konto(333008, 1500000.0,"USD", "2222", 4000000));
	}

	/**
	 * Alle Konten auf einmal zurückgeben
	 * 
	 * @return Kontoliste
	 */
	public List<Konto> getAll() {
		LinkedList<Konto> rc = new LinkedList<Konto>(allKontos);
		Collections.sort(rc);
		return rc;
	}

	/**
	 * ein ganz bestimmtes Konto zurückgeben, falls dieses existert (null, falls
	 * nicht)
	 * 
	 * @param kontoNr Kontonummer
	 * @return Konto Kontoinstanz
	 */
	public Konto getKonto(int kontoNr) {
		Konto rc = null;
		for (Konto k : allKontos)
			if (k.getKontoNr() == kontoNr)
				return k;
		return rc;
	}

	/**
	 * Konto aktualisieren für Kontenstandänderungen
	 * 
	 * @param konto Kontoinstanz
	 */
	public void updateKonto(Konto konto) {
		allKontos.set(allKontos.indexOf(konto), konto);
	}

	/**
	 * Konto löschen
	 * 
	 * @param konto Kontoinstanz
	 */
	public void deleteKonto(Konto konto) {
		allKontos.remove(konto.getKontoNr());
	}
}