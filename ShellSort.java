import java.util.Arrays;

public class ShellSort {

    public static void main(String[] args) {
        int[] arr = {36, 18, 10, 27, 3, 20, 9, 8};
        System.out.println("Original array: " + Arrays.toString(arr));
        shellSort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }

    public static void shellSort(int[] arr) {
        int incr = 1;
        while (2 * incr <= arr.length) {
            incr *= 2;
        }
        incr -= 1;

        while (incr >= 1) {
            for (int i = incr; i < arr.length; i++) {
                int toInsert = arr[i];
                int j;

                for (j = i; j >= incr && toInsert < arr[j - incr]; j -= incr) {
                    arr[j] = arr[j-incr];
                }
                arr[j] = toInsert;
            }
            incr /= 2;
        }
    }
}

/*
Initial Array: [36, 18, 10, 27, 3, 20, 9, 8]

First Increment (gap = 7):

The array is virtually divided into sublists of gap 7.
The sublists are: [36, 8], with all other elements not having pairs 7 positions apart.
After sorting the sublist [36, 8], the array becomes: [8, 18, 10, 27, 3, 20, 9, 36].
Second Increment (gap = 3):

The array is now divided into sublists of gap 3.
The sublists are: [8, 27, 9], [18, 3, 36], [10, 20].
After sorting each sublist, the array becomes: [3, 8, 10, 9, 18, 20, 27, 36].
Third Increment (gap = 1):

With a gap of 1, a regular insertion sort is applied to the entire array.
The array becomes: [3, 8, 9, 10, 18, 20, 27, 36].
Final Output: [3, 8, 9, 10, 18, 20, 27, 36]
*/

