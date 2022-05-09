package com.zeeshan;

public class Stack_with_Queue
{
    static Queue q1 = new Queue(5);
    static Queue q2 = new Queue(5);

    static int curr_size;

    Stack_with_Queue()
    {
        curr_size = 5;
    }

    static void push(int x)
    {
        curr_size++;
        q2.Enqueue(x);
        while (!q1.isEmpty())
        {
            q2.Enqueue(q1.peek());
            q1.Dequeue();
        }
        Queue<Integer> q = q1;
        q1 = q2;
        q2 = q;
    }

    static void pop()
    {
        if (q1.isEmpty())
            return;
        q1.Dequeue();
        curr_size--;
    }

    static int top()
    {
        if (q1.isEmpty())
            return -1;
        return (int) q1.peek();
    }

    static int size()
    {
        return curr_size;
    }
}
