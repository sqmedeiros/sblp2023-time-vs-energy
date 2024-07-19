import java.io.*;
 
import java.util.*;
/*
 
 
 */
 
 
 
public class entry_1787289 {
	static FastReader sc=null;
 
	public static void main(String[] args) {
		PrintWriter out=new PrintWriter(System.out);
		sc=new FastReader();
		int n=sc.nextInt();
		Pair p[]=new Pair[n];
		for(int i=0;i<n;i++) {
			p[i]=new Pair(sc.nextInt(),sc.nextInt(),sc.nextInt());
		}
		Arrays.sort(p);
		long dp[]=new long[n];
		SegTree s=new SegTree(0,n-1,dp);
		
		for(int i=0;i<n;i++) {
			dp[i]=p[i].m;
			int id=bs(p,p[i].l);
			if(id>-1)dp[i]+=dp[id];
			if(i>0) dp[i]=Math.max(dp[i], dp[i-1]);
		}
		out.println(dp[n-1]);
		out.close();
		
	}
	static int bs(Pair a[],int s) {
		int l=-1,r=a.length;
		while(l+1<r) {
			int mid=(l+r)/2;
			if(a[mid].r<s)l=mid;
			else r=mid;
		}
		return l;
	}
	static class Pair implements Comparable<Pair>{
		int l,r,m;
		Pair(int l,int r,int m){
			this.l=l;
			this.r=r;
			this.m=m;
		}
		@Override
		public int compareTo(Pair o) {
			return this.r-o.r;
		}
	}
	
	
	
	static class SegTree{
		SegTree left,right;
		int l,r;
		long max=0;
		SegTree(int l,int r,long a[]){
			this.l=l;
			this.r=r;
			if(l==r) {
				max=a[l];
				return;
			}
			else {
				int mid=(l+r)/2;
				left=new SegTree(l,mid,a);
				right=new SegTree(mid+1,r,a);
			}
			recalc();
		}
		public void set(int i,long val) {
			if(l==r) {
				this.max=val;
				return;
			}
			if(left.r>=i)left.set(i, val);
			else right.set(i, val);
			recalc();
		}
		public void recalc() {
			if(l==r)return;
			this.max=Math.max(left.max,right.max);
		}
		public long rangeMax(int l,int r) {
			if(l>this.r || r<this.l) return Integer.MIN_VALUE;
			else if(l<=this.l && r>=this.r) {
				return this.max;
			}
			else{
				return Math.max(left.rangeMax(l,r),right.rangeMax(l, r));
			}	
		}
//		public long rangeMin(int l,int r) {
//			if(l>this.r || r<this.l) return Long.MAX_VALUE;
//			else if(l<=this.l && r>=this.r) {
//				return this.min;
//			}
//			else{
//				return Math.min(left.rangeMin(l,r),right.rangeMin(l, r));
//			}	
//		}
		
	}
 
	
	
 
	static int[] ruffleSort(int a[]) {
		ArrayList<Integer> al=new ArrayList<>();
		for(int i:a)al.add(i);
		Collections.sort(al);
		for(int i=0;i<a.length;i++)a[i]=al.get(i);
		return a;
	}
	
	
	
	static void print(ArrayList<Integer> al) {
		for(int e:al) {
			System.out.print(e+" ");
		}
		System.out.println();
	}
	
	static void print(int a[]) {
		for(int e:a) {
			System.out.print(e+" ");
		}
		System.out.println();
	}
	
	static void print(char a[]) {
		for(char e:a) {
			System.out.print(e);
		}
		System.out.println();
	}
	
	static void print(long a[]) {
		for(long e:a) {
			System.out.print(e+" ");
		}
		System.out.println();
	}
	
	static long gcd(long a,long b) {
		if(b==0)return a;
		else return gcd(b,a%b);
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
        int[] readArray(int n) {
    		int a[]=new int [n];
    		for(int i=0;i<n;i++) {
    			a[i]=sc.nextInt();
    		}
    		return a;
    	}
    } 
}