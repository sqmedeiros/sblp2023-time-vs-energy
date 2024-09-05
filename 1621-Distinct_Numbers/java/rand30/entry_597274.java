import java.awt.image.ImageProducer;
import java.util.*;
import java.awt.image.BandedSampleModel;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Scanner;
public class entry_597274 {
 
 
 
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        HashSet<Integer> hs=new HashSet<>();
        for(int i=0;i<n;i++)
        {
            hs.add(sc.nextInt());
        }
 
        System.out.println(hs.size());
 
    }
}
