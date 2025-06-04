package StringProblems;

public class RotateArrayRight {

    public static void rotateRightByOne(char[] arr) {
        int n = arr.length;
        if (n <= 1) return; // No need to rotate if 0 or 1 elements

        char last = arr[n - 1]; // Store last element

        // Shift all elements one step to the right
        for (int i = n - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
        }

//        arr[0] = last; // Set last element to the first position
    }

    public static void main(String[] args) {
        char[] arr = {'a', 'b', 'c', 'd', 'e'};
        rotateRightByOne(arr);

        // Print rotated array
        for (char c : arr) {
            System.out.print(c + " ");
        }
    }
}
