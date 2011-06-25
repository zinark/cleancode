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

    @Override
    public int top()
    {
        return _Elements[_Size];
    }

    public static Stack Make(int capacity)
    {
        if (capacity < 0) throw new ZeroCapacity();
        if (capacity == 0)
        {
            return new ZeroCapacityStack();
        }

        return new BoundedStack(capacity);


    }

    public static class Overflow extends RuntimeException
    {
    }

    public static class Underflow extends RuntimeException
    {
    }

    public static class ZeroCapacity extends RuntimeException
    {
    }

    private static class ZeroCapacityStack implements Stack
    {

        @Override
        public boolean isEmpty()
        {
            return false;
        }

        @Override
        public int getSize()
        {
            return 0;
        }

        @Override
        public void push(int value)
        {
            throw new Overflow();
        }

        @Override
        public int pop()
        {
            throw new Underflow();
        }

        @Override
        public int top()
        {
            return 0;
        }
    }
}
