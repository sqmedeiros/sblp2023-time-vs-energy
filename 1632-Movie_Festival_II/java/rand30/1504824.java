import java.io.OutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.io.DataInputStream;
import java.util.Arrays;
import java.io.IOException;
import java.io.InputStream;
 
/**
 * Built using CHelper plug-in
 * Actual solution is at the top
 *
 * @author Jaynil
 */
public class entry_1504824 {
    public static void main(String[] args) {
        InputStream inputStream = System.in;
        OutputStream outputStream = System.out;
        Reader in = new Reader(inputStream);
        PrintWriter out = new PrintWriter(outputStream);
        MovieFestivalII solver = new MovieFestivalII();
        solver.solve(1, in, out);
        out.close();
    }
 
    static class MovieFestivalII {
        int[] a;
        int[] b;
 
        public void solve(int testNumber, Reader in, PrintWriter out) {
            CAvl t = new CAvl();
            int n = in.nextInt();
            int k = in.nextInt();
            a = new int[n];
            b = new int[n];
            Integer ii[] = new Integer[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.nextInt();
                b[i] = in.nextInt();
                ii[i] = i;
            }
            int size = 0;
            int ans = 0;
            Arrays.sort(ii, (x, y) -> a[x] - a[y]);
            for (int i = 0; i < n; i++) {
                int indi = ii[i];
                while (size > 0 && b[(int) t.getKthSmallest(1)] <= a[indi]) {
                    t.deleteElement(t.getKthSmallest(1));
                    size--;
                }
                if (size < k) {
                    t.insertElement(indi);
                    ans++;
                    size++;
                } else if (b[(int) t.getKthSmallest(size)] > b[indi]) {
                    t.deleteElement(t.getKthSmallest(size));
                    t.insertElement(indi);
                }
            }
            out.println(ans);
 
        }
 
        class CAvl extends CustomAVL {
            public int compare(long x, long y) {
                return Long.compare(b[(int) x], b[(int) y]);
            }
 
        }
 
    }
 
    static class CustomAVL {
        node root;
 
        public int compare(long x, long y) {
            return Long.compare(x, y);
        }
 
        CustomAVL() {
            this.root = null;
        }
 
        public int height(node temp) {
            if (temp == null) {
                return 0;
            } else {
                return temp.height;
            }
        }
 
        public int getBalance(node temp) {
            if (temp == null) {
                return 0;
            } else {
                return height(temp.left) - height(temp.right);
            }
        }
 
        public int max(int a, int b) {
            return (a > b) ? a : b;
        }
 
        public node rightrotate(node y) {
            node x = y.left;
            node T2 = x.right;
            y.lsum = y.lsum - x.lsum;
            y.lcount = y.lcount - x.lcount;
            x.rsum = x.rsum + y.rsum;
            x.rcount = x.rcount + y.rcount;
            x.right = y;
            y.left = T2;
            y.height = max(height(y.left), height(y.right)) + 1;
            x.height = max(height(x.left), height(x.right)) + 1;
 
            return x;
 
        }
 
        public node leftrotate(node x) {
            node y = x.right;
            node T2 = y.left;
            y.lsum = y.lsum + x.lsum;
            y.lcount = y.lcount + x.lcount;
            x.rsum = x.rsum - y.rsum;
            x.rcount = x.rcount - y.rcount;
            y.left = x;
            x.right = T2;
            x.height = max(height(x.left), height(x.right)) + 1;
            y.height = max(height(y.left), height(y.right)) + 1;
            return y;
        }
 
        node minValueNode(node temp) {
 
            /* loop down to find the leftmost leaf */
            while (temp.left != null)
                temp = temp.left;
 
            return temp;
        }
 
