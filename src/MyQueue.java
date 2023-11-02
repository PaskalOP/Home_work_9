import MyLinkedList.Node;

public class MyQueue <T>{
    private Node <T>firstNode;
    private Node <T>lastNode;
    private int size;

    public MyQueue() {
        this.size = 0;
        this.firstNode=null;
        this.lastNode =null;
    }
    public void add(T value){
        if(firstNode==null){
            firstNode = new Node<T>(null,null,value);
            size++;
        } else if (lastNode==null) {
            lastNode = new Node<T>(firstNode,null,value);
            firstNode.setNextNode(lastNode);
            size++;
        } else {
            Node <T>nextNode = new Node<T>(lastNode,null,value);
            lastNode.setNextNode(nextNode);
            lastNode = nextNode;
            size++;
        }
    }
    public int size(){
        return this.size;
    }
    public T peek(){
        return firstNode.getValue();
    }
    public T poll(){
       if(size>0){
           Node <T> delatedElement = firstNode;
           firstNode = firstNode.getNextNode();
           firstNode.setPreviousNode(null);
           size--;
           return delatedElement.getValue();
       } else return null;

    }
    public void clear(){
        this.size = 0;
        this.firstNode=null;
        this.lastNode =null;
    }

    @Override
    public String toString() {
        Node<T> current = firstNode;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size ; i++) {
            sb.append( current.getValue().toString());
            sb.append(" ");
            current = current.getNextNode();
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        MyQueue<Integer> mq = new MyQueue<>();
        mq.add(1);
        mq.add(3);
        mq.add(5);
        System.out.println(mq);
        System.out.println("Кількість елементів -" + mq.size());
        System.out.println("Перший елемент - " + mq.peek());
        System.out.println(" Delete this element " + mq.poll());
        System.out.println(mq);
        mq.clear();
        System.out.println(mq);
    }
}
