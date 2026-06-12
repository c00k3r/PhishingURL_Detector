import java.util.Arrays;

public class ArrangeArray {
    public static void main(String[] args) {
        int[] arrays = {1, -2, 3, -4, 5, -6, 7};
        int[] result = moveNegToEnd(arrays);
        System.out.println(Arrays.toString(result));
    }

    public static int[] moveNegToEnd(int[] arr) {
        int n = arr.length;
        int[] temp = new int[n];
        int index = 0;

        // First add all positive numbers
        for (int i = 0; i < n; i++) {
            if (arr[i] >= 0) {
                temp[index++] = arr[i];
            }
        }

        // Then add all negative numbers
        for (int i = 0; i < n; i++) {
            if (arr[i] < 0) {
                temp[index++] = arr[i];
            }
        }

        return temp;
    }
}
