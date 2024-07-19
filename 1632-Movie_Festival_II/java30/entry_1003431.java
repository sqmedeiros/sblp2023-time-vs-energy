import java.lang.*;
import java.io.*;
import java.util.*;
public class entry_1003431 {
    static Random rand = new Random();
    public static void main(String[] args) throws Exception {
        Reader br = new Reader();
        int n = br.nextInt(), k = br.nextInt();
        int[][] times = new int[n][2];
        for (int i = 0; i < n; ++i) {
            times[i][0] = br.nextInt();
            times[i][1] = br.nextInt();
        }
        qsort(times, 0, n - 1);
        int res = 0;
        TreeMap<Integer, Integer> cnt = new TreeMap<Integer, Integer>();
        for (int[] t : times) {
            Map.Entry<Integer, Integer> entry = cnt.floorEntry(t[0]);
            if (null == entry) {
                if (0 == k) continue;
                cnt.put(t[1], 1);
                k--;
            } else {
                if (1 == entry.getValue()) cnt.remove(entry.getKey());
                else cnt.put(entry.getKey(), entry.getValue() - 1);
                cnt.put(t[1], cnt.getOrDefault(t[1], 0) + 1);
            }
            res++;
        }
        System.out.println(res);
    }
    private static void qsort(int[][] nums, int i, int j) {
        int pivot = i + rand.nextInt(j - i + 1), small = i - 1;
        swap(nums, pivot, j);
        for (int p = i; p < j; ++p) {
            if (nums[p][1] <= nums[j][1]) swap(nums, ++small, p);
        }
        swap(nums, ++small, j);
        if (i < small - 1) qsort(nums, i, small - 1);
        if (small + 1 < j) qsort(nums, small + 1, j);
    }
 
    private static void swap(int[][] nums, int i, int j) {
        int a = nums[i][0], b = nums[i][1];
        nums[i][0] = nums[j][0];
        nums[i][1] = nums[j][1];
        nums[j][0] = a;
        nums[j][1] = b;
    }
 
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
}