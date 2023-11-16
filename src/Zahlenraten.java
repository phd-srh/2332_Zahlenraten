import java.util.Scanner;

/* Programm zum Zahlen raten
 * v1: gegeben ist eine geheimeZahl
 *     Eingabe: Tipp
 *     Ausgabe: Zahl ist richtig (Programmende)
 *              Zahl stimmt nicht (zurück zur Eingabe)
 *
 * v2: Ausgabe: Zahl ist kleiner/größer (als die geheimeZahl)
 *
 * v3: Computer legt die Zahl selbst fest (Bereich 100 - 999)
 *     Ausgabe: Sie haben x Versuche gebraucht
 *     Raten kann vorzeitig mit Eingabe der 0 beendet werden
 *
 * v4: Die geheimeZahl liegt nun im Bereich 1000 - 9999
 *     Ausgabe: Zahl ist viel kleiner/größer
 *
 * v5: Mastermind-style
 *     Ausgabe: Es sind x Ziffern korrekt bzw.
 *              es sind y Ziffern vorhanden (falsche Position)
 *     Zusatz: geheimeZahl darf keine doppelten Ziffern enthalten
 *     Beispiele: geheimeZahl 123 Tipp 145 -> 1 korrekte Ziffer
 *                geheimeZahl 123 Tipp 456 -> 0 korrekte Ziffern
 *                geheimeZahl 123 Tipp 356 -> 1 vorhanden Ziffer
 */

public class Zahlenraten {
    public static void main(String[] args) {
        Scanner eingabe = new Scanner(System.in);

        int geheimeZahl = (int)(Math.random() * 900 + 100);
        int anzahlVersuche = 0;
        while (true) {
            System.out.print("Bitte Tipp eingeben: ");
            int tipp = eingabe.nextInt();

            if (tipp == 0) {
                System.out.println("Die gesuchte Zahl war " + geheimeZahl);
                break;
            }

            anzahlVersuche++;
            if (tipp == geheimeZahl) {
                System.out.println("Gratuliere, die Zahl ist richtig");
                break;
            }
            else if (tipp > geheimeZahl){
                System.out.println("Sorry, die gesuchte Zahl ist kleiner");
            }
            else {
                System.out.println("Sorry, die gesuchte Zahl ist größer");
            }
        }
        System.out.println("Sie haben " + anzahlVersuche + " Versuche gebraucht.");
    }
}
