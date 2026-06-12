import java.util.Scanner;
public class Pyramid {
 public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    System.out.println("Enter number of lines : ");
    int lines = sc.nextInt();

    if(lines<1 || lines>10){
        System.out.println("Enter number of lines between 1 and 10 : ");
        return;
    }
    for(int i = 1; i<=10; i++){
        for(int j=i; j>=1; j--){
            System.out.print(j+ " ");
        }
        for(int j=2; j<=i; j++){
            System.out.print(j+ " ");
        }

        System.out.println();
    }
    sc.close();
 }
}
