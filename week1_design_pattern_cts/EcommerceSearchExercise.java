package week1_design_pattern_cts;

import java.util.Arrays;

public class EcommerceSearchExercise {

    // Checks every product one by one until it finds a match
    public static int linearSearch(String[] products, String target) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].equalsIgnoreCase(target)) {
                return i;
            }
        }
        return -1;
    }

    // Only works on a SORTED list. Repeatedly checks the middle item
    // and eliminates half the list each time — much faster for big lists.
    public static int binarySearch(String[] sortedProducts, String target) {
        int low = 0;
        int high = sortedProducts.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int comparison = sortedProducts[mid].compareToIgnoreCase(target);

            if (comparison == 0) {
                return mid;
            } else if (comparison < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        String[] products = {"Laptop", "Mouse", "Keyboard", "Monitor", "Webcam", "Headphones"};

        String searchItem = "Monitor";
        int linearResult = linearSearch(products, searchItem);
        System.out.println("[Linear Search] '" + searchItem + "' found at index: " + linearResult);

        String[] sortedProducts = products.clone();
        Arrays.sort(sortedProducts);
        System.out.println("Sorted products: " + Arrays.toString(sortedProducts));

        int binaryResult = binarySearch(sortedProducts, searchItem);
        System.out.println("[Binary Search] '" + searchItem + "' found at index: " + binaryResult);

        String missingItem = "Printer";
        System.out.println("[Linear Search] '" + missingItem + "' found at index: " + linearSearch(products, missingItem));
    }
}
