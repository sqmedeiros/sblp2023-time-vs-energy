public class entry_4906328
{
    public static void main(String[] args)
    {
        Input input = new Input();
        Output output = new Output();
        int n = input.nextInt();
        int m = input.nextInt();
        int k = input.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++)
            a[i] = input.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++)
            b[i] = input.nextInt();
        Array.sort(a);
        Array.sort(b);
        int i = 0;
        int count = 0;
        for (int e: b)
        {
            for (; i < a.length; i++)
            {
                if (e < a[i] - k)
                    break;
                else if (e <= a[i] + k)
                {
                    count++;
                    i++;
                    break;
                }
            }
        }
        output.append(count).appendNewLine();
        output.flush();
    }
}
 
class Input
{
    private final byte[] buffer;
    private int pos;
 
    public Input()
    {
        try
        {
            buffer = new byte[System.in.available() + 1];
            buffer[buffer.length - 1] = '\n';
            System.in.read(buffer);
        }
        catch (Exception ex)
        {
            throw new RuntimeException(ex);
        }
    }
 
    public byte[] next(int n)
    {
        while (true)
        {
            byte b = buffer[pos++];
            if (b != '\n')
            {
                pos--;
                break;
            }
        }
        byte[] bytes = new byte[n];
        System.arraycopy(buffer, pos, bytes, 0, n);
        pos += n;
        return bytes;
    }
 
    public byte[] next()
    {
        int from;
        while (true)
        {
            byte b = buffer[pos++];
            if (b != ' ' && b != '\n')
            {
                from = pos;
                break;
            }
        }
        while (true)
        {
            byte b = buffer[pos++];
            if (b == ' ' || b == '\n')
                break;
        }
        byte[] bytes = new byte[pos - from];
        System.arraycopy(buffer, from - 1, bytes, 0, bytes.length);
        return bytes;
    }
 
    public byte[] nextLine()
    {
        int from = pos;
        while (true)
        {
            byte b = buffer[pos++];
            if (b == '\n')
                break;
        }
        byte[] bytes = new byte[pos - from - 1];
        System.arraycopy(buffer, from, bytes, 0, bytes.length);
        return bytes;
    }
 
    public byte nextChar()
    {
        while (true)
        {
            byte b = buffer[pos++];
            if (b != ' ' && b != '\n')
                return b;
        }
    }
 
    public int nextInt()
    {
        int n;
        boolean positive;
        while (true)
        {
            byte b = buffer[pos++];
            if (b == '-')
            {
                positive = false;
                n = buffer[pos++] - '0';
                break;
            }
            else if (b >= '0' && b <= '9')
            {
                positive = true;
                n = b - '0';
                break;
            }
        }
        while (true)
        {
            byte b = buffer[pos++];
            if (b >= '0' && b <= '9')
                n = n * 10 + b - '0';
            else
                return positive ? n : -n;
        }
    }
 
    public long nextLong()
    {
        long n;
        boolean positive;
        while (true)
        {
            byte b = buffer[pos++];
            if (b == '-')
            {
                positive = false;
                n = buffer[pos++] - '0';
                break;
            }
            else if (b >= '0' && b <= '9')
            {
                positive = true;
                n = b - '0';
                break;
            }
        }
        while (true)
        {
            byte b = buffer[pos++];
            if (b >= '0' && b <= '9')
                n = n * 10 + b - '0';
            else
                return positive ? n : -n;
        }
    }
 
    public double nextDouble()
    {
        long n;
        boolean positive;
        while (true)
        {
            byte b = buffer[pos++];
            if (b == '-')
            {
                positive = false;
                n = buffer[pos++] - '0';
                break;
            }
            else if (b >= '0' && b <= '9')
            {
                positive = true;
                n = b - '0';
                break;
            }
        }
        while (true)
        {
            byte b = buffer[pos++];
            if (b >= '0' && b <= '9')
                n = n * 10 + b - '0';
            else if (b == '.')
                break;
            else
                return positive ? n : -n;
        }
        long m = 0;
        long o = 1;
        while (true)
        {
            byte b = buffer[pos++];
            if (b >= '0' && b <= '9')
            {
                m = m * 10 + b - '0';
                o *= 10;
            }
            else
            {
                double d = n + (double)m / o;
                return positive ? d : -d;
            }
        }
    }
}
 
class Output
{
    private static final int BUFFER_SIZE = 1048576;
    private final byte[] buffer = new byte[BUFFER_SIZE];
    private int pos;
 
    public Output append(String s)
    {
        int length = s.length();
        ensureCapacity(length);
        for (int i = 0; i < length; i++)
            buffer[pos++] = (byte)s.charAt(i);
        return this;
    }
 
    public Output append(byte[] bytes)
    {
        if (BUFFER_SIZE - pos < bytes.length)
        {
            flush();
            if (bytes.length > BUFFER_SIZE)
            {
                System.out.write(bytes, 0, bytes.length);
                return this;
            }
        }
        for (byte b: bytes)
            buffer[pos++] = b;
        return this;
    }
 
