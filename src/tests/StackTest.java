package tests;

import org.junit.Before;
import org.junit.Test;
import stack.BoundedStack;
import stack.Stack;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertFalse;
import static junit.framework.Assert.assertTrue;

public class StackTest
{
    private Stack stack;

    @Before
    public void setup()
    {
        stack = BoundedStack.Make(2);
    }

    @Test
    public void newlyCreatedStack_shouldBeEmpty()
    {
        assertTrue(stack.isEmpty());
        assertEquals(0, stack.getSize());
    }

    @Test
    public void AfterOnePush_StackSizeShouldBeOne()
    {
        stack.push(1);
        assertEquals(1, stack.getSize());
        assertFalse(stack.isEmpty());
    }

    @Test
    public void AfterOnePushOnePop_StackSizeShouldBeZero()
    {
        stack.push(1);
        stack.pop();
        assertEquals(0, stack.getSize());
        assertTrue(stack.isEmpty());
    }

    @Test(expected = BoundedStack.Overflow.class)
    public void WhenPushedPastLimit_StackOverFlows()
    {
        stack.push(1);
        stack.push(1);
        stack.push(1);
    }

    @Test(expected = BoundedStack.Underflow.class)
    public void WhenEmptyStackIsPopped_ShouldThrowUnderflow()
    {
        stack.pop();
    }

    @Test
    public void WhenOneIsPush_OneIsPopped()
    {
        stack.push(100);
        assertEquals(100, stack.pop());
    }

    @Test
    public void WhenOneAndTwoPushed_TwoAndOneArePopped()
    {
        stack.push(1);
        stack.push(2);

        assertEquals(2, stack.pop());
        assertEquals(1, stack.pop());
    }

    @Test(expected = BoundedStack.ZeroCapacity.class)
    public void WhenCapacityLowerThanZero_ThrowsZeroCapacity()
    {
        stack = BoundedStack.Make(-1);
    }

    @Test(expected = BoundedStack.Overflow.class)
    public void WhenCreatingStackWithZeroCapacity_AnyPushShouldOverflow()
    {
        stack = BoundedStack.Make(0);
        stack.push(1);
    }

    @Test
    public void WhenOneIsPushed_OneIsOnTop ()
    {
        stack.push(100);
        assertEquals(100, stack.top());
    }
}
