import java.util.Arrays;
 
public class entry_4792297
{
    public static void main(String[] args)
    {
        Input input = new Input();
        Output output = new Output();
        long n = input.nextLong();
        int k = input.nextInt();
        long[] a = new long[k];
        for (int i = 0; i < k; i++)
            a[i] = input.nextLong();
        long total = 0;
        long[] product = a.clone();
        boolean[] parity = new boolean[k];
        boolean[] valid = new boolean[k];
        Arrays.fill(parity, true);
        Arrays.fill(valid, true);
        int index = 0;
        while (true)
        {
            if (valid[index])
            {
                valid[index] = false;
                if (product[index] > n)
                {
                    if (++index == k)
                        break;
                }
                else
                {
                    long count = n / product[index];
                    total += parity[index] ? count : -count;
                    int max = 59 - Algebra.log2(product[index]);
                    for (int i = 0; i < index; i++)
                        product[i] = Algebra.log2(a[i]) > max ? Long.MAX_VALUE : product[index] * a[i];
                    Arrays.fill(parity, 0, index, !parity[index]);
                    Arrays.fill(valid, 0, index, true);
                    index = 0;
                }
            }
            else if (++index == k)
                break;
        }
        output.append(total).appendNewLine();
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
            else
                break;
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
 
class Algebra
{
    private Algebra() {}
 
 
    public static int log2(long n)
    {
        return 63 - Long.numberOfLeadingZeros(n);
    }
}