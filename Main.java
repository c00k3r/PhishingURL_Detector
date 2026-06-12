import java.util.Scanner;
public class Main{
public static void main(String[] args) {
   Scanner sc = new Scanner(System.in);
   System.out.print("Enter size of array ");
   int size = sc.nextInt();

   int[] numbers = new int[size];
   System.out.println("Enter " +size+ " Elements: ");
   for(int i=0; i<size; i++){
    numbers[i]=sc.nextInt();
   }
   System.out.println("Enter elements you want to delete : ");
   int ele = sc.nextInt();

   int count=0;
   for(int num : numbers){
    if( num == ele ){
      count++;
    }
  }
    int[] newArray = new int[size-count];
    int index=0;
    for(int num : numbers){
      if(num != ele){
        newArray[index++]=num;
      }
    }
      System.out.println("New array after deleting " +ele+ ":");
      for(int num : newArray){
        System.out.print(num + " ");
      }

    
   
sc.close();

 }
}