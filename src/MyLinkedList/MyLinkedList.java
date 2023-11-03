package MyLinkedList;

public class MyLinkedList <T>{
    protected Node<T> firstNode;
    protected Node<T>  lastNode;
    protected int sizeList;

    public MyLinkedList() {
        this.sizeList = 0;

    }
    public void add (T value){
        if(firstNode==null){
            firstNode = new Node<T>(null,null, value);
            sizeList++;
        } else if(lastNode==null){
           lastNode = new Node<T>(firstNode,null, value);
            firstNode.setNextNode(lastNode );
            sizeList++;
        } else {
            Node<T> node = new Node<T>(lastNode,null, value);
            lastNode.setNextNode(node);
            lastNode=node;
            sizeList++;
        }
    }
    public int size(){
        return sizeList;
    }
    public T get (int index){
        if (index>=0 && index<sizeList){
            Node <T> temp = firstNode;
            for (int i = 0; i < index; i++) {
                temp = temp.getNextNode();
            }
            return temp.getValue();
        } else throw new IllegalArgumentException();

    }
    public void remove (int index){
        if (index>=0 && index<sizeList){
            Node<T> needNode = firstNode;
            for (int i = 0; i < index; i++) {
                needNode = needNode.getNextNode();
            }
            Node<T> nextNode =  needNode.getNextNode();
            Node<T> previousNode =  needNode.getPreviousNode();
            if(previousNode==null){
                firstNode = firstNode.getNextNode();
                sizeList--;
            } else if (nextNode ==null) {
                lastNode = lastNode.getPreviousNode();
                sizeList--;
            }
            else{
                nextNode.setPreviousNode(previousNode);
                previousNode.setNextNode(nextNode);
                sizeList--;
            }

        } else throw new IllegalArgumentException();

    }
    public void clear(){
        firstNode = null;
        lastNode =null;
        sizeList =0;
    }

    public static void main(String[] args) {
        MyLinkedList<String> ll= new MyLinkedList<String>();
        ll.add("mom");
        ll.add("dad");
        ll.add("sister");
        System.out.println(ll.size());
        System.out.println(ll.get(2));
        ll.remove(2);
        System.out.println(ll.get(0));
        System.out.println(ll.get(1));
        ll.add("brother");
        ll.add("grandmother");
        System.out.println(ll.size());
        ll.clear();

        ll.add("friend");
        System.out.println(ll.get(0));
        System.out.println(ll.size());
    }
}
