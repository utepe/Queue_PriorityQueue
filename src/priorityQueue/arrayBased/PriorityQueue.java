package priorityQueue.arrayBased;

public class PriorityQueue<K, V> {
    private int front, rear, size, capacity;
    private int[] Keys;
    private V[] Values;

    public PriorityQueue(int capacity) {
        this.Keys = new int[capacity];
        this.Values = (V[]) new Object[capacity];
        this.front = -1;
        this.rear = -1;
        this.size = 0;
        this.capacity = capacity;
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    public boolean isFull(){
        return this.size == this.capacity;
    }

    public void enqueue(V value){
        enqueue(9, value);
    }

    public void enqueue(int key, V value){
        if(isFull()) System.out.println("Queue is Full");
        else if(this.front == -1){
            this.front = this.rear = 0;
            this.Keys[this.rear] = key;
            this.Values[this.rear] = value;
        }
        else if(this.rear == this.capacity - 1){
            for(int i = this.front; i <= this.rear; i++){
                this.Keys[i-this.front] = this.Keys[i];
                this.Values[i-this.front] = this.Values[i];
            }
            this.rear -= this.front;
            this.front = 0;
            insertMid(key, value);
        }
        else{
            insertMid(key, value);
        }
        this.size++;
    }

    private void insertMid(int key, V value){
        int i;
        for(i = this.rear; i >= this.front; i--){
            if(key < this.Keys[i]) {
                this.Values[i+1] = this.Values[i];
                this.Keys[i+1] = this.Keys[i];
            }
            else{ break; }
        }
        this.Keys[i+1] = key;
        this.Values[i+1] = value;
        this.rear++;
    }

    public V dequeue(){
        if(isEmpty()){ 
            System.out.println("Queue is Empty");
            return null;
        }
        else{
            V value = this.Values[this.front];
            this.Values[this.front] = null;
            this.Keys[this.front] = -1;
            this.front = (this.front + 1) % this.capacity;
            this.size--;
            return value;
        }
    }

    public V peek(){
        if(isEmpty()){ 
            System.out.println("Queue is Empty");
            return null;
        }
        else{
            return this.Values[this.front];
        }
    }

    public int getSzie(){
        return this.size;
    }

    public void display(){
        System.out.print("Front -> ");
        for(int i = this.front; i != (rear + 1); i = (i+1) % this.capacity){
            System.out.print("{"+ this.Keys[i] + ":" + this.Values[i] + "}, ");
        }
        System.out.println("<- Rear");
    }

    public int compareTo(String o) {
        return this.compareTo(o);
    }
}