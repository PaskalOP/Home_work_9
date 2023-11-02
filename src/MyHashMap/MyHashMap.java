package MyHashMap;

public class MyHashMap <K, V>{
     private NodeOneConect <K, V> [] nodes;
     private int size;

    public MyHashMap() {
        this.nodes = new NodeOneConect[5];
        this.size = 0;

    }
    public void put(K key, V value){
        int hashKey = key.hashCode();
        int numberBucket = hashKey%nodes.length;
        NodeOneConect<K,V> currentNode = new NodeOneConect<K,V>();
        currentNode.setKey(key);
        currentNode.setValue(value);
        if (nodes[numberBucket]==null){
            nodes[numberBucket] = currentNode;
            size++;
        } else {
            currentNode.setNextNode(nodes[numberBucket]);
            nodes[numberBucket]= currentNode;
            size++;
        }

    }
    public int size(){
        return this.size;
    }

    public V get (K key){
        int hashKey = key.hashCode();
        int numberBucket = hashKey%nodes.length;
        V rez = null;
        if(nodes[numberBucket]!=null){
            NodeOneConect<K,V> currentN = nodes[numberBucket];
            if(!currentN.getKey().equals(key)) {
                while (currentN.getNextNode()!=null){
                    if(currentN.getKey().equals(key) ){
                        rez = currentN.getValue();
                        break;
                    } else {
                        currentN = currentN.getNextNode();
                    }
                }
                if(currentN.getKey().equals(key)) rez = currentN.getValue();
            }
            else rez = currentN.getValue();

        }
        return rez;
    }

    public void remove (K key){
        int hashKey = key.hashCode();
        int numberBucket = hashKey%nodes.length;
        NodeOneConect<K,V> previousNode = null;

        if(nodes[numberBucket]!=null) {
            NodeOneConect<K, V> currentN = nodes[numberBucket];
            if (!currentN.getKey().equals(key)) {
                while (currentN.getNextNode() != null) {
                    previousNode = currentN;
                    currentN = currentN.getNextNode();
                    if (currentN.getKey().equals(key)) {
                        previousNode.setNextNode(currentN.getNextNode());
                        size--;
                        break;
                    } else {
                        currentN = currentN.getNextNode();
                    }
                }

            } else {
                nodes[numberBucket] = currentN.getNextNode();
                size--;
            }
        } else System.out.println("No such element");
    }
    public void printMap(){
        for (int i=0; i<nodes.length;i++) {
            if(nodes[i]!=null){
                NodeOneConect<K,V> currentN = nodes[i];
                System.out.println(currentN.getValue() );
                while (currentN.getNextNode()!=null){
                    System.out.println(currentN.getNextNode().getValue());
                    currentN =currentN.getNextNode();
                }
            }

        }
    }

    public static void main(String[] args) {
        MyHashMap<Integer,String> hm = new MyHashMap<Integer, String>();
        hm.put(1,"mom");
        hm.put(2,"dad");
        hm.put(3,"sister");
        hm.put(44,"brother");
        hm.put(5,"grandma");
        hm.put(55,"grandpa");
        hm.put(60,"uncle");

        hm.printMap();
        System.out.println("Size of map - "+hm.size());
        System.out.println("Finding element  - " + hm.get(60));
        hm.remove(55);
        hm.printMap();
        System.out.println("Size of map - "+hm.size());
        hm.remove(60);
        hm.printMap();
        System.out.println("Size of map - "+hm.size());

    }
}