        public node insert(node root, long value) {
            if (root == null) {
                return new node(value);
            }
            if (compare(value, root.value) <= 0) {
                root.lcount = root.lcount + 1;
                root.lsum = root.lsum + value;
                root.left = insert(root.left, value);
            } else {
                root.rsum = root.rsum + value;
                root.rcount = root.rcount + 1;
                root.right = insert(root.right, value);
 
            }
            root.height = 1 + max(height(root.left), height(root.right));
            int balance = getBalance(root);
 
            //ll
            if (balance > 1 && compare(value, root.left.value) <= 0) {
                return rightrotate(root);
            }
            //rr
            if (balance < -1 && compare(value, root.right.value) < 0) {
                return leftrotate(root);
            }
            //lr
            if (balance > 1 && compare(value, root.left.value) <= 0) {
                root.left = leftrotate(root.left);
                return rightrotate(root);
            }
            //rl
            if (balance < -1 && compare(value, root.right.value) > 1) {
                root.right = rightrotate(root.right);
                return leftrotate(root);
            }
            return root;
        }
 
        public node delete(node root, long value) {
            if (root == null) {
                return root;
            }
            if (compare(value, root.value) < 0) {
                root.lcount = root.lcount - 1;
                root.lsum = root.lsum - value;
                root.left = delete(root.left, value);
            } else if (compare(value, root.value) > 0) {
                root.rcount = root.rcount - 1;
                root.rsum = root.rsum - value;
                root.right = delete(root.right, value);
            } else {
                if (root.left == null || root.right == null) {
                    node temp = null;
                    if (temp == root.left) temp = root.right;
                    else temp = root.left;
                    if (temp == null) {
                        temp = root;
                        root = null;
                    } else {
                        root = temp;
                    }
 
                } else {
                    node temp = minValueNode(root.right);
                    root.lsum = root.lsum - root.value;
                    root.rsum = root.rsum - value;
                    root.rcount = root.rcount - 1;
                    root.value = temp.value;
                    root.lsum = root.lsum + root.value;
                    root.right = delete(root.right, temp.value);
                }
            }
            if (root == null) {
                return root;
            }
            root.height = max(height(root.left), height(root.right)) + 1;
            int balance = getBalance(root);
            if (balance > 1 && getBalance(root.left) >= 0)
                return rightrotate(root);
            if (balance > 1 && getBalance(root.left) < 0) {
                root.left = leftrotate(root.left);
                return rightrotate(root);
            }
            if (balance < -1 && getBalance(root.right) <= 0)
                return leftrotate(root);
            if (balance < -1 && getBalance(root.right) > 0) {
                root.right = rightrotate(root.right);
                return leftrotate(root);
            }
 
 
            return root;
        }
 
        public void insertElement(long value) {
            this.root = insert(root, value);
        }
 
        public void deleteElement(long value) {
            this.root = delete(root, value);
        }
 
        public long getKthSmallest(int k) {
            node temp = root;
 
            while (temp != null) {
                if (temp.lcount == k) {
                    return temp.value;
                }
                if (temp.lcount > k) {
                    temp = temp.left;
                    continue;
                }
                if (temp.lcount < k) {
                    k = k - temp.lcount;
                    temp = temp.right;
                }
            }
            return -1;
        }
 
        class node {
            long value;
            int lcount;
            long lsum;
            long rsum;
            int rcount;
            int height;
            node left;
            node right;
 
            node(long value) {
                this.value = value;
                this.lcount = 1;
                this.lsum = this.value;
                this.left = null;
                this.right = null;
                this.height = 1;
                this.rsum = this.value;
                this.rcount = 1;
            }
 
        }
 
    }
 
    static class Reader {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer;
        private int bytesRead;
 
        public Reader(InputStream x) {
            din = new DataInputStream(x);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
 
        public int nextInt() {
            int ret = 0;
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
 
        private void fillBuffer() {
            try {
                bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
                if (bytesRead == -1)
                    buffer[0] = -1;
            } catch (IOException e) {
                e.printStackTrace();
            }
 
        }
 
        private byte read() {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }
 
    }
}
 
