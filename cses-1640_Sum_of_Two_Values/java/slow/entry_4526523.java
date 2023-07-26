import java.util.HashMap;
import java.util.Scanner;
 
public class entry_4526523 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
 
        int n = scan.nextInt();
        int t = scan.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
        }
        sumOf(arr,n,t);
    }
 
    private static void sumOf(int[] nums, int n, int t) {
        HashMap<Integer,Integer> map = new HashMap<Integer, Integer>();
        int[] ans =new int[2];
        for(int i=0;i<n;i++){
            if(map.containsKey(nums[i])){
                ans[0] = map.get(nums[i]);
                ans[1] = i+1;
            }
            else
                map.put(t-nums[i],i+1);
        }
        if(ans[0]==0){
            System.out.println("IMPOSSIBLE");
        }
        else{
            for(int i=0;i<2;i++){
                System.out.print(ans[i]+" ");
            }
        }
 
    }
}
