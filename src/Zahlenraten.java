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
 *     Ausgabe: Zahl ist viel kleiner/größer (Delta = 500)
 *
 * v5: Mastermind-style
 *     Ausgabe: Es sind x Ziffern korrekt bzw.
 *              es sind y Ziffern vorhanden (falsche Position)
 *     Zusatz: geheimeZahl darf keine doppelten Ziffern enthalten
 *     Beispiele: geheimeZahl 123 Tipp 145 -> 1 korrekte Ziffer
 *                geheimeZahl 123 Tipp 456 -> 0 korrekte Ziffern
 *                geheimeZahl 123 Tipp 356 -> 1 vorhandene Ziffer
 */

    /* Einführung in das Thema Methoden
     *
     * Methoden aka Funktionen, Prozeduren, Unterprogramme, Subroutine
     * -> Eigenständiger Programmabschnitt, der bei Bedarf benutzt werden kann.
     *
     * Aufbau von Methoden:
     * Methode = Methodenkopf + Methodenrumpf
     *
     * Methodenkopf =
     * Sichtbarkeit (public) Modifikator (static) Datentyp Methodenname
     *                                          "(" Parameterliste ")"
     *
     * Methodensignatur = Methodenname + Datentyper aller Parameter
     * (hat was mit Überladung zu tun)
     *
     * Methodenrumpf = "{" Anweisungen "}"
     *
     * Parameterliste = [ Datentyp Parametername [, ... ] ]
     */

public class Zahlenraten {

    // Methode mit Rückgabewert nennt man Funktion
    // Variable x ist ein Parameter, formale Variable
    // Aufruf geht nach dem Prinzip: Call-By-Value
    // -> es entsteht eine neue unabhängige Variable
    public static double f ( double x ) {
        return x * x;
    }

    // Methode ohne Rückgabewert (Datentyp void) nennt man Prozedur
    public static void ausgabe( double x ) {
        if (x < 0) return;
        System.out.println("Der Wert von x = " + x);
    }


    public static void main(String[] args) {

        double x = 3.14;
        ausgabe(x);
        double y = f(x);
        ausgabe(x);


        System.out.println( f(2) );
        System.out.println( f(5) );
        System.out.println( y );




        Scanner eingabe = new Scanner(System.in);

//        int geheimeZahl = (int)(Math.random() * 9000 + 1000);
        int geheimeZahl = 123; // nur zum Testen
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

            int anzahlKorrekteZiffern = 0;
            int kopieDerGeheimenZahl = geheimeZahl;
            while ( tipp > 0 ) {
                int zifferGeheimeZahl = kopieDerGeheimenZahl % 10;
                int zifferTipp = tipp % 10;
                if (zifferGeheimeZahl == zifferTipp) {
                    anzahlKorrekteZiffern++;
                }
                kopieDerGeheimenZahl = kopieDerGeheimenZahl / 10;
                tipp = tipp / 10;
            }
            System.out.println("Es sind " + anzahlKorrekteZiffern + " Ziffern korrekt");
        }
        System.out.println("Sie haben " + anzahlVersuche + " Versuche gebraucht.");
    }
}
