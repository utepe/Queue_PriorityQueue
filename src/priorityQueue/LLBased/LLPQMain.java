package priorityQueue.LLBased;

public class LLPQMain {
    public static void main(String[] args) {
        LLPriorityQueue<Integer, String> LLPQ = new LLPriorityQueue<Integer, String>();
        System.out.println("LLPQ1: LL Based pQueue Test 1");
        LLPQ.enqueue(2, "Java");
        LLPQ.enqueue(1, "Python");
        LLPQ.enqueue(4, "XML");
        LLPQ.enqueue(2, "HTML");
        LLPQ.enqueue(3, "CSS");
        LLPQ.display();
        LLPQ.dequeue();
        LLPQ.display();
        LLPQ.enqueue(3, "JSON");
        LLPQ.enqueue("C#");
        LLPQ.display();

        LLPriorityQueue<Integer, Character> LLPQ2 = new LLPriorityQueue<Integer, Character>();
        System.out.println("\nLLPQ2: LL Based pQueue Test 2");
        LLPQ2.enqueue(5, 'A');
        LLPQ2.enqueue(9, 'C');
        LLPQ2.enqueue(3, 'B');
        LLPQ2.display();
        System.out.println("Peeking Highest: " + LLPQ2.peek());
        LLPQ2.dequeue();
        LLPQ2.enqueue(7, 'D');
        LLPQ2.display();
        LLPQ2.dequeue();
        LLPQ2.display();
        LLPQ2.dequeue();
        LLPQ2.display();
        LLPQ2.dequeue();
        LLPQ2.display();
        System.out.println("Is pQueue Empty? " + LLPQ2.isEmpty());
    }
}