    public Output append(byte[] bytes, int from, int to)
    {
        int length = to - from;
        if (BUFFER_SIZE - pos < length)
        {
            flush();
            if (length > BUFFER_SIZE)
            {
                System.out.write(bytes, from, length);
                return this;
            }
        }
        for (int i = from; i < to; i++)
            buffer[pos++] = bytes[i];
        return this;
    }
 
    public Output append(char c)
    {
        ensureCapacity(1);
        buffer[pos++] = (byte)c;
        return this;
    }
 
    public Output append(int i)
    {
        return append(Integer.toString(i));
    }
 
    public Output append(long l)
    {
        return append(Long.toString(l));
    }
 
    public Output append(double d)
    {
        return append(Double.toString(d));
    }
 
    public void appendNewLine()
    {
        ensureCapacity(1);
        buffer[pos++] = '\n';
    }
 
    public void flush()
    {
        System.out.write(buffer, 0, pos);
        pos = 0;
    }
 
    private void ensureCapacity(int n)
    {
        if (BUFFER_SIZE - pos < n)
            flush();
    }
}
 
class Array
{
    private Array() {}
 
    public static void sort(int[] array)
    {
        int bits = 8;
        int radix = 1 << bits;
        int[][] buckets = new int[radix][array.length];
        int[] size = new int[radix];
        for (int e: array)
        {
            int index = e & radix - 1;
            buckets[index][size[index]++] = e;
        }
        int[][] newBuckets = new int[radix][array.length];
        for (int i = bits; i < Integer.SIZE; i += bits)
        {
            int[] newSize = new int[radix];
            for (int j = 0; j < radix; j++)
            {
                for (int k = 0; k < size[j]; k++)
                {
                    int index = buckets[j][k] >>> i & radix - 1;
                    newBuckets[index][newSize[index]++] = buckets[j][k];
                }
            }
            int[][] temp = buckets;
            buckets = newBuckets;
            newBuckets = temp;
            size = newSize;
        }
        {
            int i = 0;
            for (int j = radix >> 1; j < radix; j++)
            {
                for (int k = 0; k < size[j]; k++)
                    array[i++] = buckets[j][k];
            }
            for (int j = 0; j < radix >> 1; j++)
            {
                for (int k = 0; k < size[j]; k++)
                    array[i++] = buckets[j][k];
            }
        }
    }
 
    public static <T> void shuffle(int[] array)
    {
        for (int i = array.length; i > 1; i--)
            swap(array, Random.nextInt(i), i - 1);
    }
 
    public static <T> void shuffle(T[] array)
    {
        for (int i = array.length; i > 1; i--)
            swap(array, Random.nextInt(i), i - 1);
    }
 
    public static void swap(byte[] array, int i, int j)
    {
        byte temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
 
    public static void swap(int[] array, int i, int j)
    {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
 
    public static <T> void swap(T[] array, int i, int j)
    {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
 
    public static void permute(byte[] array, Procedure procedure)
    {
        permute(array, array.length, procedure);
    }
 
    private static void permute(byte[] array, int length, Procedure procedure)
    {
        if (length == 1)
            procedure.run();
        else
        {
            permute(array, --length, procedure);
            for (int i = 0; i < length; i++)
            {
                int index = (length & 1) == 0 ? 0 : i;
                swap(array, index, length);
                permute(array, length, procedure);
            }
        }
    }
 
    public static void permute(int[] array, Procedure procedure)
    {
        permute(array, array.length, procedure);
    }
 
    private static void permute(int[] array, int length, Procedure procedure)
    {
        if (length == 1)
            procedure.run();
        else
        {
            permute(array, --length, procedure);
            for (int i = 0; i < length; i++)
            {
                int index = (length & 1) == 0 ? 0 : i;
                swap(array, index, length);
                permute(array, length, procedure);
            }
        }
    }
}
 
interface Procedure
{
    void run();
}
 
class Random
{
    private static long seed = System.nanoTime() ^ 8682522807148012L;
 
    private Random() {}
 
    public static void nextBytes(byte[] bytes)
    {
        for (int i = 0, len = bytes.length; i < len; )
        {
            for (int rnd = nextInt(), n = Math.min(len - i, Integer.SIZE / Byte.SIZE); n-- > 0; rnd >>= Byte.SIZE)
                bytes[i++] = (byte)rnd;
        }
    }
 
    public static int nextInt()
    {
        return next(32);
    }
 
    public static int nextInt(int bound)
    {
        int r = next(31);
        int m = bound - 1;
        if ((bound & m) == 0)
            r = (int)(bound * (long)r >> 31);
        else
            for (int u = r; u - (r = u % bound) + m < 0; u = next(31));
        return r;
    }
 
    public static long nextLong()
    {
        return (long)next(32) << 32 | next(32);
    }
 
    public static boolean nextBoolean()
    {
        return next(1) != 0;
    }
 
    public static float nextFloat()
    {
        return next(24) / (float)(1 << 24);
    }
 
    public static double nextDouble()
    {
        return ((long)next(26) << 27 | next(27)) * 0x1.0p-53;
    }
 
    private static int next(int bits)
    {
        seed = seed * 0x5DEECE66DL + 0xBL & 0xFFFFFFFFFFFFL;
        return (int)(seed >>> 48 - bits);
    }
}