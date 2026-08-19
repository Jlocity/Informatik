import java.util.Locale;
import java.util.Scanner;

public class Fahrkartenautomat {

    private static final double PREIS_EINZELFAHRKARTE = 3.20;
    private static final double PREIS_TAGESKARTE = 8.50;
    private static final int ALTERSGRENZE = 18;
    private static final double ALTERSRABATT = 0.25;
    private static final int MENGENRABATT_AB_ANZAHL = 5;
    private static final double MENGENRABATT = 0.10;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Alter: ");
        int alter = scanner.nextInt();

        System.out.print("Anzahl Fahrkarten: ");
        int anzahl = scanner.nextInt();

        System.out.print("Tageskarte (true/false): ");
        boolean tageskarte = scanner.nextBoolean();

        double grundpreis = tageskarte ? PREIS_TAGESKARTE : PREIS_EINZELFAHRKARTE * anzahl;

        double rabatt = 0.0;
        StringBuilder rabattText = new StringBuilder();

        if (alter < ALTERSGRENZE) {
            rabatt += ALTERSRABATT;
            rabattText.append("Altersrabatt (25 %)");
        }

        if (!tageskarte && anzahl >= MENGENRABATT_AB_ANZAHL) {
            rabatt += MENGENRABATT;
            if (rabattText.length() > 0) {
                rabattText.append(" + ");
            }
            rabattText.append("Mengenrabatt (10 %)");
        }

        if (rabattText.length() == 0) {
            rabattText.append("kein Rabatt");
        }

        double endpreis = grundpreis * (1 - rabatt);

        System.out.println();
        System.out.println("Alter: " + alter);
        System.out.println("Anzahl Fahrkarten: " + anzahl);
        System.out.println("Tageskarte: " + tageskarte);
        System.out.println();
        System.out.printf(Locale.GERMANY, "Grundpreis: %.2f €%n", grundpreis);
        System.out.printf(Locale.GERMANY, "Rabatt: %.0f %% (%s)%n", rabatt * 100, rabattText.toString());
        System.out.printf(Locale.GERMANY, "Endpreis: %.2f €%n", endpreis);

        scanner.close();
    }
}
