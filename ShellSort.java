import java.util.Arrays;

public class ShellSort {

    public static void main(String[] args) {
        int[] arr = {36,18,10,27,3,20,9,8};
        System.out.println("Original array: " + Arrays.toString(arr));
        shellSort(arr);
        System.out.println("Sorted array: " + Arrays.toString(arr));
    }

    static void shellSort(int[] arr) { // Using Hibbard’s sequence
        int incr = 1;
        // Find the maximum increment less than the length of the array following Hibbard's sequence. (2^k - 1)
        while (2 * incr <= arr.length) incr = 2 * incr;
        incr = incr - 1; // Decrement to get the correct starting value according to Hibbard's sequence.

        // Continue the sorting process while the increment is at least 1.
        while (incr >= 1) {
            // Perform a gapped insertion sort for this increment size.
            for (int i = incr; i < arr.length; i++) {
                int toInsert = arr[i];
                int j;
                // Shift elements over to make room for the insertion if necessary.
                for (j = i; j >= incr && toInsert < arr[j - incr]; j -= incr) {
                    arr[j] = arr[j - incr];
                }
                // Insert the element at the correct position in the gapped sorted array.
                arr[j] = toInsert;
            }
            // Reduce the increment size for the next pass.
            incr = incr / 2;
        }
    }
}

/*
Initial Array
Our starting array is: [36, 18, 10, 27, 3, 20, 9, 8]

Setting Up Increments (Hibbard’s Sequence)
For an array of length 8, Hibbard’s sequence gives us the increments: 1, 3, 7. We start with the largest increment (7), then move to smaller increments (3, then 1).

Shell Sort Steps
1. First Pass (Increment = 7)
Compare elements that are 7 positions apart.
In our array, this would compare 36 with 8 (only one pair due to the array size and increment).
No swap is needed as 36 is not less than 8.
After this pass, the array remains unchanged: [36, 18, 10, 27, 3, 20, 9, 8].

2. Second Pass (Increment = 3)
Now, we compare elements that are 3 positions apart.
The comparisons will be between the pairs (36, 27), (18, 3), (10, 20), (27, 9).
Swap 36 and 27, 18 and 3, 10 and 20. No swap needed for 27 and 9.
After this pass, the array looks like: [27, 3, 10, 36, 18, 20, 9, 8].

3. Third Pass (Increment = 1)
Now, the increment is 1, so we do a standard insertion sort.
We sequentially compare each element with its predecessors and insert it into its correct position.
The process for this pass:
3 is already in the correct position.
Insert 20 between 3 and 27.
36 is moved to the end.
Insert 10 between 3 and 20.
Insert 18 between 10 and 20.
9 is inserted between 8 and 10.
No change for 8.
The final sorted array is [3, 8, 9, 10, 18, 20, 27, 36].
 */

