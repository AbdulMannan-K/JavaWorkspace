public class Main {


    public static void main(String[] args) {
        Queue<Integer> queue = new Queue<Integer>(6);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        queue.enqueue(6);
        queue.enqueue(7);
        queue.enqueue(8);
        queue.dequeue();
        queue.printQueue();

        System.out.println();

        LinkedQueue<Integer> q = new LinkedQueue<>();
        q.enqueue(3);
        q.enqueue(4);
        q.enqueue(5);
        q.enqueue(6);
        q.enqueue(7);
        q.enqueue(8);
        q.dequeue();
        q.printQueue();
//        Queue<Task> tasks = new Queue<>(8);
//        tasks.enqueue(new Task(1,100));
//        tasks.enqueue(new Task(2,70));
//        tasks.enqueue(new Task(3,60));
//        tasks.enqueue(new Task(4,40));
//
//        while (!tasks.isEmpty()) {
//            roundRobin(tasks,40);
//        }

    }

    public static void roundRobin(Queue<Task> tasks, int quantum) {
        if(tasks.getFront()==tasks.size) System.exit(0);
        Task front = (Task) tasks.getArray()[tasks.getFront()];
        System.out.println("Task ID : " + front.getTaskId() + " " + "Execution Time : " + front.getExecutionTime());
        front.setExecutionTime(front.getExecutionTime()-quantum);
        System.out.println("Remaining Execution Time : " + front.getExecutionTime());
        if(front.getExecutionTime()<=0) {
            System.out.println("Task ID : " + front.getTaskId() +  " is completed, it is being pooped out");
            tasks.dequeue();
        }else {
            tasks.dequeue();
            tasks.enqueue(front);
        }

    }
}
