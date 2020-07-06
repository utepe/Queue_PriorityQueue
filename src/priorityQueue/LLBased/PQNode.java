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

	@Override
    public int compareTo(PQNode<K, V> o) {
        int o1 = Integer.parseInt(this.key.toString());
        int o2 = Integer.parseInt(o.key.toString());
        return o1-o2;
    }
}