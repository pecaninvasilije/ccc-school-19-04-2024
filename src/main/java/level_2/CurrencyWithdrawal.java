package level_2;

import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.io.FileWriter;
import java.io.IOException;

public class CurrencyWithdrawal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String filename = "D:\\OutsourcedIdeaProject\\ccc-school-19-04-2024\\src\\main\\resources\\level2\\example2.txt";  // Reading filename from input

        try (FileWriter writer = new FileWriter(filename)) {
            int N = Integer.parseInt(scanner.nextLine().trim());  // Number of currencies
            int C = Integer.parseInt(scanner.nextLine().trim());  // Number of coins per currency
            int A = Integer.parseInt(scanner.nextLine().trim());  // Number of amounts per currency

            for (int i = 0; i < N; i++) {
                String[] coinStrings = scanner.nextLine().split(" ");
                int[] coins = new int[C];
                Map<Integer, Integer> coinMap = new HashMap<>();
                for (int j = 0; j < C; j++) {
                    coins[j] = Integer.parseInt(coinStrings[j]);
                    coinMap.put(coins[j], coinMap.getOrDefault(coins[j], 0) + 1);
                }

                String[] amountStrings = scanner.nextLine().split(" ");
                for (int k = 0; k < A; k++) {
                    int amount = Integer.parseInt(amountStrings[k]);
                    String result = findPairs(coins, coinMap, amount);
                    writer.write(result + "\n");  // Writing each result followed by a new line
                }
            }
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

    private static String findPairs(int[] coins, Map<Integer, Integer> coinMap, int amount) {
        for (int coin : coins) {
            int needed = amount - coin;
            if ((needed == coin && coinMap.get(coin) > 1) || (needed != coin && coinMap.containsKey(needed))) {
                return coin + " " + needed;  // Returning the pair as a string
            }
        }
        return "";  // Should not happen as per problem statement that every amount has a solution
    }
}
