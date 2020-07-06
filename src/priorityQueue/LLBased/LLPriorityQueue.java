package priorityQueue.LLBased;

public class LLPriorityQueue<K, V> {
    private PQNode<K, V> first, last;
    private int size;

    public LLPriorityQueue(){
        this.first = null;
        this.last = null;
        this.size = 0;
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
        return false;
    }
    
    /**
     * enqueue Base Method
     * calls this method if user does not pass in the priority of the element
     * sets default priority to 9
     * calls overloaded enqueue Method
     * @param value
     */

    //TODO: 
    public void enqueue(V value){
        enqueue((K)(Integer) 10, value);
    }

    /**
     * enqueue Overloaded Method
     * adds element to the pQueue based on the priority (key) of the element
     * @param key
     * @param value
     */
    public void enqueue(K key, V value){
        PQNode<K, V> newNode = new PQNode<K, V>(key, value);
        if(isEmpty()){
            this.first = newNode;
            this.last = newNode;
        }
        else if(newNode.compareTo(this.first) == -1){ //if priority is the greatest
            newNode.next = this.first;
            this.first = newNode;
        }
        else{
            //-1 return means key < o
            //1 return means key == o
            //1 reuturn means key > o
            PQNode<K, V> current = this.first; 

            while(current.next != null && current.next.compareTo(newNode) < 1){
                current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
            if(newNode.next == null){
                this.last = newNode;
            } 
        }
        this.size++;
    }
    
    /**
     * dequeue Method
     * removed and returns the element with the highest priority
     * @return value of the element with the highest priority
     */
    public V dequeue(){
        if(isEmpty()) return null;
        if(this.first == this.last) this.last = null;
        PQNode<K, V> firstEle = this.first;
        this.first = this.first.next;
        this.size--;
        return firstEle.value;
    }

    /**
     * peek Method
     * returns but does not remove the element with the highest priority
     * @return this.first.value
     */
    public V peek(){
        if(isEmpty()) return null;
        else{
            return this.first.value;
        }
    }
    
    /**
     * peekMin Method
     * returns but does not remove the element with the lowest priority
     * @return this.last.value
     */
    public V peekMin(){
        if(isEmpty()) return null;
        else{
            return this.last.value;
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
     * display Method
     * prints each element of the Queue from first to last
     */
    public void display(){
        PQNode<K, V> current = this.first;
        System.out.print("highest -> ");
        while(current != null){
            System.out.print("{"+ current.key + ":" + current.value + "}, ");
            current = current.next;
        }
        System.out.println("<- lowest");
    }
}