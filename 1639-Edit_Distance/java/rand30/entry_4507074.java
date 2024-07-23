/******************************************************************************
 
Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.
 
*******************************************************************************/
import java.util.*;
public class entry_4507074
{  
    public  static int [][] dp =  new int[5002][5002];
    
    public static  int solve(int i  , int  j  , String str1 ,String  str2){
        if(str1.length() == i)return str2.length()-j;
        if(str2.length() == j)return str1.length()-i;
        if(dp[i][j] != -1)return dp[i][j];
        int ans =0;
        if(str1.charAt(i) == str2.charAt(j)){
           ans = solve(i+1 , j+1 , str1 , str2); 
        }else{
            //replace
            int ans1 = 0;
            int ans2 = 0;
            int ans3  = 0;
            if(dp[i+1][j+1] !=-1){
                ans1 = dp[i+1][j+1];
            }else{
                ans1 =  solve(i+1 ,j+1 , str1 , str2) ; 
            }
            
            // remove
            if(dp[i+1][j] != -1){
                ans2 = dp[i+1][j];
            }else{
                 ans2 =   solve(i+1 ,j , str1 , str2) ;
            }
            
            // add 
            if(dp[i][j+1] != -1 ){
                ans3 = dp[i][j+1];
            }else{
                ans3 = solve(i ,j+1 , str1 , str2) ; 
            }
             
            ans = 1+Math.min(ans1 ,Math.min(ans2 , ans3));
        }
        return dp[i][j] =  ans; 
    }
	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		String str1  = sc.nextLine();
		String str2  =  sc.nextLine();
		 for( int i = 0 ; i <= str1.length() ; i ++){
            for( int j = 0 ;  j <= str2.length() ; j ++)
            {
                dp[i][j]= -1;
            }
        }
		System.out.println(solve(0  , 0 , str1 ,str2));
		
	}
}