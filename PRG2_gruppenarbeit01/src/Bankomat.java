import java.util.Scanner;

public class Bankomat {
	Scanner scanner = new Scanner(System.in);

	public void starten() {

		System.out.println("Bitte Bankkarte einschieben");
		System.out.println("Bankkarte wird gelesen...");
		System.out.println("PIN: ");

		Konto konto = new Konto(224016);

		for (int i = 0; i < 3; i++) {
			if (konto.checkPin(eingabe())) {
				
				while (true) {
					System.out.println("Mögliche Aktionen: Einzahlung(E), Auszahlung(A), Kontoabfrage(K), Beenden(B)");
					String eingabe = scanner.next();
					if (eingabe.equals("B")) {
						System.exit(0);
					}
					switch (eingabe) {
					case "E":
						System.out.println("Wie viel möchten Sie einzahlen?");
						konto.einzahlen(scanner.nextDouble());
						break;
					case "A":
						System.out.println("Wie viel möchten Sie auszahlen?");
						konto.auszahlen(scanner.nextDouble());
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
