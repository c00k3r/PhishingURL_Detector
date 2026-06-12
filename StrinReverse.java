public class StrinReverse {
     public static void main(String[] args) {
        String Str = "Messi"; 
        char[] ca = Str.toCharArray();
        int size = ca.length;
        String reversedString = "";
        for(int i = size-1; i>=0; i--){
            reversedString = reversedString + ca[i];
             System.out.print(ca[i]);
        } 
        
     }
}
