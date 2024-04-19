package level_1;

import java.util.Scanner;
import java.util.HashSet;
import java.util.Set;

public class CurrencyChecker {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = Integer.parseInt(scanner.nextLine());  // Read the number of currencies
        int C = Integer.parseInt(scanner.nextLine());  // Read the number of coins per currency

        for (int i = 0; i < N; i++) {
            String[] coinStrings = scanner.nextLine().split(" ");
            int[] coins = new int[C];
            for (int j = 0; j < C; j++) {
                coins[j] = Integer.parseInt(coinStrings[j]);
            }

            int result = findSmallestNonSingleCoinAmount(coins);
            System.out.println(result);
        }

        scanner.close();
    }

    private static int findSmallestNonSingleCoinAmount(int[] coins) {
        Set<Integer> coinSet = new HashSet<>();
        for (int coin : coins) {
            coinSet.add(coin);
        }

        int smallestMissing = 1;
        while (true) {
            if (!coinSet.contains(smallestMissing)) {
                return smallestMissing;
            }
            smallestMissing++;
        }
    }
}
