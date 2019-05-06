import java.util.Scanner;

public class Bankomat {
	Scanner scanner = new Scanner(System.in);

	public void starten() {

		System.out.println("Bitte Bankkarte einschieben");
		System.out.println("Bankkarte wird gelesen...");
		
		//Konto öffnen
		Konto konto = new Konto(333444, 4444);
		System.out.println("Konto wird geöffnet");
		System.out.println("PIN: ");

		
		for (int i = 0; i < 3; i++) {
			if (konto.checkPin(eingabe())) {
				System.out.println("PIN korrekt");
				while (true) {
					System.out.println("Mögliche Aktionen: Einzahlung(E), Auszahlung(A), Kontoabfrage(K), Beenden(B)");
					String eingabe = scanner.next().toUpperCase();
					if (eingabe.equals("B")) {
						System.exit(0);
					}
					switch (eingabe) {
					case "E":
						System.out.println("Wie viel möchten Sie einzahlen?");
						if (konto.einzahlen(scanner.nextDouble())) {
							System.out.println("Betrag wurde erfolgreich einbezahlt");
						}else {
							System.out.println("Betrag konnte nicht einbezahlt werden");
						}
						break;
					case "A":
						System.out.println("Wie viel möchten Sie auszahlen?");
						if (konto.auszahlen(scanner.nextDouble())) {
							System.out.println("Betrag wurde erfolgreich ausbezahlt");
						}else {
							System.out.println("Betrag konnte nicht ausbezahlt werden");
						}
						break;
					case "K":
						System.out.println(konto.getKontostand());
						break;
					default:
						System.out.println("Ungültige Eingabe");
						break;
					}
				}

			} else {
				System.out.println("PIN falsch - noch " + (2 - i) + " Versuche");
			}
		}

		System.out.println("Zu viele Fehlversuche - Karte ist gesperrt");
		System.exit(0);

	}

	private String eingabe() {
		return scanner.nextLine();
	}

}
