import java.io.*;
import java.util.*;
 
 
public class entry_2566279 {
 
    public static void main(String[] args) throws Exception{
        FastScanner fs = new FastScanner();
        int T = 1;
       //T=fs.nextInt();
        for (int tt = 0; tt < T; tt++) {
        		long n = fs.nextLong();
        		int k = fs.nextInt();
        		long set[] = new long[k];
        		TreeSet<Long>s  = new TreeSet<Long>();
        		
        		for(int i=0;i<k;i++){
        				set[i]=fs.nextLong();
        		}
        		long cnt=0;
        		long ndiv[] = new long[k+1];
 
        		for(int i=1;i<(1<<k);i++){
        			long temp =n;
        			int num=0;
        			for(int j=0;j<k;j++){
        				long x= i&(1<<j);
        				if(x!=0){
        					num+=1;
        					temp/=set[j];
        				}
 
        			}
        			//System.out.println("mask is "+i+" "+temp+" "+num);
        			ndiv[num]+=temp;
        		}
 
        		long ans=0;
        		for(int i=1;i<=k;i++){
        		//	System.out.println(i+" "+ndiv[i]);
        			if(i%2==0){
        				ans-=ndiv[i];
        			}else{
        				ans+=ndiv[i];
        			}
        		}
         		System.out.println(ans);
        }
    }
 
  
 
    static void sort(int[] a) {
        ArrayList<Integer> l = new ArrayList<>();
        for (int i : a) l.add(i);
        Collections.sort(l);
        for (int i = 0; i < a.length; i++) a[i] = l.get(i);
    }
 
    static class FastScanner {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer("");
 
        String next() {
            while (!st.hasMoreTokens())
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            return st.nextToken();
        }
 
        int nextInt() {
            return Integer.parseInt(next());
        }
 
        long[] readArray(int n) {
            long[] a = new long[n];
            for (int i = 0; i < n; i++) a[i] = nextLong();
            return a;
        }
 
        long nextLong() {
            return Long.parseLong(next());
        }
    }
 
}