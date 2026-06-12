import java.util.Arrays;

public class Sorting {
   public static void main(String[] args) {
    int[] a = {2, 5, 1, 44, 64, 99, 23, 7, 26, 42};
    System.out.println("Before sorting : "+Arrays.toString(a));

    Arrays.parallelSort(a);

    System.out.println("After sorting : "+Arrays.toString(a));
   }
}
