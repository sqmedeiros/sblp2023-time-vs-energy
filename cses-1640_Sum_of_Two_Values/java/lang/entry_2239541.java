import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.*;
 
public class entry_2239541 {
 
	static int search(int l,int r,int x,int[] a) {
		if (l>=r) {
			return l;
		}int mid = (l+r)/2;
		if (a[mid]>x) {
			return search(l,mid-1,x,a);
		}else if (a[mid]<x) {
			
		
			return search(mid+1,r,x,a);
		}
		//System.out.println(mid);
		return mid;
	}
	
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		Reader.init(System.in);
		int n = Reader.nextInt(); int m = Reader.nextInt();
		
		//HashSet<Integer> h = new HashSet<Integer>();
		//int c=0;
		int[] a = new int[n];
		for (int i=0;i<n;i++) {
			a[i] = Reader.nextInt();
			//if (h.contains(p)) continue ;
			//c+=1;
			//h.add(p);
		}
		int[] b= new int[n];
		for (int j=0;j<n;j++) {
			b[j]=a[j];
		}
		Arrays.sort(a);
		if (n==1) System.out.println("IMPOSSIBLE");
		
		else {
		//System.out.println(Arrays.toString(b));
		int to = n-1;
		for (int i=0;i<n-1;i++) {
			
			if (m-a[i]>0) {
				to=search(i+1,to,m-a[i],a);
				if (a[to]+a[i]==m) {
					for (int j=0;j<n;j++) {
						if (a[to]==b[j]) {
							to=j;
							break;
						}
					}for (int j=0;j<n;j++) {
						if (a[i]==b[j] && j!=to) {
							i=j;
							break;
						}
					}
					System.out.print(i+1+ " " );
					System.out.print(to+1);
					break;
				}
				
			}
			if (i==to || (i+1==to && i==n-2)) {
				System.out.println("IMPOSSIBLE");
				break;
			}
			//ystem.out.println(to);
			
		}
		
		}
	/*	int[] b = new int[m];
		for (int i=0;i<m;i++) {
			b[i] = Reader.nextInt();
			//if (h.contains(p)) continue ;
			//c+=1;
			//h.add(p);
		}
	//	Arrays.sort(a);
		for (int i=0;i<m;i++) {
			
		}
		
	/*	int[] b = new int[m];
		for (int i=0;i<m;i++) {
			b[i] = Reader.nextInt();
			//if (h.contains(p)) continue ;
			//c+=1;
			//h.add(p);
		}
		Arrays.sort(a) ; Arrays.sort(b);
		
		//System.out.println(c);
		int c = 0; int ans =0 ; int c1 =0; 
		while (c1 < n && c<m) {
			//System.out.println(1);
			
				if (a[c1]+k>=b[c] && a[c1]-k<=b[c]) {
					ans+=1;
					c+=1;
					c1+=1;
				}
				else if (a[c1]+k<b[c]) {
					
					c1+=1;
					//break;
				}else if ( a[c1] -k > b[c]) {
					
					c+=1;
					//break;
				}
			
		}
		System.out.println(ans);
		*/
		
	}
 
}
 
 
 
 
class Reader {
    static BufferedReader reader;
    static StringTokenizer tokenizer;
 
    /** call this method to initialize reader for InputStream */
    static void init(InputStream input) {
        reader = new BufferedReader(
                     new InputStreamReader(input) );
        tokenizer = new StringTokenizer("");
    }
 
    /** get next word */
    static String next() throws IOException {
        while ( ! tokenizer.hasMoreTokens() ) {
            //TODO add check for eof if necessary
            tokenizer = new StringTokenizer(
                   reader.readLine() );
        }
        return tokenizer.nextToken();
    }
 
    static int nextInt() throws IOException {
        return Integer.parseInt( next() );
    }
	
    static double nextDouble() throws IOException {
        return Double.parseDouble( next() );
    }
}
 
 
 
