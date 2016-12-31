import java.util.Arrays;
import java.util.Random;

/**
 * This class contains different sorts implementations with a main method executing them on a int array.
 */
public class Sorts {

    /**
     * The main method.
     *
     * @param args arguments are passed to an array of integers to sort, a random array will be generated if empty
     */
    public static void main(final String[] args) {
        final Random r = new Random();
        final int[] array;

        // Generate random array
        if (args.length == 0) {
            int len = r.nextInt(16);
            array = new int[len > 2 ? len : 2];

            for (int i = 0; i < array.length; i++) {
                array[i] = r.nextInt(16);
            }
        } else {
            // Parsed arguments to an integer array
            array = new int[args.length];

            for (int i = 0; i < array.length; i++) {
                array[i] = Integer.parseInt(args[i]);
            }
        }

        System.out.println("Array to sort: " + Arrays.toString(array));

        // Bubble sort
        int[] t1 = Arrays.copyOf(array, array.length);
        bubbleSort(t1);
        System.out.println("  Bubble sort: " + Arrays.toString(t1));
    }

    /**
     * Swaps two elements at index {@code a} and {@code b} in the given array.
     *
     * @param array the array with elements to swap
     * @param a index of first element to swap
     * @param b index of second element to swap
     */
    static void swapElementsByIndex(final int[] array, final int a, final int b) {
        final int tmp = array[a];
        array[a] = array[b];
        array[b] = tmp;
    }

    static void bubbleSort(final int[] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length - i; j++) {
                if (array[j - 1] > array[j]) {
                    swapElementsByIndex(array, j - 1, j);
                }
            }
        }
    }
}