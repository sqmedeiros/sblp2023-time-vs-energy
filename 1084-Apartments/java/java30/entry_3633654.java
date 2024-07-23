import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import static java.lang.System.*;
 
public class entry_3633654 {
    public static void main(String[] args) {
        FastScanner1 in = new FastScanner1(System.in);
        int numPeeps = in.nextInt();
        int numSpots = in.nextInt();
        int maxDiff = in.nextInt();
        int[] desired = new int[numPeeps];
        for (int p=0; p<numPeeps; p++) {
            desired[p] = in.nextInt();
        }
        QuickSort qs = new QuickSort();
        qs.sort(desired);
        //out.println(Arrays.toString(desired));
        int[] spots = new int[numSpots];
        for (int s=0; s<numSpots; s++) {
            spots[s] = in.nextInt();
        }
        qs.sort(spots);
        //out.println(Arrays.toString(spots));
        int spotInd = 0;
        int peepInd = 0;
        int numServiced = 0;
        while (spotInd < spots.length && peepInd < desired.length) {
            if (spots[spotInd] <= desired[peepInd] + maxDiff) {
                if (spots[spotInd] >= desired[peepInd] - maxDiff) {
                    peepInd++;
                    numServiced++;
                }
                spotInd++;
            } else {
                peepInd++;
            }
        }
        out.println(numServiced);
    }
}
class FastScanner1 {
    private InputStream stream;
    private byte[] buf = new byte[1024];
    private int curChar;
    private int numChars;
 
    public FastScanner1(InputStream stream) {
        this.stream = stream;
    }
 
    int read() {
        if (numChars == -1)
            throw new InputMismatchException();
        if (curChar >= numChars) {
            curChar = 0;
            try {
                numChars = stream.read(buf);
            } catch (IOException e) {
                throw new InputMismatchException();
            }
            if (numChars <= 0)
                return -1;
        }
        return buf[curChar++];
    }
 
    boolean isSpaceChar(int c) {
        return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
    }
 
    boolean isEndline(int c) {
        return c == '\n' || c == '\r' || c == -1;
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
 
    String next() {
        int c = read();
        while (isSpaceChar(c))
            c = read();
        StringBuilder res = new StringBuilder();
        do {
            res.appendCodePoint(c);
            c = read();
        } while (!isSpaceChar(c));
        return res.toString();
    }
 
    String nextLine() {
        int c = read();
        while (isEndline(c))
            c = read();
        StringBuilder res = new StringBuilder();
        do {
            res.appendCodePoint(c);
            c = read();
        } while (!isEndline(c));
        return res.toString();
    }
}
class QuickSort {
    private int input[];
    private int length;
 
    public void sort(int[] numbers) {
        if (numbers == null || numbers.length == 0) {
            return;
        }
        this.input = numbers;
        length = numbers.length;
        quickSort(0, length - 1);
    }
    /*
     * This method implements in-place quicksort algorithm recursively.
     */
 
    private void quickSort(int low, int high) {
        int i = low;
        int j = high;
 
        // pivot is middle index
        int pivot = input[low + (high - low) / 2];
 
        // Divide into two arrays
        while (i <= j) {
            /**
             * As shown in above image, In each iteration, we will identify a
             * number from left side which is greater then the pivot value, and
             * a number from right side which is less then the pivot value. Once
             * search is complete, we can swap both numbers.
             */
            while (input[i] < pivot) {
                i++;
            }
            while (input[j] > pivot) {
                j--;
            }
            if (i <= j) {
                swap(i, j);
                // move index to next position on both sides
                i++;
                j--;
            }
        }
 
        // calls quickSort() method recursively
        if (low < j) {
            quickSort(low, j);
        }
 
        if (i < high) {
            quickSort(i, high);
        }
    }
 
    private void swap(int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
}