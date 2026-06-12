import java.util.Scanner;
public class Vowels {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter alphabet : ");
        String alpha = sc.next();

        if(alpha.equals("a") || alpha.equals("e") || alpha.equals("i") || alpha.equals("o") || alpha.equals("u")){
            System.out.println("It's a vowel");
        }else{
            System.out.println("not a vowel");
        }
        sc.close();
    }
}
