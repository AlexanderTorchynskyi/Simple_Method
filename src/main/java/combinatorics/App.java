package combinatorics;

import org.paukov.combinatorics3.Generator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {

        Map<Integer, List<Product>> combinationsOfProductsThatLowerThenDailyLimit = new HashMap<>();
        List<Product> backLog = new ArrayList<>();

        backLog.add(new Product("potato", 50.0, 3.0));
        backLog.add(new Product("chips", 250.0, 3.0));
        backLog.add(new Product("meat", 60.0, 2.0));
        backLog.add(new Product("milk", 44.0, 5.0));
        backLog.add(new Product("juice", 90.0, 3.4));

        int minimumProductsInSet = 3;
        int maximumProductsInSet = 5;
        int dayliCaloriesLimit = 350;

        for (int i = minimumProductsInSet, count = 1; i <= maximumProductsInSet; i++) {
            List<List<Product>> listOfCombs = getCombs(i, backLog);
            for (List<Product> innerArr : listOfCombs) {
                double sumCalories = innerArr.stream().mapToDouble(Product::getCalories).sum();
                if (sumCalories <= dayliCaloriesLimit) {
                    combinationsOfProductsThatLowerThenDailyLimit.put(count, innerArr);
                    count++;
                }
            }
        }
        combinationsOfProductsThatLowerThenDailyLimit.forEach((k, v) -> System.out.println("key -> " + k + " value -> " + v));

    }

    private static List<List<Product>> getCombs(int m, List<Product> arr) {
        return Generator.combination(arr)
                .simple(m)
                .stream().collect(Collectors.toList());
    }
}
