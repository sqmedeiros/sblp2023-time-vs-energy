//package com.rajan.codeforces.csesProblemSet.graph.introductoryProblems;
 
import java.io.*;
 
public class entry_3862516 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        int tt = Integer.parseInt(reader.readLine());
        while (tt-- > 0) {
            String[] temp = reader.readLine().split("\\s+");
            long y = Long.parseLong(temp[0]), x = Long.parseLong(temp[1]);
            if (y == x) {
                long p = x * x;
                writer.write((p - x + 1L) + "\n");
            } else if (y >= x) {
                if ((y & 1L) == 0L) {
                    long p = y * y;
                    writer.write((p - x + 1L) + "\n");
                } else {
                    long p = (y - 1L) * (y - 1L) + 1;
                    writer.write((p + x - 1L) + "\n");
                }
            } else {
                if ((x & 1L) != 0L) {
                    long p = x * x;
                    writer.write((p - y + 1L) + "\n");
                } else {
                    long p = (x - 1L) * (x - 1L) + 1L;
                    writer.write((p + y - 1L) + "\n");
                }
            }
        }
        writer.flush();
    }
}