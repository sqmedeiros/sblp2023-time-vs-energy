import java.util.*;
import java.lang.*;
class entry_2077151 {
    static Scanner sr = new Scanner(System.in);
    public static void main(String args[]) {
        int mod=1000000007;
        int n=sr.nextInt();
        int x=sr.nextInt();
        int a[]=new int[n];
        for(int i=0;i<n;i++)
        {
            a[i]=sr.nextInt();
        }
        int t[]=new int[x+1];
        t[0]=1;
        for(int i=1;i<=n;i++)
        {
            for(int j=1;j<=x;j++)
            {
                if(a[i-1]<=j)
                    t[j]=(t[j-a[i-1]]+t[j])%mod;
            }
        }
        System.out.println(t[x]);
    }
}
