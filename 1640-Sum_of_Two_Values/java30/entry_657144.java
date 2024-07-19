import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class entry_657144 { // 2SUM REAL 
	static int[][] arr;
	
	static int n, target;
	
	public static void merge(int l, int m, int r) 
    { 
        int n1 = m - l + 1; 
        int n2 = r - m; 
 
        int[][] L = new int[n1][arr[0].length]; 
        int[][] R = new int[n2][arr[0].length]; 
 
        for (int i = 0; i < n1; ++i) 
            L[i] = arr[l + i]; 
        for (int j = 0; j < n2; ++j) 
            R[j] = arr[m + 1 + j]; 
 
        int i = 0, j = 0;  
        int k = l; 
        while (i < n1 && j < n2) { 
            if (L[i][0] <= R[j][0]) { 
                arr[k] = L[i]; 
                i++; 
            } 
            else { 
                arr[k] = R[j]; 
                j++; 
            } 
            k++; 
        } 
 
        while (i < n1) { 
            arr[k] = L[i]; 
            i++; 
            k++; 
        } 
 
        while (j < n2) { 
            arr[k] = R[j]; 
            j++; 
            k++; 
        } 
    } 
  
 
    public static void sort(int l, int r) 
    { 
        if (l < r) { 
            int m = (l + r) / 2; 
  
            sort(l, m); 
            sort(m + 1, r); 
  
            merge(l, m, r); 
        } 
    } 
	
	public static void sort() {
		sort(0, arr.length - 1);
	}
	
	public static void main (String[] args) throws IOException {
 
		System.out.println(); // DELETE LINE WHEN SUBMITTING
		BufferedReader x = new BufferedReader(new InputStreamReader(System.in)); 
		StringTokenizer st = new StringTokenizer(x.readLine()); 
		n = Integer.parseInt(st.nextToken());
		target = Integer.parseInt(st.nextToken());
		arr = new int[n][2];
		st = new StringTokenizer(x.readLine()); 
		for (int i = 0; i < n; i++) {
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = i + 1;
		}
		sort();
		int one = 0;
		int two = n - 1;
		
		while (one != two && arr[one][0] + arr[two][0] != target) {
			int sum = arr[one][0] + arr[two][0];
			if (sum < target) one++;
			if (sum > target) two--;
		}
		
		if (arr[one][0] + arr[two][0] == target && one != two) System.out.println(arr[one][1] + " " + arr[two][1]);
		else System.out.println("IMPOSSIBLE");
		
		x.close();
	}
}
