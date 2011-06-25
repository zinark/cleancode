package stack;

public class BoundedStack implements Stack
{
    int _Size = 0;
    int _Capacity = 0;
    int[] _Elements;

    BoundedStack(int capacity)
    {
        _Capacity = capacity;
        _Elements = new int[capacity + 1];
    }

    @Override
    public boolean isEmpty()
    {
        return _Size == 0;
    }

    @Override
    public int getSize()
    {
        return _Size;
    }

    @Override
    public void push(int value)
    {
        if (_Size == _Capacity) throw new Overflow();
        _Elements[++_Size] = value;
    }

    @Override
    public int pop()
    {
        if (_Size == 0) throw new Underflow();
        return _Elements[_Size--];
    }

    public static BoundedStack Make(int capacity)
    {
        if (capacity < 0) throw new ZeroCapacity();
        return new BoundedStack(capacity);
    }

    public class Overflow extends RuntimeException
    {
    }

    public class Underflow extends RuntimeException
    {
    }

    public static class ZeroCapacity extends RuntimeException
    {
    }
}
