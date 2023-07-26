import java.io.BufferedReader;
import java.io.InputStreamReader;
 
public class entry_3048873 {
    public static void main(String[] args)throws java.io.IOException{
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        long result,x,y;
        int t = Integer.parseInt(br.readLine());
        while(t-->0){
            result=1;
            String[] s  =br.readLine().split(" ");
             x = Long.parseLong(s[0]);
             y = Long.parseLong(s[1]);
             if(y>x){
                 if(y%2!=0){
                     result = (y*y)-x+1;
 
 
                 }
                 else{
                     result = ((y-1)*(y-1))+x;
 
                 }
             }
             else {
                 if(x%2!=0) {
                     result = ((x - 1) * (x - 1)) + y;
                 }
                 else{
                     result = (x*x)-y+1;
                 }
             }
            System.out.println(result);
        }
    }
}
