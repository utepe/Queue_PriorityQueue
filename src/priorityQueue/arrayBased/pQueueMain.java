package priorityQueue.arrayBased;

public class pQueueMain {
    public static void main(String[] args) {
        PriorityQueue<Integer, String> PQ = new PriorityQueue<Integer, String>(10);
        System.out.println("PQ1: Array Based pQueue Test 1");
        PQ.enqueue(2, "Java");
        PQ.enqueue(1, "Python");
        PQ.enqueue(4, "XML");
        PQ.enqueue(2, "HTML");
        PQ.enqueue(3, "CSS");
        PQ.display();
        PQ.dequeue();
        PQ.display();
        PQ.enqueue(3, "JSON");
        PQ.display();

        PriorityQueue<Integer, Character> PQ2 = new PriorityQueue<Integer, Character>(10);
        System.out.println("\nPQ2: Array Based pQueue Test 2");
        PQ2.enqueue(5, 'A');
        PQ2.enqueue(9, 'C');
        PQ2.enqueue(3, 'B');
        PQ2.display();
        System.out.println("Peeking Highest: " + PQ2.peek());
        PQ2.dequeue();
        PQ2.enqueue(7, 'D');
        PQ2.display();
        PQ2.dequeue();
        PQ2.display();
        PQ2.dequeue();
        PQ2.display();
        PQ2.dequeue();
        PQ2.display();
        System.out.println("Is pQueue Empty? " + PQ2.isEmpty());
    }
}