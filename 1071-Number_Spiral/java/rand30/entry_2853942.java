 
import java.io.BufferedReader;
 
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
 
 
public class entry_2853942 {
	static FastReader in=new FastReader();
    static final Random random=new Random();
    static long mod=1000000007L;
    static HashMap<Integer,Integer>map=new HashMap<>();
    static void ruffleSort(long[] a) {
        int n=a.length;
        for (int i=0; i<n; i++) {
            int oi=random.nextInt();
			long temp=a[oi];
            a[oi]=a[i]; a[i]=temp;
        }
        Arrays.sort(a);
    }
    public static int upper_bound(ArrayList<Integer> arr, int ele) {
    	int si = 0;
    	int ei = arr.size()-1;
    	int ans = -1;
    	while(si<=ei) {
    		int mid = (si + ei)/2;
    		if(arr.get(mid)<ele) {
    			si = mid +1;
    		}else {
    			ans = mid;
    			ei = mid -1;
    			
    		}
    	}
    	return ans;
    	
    }
    public static int lower_bound(ArrayList<Integer> arr, int ele) {
    	int si = 0;
    	int ei = arr.size()-1;
    	int ans = -1;
    	while(si<=ei) {
    		int mid = (si + ei)/2;
    		if(arr.get(mid)<=ele) {
    			ans = mid;
    			si = mid +1;
    		}
    		
    		else {
    			ei = mid -1;
    			
    			
    		}
    	}
    	return ans;
    	
    }
    
    
    
    
	
	public static void main(String[]args) {
		
        FastReader res = new FastReader();
		
		int t = res.nextInt();
		
		
		
		
		while(t>0) {
			long x = res.nextInt();
			long y = res.nextInt();
			
			if(y>=x) {
				if(y%2!=0) {
					long ans = y*y - x +1;
					System.out.println(ans);
				}else {
					long ans = (y-1)*(y-1) +x;
					System.out.println(ans);
				}
			}else {
				if(x%2!=0) {
					long ans = (x-1)*(x-1) +y;
					System.out.println(ans);
				}else {
					long ans = x*x - y +1;
					System.out.println(ans);
				}
				
			}
			
			
			
			
			
			
			
			
			
        		
        	
        	
        	
        	
        	
        	
        	
 
			
			t--;
			
			
			
			
			
			
	        
			
			
			
		}
	}
	static int max(int a, int b)
    {
        if(a<b)
        	return b;
        return a;
    }
 
 
    static void ruffleSort(int[] a) {
        int n=a.length;
        for (int i=0; i<n; i++) {
            int oi=random.nextInt(n), temp=a[oi];
            a[oi]=a[i]; a[i]=temp;
        }
        Arrays.sort(a);
    }
 
    static < E > void print(E res)
    {
        System.out.println(res);
    }
 
 
    static  int gcd(int a,int b)
    {
        if(b==0)
        {
            return a;
        }
        return gcd(b,a%b);
    }
 
    static int lcm(int a, int b)
    {
        return (a / gcd(a, b)) * b;
    }
 
 
    static int abs(int a)
    {
        if(a<0)
            return -1*a;
        return a;
    }
	 static class FastReader
	    {
	        BufferedReader br;
	        StringTokenizer st;
	 
	        public FastReader()
	        {
	            br = new BufferedReader(new
	                    InputStreamReader(System.in));
	        }
	 
	        String next()
	        {
	            while (st == null || !st.hasMoreElements())
	            {
	                try
	                {
	                    st = new StringTokenizer(br.readLine());
	                }
	                catch (IOException  e)
	                {
	                    e.printStackTrace();
	                }
	            }
	            return st.nextToken();
	        }
	        int nextInt()
	        {
	            return Integer.parseInt(next());
	        }
	 
	        long nextLong()
	        {
	            return Long.parseLong(next());
	        }
	 
	        double nextDouble()
	        {
	            return Double.parseDouble(next());
	        }
	        String nextLine()
	        {
	            String str = "";
	            try
	            {
	                str = br.readLine();
	            }
	            catch (IOException e)
	            {
	                e.printStackTrace();
	            }
	            return str;
	        }
	 
	        int [] readintarray(int n) {
	            int res [] = new int [n];
	            for(int i = 0; i<n; i++)res[i] = nextInt();
	            return res;
	        }
	        long [] readlongarray(int n) {
	            long res [] = new long [n];
	            for(int i = 0; i<n; i++)res[i] = nextLong();
	            return res;
	        }
	    }
	 
	}
class pair{
	int x;
	int y;
}
