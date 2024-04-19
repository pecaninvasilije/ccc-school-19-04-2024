package level_1;

import java.io.*;
import java.util.*;

public class Level_1 {

    public static void main(String[] args) {
        try {
            // Eingabetextdatei lesen
            File inputFile = new File("C:\\Users\\vasil\\htlstp\\CCC 2024\\ccc-school-19-04-2024\\src\\main\\java\\level_1\\level1_example.in");
            Scanner scanner = new Scanner(inputFile);

            // Anzahl der Währungen lesen
            int numCurrencies = scanner.nextInt();

            // Anzahl der Münzen pro Währung in die Ausgabetextdatei schreiben
            File outputFile = new File("output.txt");
            FileWriter writer = new FileWriter(outputFile);

            // Anzahl der Währungen in die Ausgabetextdatei schreiben
            writer.write(numCurrencies + "\n");

            // Die Anzahl der Münzen für jede Währung aus der Eingabetextdatei lesen und in die Ausgabetextdatei schreiben
            for (int i = 0; i < numCurrencies; i++) {
                int numCoinsPerCurrency = scanner.nextInt();
                int[] coins = new int[numCoinsPerCurrency];
                for (int j = 0; j < numCoinsPerCurrency; j++) {
                    coins[j] = scanner.nextInt();
                }
                int result = findSmallestAmount(coins);
                writer.write(result + "\n");
            }

            // Ressourcen freigeben
            scanner.close();
            writer.close();

            System.out.println("Output erfolgreich in output.txt geschrieben.");

        } catch (IOException e) {
            System.out.println("Fehler beim Lesen oder Schreiben der Datei: " + e.getMessage());
            e.printStackTrace();
        }
    }

    // Methode, um den kleinsten Betrag zu finden, der nicht mit einer einzelnen Münze bezahlt werden kann
    private static int findSmallestAmount(int[] coins) {
        Arrays.sort(coins);
        int smallestAmount = 1;

        for (int coin : coins) {
            if (coin > smallestAmount) {
                break;
            }
            smallestAmount += coin;
        }

        return smallestAmount;
    }
}
