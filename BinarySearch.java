import java.util.Scanner;
public class BinarySearch {
      public static void main(String[] args) {
        int[] arr = {1, 5, 6, 7, 27, 33, 37, 42, 55, 85, 99};
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the element you want to search : ");
        int searchNum = sc.nextInt();

        int low = 0;
        int high = arr.length - 1;
        int mid = 0;
        while(low<=high){
            mid = (low+high)/2;
            if(searchNum==arr[mid]){
                System.out.println("element found at index "+mid);
                break;
            }
            else if(searchNum<arr[mid]){
                high = mid-1;
            }
            else if(searchNum>arr[mid]){
                low=mid+1;
            }
            
            
        }
        if(low>high){
            System.out.println("This particular element is not present in the given array. ");
        }
        sc.close();

      } 
}
