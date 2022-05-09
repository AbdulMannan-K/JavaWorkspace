package com.zeeshan;

public class Queue_with_Stack
{
    static Stack s1 = new Stack();
    static Stack s2 = new Stack();

    static void enQueue(int x)
    {
        while (!s1.isEmpty())
        {
            s2.push(s1.pop());
        }
        s1.push(x);
        while (!s2.isEmpty())
        {
            s1.push(s2.pop());
        }
    }

    static int deQueue()
    {
        if (s1.isEmpty())
        {
            System.out.println("Q is Empty");
            System.exit(0);
        }
        int x = s1.peek();
        s1.pop();
        return x;
    }
}
