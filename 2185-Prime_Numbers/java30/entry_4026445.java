 
import java.util.Scanner;
 
public class entry_4026445 {
    public static void main(String[] args) {
       Scanner sc=new Scanner(System.in);
        long n=sc.nextLong();
        int k=sc.nextInt();
        long []primes=new long[k];
        long []Inclusion_exclusion=new long[k+1];
        for(int i=0;i<k;i++) primes[i]= sc.nextLong();
        for(int mask=1;mask<(1<<k);mask++){
            int num_of_divisor=0;
            long temp=n;
            for(int i=0;i<k;i++){
                if(( (1<<i) & mask) !=0){
                    num_of_divisor++;
                    temp=temp/primes[i];
                }
            }
            Inclusion_exclusion[num_of_divisor] += temp;
        }
 
        long ans=0;
        for(int i=1;i<=k;i++){
            /*
            add the odd ones
            subs the even ones
             */
            if(i%2==1)
            ans +=Inclusion_exclusion[i];
            else
            ans -=Inclusion_exclusion[i];
        }
        System.out.println(ans);
    }
}