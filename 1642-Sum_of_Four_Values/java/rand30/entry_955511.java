import java.util.*;
import java.lang.*;
import java.io.*;
public class entry_955511
{   
    static FastScanner sc = new FastScanner(System.in);
    static PrintWriter out = new PrintWriter(System.out);
   
    static class Pair{
        int idx1=0,idx2=0;
        long val=0;
        Pair(int idx1, int idx2,long val){
            this.val=val;
            this.idx1=idx1;
            this.idx2=idx2;
        }
    }
    static class cmp implements Comparator<Pair>
    {
        public int compare(Pair a,Pair b){
            return (int)(a.val-b.val);
        }
    }
    public static int ok(List<Pair> a,long rem ,int i){
        int low=i,high=a.size()-1;
        // out.println(rem);
        while(low<=high){
            int mid=(low+high)/2;
            if(a.get(mid).val==rem){
                return mid;
            }
            else if(a.get(mid).val>rem){
                high=mid-1;
            }
            else{
                low=mid+1;    
            }
        }
 
        return -1;
    }
    public static boolean noC(Pair a,Pair b){
        Set<Integer> set = new HashSet<>();
        set.add(a.idx1);
        set.add(a.idx2);
        set.add(b.idx1);
        set.add(b.idx2);
        return set.size()==4?true:false;
 
    }
    public static void main(String args[]) throws Exception
    {
        int n=sc.nextInt();
        long x=sc.nextLong();
        long arr[]= new long[n];
        for(int i=0;i<n;i++) arr[i]=sc.nextLong();
        List<Pair> a =new ArrayList<>();
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                a.add(new Pair(i+1,j+1,arr[i]+arr[j]));
            }
        }
        Collections.sort(a,new cmp());
 
        // for(Pair p:a){
        //     out.println(p.val+" "+p.idx1+" "+p.idx2);
        // }
 
        boolean flag=true;
        int i=0,j=a.size()-1;
 
        while(i<j){
            if(a.get(i).val+a.get(j).val==x && noC(a.get(i),a.get(j))){
                out.println(a.get(i).idx1+" "+a.get(i).idx2+" "+a.get(j).idx1+" "+a.get(j).idx2);
                flag=false;
                break;
            }
            else if(a.get(i).val+a.get(j).val>=x){
                j--;
            }
            else{
                i++;
            }
        }
        if(flag){
            out.println("IMPOSSIBLE");
        }
 
        out.close();
    }
    
}
class FastScanner
{   
 
    final private int BUFFER_SIZE = 1 << 17;
    private DataInputStream din;
    private byte[] buffer;
    private int bufferPointer, bytesRead;
 
    public FastScanner(InputStream in)
    {
        din = new DataInputStream(in);
        buffer = new byte[BUFFER_SIZE];
        bufferPointer = bytesRead = 0;
    }
    public String nextLine() throws Exception
    {
        StringBuffer sb = new StringBuffer("");
        byte c = read();
        while (c <= ' ') c = read();
        do
        {
            sb.append((char)c);
            c = read();
        }
        while(c > ' ');
        return sb.toString();
    }
 
    public char nextChar() throws Exception
    {
        byte c = read();
        while(c <= ' ') c = read();
        return (char)c;
    }
 
    public int nextInt() throws Exception
    {
        int ret = 0;
        byte c = read();
        while (c <= ' ') c = read();
        boolean neg = c == '-';
        if (neg) c = read();
        do
        {
            ret = ret * 10 + c - '0';
            c = read();
        }
        while (c > ' ');
        if (neg) return -ret;
        return ret;
    }
 
    public long nextLong() throws Exception
    {
        long ret = 0;
        byte c = read();
        while (c <= ' ') c = read();
        boolean neg = c == '-';
        if (neg) c = read();
        do
        {
            ret = ret * 10 + c - '0';
            c = read();
        }
        while (c > ' ');
        if (neg) return -ret;
        return ret;
    }
 
    private void fillBuffer() throws Exception
    {
        bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
        if (bytesRead == -1) buffer[0] = -1;
    }
 
    private byte read() throws Exception
    {
        if (bufferPointer == bytesRead) fillBuffer();
        return buffer[bufferPointer++];
    }
    public double nextDouble() throws Exception
    {
        double ret = 0, div = 1;
        byte c = read();
        while (c <= ' ')
            c = read();
        boolean neg = (c == '-');
        if (neg)
            c = read();
 
        do
        {
            ret = ret * 10 + c - '0';
        }
        while ((c = read()) >= '0' && c <= '9');
 
        if (c == '.')
        {
            while ((c = read()) >= '0' && c <= '9')
            {
                ret += (c - '0') / (div *= 10);
            }
        }
 
        if (neg)
            return -ret;
        return ret;
    }
 
    public void reverse(int arr[]){
       for(int i=0;i<arr.length/2;i++){
           int temp=arr[i];
           arr[i]=arr[arr.length-i-1];
           arr[arr.length-i-1]=temp;
       }         
    }
    public void revLongArray(long arr[]){
       for(int i=0;i<arr.length/2;i++){
           long temp=arr[i];
           arr[i]=arr[arr.length-i-1];
           arr[arr.length-i-1]=temp;
       }         
    }   
 
}
 
 
 
 