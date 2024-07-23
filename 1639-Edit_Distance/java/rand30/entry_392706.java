/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
/**
 *
 * @author milin
 */
class entry_392706 {
 
    static class FastReader {
 
        BufferedReader br;
        StringTokenizer st;
 
        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
 
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
 
        int nextInt() {
            return Integer.parseInt(next());
        }
 
        long nextLong() {
            return Long.parseLong(next());
        }
 
        double nextDouble() {
            return Double.parseDouble(next());
        }
 
        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
 
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        FastReader fr = new FastReader();
        String a = fr.next();
        String b = fr.next();
        int len1 = a.length();
        int len2 = b.length();
        int ar[][] = new int[len1][len2];
        for (int i = 0; i < len1; i++) {
            for (int j = 0; j < len2; j++) {
                if (a.charAt(i) == b.charAt(j)) {
                    int x = Math.max(i - j, j - i);
                    if (i == 0 && j == 0) {
                        ar[i][j] = 0;
                    } else if (i == 0) {
                        ar[i][j] = Math.max(ar[i][j - 1], x);
                    } else if (j == 0) {
                        ar[i][j] = Math.max(ar[i - 1][j], x);
                    } else {
                        ar[i][j] = Math.max(ar[i - 1][j - 1], x);
                    }
                } else {
                    if (i == 0 && j == 0) {
                        ar[i][j] = 1;
                    } else if (i == 0) {
                        ar[i][j] = ar[i][j - 1] + 1;
                    } else if (j == 0) {
                        ar[i][j] = ar[i - 1][j] + 1;
                    } else {
                        ar[i][j] = Math.min(Math.min(ar[i - 1][j] + 1, ar[i][j - 1] + 1), ar[i - 1][j - 1] + 1);
                    }
 
                }
            }
        }
        System.out.println(ar[len1 - 1][len2 - 1]);
    }
 
}