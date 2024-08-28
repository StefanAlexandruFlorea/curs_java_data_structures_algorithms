package datastructures.queue;

public class Main {
    public static void main(String[] args) {
        Queue queue = new Queue(1);
        queue.enqueue(2);

        queue.printList();

        System.out.println(queue.dequeue().value);
        System.out.println(queue.dequeue().value);
        System.out.println(queue.dequeue());

    }
}
