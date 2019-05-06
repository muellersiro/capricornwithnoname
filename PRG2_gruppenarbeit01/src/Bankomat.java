import java.util.Scanner;

public class Bankomat {

	public static void main(String[] args) {
		
		System.out.println("Bitte Bankkarte einschieben");
		System.out.println("Bankkarte wird gelesen...");
		System.out.println("PIN: ");
		
		
		checkPin("123");
		
		
		
	}
	
	
	private static void checkPin(String KontoPin) {
		for (int i = 0; i < 3; i++) {
			if (eingabe().equals("1234")) {
				System.out.println("PIN korrekt");
				
			}else{
				System.out.println("PIN falsch - noch " + (2-i) + " Versuche" );
			};
		}
		System.out.println("Zu viele Fehlerversuche - Karte ist gesperrt");
		System.exit(0);
	}
	
	private static String eingabe() {
		Scanner scanner = new Scanner(System.in);
            return scanner.nextLine(); 
	}

	}

