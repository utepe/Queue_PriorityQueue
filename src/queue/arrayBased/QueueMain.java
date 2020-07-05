package queue.arrayBased;

public class QueueMain {
   public static void main(String[] args) {
    Queue<String> Q1 = new Queue<String>(10);
    System.out.println("Q1: Array Based Queue Test 1");
    Q1.enqueue("Java");
    Q1.enqueue("Python");
    Q1.enqueue("XML");
    Q1.enqueue("HTML");
    Q1.enqueue("CSS");
    Q1.enqueue("LISP");
    
    Q1.display();
    Q1.dequeue();
    Q1.display();
    Q1.enqueue("JSON");
    Q1.display();

    Queue<Integer> Q2 = new Queue<Integer>(10);
    System.out.println("\nQ2: Array Based Queue Test 2");
    Q2.enqueue(100);
    Q2.enqueue(1);
    Q2.enqueue(5);
    Q2.enqueue(16);
    
    Q2.display();
    Q2.dequeue();
    Q2.enqueue(40);
    Q2.display();
    Q2.dequeue();
    Q2.display();
   } 
}