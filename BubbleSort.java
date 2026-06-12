import java.util.Arrays;

public class BubbleSort {
  public static void main(String[] args) {
    int[] arr = {35, 1, 5, 16, 3, 9, 12};

    int temp;
    for(int i=0; i<7; i++){
        for(int j=0; j<6; j++){
            if(arr[j]>arr[j+1]){
                temp = arr[j];
                arr[j] = arr[j+1];
                arr[j+1] = temp;
            }
        }
    }
    System.out.println(Arrays.toString(arr));
  }
}
