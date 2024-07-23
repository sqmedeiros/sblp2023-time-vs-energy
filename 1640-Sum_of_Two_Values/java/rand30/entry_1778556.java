// Working program using Reader Class
import java.io.DataInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
 
public class entry_1778556{
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
    
    public static void main(String[] args)throws IOException {
        Reader s = new Reader();
        int t=1;
//        int t = s.nextInt();
      
        while (t-- > 0) {
    		int n =s.nextInt();
    		int k=s.nextInt();
    		
    		List<Integer> a = new ArrayList<>();
    		Map<Integer,Integer> map= new HashMap<>();
    		for(int i=0;i<n;i++) {
    			a.add(s.nextInt());
    			map.put(a.get(i),i);
    		}
    		boolean f=false;
    		for(int i=0;i<n;i++) {
    			
    			 if(map.containsKey(k-a.get(i)) && map.get(k-a.get(i))!=i ) {
    				System.out.println((i+1)+" "+((map.get(k-a.get(i))+1)));
    				f=true;
    				break;
    			}
    		}
    		if(!f)System.out.println("IMPOSSIBLE");
        }
        
    }
}
