package com.zeeshan;

import java.util.Scanner;

public class Main
{
    public static void main(String[] args)
    {
        int option;
        while ((option = getUserSelection()) != 0)
        {
            switch (option)
            {
                case 1:
                {
                    Stack stack = new Stack();
                    stack.push(10);
                    stack.push(15);
                    stack.push(20);
                    stack.push(25);
                    stack.push(30);
                    System.out.println("Pooped out from Stack : " + stack.pop());
                    System.out.println("Top Element of Stack : " + stack.peek());
                    System.out.println();
                    break;
                }
                case 2:
                {
                    Queue queue = new Queue(8);
                    queue.Enqueue(1);
                    queue.Enqueue(2);
                    queue.Enqueue(3);
                    queue.Enqueue(4);
                    queue.Enqueue(5);
                    queue.queueDisplay();
                    queue.Dequeue();
                    queue.queueDisplay();
                    queue.peek();
                    queue.Enqueue(6);
                    queue.queueDisplay();
                    System.out.println();
                    break;
                }
                case 3:
                {
                    Queue_with_Stack queue = new Queue_with_Stack();
                    queue.enQueue(1);
                    queue.enQueue(2);
                    queue.enQueue(3);
                    queue.enQueue(4);
                    System.out.print("Queue with Stack -----> ");
                    for(int i = 0; i<4; i++)
                    {
                        System.out.print(queue.deQueue());
                    }
                    System.out.println();
                    break;
                }
                case 4:
                {
                    Stack_with_Queue stack = new Stack_with_Queue();
                    stack.push(10);
                    stack.push(15);
                    stack.push(20);
                    stack.push(25);
                    System.out.println("current size: " + stack.size());
                    System.out.println("Queue with Stack -----> ");
                    for(int i = 0; i<4; i++)
                    {
                        stack.pop();
                        System.out.print(stack.top());
                    }
                    System.out.println();
                    System.out.println("current size: " + stack.size());
                    break;
                }
                case 5:
                {
                    System.exit(0);
                    break;
                }
            }
        }
    }
    public static int getUserSelection()
    {
        int option = 0;
        System.out.println("------- Welcome to the Queue vs Stack Implementation -------- ");
        System.out.println("Press 1 :  Implement Stack");
        System.out.println("Press 2 :  Implement Queue");
        System.out.println("Press 3 :  Implement Stack with Queue");
        System.out.println("Press 4 :  Implement Queue with Stack");
        System.out.println("Press 5 :  Exit");
        System.out.println();

        while (true)
        {
            System.out.print("Enter your choice: ");
            Scanner sc = new Scanner(System.in);
            option = sc.nextInt();
            if (option >= 0 && option <= 5)
                break;
            else {
                System.out.println("Invalid Input");
            }
        }
        return option;
    }
}
