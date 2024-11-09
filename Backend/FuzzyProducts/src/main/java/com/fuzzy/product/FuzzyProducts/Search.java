package com.fuzzy.product.FuzzyProducts;

import java.util.ArrayList;
import java.util.Arrays;

public class Search {

    /**
     * Function to look for products with a query string. First it will try for
     * exact match on product id and name. Second will try for a fuzzy search with
     * Levenshtein distance on product name.
     * 
     * @param query search string
     * @param list  of products to check
     * @return list of products
     */
    public static ArrayList<Product> findProducts(String query, ArrayList<Product> list) {
        // First try for exact matches
        ArrayList<Product> products = exactMatches(query, list);

        // If no exact matches exist then look for best fuzzy search match
        if (products.isEmpty()) {
            Product p = fuzzySearch(query, list);
            if (p != null) {
                products.add(p);
            }
        }
        return products;
    }

    /**
     * Exact matches lookup on product id and names
     * 
     * @param query parameter
     * @param list  list of products
     * @return return list of matches
     */
    private static ArrayList<Product> exactMatches(String query, ArrayList<Product> list) {
        ArrayList<Product> products = new ArrayList<Product>();

        // Loop through list and check name and product ids for exact matches
        for (Product p : list) {
            if (p.getName().equals(query) || Integer.toString(p.getProductId()).equals(query)) {
                products.add(p);
            }
        }

        return products;
    }

    /**
     * Fuzzy search on Product.name
     * 
     * @param query parameter
     * @param list  of products
     * @return return best match
     */
    private static Product fuzzySearch(String query, ArrayList<Product> list) {
        int dist = Integer.MAX_VALUE;
        Product result = null;

        // Loop through list and find the closest match
        for (Product p : list) {
            int curr = levenshteinDistance(query, p.getName());
            if (curr < dist) {
                dist = curr;
                result = p;
            }
        }

        return result;
    }

    /**
     * Distance function to check similarity of two strings
     * 
     * @param str1 first String to check
     * @param str2 second String to check
     * @return int value of how closely similar the two Strings are
     */
    public static int levenshteinDistance(String str1, String str2) {

        // Matrix to store calculated values
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];

        // Loop through both strings
        for (int i = 0; i <= str1.length(); i++) {
            for (int j = 0; j <= str2.length(); j++) {

                if (i == 0) {
                    // str1 empty case then add all str2 values
                    dp[i][j] = j;
                } else if (j == 0) {
                    // str2 empty case then add all str1 values
                    dp[i][j] = i;
                } else {

                    // find the minimum among the three operations, replace, delete or insert
                    // character
                    dp[i][j] = minm_edits(dp[i - 1][j - 1] + NumOfReplacement(str1.charAt(i - 1), str2.charAt(j - 1)), // replace
                            dp[i - 1][j] + 1, // delete
                            dp[i][j - 1] + 1); // insert
                }
            }
        }

        // Return the value matching the last place in matrix
        return dp[str1.length()][str2.length()];
    }

    /**
     * Function to check if a character is the same for the purpose of replacing in
     * distance function
     * 
     * @param c1 first character
     * @param c2 second character
     * @return 0 if its the same, 1 if different
     */
    static int NumOfReplacement(char c1, char c2) {
        return c1 == c2 ? 0 : 1;
    }

    /**
     * Returns the minimum value of the integers provided
     * 
     * @param nums all int values to check
     * @return return the lowest of the provided integers, returns MAX_VALUE if no
     *         input
     */
    static int minm_edits(int... nums) {
        return Arrays.stream(nums).min().orElse(Integer.MAX_VALUE);
    }

}
