import java.io.*;
import java.util.*;
 
public class entry_4578051{
    public static void main(String[] args) throws IOException {
        Reader io = new Reader();
        PrintWriter pw = new PrintWriter(System.out);
 
        /*int ticketNum = io.nextInt();
        int peopleNum = io.nextInt();
        // No multiset in java so we'll have to use a TreeMap
        NavigableMap<Integer, Integer> ticketMultiset = new TreeMap<>();
        Map.Entry<Integer, Integer> val;
*/
        int t = 1;
        outer:while(t-->0){
            ArrayList<Pair> al = new ArrayList<Pair>();
            int n = io.nextInt();
           int x = io.nextInt();
           int a[] = new int[n];
           for(int i=0;i<n;i++){
               a[i] = io.nextInt();
           }
           HashMap<Integer,Integer>h = new HashMap<>();
           boolean f = false;
           for(int i=0;i<n;i++){
               if(h.containsKey((x-a[i]))){
                   System.out.println(h.get((x-a[i]))+" "+(i+1));
                   continue outer;
               }else{
                   if(!h.containsKey(a[i])){
                       h.put(a[i],(i+1));
                   }
               }
           }
            System.out.println("IMPOSSIBLE");
 
        }
 
        io.close();
        pw.close();
    }
    static void sort(long[] a) {
        ArrayList<Long> l = new ArrayList<>();
        for (long i : a) l.add(i);
        Collections.sort(l);
        for (int i = 0; i < a.length; i++) a[i] = l.get(i);
    }
 
    // Kattio is too slow
    //BeginCodeSnip{Fast Reader}
    static class Reader
    {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;
 
        public Reader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }
 
        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }
 
        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
        }
        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do
            {
                ret = ret * 10 + c - '0';
            }  while ((c = read()) >= '0' && c <= '9');
 
            if (neg)
                return -ret;
            return ret;
        }
    }
 
    static class Pair implements Comparable<Pair> {
        int x;
        int y;
 
        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
        public int compareTo(Pair o){
            return (int)(this.y-o.y);
        }
    }
 
}
