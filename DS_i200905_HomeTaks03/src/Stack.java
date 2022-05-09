public class Stack <T> {
    int top;
    Object array[] = new Object[20] ;
    int size;

    Stack(int size)
    {
        array = new Object[size];
        this.size=size;
        top = -1;
    }

    boolean isEmpty()
    {
        return (top < 0);
    }

    boolean push(T x)
    {
        if (top >= (size - 1))
        {
            System.out.println("Stack Overflow");
            return false;
        }
        else
        {
            array[++top] = x;
            System.out.println("Pushed into stack : " + x);
            return true;
        }
    }

    public T pop()
    {
        if (top < 0)
        {
            System.out.println("Stack Underflow");
            return null;
        }
        else
        {
            T value =(T) array[top--];
            return value;
        }
    }

    public T peek()
    {
        if (top < 0)
        {
            System.out.println("Stack Underflow");
            return null;
        }
        else
        {
            T x = (T) array[top];
            return x;
        }
    }

    void print()
    {
        for(int i = top; i>0; i--)
        {
            System.out.print(" "+ array[i]);
        }
    }
}
