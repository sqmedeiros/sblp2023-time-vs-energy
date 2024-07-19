//package com.denisbogdanov.cses.problemset_2.dp;
 
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class entry_5303692 {
    public static void main(String[] args) throws Exception {
        InputStream inputStream = System.in;
    //  java.io.InputStream inputStream = new java.io.FileInputStream("C:\\Users\\RogBo\\Desktop\\input.txt");
        InputReader in = new InputReader(inputStream);
 
        String s1 = in.next();
        String s2 = in.next();
 
        int n1 = s1.length();
        int n2 = s2.length();
        int[][] distanceDp = new int[n1 + 1][n2 + 1];
 
        for (int i = 0; i < n1 + 1; i++) {
            distanceDp[i][0] = i;
        }
 
        for (int i = 0; i < n2 + 1; i++) {
            distanceDp[0][i] = i;
        }
 
        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                if (s1.charAt(i) == s2.charAt(j)) {
                    distanceDp[i + 1][j + 1] = distanceDp[i][j];
                } else {
                    distanceDp[i + 1][j + 1] = 1 + Math.min(
                            distanceDp[i][j],
                            Math.min(distanceDp[i][j + 1], distanceDp[i + 1][j]));
                }
            }
        }
 
        System.out.println(distanceDp[n1][n2]);
    }
 
    private static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;
 
        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
        }
 
        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
 
            return tokenizer.nextToken();
        }
 
        public int nextInt() {
            return Integer.parseInt(next());
        }
 
        public long nextLong() {
            return Long.parseLong(next());
        }
 
        public int[] readIntArray(int n) {
            int[] result = new int[n];
            for (int i = 0; i < n; i++) {
                result[i] = nextInt();
            }
 
            return result;
        }
 
        public char[][] readCharGrid(int rows, int columns) {
            char[][] result = new char[rows][columns];
            for (int r = 0; r < rows; r++) {
                String row = next();
                result[r] = row.toCharArray();
            }
 
            return result;
        }
    }
}