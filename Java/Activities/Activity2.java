package activities;

import java.util.Arrays;

public class Activity2 {
    public static void main (String[] args) {
        int[] numArr = {10, 77, 10, 54, -11, 10};
        System.out.println("Original Array: " + Arrays.toString(numArr));
        int search_Num = 10;
        int Sum = 30;

        System.out.println("Result: " + result(numArr, search_Num, Sum));
    }

    public static boolean result(int[] numbers, int search_Num, int Sum) {
        int temp_sum = 0;
        for (int number : numbers) {
            if (number == search_Num) {
                temp_sum += search_Num;
            }

            if (temp_sum > Sum) {
                break;
            }
        }
        return temp_sum == Sum;
    }
}