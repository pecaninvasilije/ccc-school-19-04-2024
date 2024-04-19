package level_2;

import java.io.*;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class CurrencyWithdrawal {
    public static void main(String[] args) {
        String inputFile = "D:\\OutsourcedIdeaProject\\ccc-school-19-04-2024\\src\\main\\resources\\level2\\level2_example.in";  // Input file path
        String outputFile = "D:\\OutsourcedIdeaProject\\ccc-school-19-04-2024\\src\\main\\resources\\level2\\example2.txt"; // Output file path

        try (Scanner scanner = new Scanner(new File(inputFile));
             PrintWriter writer = new PrintWriter(new File(outputFile))) {

            if (!scanner.hasNextInt()) return; // Check if there's an integer to read
            int N = scanner.nextInt(); // Read the number of currencies

            for (int i = 0; i < N; i++) {
                if (!scanner.hasNextInt()) return; // Check if there's an integer to read
                int C = scanner.nextInt(); // Number of coin values
                int[] coins = new int[C];

                for (int j = 0; j < C; j++) {
                    if (!scanner.hasNextInt()) return; // Check if there's an integer to read
                    coins[j] = scanner.nextInt();
                }

                if (!scanner.hasNextInt()) return; // Check if there's an integer to read
                int A = scanner.nextInt(); // Number of amounts
                int[] amounts = new int[A];

                for (int j = 0; j < A; j++) {
                    if (!scanner.hasNextInt()) return; // Check if there's an integer to read
                    amounts[j] = scanner.nextInt();
                }

                // Find and write pairs for each amount
                for (int amount : amounts) {
                    boolean found = false;
                    Map<Integer, Integer> map = new HashMap<>();
                    for (int coin : coins) {
                        int complement = amount - coin;
                        if (map.containsKey(complement)) {
                            writer.println(complement + " " + coin);
                            found = true;
                            break;
                        }
                        map.put(coin, 1);
                    }

                    if (!found) {
                        // Check if a coin can be used twice
                        for (int coin : coins) {
                            if (2 * coin == amount) {
                                writer.println(coin + " " + coin);
                                break;
                            }
                        }
                    }
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
}
