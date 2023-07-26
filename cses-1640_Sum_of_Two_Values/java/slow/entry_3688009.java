import java.util.*;
public class entry_3688009 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int x = input.nextInt();
        ArrayList<Integer> arr = new ArrayList<Integer>();
        for(int i = 0; i < n; i++) {
            int z = input.nextInt();
            arr.add(z);
        }    
        printpairs(arr, x);
    }
    static void printpairs(ArrayList<Integer> arr, int sum)
    {
        HashSet<Integer> s = new HashSet<Integer>();
        for (int i = 0; i < arr.size(); ++i){
            int temp = sum - arr.get(i);
            if (s.contains(temp)) {
                int index = 1 + arr.indexOf(temp);
                if(i>arr.indexOf(temp)){
                    System.out.println(index + " " + (i+1));
                    return;
                }
                else{
                    System.out.println((i+1) +" "+ index);
                    return;
                }
            }
            s.add(arr.get(i));
        }
        System.out.println("IMPOSSIBLE");
        
    }
 
}
