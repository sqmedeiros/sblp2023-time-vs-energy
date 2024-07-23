import java.io.*; 
import java.util.*;
import java.math.BigInteger;
 
public class entry_3878762 
{ 
    InputStream is; 
    PrintWriter out = new PrintWriter(System.out); ; 
    String INPUT = ""; 
  
    void run() throws Exception 
    { 
        is = System.in;
        solve(); 
        out.flush();
        out.close();
    } 
  
    public static void main(String[] args) throws Exception { new entry_3878762().run(); }
    public byte[] inbuf = new byte[1024]; 
    public int lenbuf = 0, ptrbuf = 0; 
    public int readByte() 
    { 
        if(lenbuf == -1)throw new InputMismatchException(); 
        if(ptrbuf >= lenbuf){ ptrbuf = 0; 
        try { lenbuf = is.read(inbuf); } catch (IOException e) { throw new InputMismatchException(); } 
        if(lenbuf <= 0)return -1; } return inbuf[ptrbuf++]; } 
  
    public boolean isSpaceChar(int c) 
    { 
        return !(c >= 33 && c <= 126); 
    }  
  
    public int skip() 
    {
    //  continue; String; charAt; println(); ArrayList; Integer; Long;
    //  long; Queue; Deque; LinkedList; Pair; double; binarySearch;  
	//  s.toCharArray; length(); length; getOrDefault; break;
    //  Map.Entry<Integer, Integer> e; HashMap; TreeMap;
        int b; 
        while((b = readByte()) != -1 && isSpaceChar(b)); 
        return b; 
    } 
  
    public double nd() 
    { 
        return Double.parseDouble(ns()); 
    } 
  
    public char nc() 
    { 
        return (char)skip(); 
    } 
  
    private String ns() 
    { 
        int b = skip(); 
        StringBuilder sb = new StringBuilder(); 
        while(!(isSpaceChar(b)))
        { 
            sb.appendCodePoint(b); b = readByte();
        } 
        return sb.toString(); 
    } 
  
    private int ni() 
    { 
        return (int)nl(); 
    }
    
    private long nl() 
    {
        long num = 0; 
        int b; 
        boolean minus = false; 
        while((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-')); 
        if(b == '-')
        { 
            minus = true; b = readByte(); 
        } 
        while(true)
        { 
            if(b >= '0' && b <= '9')
            { 
                num = num * 10 + (b - '0'); 
            }
            else { return minus ? -num : num; } b = readByte(); 
        }
    } 
  
    class Pair 
    { 
        int first; 
        int second; 
        Pair(int a, int b) 
        { 
            first = a; 
            second = b; 
        }   
    }
    
    //  KMP ALGORITHM
    void KMPSearch(String pat, String txt) {
        int M = pat.length(); int N = txt.length();
        int lps[] = new int[M]; int j = 0;
        computeLPSArray(pat, M, lps); int i = 0;
        while (i < N) {
            if (pat.charAt(j) == txt.charAt(i)) {
                j++;
                i++;
            }
            if (j == M) {
                j = lps[j - 1];
            }
            else if (i < N && pat.charAt(j) != txt.charAt(i)) {
                if (j != 0) j = lps[j - 1];
                else i = i + 1;
            }
        }
    }
  
    void computeLPSArray(String pat, int M, int lps[]) {
        int len = 0; int i = 1; lps[0] = 0;
        while (i < M) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            }
            else {
                if (len != 0) {
                    len = lps[len - 1];
                }
                else {
                    lps[i] = len;
                    i++;
                }
            }
        }
    }
 
    int FirstAndLastOccurrenceOfAnElement(int[] arr, int target, boolean findStartIndex)
    {
        int ans = -1;
        int n = arr.length;
        int low = 0; int high = n-1;
        while(low <= high)
        {
            int mid = low + (high - low)/2;
            if(arr[mid] > target) high = mid-1;
            else if(arr[mid] < target) low = mid+1;
            else
            {
                ans = mid;
                if(findStartIndex) high = mid-1;
                else low = mid+1;
            }
        }
        return ans;
    }
 
    //  Print All Subsequence.
    static ArrayList<Integer> qwerty = new ArrayList<>();
    void printAllSubsequence(int[] arr, int index, int n)
    {
        if(index >= n) {
            for(int i=0; i<qwerty.size(); i++) out.print(qwerty.get(i) + " ");
            if(qwerty.size() == 0) out.print(" "); out.println();
            return;
        }
        qwerty.add(arr[index]); printAllSubsequence(arr, index+1, n);
        qwerty.remove(qwerty.size()-1); printAllSubsequence(arr, index+1, n);
    }
    //  Print All Subsequence.
 
    //  Print All Subsequence. with sum k.
    static ArrayList<Integer> qwerty2 = new ArrayList<>();
    void printSubsequenceWithSumK(int[] arr, int index, int K, int sum, int n)
    {
        if(index >= n) {
            if(sum == K) 
            {
                for(int i=0; i<qwerty2.size(); i++)
                    out.print(qwerty2.get(i) + " ");
                out.println();
            }
            return;
        }
        qwerty2.add(arr[index]);
        sum += arr[index];
        printSubsequenceWithSumK(arr, index+1, K, sum, n);
        sum -= arr[index];
        qwerty2.remove(qwerty2.size()-1); 
        printSubsequenceWithSumK(arr, index+1, K, sum, n);
    }
    //  Print All Subsequence. with sum k.
 
    int[] na(int n)
    {
        int[] arr = new int[n];
        for(int i=0; i<n; i++) arr[i]=ni();
        return arr;
    }
 
    long[] nal(int n)
    {
        long[] arr = new long[n];
        for(int i=0; i<n; i++) arr[i]=nl();
        return arr;
    }
    
    void solve()
    {
        int test_case = 1;
        while(test_case-- > 0)
        {
            int n = ni(); int k = ni();
			int[] arr = na(n);
			if(n == 1) {
				out.println("IMPOSSIBLE");
				continue;
			}
			HashMap<Integer, Integer> map = new HashMap<>();
			for(int i=0; i<n; i++) map.put(arr[i], i);
			int p = -1, q = -1;
			for(int i=0; i<n; i++) {
				int dist = k - arr[i];
				p = i;
				if(map.containsKey(dist) && map.get(dist) != p) {
					q = map.get(dist);
					break;
				}
			}
			
			if(p == -1 || q == -1) {
				out.println("IMPOSSIBLE");
			} else {
				out.println((p + 1) + " " + (q + 1));
			}
        }
    }
}
