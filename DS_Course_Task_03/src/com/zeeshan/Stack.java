package com.zeeshan;

public class Stack
{
        static final int MAX = 5;
        int top;
        int a[] = new int[MAX];

        Stack()
        {
            top = -1;
        }

    boolean isEmpty()
    {
        return (top < 0);
    }

    boolean push(int x)
    {
        if (top >= (MAX - 1))
        {
            System.out.println("Stack Overflow");
            return false;
        }
        else
        {
            a[++top] = x;
            System.out.println("Pushed into stack : " + x);
            return true;
        }
    }

    int pop()
    {
        if (top < 0)
        {
            System.out.println("Stack Underflow");
            return 0;
        }
        else
        {
            int x = a[top--];
            return x;
        }
    }

    int peek()
    {
        if (top < 0)
        {
            System.out.println("Stack Underflow");
            return 0;
        }
        else
        {
            int x = a[top];
            return x;
        }
    }

    void print()
    {
        for(int i = top; i>0; i--)
        {
            System.out.print(" "+ a[i]);
        }
    }
}