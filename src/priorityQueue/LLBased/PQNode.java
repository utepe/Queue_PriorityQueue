package priorityQueue.LLBased;

public class PQNode<K, V> implements Comparable<PQNode<K, V>>{
    PQNode<K, V> next;
    K key;
    V value;

    public PQNode(K key, V value){
        this.key = key;
        this.value = value;
        this.next = null;
    }

    public PQNode(String i, V value) {
        this.key = (K) i;
        this.value = value;
        this.next = null;
	}

	@Override
    public int compareTo(PQNode<K, V> o) {
        String o1 = this.toString();
        String o2 = o.toString();
        return o1.compareTo(o2);
    }

    public String toString(){
        return key.toString();
    }
}