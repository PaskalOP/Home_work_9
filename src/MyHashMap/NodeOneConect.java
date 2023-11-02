package MyHashMap;

public class NodeOneConect <K, V>{
   private NodeOneConect<K,V> nextNode;
   private K key;
   private V value;

    public NodeOneConect() {
        this.nextNode = nextNode;
        this.key = key;
        this.value = value;
    }

    public NodeOneConect<K, V> getNextNode() {
        return nextNode;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setNextNode(NodeOneConect<K, V> nextNode) {
        this.nextNode = nextNode;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
