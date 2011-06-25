package stack;

public class Stack
{
    private int size = 0;
    private int capacity = 0;

    Stack(int capacity)
    {
        this.capacity = capacity;
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    public int getSize()
    {
        return size;
    }

    public void push(int i)
    {
        if (size == capacity) throw new Overflow();
        size++;
    }

    public int pop()
    {
        if (size == 0) throw new Underflow();
        size--;

        return -1;
    }

    public static Stack Build(int capacity)
    {
        return new Stack(capacity);
    }

    public class Overflow extends RuntimeException
    {
    }

    public class Underflow extends RuntimeException
    {
    }

    public void test ()
    {

    }
}
