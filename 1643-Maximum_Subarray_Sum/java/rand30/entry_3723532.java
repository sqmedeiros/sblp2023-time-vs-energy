import java.io.*;
import java.util.*;
 public class entry_3723532 {
      
	public static void main (String[] args)throws IOException {
BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
Scanner sc=new Scanner(System.in);
//	StringBuilder str=new StringBuilder("");
    String h[]=br.readLine().split(" ");
	int n=Integer.parseInt(h[0]);
//	int x=Integer.parseInt(h[1]);
	int a[]=new int[n];
	int i;
    String g[]=br.readLine().split(" ");
	for(i=0;i<n;i++){
	    a[i]=Integer.parseInt(g[i]);
	}
    long ans=Integer.MIN_VALUE;
    long sum=0;
    for(i=0;i<n;i++){
        if((sum+a[i])>0){
            sum=sum+a[i];
             ans=Math.max(ans,sum);
        }
        else{
            ans=Math.max(ans,a[i]);
            sum=Math.max(0,a[i]);
        }
       
        
    }
    System.out.println(ans);
 }
 }
 class mine{
     int a;
     int b;
     public mine(int x,int y){
         a=x;
         b=y;
     }
 }
	
 
