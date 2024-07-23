import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
 
public class entry_1935590 {
 
    public static void main(String[] args) throws IOException {
 
 
        Reader in = new Reader();
        int n = in.nextInt();
        Project[] projects = new Project[n];
        TreeMap<Integer, Long> tree = new TreeMap<>();
        final int lastDay = 1_000_000_001;
        tree.put(0, 0L);
        tree.put(lastDay, 0L);
 
        for(int i = 0; i < n; i++){
            int start = in.nextInt();
            int end = in.nextInt();
            int reward = in.nextInt();
            projects[i] = new Project(start, end, reward);
            tree.put(start, 0L);
        }
 
        sortProjects(projects);
 
        long previous = 0;
        int current = 0;
 
        for(var entry : tree.entrySet()){
            entry.setValue(previous);
 
            while(current < projects.length && projects[current].end < entry.getKey()){
                int reward = projects[current].reward;
                int start = projects[current].start;
                int floor = tree.floorKey(start);
                long value = tree.get(floor) + reward;
                if(value > previous){
                    entry.setValue(value);
                    previous = value;
                }
                current++;
            }
        }
 
        System.out.print(tree.get(lastDay));
    }
 
 
    public static void sortProjects(Project[] a){
        int gap = 0;
        while(gap < a.length) gap = (gap * 3) + 1;
        gap/= 3;
 
        while (gap > 0) {
            for (int i = gap; i < a.length; i += 1) {
 
                Project temp = a[i];
                int j = i;
 
                while(j >= gap && a[j - gap].end >  temp.end){
                    a[j] = a[j - gap];
                    j -= gap;
                }
                a[j] = temp;
            }
            gap/= 3;
        }
    }
}
 
 
class Project {
    public int start;
    public int end;
    public int reward;
    public Project(int start, int end, int reward) {
        this.start = start;
        this.end = end;
        this.reward = reward;
    }
}
 
 
// The Reader Class was designed by Rishabh Mahrsee.
// See: Article: Fast IO in Java in Competitive Programming
// Website: GeeksForGeeks
// Url: https://www.geeksforgeeks.org/fast-io-in-java-in-competitive-programming/
class Reader {
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
        din = new DataInputStream(
                new FileInputStream(file_name));
        buffer = new byte[BUFFER_SIZE];
        bufferPointer = bytesRead = 0;
    }
 
    public String readLine() throws IOException
    {
        byte[] buf = new byte[64]; // line length
        int cnt = 0, c;
        while ((c = read()) != -1) {
            if (c == '\n') {
                if (cnt != 0) {
                    break;
                }
                else {
                    continue;
                }
            }
            buf[cnt++] = (byte)c;
        }
        return new String(buf, 0, cnt);
    }
 
    public int nextInt() throws IOException
    {
        int ret = 0;
        byte c = read();
        while (c <= ' ') {
            c = read();
        }
        boolean neg = (c == '-');
        if (neg)
            c = read();
        do {
            ret = ret * 10 + c - '0';
        } while ((c = read()) >= '0' && c <= '9');
 
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
        } while ((c = read()) >= '0' && c <= '9');
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
        } while ((c = read()) >= '0' && c <= '9');
 
        if (c == '.') {
            while ((c = read()) >= '0' && c <= '9') {
                ret += (c - '0') / (div *= 10);
            }
        }
 
        if (neg)
            return -ret;
        return ret;
    }
 
    private void fillBuffer() throws IOException
    {
        bytesRead = din.read(buffer, bufferPointer = 0,
                BUFFER_SIZE);
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