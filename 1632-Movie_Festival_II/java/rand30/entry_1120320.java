import java.util.*;
import java.io.*;
public class entry_1120320
{
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
  
        public Reader(String file_name) throws IOException 
        { 
            din = new DataInputStream(new FileInputStream(file_name)); 
            buffer = new byte[BUFFER_SIZE]; 
            bufferPointer = bytesRead = 0; 
        } 
  
        public String readLine() throws IOException 
        { 
            byte[] buf = new byte[64]; // line length 
            int cnt = 0, c; 
            while ((c = read()) != -1) 
            { 
                if (c == '\n') 
                    break; 
                buf[cnt++] = (byte) c; 
            } 
            return new String(buf, 0, cnt); 
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
  
        public long nextLong() throws IOException 
        { 
            long ret = 0; 
            byte c = read(); 
            while (c <= ' ') 
                c = read(); 
            boolean neg = (c == '-'); 
            if (neg) 
                c = read(); 
            do { 
                ret = ret * 10 + c - '0'; 
            } 
            while ((c = read()) >= '0' && c <= '9'); 
            if (neg) 
                return -ret; 
            return ret; 
        } 
  
        public double nextDouble() throws IOException 
        { 
            double ret = 0, div = 1; 
            byte c = read(); 
            while (c <= ' ') 
                c = read(); 
            boolean neg = (c == '-'); 
            if (neg) 
                c = read(); 
  
            do { 
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
    } 
    static Random rand = new Random();
    static class V {
        V l, r;
        int key, cnt, x;
        V(int key) {
            this.key = key;
            x = rand.nextInt();
        }
    }
    static V v_, l_, r_;
    static void split(V v, int key) {
        if (v == null) {
            v_ = l_ = r_ = null;
        } else if (v.key < key) {
            split(v.r, key);
            v.r = l_; l_ = v;
        } else if (v.key > key) {
            split(v.l, key);
            v.l = r_; r_ = v;
        } else {
            v_ = v;
            l_ = v.l;
            r_ = v.r;
            v.l = v.r = null;
        }
    }
    static V merge(V l, V r) {
        if (l == null)
            return r;
        if (r == null)
            return l;
        if (l.x <= r.x) {
            l.r = merge(l.r, r);
            return l;
        } else {
            r.l = merge(l, r.l);
            return r;
        }
    }
    static V last(V v) {
        if (v != null)
            while (v.r != null)
                v = v.r;
        return v;
    }
    static void tr_add(int key) {
        split(v_, key);
        if (v_ == null)
            v_ = new V(key);
        v_.cnt++;
        v_ = merge(merge(l_, v_), r_);
    }
    static void tr_remove(int key) {
        split(v_, key);
        if (--v_.cnt == 0)
            v_ = null;
        v_ = merge(merge(l_, v_), r_);
    }
    static V tr_floor(int key) {
        split(v_, key);
        V v = v_ != null ? v_ : last(l_);
        v_ = merge(merge(l_, v_), r_);
        return v;
    }
    public static void main(String[] args) throws IOException {
        Reader sc = new Reader();
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] aa = new int[n];
        int[] bb = new int[n];
        Integer[] ii = new Integer[n];
        for (int i = 0; i < n; i++) {
            aa[i] = sc.nextInt();
            bb[i] = sc.nextInt();
            ii[i] = i;
        }
        while (k-- > 0)
            tr_add(0);
        Arrays.sort(ii, (i, j) -> bb[i] - bb[j]);
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            V v = tr_floor(aa[ii[i]]);
            if (v != null) {
                tr_remove(v.key);
                tr_add(bb[ii[i]]);
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}