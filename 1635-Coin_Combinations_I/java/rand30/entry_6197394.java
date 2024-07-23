import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class entry_6197394 {
 
  private static FastReader reader = new FastReader(System.in);
  private static FastWriter writer = new FastWriter(System.out);
 
  private static final int MODULO = 1_000_000_007;
 
  public static void main(String[] args) throws IOException {
    int[] firstLineArguments = reader.readLineOfIntegers(2, " ");
    int numberOfCoins = firstLineArguments[0];
    int targetSum = firstLineArguments[1];
 
    int[] coinValues = reader.readLineOfIntegers(numberOfCoins, " ");
    Arrays.sort(coinValues);
 
    int[] numberOfCombinations = new int[targetSum + 1];
    numberOfCombinations[0] = 1;
 
    for (int sum = 0; sum <= targetSum; sum++) {
      if (numberOfCombinations[sum] == 0) {
        continue;
      }
 
      for (int coinIndex = 0; coinIndex < numberOfCoins; coinIndex++) {
        int coinValue = coinValues[coinIndex];
        int nextSum = sum + coinValue;
 
        if (nextSum > targetSum) {
          break;
        }
 
        numberOfCombinations[nextSum] = (numberOfCombinations[nextSum] + numberOfCombinations[sum]) % MODULO;
      }
    }
 
    int result = numberOfCombinations[targetSum];
    writer.writeInteger(result);
    writer.flush();
  }
 
  public static class FastReader {
 
    private BufferedReader input;
 
    public FastReader(InputStream inputStream) {
      input = new BufferedReader(new InputStreamReader(inputStream));
    }
 
    public int readLineOfInteger() throws IOException {
      return Integer.parseInt(input.readLine());
    }
 
    public int[] readLineOfIntegers(int numberOfIntegers, String separator) throws IOException {
      int[] integers = new int[numberOfIntegers];
      StringTokenizer tokenizer = new StringTokenizer(input.readLine(), separator);
 
      for (int index = 0; index < numberOfIntegers; index++) {
        integers[index] = Integer.parseInt(tokenizer.nextToken());
      }
 
      return integers;
    }
  }
 
  public static class FastWriter {
 
    private BufferedOutputStream output;
 
    public FastWriter(OutputStream outputStream) {
      output = new BufferedOutputStream(outputStream);
    }
 
    public void writeInteger(int integer) throws IOException {
      output.write((Integer.toString(integer)).getBytes());
    }
 
    public void flush() throws IOException {
      output.flush();
    }
  }
}