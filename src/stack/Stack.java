package stack;

import java.util.ArrayList;
import java.util.List;

public class Stack
{
    int _Size = 0;
    int _Capacity = 0;
    int[] _Elements;

    Stack(int capacity)
    {
        _Capacity = capacity;
        _Elements = new int[1024];
    }

    public boolean isEmpty()
    {
        return _Size == 0;
    }

    public int getSize()
    {
        return _Size;
    }

    public void push(int value)
    {
        if (_Size == _Capacity) throw new Overflow();
        _Elements[++_Size] = value;
    }

    public int pop()
    {
        if (_Size == 0) throw new Underflow();
        return _Elements[_Size--];
    }

    public static Stack Make(int capacity)
    {
        if (capacity < 0) throw new ZeroCapacity();
        return new Stack(capacity);
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
