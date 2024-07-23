 
import java.util.Arrays;
import java.util.Scanner;
 
public class entry_3112574 {
 
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		String s1=sc.nextLine();
		String s2=sc.nextLine();
		int n=s1.length();
		int m=s2.length();
		int mat[][]=new int[n+1][m+1];
		for(int i=0;i<m+1;i++) {
			mat[0][i]=i;
		}
		
		for(int i=0;i<n+1;i++) {
			mat[i][0]=i;
		}
		
		for(int i=1;i<n+1;i++) {
			for(int j=1;j<m+1;j++) {
				if(s1.charAt(i-1)==s2.charAt(j-1)) {
					mat[i][j]=mat[i-1][j-1];
				}else {
					mat[i][j]=1+Math.min(Math.min(mat[i][j-1],mat[i-1][j]),mat[i-1][j-1]);
				}
			}
		}
		
		System.out.println(mat[n][m]);
 
	}
 
}