import java.util.Scanner;
 
	
public class entry_308091 {
	static long MOD = (int)(1e9+7);
	static long DIV2 = (int)(5e8+4);
	static long rangeSum(long l, long r){
		long num = r-l+1;
		long avg = l+r;
		num%=MOD;
		avg%=MOD;
		long ans = num*avg;
		ans%=MOD;
		ans=(ans*DIV2)%MOD;
		
		return ans;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] fact = new int[1000001];
		Scanner scan = new Scanner(System.in);
		long n = scan.nextLong();
		long sqrt = (long)Math.sqrt(n);
		long sum = 0;
		for(int i=1;i<sqrt;i++){
			sum+=i*(n/i);
			sum+=i*(rangeSum(n/(i+1)+1,n/i));
			sum%=MOD;
		}
		for(long i=sqrt;i<=n/sqrt;i++){
			sum+=i*(n/i);
			sum%=MOD;
		}
		System.out.println(sum);
	}
 
}