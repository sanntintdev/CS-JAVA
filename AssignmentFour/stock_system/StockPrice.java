package AssignmentFour.stock_system;

import AssignmentFour.stock_system.StockPriceOperations;
import java.util.ArrayList;
import java.util.Arrays;

public class StockPrice {

    public static void main(String[] args) {
        int[] stockPricesArray = { 10, 15, 12, 18, 20 };
        ArrayList<Integer> stockPricesList = new ArrayList<>(
            Arrays.asList(10, 15, 12, 18, 20)
        );

        double averagePrice = StockPriceOperations.calculateAveragePrice(
            stockPricesArray
        );
        System.out.println("Average Stock Price: " + averagePrice);

        int maximumPrice = StockPriceOperations.findMaximumPrice(
            stockPricesArray
        );
        System.out.println("Maximum Stock Price: " + maximumPrice);

        int occurrenceCount = StockPriceOperations.countOccurrences(
            stockPricesArray,
            15
        );
        System.out.println("Occurrence Count of 15: " + occurrenceCount);

        ArrayList<Integer> cumulativeSum =
            StockPriceOperations.computeCumulativeSum(stockPricesList);
        System.out.println("Cumulative Sum of Stock Prices: " + cumulativeSum);
    }
}
