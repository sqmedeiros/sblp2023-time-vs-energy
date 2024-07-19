import java.io.*;
import java.util.*;
public class entry_893242 {
 
    public static void merge(long arr[], int l, int m, int r)
    {
        // Find sizes of two subarrays to be merged
        int n1 = m - l + 1;
        int n2 = r - m;
 
        /* Create temp arrays */
        long L[] = new long[n1];
        long R[] = new long[n2];
 
        /*Copy data to temp arrays*/
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];
 
        /* Merge the temp arrays */
 
        // Initial indexes of first and second subarrays
        int i = 0, j = 0;
 
        // Initial index of merged subarry array
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }
 
        /* Copy remaining elements of L[] if any */
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
 
        /* Copy remaining elements of R[] if any */
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }
 
    // Main function that sorts arr[l..r] using
    // merge()
    public static void sort(long arr[], int l, int r)
    {
        if (l < r) {
            // Find the middle point
            int m = (l + r) / 2;
 
            // Sort first and second halves
            sort(arr, l, m);
            sort(arr, m + 1, r);
 
            // Merge the sorted halves
            merge(arr, l, m, r);
        }
    }
    public static long apartments(int n,long applicants[], int m,long apartments[],long k)
   {
       //ArrayList<Long> ans=new ArrayList<>();
//       Arrays.sort(applicants);
//       Arrays.sort(apartments);
       sort(applicants,0,n-1);
       sort(apartments,0,m-1);
 
       int i=0,j=0;
       long ans=0;
       while(i<n && j<m)
       {
           long tminus=applicants[i]-k;
           long tplus=applicants[i]+k;
           if(apartments[j]<tminus)
           {
               j++;
           }
           else if(apartments[j]>tplus)
           {
               i++;
           }
           else
           {
               ans+=1;
               i++;
               j++;
           }
       }
       return ans;
   }
 
    public static void main(String[] args) throws Exception {
//        PrintWriter out = new PrintWriter(System.out);
//        InputStreamReader is = new InputStreamReader(System.in);
//        BufferedReader br = new BufferedReader(is);
//
//        String ss1 = br.readLine();
 
        PrintWriter out=new PrintWriter(System.out);
        InputStreamReader isr=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(isr);
 
        String s1[]=br.readLine().split("\\s");
 
        int n=Integer.parseInt(s1[0]);
        int m=Integer.parseInt(s1[1]);
        long k=Long.parseLong(s1[2]);
 
        String a1[]=br.readLine().split("\\s");
        String a2[]=br.readLine().split("\\s");
//        long applicants[]=Arrays.stream(br.readLine().split("\\s")).mapToLong(Long::parseLong).toArray();
//        long apartments[]=Arrays.stream(br.readLine().split("\\s")).mapToLong(Long::parseLong).toArray();
 
        long applicants[]=new long[a1.length];
        long apartments[]=new long[a2.length];
 
        for(int i=0;i<applicants.length;i++)
        {
            applicants[i]=Long.parseLong(a1[i]);
        }
        for(int i=0;i<apartments.length;i++)
        {
            apartments[i]=Long.parseLong(a2[i]);
        }
 
        //System.out.println("50000lllllllllllllllllllll");
        out.println(apartments(n,applicants,m,apartments,k));
        out.flush();
 
    }
}