package AssignmentFour.stock_system;

import java.util.ArrayList;
import java.util.Arrays;

public class StockPriceOperations {

    // Method to calculate the average stock price
    public static double calculateAveragePrice(int[] stockPrices) {
        int sum = 0;
        for (int price : stockPrices) {
            sum += price;
        }
        return (double) sum / stockPrices.length;
    }

    // Method to find the maximum stock price
    public static int findMaximumPrice(int[] stockPrices) {
        int maxPrice = stockPrices[0];
        for (int price : stockPrices) {
            if (price > maxPrice) {
                maxPrice = price;
            }
        }
        return maxPrice;
    }

    // Method to count the occurrence of a specific price
    public static int countOccurrences(int[] stockPrices, int targetPrice) {
        int count = 0;
        for (int price : stockPrices) {
            if (price == targetPrice) {
                count++;
            }
        }
        return count;
    }

    // Method to compute the cumulative sum of stock prices
    public static ArrayList<Integer> computeCumulativeSum(
        ArrayList<Integer> stockPrices
    ) {
        ArrayList<Integer> cumulativeSum = new ArrayList<>();
        int sum = 0;
        for (int price : stockPrices) {
            sum += price;
            cumulativeSum.add(sum);
        }
        return cumulativeSum;
    }
}
