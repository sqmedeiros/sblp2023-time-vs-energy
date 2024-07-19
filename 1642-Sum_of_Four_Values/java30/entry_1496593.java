import java.util.*;
import java.io.*;
 
public class entry_1496593 {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n=in.nextInt(), x=in.nextInt();
		int [][]arr=new int[n][2];
		for(int i=0;i<n;i++) {
			arr[i][0]=in.nextInt();
			arr[i][1]=i;
		}
		Arrays.sort(arr, (a,y)->a[0]-y[0]);
		String ans="IMPOSSIBLE";
		for(int r=0;r<n;r++) {
			for(int i=r+1;i<n;i++) {
				int x1=x-arr[i][0]-arr[r][0];
				for(int j=i+1, k=n-1;j<k;j++) {
					while(j<k&&arr[j][0]+arr[k][0]>x1) {
						k--;
					}
					if(j<k&&arr[j][0]+arr[k][0]==x1) {
						ans=""+(arr[i][1]+1)+" "+(arr[j][1]+1)+" "+(arr[k][1]+1)+" "+(arr[r][1]+1);
						break;
					}
				}
			}
		}
		
 
		System.out.println(ans);
		in.close();
	}
 
}