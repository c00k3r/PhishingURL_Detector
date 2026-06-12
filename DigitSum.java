import java.util.Scanner;
public class DigitSum {
    public static void main(String[] args) {
   Scanner sc = new Scanner(System.in);
   System.out.println("Enter a number between 0 and 1000 : ");
   int number = sc.nextInt();

   if(number<0 || number>1000){
    System.out.println("Enter valid number!!");
    return;
   }

   int sum=0;
   int temp=number;

   while(temp>0){
    sum+=temp%10;
    temp/=10;
   }
   System.out.println("Sum of the digits in " + number + "is " + sum);
    }
}
