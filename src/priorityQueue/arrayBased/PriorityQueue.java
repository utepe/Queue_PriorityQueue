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

    /**
     * isEmpty Method
     * @return True if size == 0
     */
    public boolean isEmpty(){
        return this.size == 0;
    }

    /**
     * isFull Method
     * @return False since LLPQueue can never be full
     */
    public boolean isFull(){
        return this.size == this.capacity;
    }

    /**
     * enqueue Base Method
     * calls this method if user does not pass in the priority of the element
     * sets default priority to 9
     * calls overloaded enqueue Method
     * @param value
     */
    public void enqueue(V value){
        enqueue(10, value);
    }

    /**
     * enqueue Overloaded Method
     * adds element to the pQueue based on the priority (key) of the element
     * @param key
     * @param value
     */
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

    /**
     * insertMid Method
     * inserts Key, Value into the middle of the Keys, and Values Array while shifting other elements
     * @param key
     * @param value
     */
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

    /**
     * dequeue Method
     * removed and returns the element with the highest priority
     * @return value of the element with the highest priority
     */
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

    public V removeMid(){
    if(isEmpty()) return null;
    int i;
    int deletingPos = size/2; //trying to delete the element at size/2 
    V deletingValue = Values[deletingPos];
    //traverse to the array and shift all elements over
    for(i = deletingPos; i < this.rear; i++) {
        Values[i]  = Values[i+1];
        Keys[i] = Keys[i+1];
    }
    this.rear--;
    size -= 1;
    return deletingValue;
    }

    /**
     * peek Method
     * returns but does not remove the element with the highest priority
     * @return this.first.value
     */
    public V peek(){
        if(isEmpty()){ 
            System.out.println("Queue is Empty");
            return null;
        }
        else{
            return this.Values[this.front];
        }
    }

    /**
     * getSize Method
     * @return the current size of the Queue
     */
    public int getSzie(){
        return this.size;
    }

    /**
     * display Method
     * prints each element of the Queue from first to last
     */
    public void display(){
        System.out.print("Front -> ");
        for(int i = this.front; i != (rear + 1); i = (i+1) % this.capacity){
            System.out.print("{"+ this.Keys[i] + ":" + this.Values[i] + "}, ");
        }
        System.out.println("<- Rear");
    }
}