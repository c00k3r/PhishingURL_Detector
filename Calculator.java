import java.util.Scanner;
public class Calculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first number : ");
        double num1 = sc.nextDouble();

        System.out.println("Enter second number : ");
        double num2 = sc.nextDouble();

        System.out.println("Enter operation(+, -, *, /): ");
        char operation = sc.next().charAt(0);
        double result;

        switch(operation){
            case '+' :
            result = num1 + num2;
            System.out.println("Result is : "+result);
            break;

            case '-' :
            result = num1 - num2;
            System.out.println("Result is : "+result);
            break;

            case '*' :
            result = num1 * num2;
        System.out.println("Result is : "+result);
    break;
            case '/' :
            result = num1 / num2;
        System.out.println("Result is : "+result);
    break;
default: System.out.println("Invalid operator ");
        }


        sc.close();
             
    }

}
