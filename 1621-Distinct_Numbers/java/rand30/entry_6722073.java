import java.io.*;
import java.util.*;
 
public class distinctnumbers {
    public static void main(String[] args)throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        int n =Integer.parseInt(bf.readLine());
 
        String[] st=bf.readLine().split(" ");
        HashSet<String> hs=new HashSet<>();
        for(String ele:st)hs.add(ele);
        System.out.println(hs.size());
    }
}