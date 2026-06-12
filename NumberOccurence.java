import java.util.Scanner;
public class NumberOccurence {
      public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[] counts = new int[51];
        System.out.println("enter integers betweeen 1 and 50 (end with 0)");
        while(true){
            int numbers = sc.nextInt();
            if(numbers==0){
                break;
            }
            if(numbers>=1 && numbers<=50){
                counts[numbers]++;
            }else{
                System.out.println("Invalid input , please enter a valiud input ");

            }
        }
        for(int i=1; i<=50; i++){
            if(counts[i]>0){
               System.out.println(i+ " occurs " +counts[i]+ " "+ (counts[i]==1?"time":"times"));
            }
        }
        sc.close();
      }
}
