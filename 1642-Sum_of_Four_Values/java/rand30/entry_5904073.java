//package com.rajan.cses.sortingAndSearching;
 
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
 
public class entry_5904073 {
    private static BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private static BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
 
    public static void main(String[] args) throws Exception {
        int[] input = parseInt(reader.readLine());
        int n = input[0], x = input[1];
        int[] a = parseInt(reader.readLine());
        int[][] data = new int[n][2];
        for (int i = 0; i < n; i++) {
            data[i] = new int[]{a[i], i};
        }
        data = sort(data, 0, n - 1, (p, q) -> Integer.compare(p[0], q[0]));
        Map<Long, List<int[]>> pairSumMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                long sum = data[i][0] + data[j][0];
                pairSumMap.putIfAbsent(sum, new ArrayList<>());
                pairSumMap.get(sum).add(new int[]{data[i][1], data[j][1]});
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                long r = x - data[i][0] - data[j][0];
                if(pairSumMap.containsKey(r)){
                    List<int[]> pairList=pairSumMap.get(r);
                    for(int[] pair: pairList){
                        if(data[i][1]!=pair[0] && data[i][1]!=pair[1] && data[j][1]!=pair[0] && data[j][1]!=pair[1]){
                            writer.write(String.format("%d %d %d %d\n", data[i][1]+1, data[j][1]+1, pair[0]+1, pair[1]+1));
                            writer.flush();
                            return;
                        }
                    }
                }
            }
        }
        writer.write("IMPOSSIBLE\n");
        writer.flush();
    }
 
    private static int[] search(int[][] a, int p, int t) {
        for (int i = p, j = a.length - 1; i < j; ) {
            if (a[i][0] + a[j][0] < t) {
                i++;
            } else if (a[i][0] + a[j][0] > t) {
                j--;
            } else {
                return new int[]{a[i][1], a[j][1]};
            }
        }
        return null;
    }
 
    private static boolean canComplete(int[] k, int t, long time) {
        long total = 0L;
        for (int p : k) {
            total += time / (p * 1L);
            if (total >= t) {
                return true;
            }
        }
        return total >= t;
    }
 
    private static void printArray(int[] nums) throws java.lang.Exception {
        for (int i = 0; i < nums.length; i++) {
            writer.write((i == 0 ? "" : " ") + nums[i]);
        }
        writer.write("\n");
    }
 
    private static void printArray(long[] nums) throws java.lang.Exception {
        for (int i = 0; i < nums.length; i++) {
            writer.write((i == 0 ? "" : " ") + nums[i]);
        }
        writer.write("\n");
    }
 
    private static int[] parseInt(String str) {
        String[] parts = str.split("\\s+");
        int[] ans = new int[parts.length];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = Integer.parseInt(parts[i]);
        }
        return ans;
    }
 
    private static long[] parseLong(String str) {
        String[] parts = str.split("\\s+");
        long[] ans = new long[parts.length];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = Long.parseLong(parts[i]);
        }
        return ans;
    }
 
    private static int[][] sort(int[][] data, int i, int j, Comparator<int[]> comparator) {
        if (i == j) {
            return new int[][]{data[i].clone()};
        }
        int mid = i + (j - i) / 2;
        int[][] left = sort(data, i, mid, comparator);
        int[][] right = sort(data, mid + 1, j, comparator);
        return merge(left, right, comparator);
    }
 
    private static int[][] merge(int[][] left, int[][] right, Comparator<int[]> comparator) {
        int n1 = left.length, n2 = right.length;
        int[][] merged = new int[n1 + n2][];
        int idx = 0, leftIdx = 0, rightIdx = 0;
        while (leftIdx < n1 && rightIdx < n2) {
            if (comparator.compare(left[leftIdx], right[rightIdx]) <= 0) {
                merged[idx++] = left[leftIdx++];
            } else {
                merged[idx++] = right[rightIdx++];
            }
        }
        while (leftIdx < n1) {
            merged[idx++] = left[leftIdx++];
        }
        while (rightIdx < n2) {
            merged[idx++] = right[rightIdx++];
        }
        return merged;
    }
}