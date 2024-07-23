import java.io.*; 
import java.util.*; 
public class entry_2348109 { 
        public static void main(String args[])throws IOException{ 
		    BufferedReader br=new BufferedReader(new InputStreamReader(System.in)); 
			StringTokenizer st=new StringTokenizer(""); 
			int t=Integer.parseInt(br.readLine()); 
			while(t-->0){ 
			   st=new StringTokenizer(br.readLine()); 
			   long y=Integer.parseInt(st.nextToken()); 
			   long  x=Integer.parseInt(st.nextToken()); 
			   long k=Math.max(y,x); 
			   long  ans=(k-1)*(k-1);
			   if(k%2!=0) 
                ans+=(x+(k-y)); 
                else 
              ans+=(y+(k-x)); 
         System.out.println(ans); 		  
			}
		
		  }
 
  } 
  
  
  
  
  
  