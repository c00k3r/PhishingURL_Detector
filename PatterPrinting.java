public class PatterPrinting {
  public static void main(String[] args) {
    for(int i=1; i<=4; i++){
      for(int j=3; j>=i; j--){
        System.out.print(" ");
      }
      for(int k=3; k>=i; k--){
        System.out.print(" ");
      }
      for(int l=1; l>=(2*i)-(1); l++){
        System.out.print("*");
      }
      System.out.println();
    }  
 }
}
