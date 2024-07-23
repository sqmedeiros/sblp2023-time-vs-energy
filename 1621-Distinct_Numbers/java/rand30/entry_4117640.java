import java.io.*;
import java.util.*;
public class entry_4117640 {
    
    public static void main(String args[]) throws IOException {
        // Your code goes here
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
         String str[]=br.readLine().split(" ");
         int n=Integer.parseInt(str[0]);
         int x=Integer.parseInt(str[1]);
         int a[]=new int[n];
         int i;
         String h[]=br.readLine().split(" ");
         for(i=0;i<n;i++)
         a[i]=Integer.parseInt(h[i]);
         
         HashMap<Integer,mine> map=new HashMap<>();
         boolean ans=false;
         int j;
         for(i=0;i<n;i++){
             for(j=i+1;j<n;j++){
                 map.put(a[i]+a[j],new mine(i,j));
             }
         }
         for(i=0;i<n-1;i++){
             for(j=i+1;j<n;j++){
                 int sum=a[i]+a[j];
                 int search=x-sum;
                 if(map.containsKey(search)){
                     int p=map.get(search).x;
                     int q=map.get(search).y;
                     if(p!=i&&q!=j&&p!=j&&q!=i){
                         System.out.println((i+1)+" "+(j+1)+" "+(p+1)+" "+(q+1));
                         ans=true;
                         break;
                     }
                 }
             }
             if(ans)
             break;
         }
         if(!ans)
         System.out.println("IMPOSSIBLE");
         
         
            
 
         
    }
}
class mine{
    int x;
    int y;
    public mine(int a,int b){
        x=a;
        y=b;
    }
}