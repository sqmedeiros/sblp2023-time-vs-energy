import java.util.Scanner;
 
public class entry_3148224 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] a = new long[n];
        for(int i = 0 ; i < n; i++){
            a[i] = sc.nextInt();
        }
        sc.close();
        long msf = Integer.MIN_VALUE;
        long meh = 0;
        for(int i = 0 ; i < n; i++){
            meh += a[i];
            msf = Math.max(msf, meh);
            meh = Math.max(meh, 0);
        }
        System.out.println(msf);
    }
    
}
