import java.util.*;
public class entry_2651125 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        boolean a = false;
        HashMap<Integer,Integer> s = new HashMap<Integer,Integer>();
        for(int i = 0 ; i<n ; i++){
            arr[i] = sc.nextInt();
        }
        sc.close();
        for(int i = 0 ; i<n ; i++){
            if(s.containsKey(k-arr[i])){
                System.out.print(s.get(k-arr[i])+1 + " ");
                System.out.println(i+1 + " ");
                a = true;
                break;
            }
            s.put(arr[i],i);
        }
        if(a==false)System.out.println("IMPOSSIBLE");
    }
    
}
