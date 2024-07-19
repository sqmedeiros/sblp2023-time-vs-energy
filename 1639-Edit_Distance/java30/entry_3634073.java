//package cses;
 
import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;
 
public class entry_3634073 {
    static final Kattio io = new Kattio(System.in, System.out);
    static final StringBuilder sb = new StringBuilder();
    static final String NEW_LINE = System.lineSeparator();
    static final int MODULUS = 1000000007;
    static String word1;
    static String word2;
    static int[][] memo;
 
    public static void main(String[] args) {
        word1 = io.getWord();
        word2 = io.getWord();
        memo = new int[word1.length() + 1][word2.length() + 1];
 
        io.println(solve());
 
        io.close();
    }
 
    private static int solve() {
        memo[word1.length()][word2.length()] = 0;
        for (int i = 0; i < word1.length(); i++) memo[i][word2.length()] = word1.length() - i;
        for (int i = 0; i < word2.length(); i++) memo[word1.length()][i] = word2.length() - i;
 
        for (int i = word1.length() - 1; i >= 0; i--) {
            for (int j = word2.length() - 1; j >= 0; j--) {
                if (word1.charAt(i) == word2.charAt(j)) memo[i][j] = memo[i+1][j+1];
                else memo[i][j] = Math.min(Math.min(memo[i][j+1], memo[i+1][j]), memo[i+1][j+1]) + 1;
            }
        }
 
        return memo[0][0];
    }
 
 
    static class Kattio extends PrintWriter {
        public Kattio(InputStream i, OutputStream o) {
            super(new BufferedOutputStream(o));
            r = new BufferedReader(new InputStreamReader(i));
        }
 
        public boolean hasMoreTokens() {
            return peekToken() != null;
        }
 
        public int getInt() {
            return Integer.parseInt(nextToken());
        }
 
        public double getDouble() {
            return Double.parseDouble(nextToken());
        }
 
        public long getLong() {
            return Long.parseLong(nextToken());
        }
 
        public String getWord() {
            return nextToken();
        }
 
 
        private final BufferedReader r;
        private StringTokenizer st;
        private String token;
 
        private String peekToken() {
            if (token == null)
                try {
                    while (st == null || !st.hasMoreTokens()) {
                        String line = r.readLine();
                        if (line == null) return null;
                        st = new StringTokenizer(line);
                    }
                    token = st.nextToken();
                } catch (IOException ignored) { /* ignored */ }
            return token;
        }
 
        private String nextToken() {
            String ans = peekToken();
            token = null;
            return ans;
        }
    }
}