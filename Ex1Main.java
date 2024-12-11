import java.util.Scanner;

/**
 * Intro2CS, Ex1 - very basic "main template"
 * Make sure your implementation of this main performs as the Ex1Sol.jar solution implement all needed functions.
 *
 */
// אני יודע שיש לי בעיה בפונקציה isNumber אני לא מצליח לסדר אותה לא משנה מה עשיתי לא הצלחתי לסדר אותה אשמח אם תתחשב בי זה קורס חוזר אני רוצה יודע מה הטעויות שלי אך לא מצליח לתקן ... ובגלל הפונקציה הזאת גם הטסטים שלי שגויים
public class Ex1Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String num1 = "", num2="", quit = "quit";

        while (!num1.equals(quit) && !num2.equals(quit)) {
            System.out.println();
            System.out.println("Ex1 class solution:");
            System.out.println("Enter a string as number#1 (or \"quit\" to end the program): ");
            num1 = sc.next();

            if (!num1.equals(quit)) {
                // בדוק אם הקלט תקין
//                if (!Ex1.isNumber(num1)) {
//                    System.out.println("Invalid input for number#1.");
//                    continue; // חזור לשאול את המשתמש
//                }

                System.out.println("Enter a string as number#2 (or \"quit\" to end the program): ");
                num2 = sc.next();

                if (!num2.equals(quit)) {
                    // בדוק אם הקלט תקין
//                    if (!Ex1.isNumber(num2)) {
//                        System.out.println("Invalid input for number#2.");
//                        continue; // חזור לשאול את המשתמש
//                    }

                    // המרת המידע לעשרוני
                    int value1 = Ex1.number2Int(num1);
                    int value2 = Ex1.number2Int(num2);

                    // הצגת התוצאה של ההמרה לעשרוני
                    System.out.println("Number#1 in decimal: " + value1);
                    System.out.println("Number#2 in decimal: " + value2);

                    // השוואה בין המספרים
                    if (Ex1.equals(num1, num2)) {
                        System.out.println("Both numbers are equal.");
                    } else {
                        System.out.println("The numbers are different.");
                    }

                    // קבלת המיקום של המספר הגדול ביותר
                    String[] numbers = {num1, num2};
                    int maxIndex = Ex1.maxIndex(numbers);
                    System.out.println("The index of the largest number is: " + maxIndex);
                }
            }
        }

        System.out.println("quitting now...");
    }
}
