package level_2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Level_2 {
    public static void main(String[] args) {
        int[][] currencies = {{1, 2, 6, 9, 14}, {1, 2, 3, 4, 7}, {1, 3, 5, 8, 11}};
        int[][] amounts = {{10, 4, 15}, {7, 11, 10}, {12, 14, 6}};
        findCoins(currencies, amounts);
    }

    public static void findCoins(int[][] currencies, int[][] amounts) {
        for (int i = 0; i < currencies.length; i++) {
            for (int amount : amounts[i]) {
                for (int coin1 : currencies[i]) {
                    for (int coin2 : currencies[i]) {
                        if (coin1 + coin2 == amount) {
                            System.out.println(coin1 + " " + coin2);
                            break;
                        }
                    }
                }
            }
        }
    }
}
