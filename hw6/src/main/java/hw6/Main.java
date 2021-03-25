package hw6;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(arrAfterFour(new int[]{1, 2, 4, 4})));
        System.out.println(Arrays.toString(arrAfterFour(new int[]{1, 2, 3, 5})));
        System.out.println(arrOneAndFour(new int[]{1, 2, 4, 4}));
        System.out.println(arrOneAndFour(new int[]{1, 1, 4, 4}));
        System.out.println(arrOneAndFour(new int[]{1, 1, 1, 1}));

    }

    public static int[] arrAfterFour(int[] arr) {

        for (int i = arr.length - 1; i >= 0; i--) {
            if (arr[i] == 4) {
                return Arrays.copyOfRange(arr, i + 1, arr.length);
            }
        }
        throw new RuntimeException();
    }

    public static boolean arrOneAndFour(int[] arr) {
        int cntOne = 0;
        int cntFour = 0;

        for (int i = 0; i < arr.length; i++) {
            switch (arr[i]) {
                case 1:
                    cntOne++;
                    break;
                case 4:
                    cntFour++;
                    break;
                default:
                    return false;
            }
        }

        if (cntOne == 0 || cntFour == 0) {
            return false;
        }
        return true;
    }
}

