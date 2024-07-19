// package com.company;
 
import com.sun.source.tree.Tree;
 
import java.io.*;
import java.util.*;
 
public class entry_5478296 {
    static int number = 0;
    static class Event implements Comparable<Event>{
        int start, end, index;
        Event(int start, int end, int index){
            this.start = start;
            this.end = end;
            this.index = index;
        }
        public int compareTo(Event o){
            if(this.end != o.end) return Integer.compare(this.end, o.end);
            return Integer.compare(this.index, o.index);
        }
    }
 
    public static void main(String[] args) {
        FastIO io = new FastIO();
        int n = io.nextInt(), k = io.nextInt();
        PriorityQueue<Event> unprocessedEvents = new PriorityQueue<>();
        TreeSet<Event> runningEvents = new TreeSet<>();
 
        for(int i = 0; i < n; i++){
            unprocessedEvents.add(new Event(io.nextInt(), io.nextInt(), number));
            number++;
        }
        int count = 0;
        while(!unprocessedEvents.isEmpty()){
            Event examinedEvent = unprocessedEvents.poll();
            Event toBeRemoved = runningEvents.floor(new Event(0, examinedEvent.start, examinedEvent.index));
 
            if(toBeRemoved != null){
                runningEvents.remove(toBeRemoved);
                runningEvents.add(examinedEvent);
                count++;
            }
            else{
                if(runningEvents.size() < k){
                    runningEvents.add(examinedEvent);
                    count++;
                }
            }
        }
        io.print(count);
        io.close();
    }
}
class FastIO extends PrintWriter {
    private InputStream stream;
    private byte[] buf = new byte[1<<16];
    private int curChar, numChars;
 
    // standard input
    public FastIO() { this(System.in,System.out); }
    public FastIO(InputStream i, OutputStream o) {
        super(o);
        stream = i;
    }
    // file input
    public FastIO(String i, String o) throws IOException {
        super(new FileWriter(o));
        stream = new FileInputStream(i);
    }
 
    // throws InputMismatchException() if previously detected end of file
    private int nextByte() {
        if (numChars == -1) throw new InputMismatchException();
        if (curChar >= numChars) {
            curChar = 0;
            try {
                numChars = stream.read(buf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (numChars == -1) return -1; // end of file
        }
        return buf[curChar++];
    }
 
    // to read in entire lines, replace c <= ' '
    // with a function that checks whether c is a line break
    public String next() {
        int c; do { c = nextByte(); } while (c <= ' ');
        StringBuilder res = new StringBuilder();
        do { res.appendCodePoint(c); c = nextByte(); } while (c > ' ');
        return res.toString();
    }
    public int nextInt() { // nextLong() would be implemented similarly
        int c; do { c = nextByte(); } while (c <= ' ');
        int sgn = 1; if (c == '-') { sgn = -1; c = nextByte(); }
        int res = 0;
        do {
            if (c < '0' || c > '9')
                throw new InputMismatchException();
            res = 10*res+c-'0';
            c = nextByte();
        } while (c > ' ');
        return res * sgn;
    }
    public double nextDouble() { return Double.parseDouble(next()); }
}