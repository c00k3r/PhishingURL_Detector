public class PostfixPrefix {
    public static void main(String[] args) {
        int a=5;
        int b = a++;

        int c=7;
        int d=c--;
        System.out.println("Value of b is : "+a);
        System.out.println("Value of d is : "+c);
    }
}
