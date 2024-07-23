import java.util.*;
 
public class entry_4905820
{
    public static void main(String[] args)
    {
        Input input = new Input();
        Output output = new Output();
        Movie[] movies = new Movie[input.nextInt()];
        int k = input.nextInt();
        Heap<Movie> sortingHeap = new Heap<>(movies.length, (a, b) -> Integer.compare(a.start, b.start), new IntegerFieldAccess<>()
        {
            public int get(Movie movie)
            {
                return movie.index1;
            }
 
            public void set(Movie movie, int v)
            {
                movie.index1 = v;
            }
        });
        for (int i = 0; i < movies.length; i++)
            sortingHeap.offer(new Movie(input.nextInt(), input.nextInt()));
        for (int i = 0; i < movies.length; i++)
            movies[i] = sortingHeap.poll();
        Heap<Movie> minHeap = new Heap<>(movies.length, (a, b) -> Integer.compare(a.end, b.end), new IntegerFieldAccess<>()
        {
            public int get(Movie movie)
            {
                return movie.index1;
            }
 
            public void set(Movie movie, int v)
            {
                movie.index1 = v;
            }
        });
        Heap<Movie> maxHeap = new Heap<>(movies.length, (a, b) -> Integer.compare(b.end, a.end), new IntegerFieldAccess<>()
        {
            public int get(Movie movie)
            {
                return movie.index2;
            }
 
            public void set(Movie movie, int v)
            {
                movie.index2 = v;
            }
        });
        int count = movies.length;
        for (Movie e: movies)
        {
            while (minHeap.size() != 0 && minHeap.peek().end <= e.start)
                maxHeap.remove(minHeap.poll());
            minHeap.offer(e);
            maxHeap.offer(e);
            if (maxHeap.size() > k)
            {
                minHeap.remove(maxHeap.poll());
                count--;
            }
        }
        output.append(count).appendNewLine();
        output.flush();
    }
 
    private static class Movie
    {
        private final int start;
        private final int end;
        private int index1;
        private int index2;
 
        public Movie(int start, int end)
        {
            this.start = start;
            this.end = end;
        }
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
 
interface Comparator<T>
{
    int compare(T a, T b);
}
 
class Heap<E> implements Iterable<E>
{
    private final E[] heap;
    private final Comparator<E> comparator;
    private final IntegerFieldAccess<E> index;
    private int size;
 
    public Heap(int n, Comparator<E> comparator, IntegerFieldAccess<E> index)
    {
        heap = (E[])new Object[Integer.highestOneBit(n) << 1];
        this.comparator = comparator;
        this.index = index;
    }
 
    public int size()
    {
        return size;
    }
 
    public Iterator<E> iterator()
    {
        return new HIterator();
    }
 
    public void offer(E e)
    {
        siftUp(++size, e);
    }
 
    public void decrease(E e)
    {
        siftUp(index.get(e), e);
    }
 
    private void siftUp(int index, E e)
    {
        for (int i = index, j = index >> 1; ; i = j, j >>= 1)
        {
            if (j == 0 || comparator.compare(heap[j], e) <= 0)
            {
                set(i, e);
                break;
            }
            else
                set(i, heap[j]);
        }
    }
 
    public E poll()
    {
        E e = heap[1];
        siftDown(1, heap[size--]);
        return e;
    }
 
    public void increase(E e)
    {
        siftDown(index.get(e), e);
    }
 
    private void siftDown(int index, E e)
    {
        for (int i = index; ; )
        {
            int left = i << 1;
            int right = left | 1;
            if (right > size)
            {
                if (left > size || comparator.compare(e, heap[left]) <= 0)
                    set(i, e);
                else
                {
                    set(i, heap[left]);
                    set(left, e);
                }
                break;
            }
            else
            {
                if (comparator.compare(heap[left], heap[right]) < 0)
                {
                    if (comparator.compare(heap[left], e) < 0)
                    {
                        set(i, heap[left]);
                        i = left;
                    }
                    else
                    {
                        set(i, e);
                        break;
                    }
                }
                else
                {
                    if (comparator.compare(heap[right], e) < 0)
                    {
                        set(i, heap[right]);
                        i = right;
                    }
                    else
                    {
                        set(i, e);
                        break;
                    }
                }
            }
        }
    }
 
    private void set(int index, E e)
    {
        heap[index] = e;
        this.index.set(e, index);
    }
 
    public E peek()
    {
        return heap[1];
    }
 
    public void remove(E e)
    {
        for (int i = index.get(e), j = i >> 1; j != 0; i = j, j >>= 1)
            set(i, heap[j]);
        siftDown(1, heap[size--]);
    }
 
    public void clear()
    {
        size = 0;
    }
 
    private class HIterator implements Iterator<E>
    {
        private int index;
 
        public boolean hasNext()
        {
            return index != size;
        }
 
        public E next()
        {
            return heap[++index];
        }
    }
}
 
interface IntegerFieldAccess<T>
{
    int get(T t);
    void set(T t, int v);
 
    default int postIncrement(T t)
    {
        int v = get(t);
        set(t, v + 1);
        return v;
    }
 
    default int postDecrement(T t)
    {
        int v = get(t);
        set(t, v - 1);
        return v;
    }
 
    default int preIncrement(T t)
    {
        int v = get(t) + 1;
        set(t, v);
        return v;
    }
 
    default int preDecrement(T t)
    {
        int v = get(t) - 1;
        set(t, v);
        return v;
    }
} 	