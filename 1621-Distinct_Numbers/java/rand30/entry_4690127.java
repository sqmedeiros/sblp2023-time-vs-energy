import java.util.*;
public class entry_4690127 {
    public static void main(String[] args) {
       Scanner kb=new Scanner(System.in);
       int n=kb.nextInt();
       HashSet<Integer> hs=new HashSet<>();
       for(int i=0;i<n;i++)
       {
           int num=kb.nextInt();
           hs.add(num);
       }
        System.out.println(hs.size());
    }
    
}
