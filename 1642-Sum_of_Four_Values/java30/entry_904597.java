import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
 
class entry_904597 {
    static int ar[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st[] = br.readLine().split(" ");
        int n = Integer.parseInt(st[0]);
        long x = Long.parseLong(st[1]);
        ar = new int[n][2];
        HashMap<Long, int[]> map = new HashMap<>();
        st = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            ar[i][0] = Integer.parseInt(st[i]);
            ar[i][1] = i+1;
        }
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                map.put((long)ar[i][0]+ar[j][0], new int[]{i+1, j+1});
            }
        }
        Arrays.sort(ar, (o1, o2) -> {
            if(o1[0] == o2[0]) return o1[1] - o2[1];
            return o1[0] - o2[0];
        });
 
        for (int i = 0; i < n-3; i++) {
            for (int j = i+1; j < n-2; j++) {
                    long diff = x - (long) ar[i][0] - (long) ar[j][0];
                    if(map.containsKey(diff)) {
                        if(((map.get(diff)[0] != ar[i][1]) && (map.get(diff)[1] != ar[j][1])) && ((map.get(diff)[0] != ar[j][1]) && (map.get(diff)[1] != ar[i][1]))){
                            System.out.println(ar[i][1]+" "+ar[j][1]+" "+map.get(diff)[0]+" "+map.get(diff)[1]);
                            return;
                        }
                    }
            }
        }
        System.out.println("IMPOSSIBLE");
 
    }
 
    static int binS(int l, int r, long t) {
        while(l < r) {
            int mid = (l+r) / 2;
            if(ar[mid][0] == t) {
                return mid;
            }
            if(ar[mid][0] > t) {
                r = mid;
            }
            if(ar[mid][0] < t) {
                l = mid+1;
            }
        }
        if(ar[r][0] == t) return r;
        return -1;
    }
}