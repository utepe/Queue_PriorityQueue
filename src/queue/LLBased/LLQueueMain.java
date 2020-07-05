package queue.LLBased;

public class LLQueueMain {
    public static void main(String[] args) {
        LLQueue<String> LLQ = new LLQueue<String>();
        System.out.println("LLQ1: LL Based Queue Test 1");
        LLQ.enqueue("Java");
        LLQ.enqueue("Python");
        LLQ.enqueue("XML");
        LLQ.enqueue("HTML");
        LLQ.enqueue("CSS");
        LLQ.enqueue("LISP");
        
        LLQ.display();
        LLQ.dequeue();
        LLQ.display();
        LLQ.enqueue("JSON");
        LLQ.display();

        LLQueue<Integer> LLQ2 = new LLQueue<Integer>();
        System.out.println("\nLLQ2: LL Based Queue Test 2");
        LLQ2.enqueue(100);
        LLQ2.enqueue(1);
        LLQ2.enqueue(5);
        LLQ2.enqueue(16);
        
        LLQ2.display();
        LLQ2.dequeue();
        LLQ2.enqueue(40);
        LLQ2.display();
        LLQ2.dequeue();
        LLQ2.display();
    }
}