public class Practice {
    public static void main(String[] args) {
        int[] a = {7, 8, 3, 1, 2};
        int n = a.length;
        int temp;
        int swap=0;

        for(int i = 0; i < n - 1; i++) {
            for(int j = 0; j < n-1-i; j++) {
                if(a[j]>a[j + 1]) {
                    temp=a[j];
                    a[j]=a[j + 1];
                    a[j+1]=temp;
                    swap=1;
                }
            }
            if(swap == 0) {
                break;
            }
        }
        for(int i = 0; i < n; i++) {
            System.out.print(a[i]);
        }
        System.out.println("Value of swap is : " +swap);
    }
}
