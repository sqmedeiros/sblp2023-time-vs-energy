import java.util.*;
import java.io.*;
public class entry_8014395 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0;i<n;i++){
            arr[i] = sc.nextInt();
        }
        int ans = solve(arr);
        System.out.println(ans);
    }
    public static int solve(int[] arr){
        HashMap<Integer,Integer>  hMap = new HashMap<Integer,Integer>();
        for(int i=0;i<arr.length;i++){
            if(hMap.containsKey(arr[i])){
                hMap.put(arr[i],hMap.get(arr[i]));
            }
            else{
                hMap.put(arr[i],1);
            }
        }
        return hMap.size();
    }
}
