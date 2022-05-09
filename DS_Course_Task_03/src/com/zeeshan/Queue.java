package com.zeeshan;

public class Queue<T>
{
    private Object queueArr[];
    private int front;
    private int rear;
    private int capacity;

    public Object[] getQueueArr()
    {
        return queueArr;
    }
    public void setQueueArr(Object[] queueArr)
    {
        this.queueArr = queueArr;
    }

    public int getFront()
    {
        return front;
    }
    public void setFront(int front)
    {
        this.front = front;
    }

    public int getRear()
    {
        return rear;
    }
    public void setRear(int rear)
    {
        this.rear = rear;
    }

    public Queue(Object[] queueArr, int front, int rear)
    {
        this.queueArr = queueArr;
        this.front = front;
        this.rear = rear;
    }

    Queue(int cap)
    {
        rear = -1;
        front = -1;
        capacity = cap;
        queueArr = new Object[capacity];
    }

    public void Enqueue(T data)
    {
        if (isFull())
        {
            System.out.println("Queue is full!! Can not add more elements");
        } else if (front == -1 && rear == -1)
        {
            rear = 0;
            front = 0;
            queueArr[rear] = data;
            System.out.println("Added to the queue :"+data);
        } else {
            rear++;
            queueArr[rear] = data;
            System.out.println("Added to the queue :"+data);
        }
    }

    public void Dequeue()
    {
        if (isEmpty()) {
            System.out.println("Queue is empty!! Can not dequeue element");
        } else if (front == rear) {
            front = -1;
            rear = -1;
        } else {
            System.out.println("Removed from the queue" + queueArr[front]);
            front++;
        }
    }

    public boolean isFull()
    {
        if (rear + 1 == capacity)
        {
            return true;
        }
        return false;
    }

    public boolean isEmpty()
    {
        if (front == -1 && rear == -1)
        {
            return true;
        }
        return false;
    }

    void queueDisplay()
    {
        int i;
        if (front == -1 && rear == -1)
        {
            System.out.println("Queue is Empty");
            return;
        }
        for (i = front; i < rear + 1; i++)
        {
            System.out.printf("%d <----- " ,queueArr[i]);
        }
        System.out.println();
        return;
    }

    public Object peek()
    {
        if (isEmpty())
        {
            System.out.println("Queue is empty!!");
            return null;
        } else
        {
            System.out.println("Front element is :" + queueArr[front]);
            return queueArr[front];
        }
    }
}