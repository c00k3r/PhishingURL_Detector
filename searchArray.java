public class searchArray {
   public static void main(String[] args) {
    int[] a = {8, 14, 16, 78, 34, 22};
    int searchNum = 78;
    boolean found = false;
    for(int i=0; i<a.length; i++){
        if(searchNum == a[i]) {
            System.out.println(searchNum+ "elment found at index : "+i);
        found = true;
    } if (!found){
        System.out.println(searchNum+" not found in the array");
    }
    
    }
   }
}
