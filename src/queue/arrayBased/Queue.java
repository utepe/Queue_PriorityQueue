package queue.arrayBased;

public class Queue<E> {
    private int front, rear, size, capacity;
    private E[] arr;

    /**
     * Queue Constructor
     * @param capacity
     */
    public Queue(int capacity){
        this.arr = (E[]) new Object[capacity];
        this.front = -1;
        this.rear = -1;
        this.size = 0;
        this.capacity = capacity;
    }

    /**
     * isFull Method
     * @return True if size == capacity of queue
     */
    public boolean isFull(){
        return this.size == this.capacity;
    }

    /**
     * isEmpty Method
     * @return True if size == 0
     */
    public boolean isEmpty(){
        return this.size == 0;
    }

    /**
     * enqueue Method
     * inserts the entered data to the rear of thre queue
     * @param data
     */
    public void enqueue(E data){
        if(isFull()) System.out.println("Queue is Full");
        else{
            this.rear = (this.rear + 1) % this.capacity;
            this.arr[this.rear] = data;
            this.size++;
            if(this.front == -1){
                this.front = this.rear;
            }
        }
    }

    /**
     * dequeue Method
     * removed and returns the data at the front of the Queue
     * @return element
     */
    public E dequeue(){
        if(isEmpty()){ 
            System.out.println("Queue is Empty");
            return null;
        }
        else{
            E element = this.arr[this.front];
            this.arr[this.front] = null;
            this.front = (this.front + 1) % this.capacity;
            this.size--;
            return element;
        }
    }

    /**
     * peek Method
     * returns the element at the front of the Queue (doesnt remove)
     * @return 
     */
    public E peek(){
        if(isEmpty()) return null;
        else{
            return this.arr[this.front];
        }
    }

    /**
     * getSize Method
     * @return the current size of the Queue
     */
    public int getSize(){
        return this.size;
    }

    /**
     * printQueue Method
     * prints each element of the Queue from front to rear
     */
    public void display(){
        System.out.print("Front -> ");
        for(int i = this.front; i != (rear + 1); i = (i+1) % this.capacity)
        {
            System.out.print(this.arr[i] + ", ");
        }
        System.out.println("<- Rear");
    }

}