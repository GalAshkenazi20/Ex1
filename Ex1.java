/**
 * This class represents a simple solution for Ex1.
 * As defined here: https://docs.google.com/document/d/1AJ9wtnL1qdEs4DAKqBlO1bXCM6r6GJ_J/r/edit/edit
 * In this assignment, we will design a number formatting converter and calculator.
 * In general, we will use Strings as numbers over basis of binary till Hexa.
 * [2-16], 10-16 are represented by A,B,..G.
 * The general representation of the numbers is as a String with the following format:
 * <number><b><base> e.g., “135bA” (i.e., “135”, as 10 is the default base), “100111b2”, “12345b6”,”012b5”, “123bG”, “EFbG”.
 * The following are NOT in the format (not a valid number):
 * “b2”, “0b1”, “123b”, “1234b11”, “3b3”, “-3b5”, “3 b4”, “GbG”, "", null,
 * You should implement the following static functions:
 */
public class Ex1 {
    /**
     * Convert the given number (num) to a decimal representation (as int).
     * It the given number is not in a valid format returns -1.
     * @param num a String representing a number in basis [2,16]
     * @return
     */
    public static int number2Int(String num) {
        int ans = -1;
        if(num.isEmpty()){
        return ans;
    }
        try {
            // Split the input into the number and base parts
            int bIndex = num.lastIndexOf('b');
            if (bIndex == -1 || bIndex == 0 || bIndex == num.length() - 1) {
                return ans; // Invalid format (no 'b' or 'b' in the wrong place)
            }

            String numberPart = num.substring(0, bIndex);
            String basePart = num.substring(bIndex + 1);

            // Parse the base
            int base = Integer.parseInt(basePart);
            if (base < 2 || base > 16) {
                return ans; // Invalid base
            }

            // Parse the number part in the given base
            ans = Integer.parseInt(numberPart, base);
        } catch (NumberFormatException e) {
            // Catch any parsing errors and return -1
            return -1;
        }

        return ans;
    }

    /**
     * This static function checks if the given String (g) is in a valid "number" format.
     * @param a a String representing a number
     * @return true iff the given String is in a number format
     */
    public static boolean isNumber(String a) {
        if (a == null || a.isEmpty() || !a.contains("b") || a.indexOf('b') == a.length() - 1 || a.indexOf('b') == 0)
        { return false; }
        String[] parts = a.split("b");
        if (parts.length != 2) { return false; }
        String numberPart = parts[0];
        String basePart = parts[1];
        int base;
        try { base = Integer.parseInt(basePart);
            if (base < 2 || base > 16) { return false; }
        } catch (NumberFormatException e) { return false; }
        String validChars = "0123456789ABCDEFG".substring(0, base);
        for (char c : numberPart.toCharArray()) { if (validChars.indexOf(c) == -1) { return false; } }
        return true;
    }

    /**
     * Calculate the number representation (in basis base)
     * of the given natural number (represented as an integer).
     * If num<0 or base is not in [2,16] the function should return "" (the empty String).
     * @param num the natural number (include 0).
     * @param base the basis [2,16]
     * @return a String representing a number (in base) equals to num, or an empty String (in case of wrong input).
     */
    public static String int2Number(int num, int base) {
        if (num < 0 || base < 2 || base > 16) {
            return ""; // Invalid input
        }

        // Special case for 0
        if (num == 0) {
            return "0";
        }

        String digits = "0123456789ABCDEF";
        StringBuilder result = new StringBuilder();

        while (num > 0) {
            result.insert(0, digits.charAt(num % base));
            num /= base;
        }

        return result.toString();
    }

    /**
     * Checks if the two numbers have the same value.
     * @param n1 first number
     * @param n2 second number
     * @return true iff the two numbers have the same values.
     */
    public static boolean equals(String n1, String n2) {
        boolean ans = true;

//        // Check if either of the numbers is null
//        if (n1 == null || n2 == null) {
//            return false;
//        }
//
//        // Convert both numbers to integers (using the number2Int method)
//        int num1 = number2Int(n1);
//        int num2 = number2Int(n2);
//
//        // Check if either of the conversions failed
//        if (num1 == -1 || num2 == -1) {
//            return false;
//
//        }
//
//        // Compare the two integer values
//        if (num1 != num2) {
//            ans = false;
//        }

        return ans;
    }

    /**
     * This static function search for the array index with the largest number (in value).
     * In case there are more than one maximum - returns the first index.
     * Note: you can assume that the array is not null and is not empty, yet it may contain null or none-valid numbers (with value -1).
     * @param arr an array of numbers
     * @return the index in the array in with the largest number (in value).
     *
     */
    public static int maxIndex(String[] arr) {
        int maxIndex = -1;
        int maxValue = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            int value = number2Int(arr[i]);
            if (value > maxValue) {
                maxValue = value;
                maxIndex = i;
            }
        }

        return maxIndex;
    }
    private static int convertBase(String baseStr) {
        switch (baseStr) {
            case "2":
                return 2;
            case "3":
                return 3;
            case "4":
                return 4;
            case "5":
                return 5;
            case "6":
                return 6;
            case "7":
                return 7;
            case "8":
                return 8;
            case "9":
                return 9;
            case "A":
                return 10;
            case "B":
                return 11;
            case "C":
                return 12;
            case "D":
                return 13;
            case "E":
                return 14;
            case "F":
                return 15;
            case "G":
                return 16;
            default:
                return -1;
        }
    }
}
