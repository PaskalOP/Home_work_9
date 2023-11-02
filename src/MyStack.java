import MyLinkedList.MyLinkedList;
import MyLinkedList.Node;


public class MyStack <T> extends MyLinkedList {
    // Методи size(), remove(), clear() - викликаються з батьківського класу
    public void push (T value){
        add(value);
    }
    public T peek(){
        Node<T> last = lastNode;
        return last.getValue();
    }

    public T pop (){
        if(sizeList>0){
            Node <T> delatedElement = lastNode;
            lastNode = lastNode.getPreviousNode();
            lastNode.setNextNode(null);
            sizeList--;
            return delatedElement.getValue();
        } else return null;

    }
    public static void main(String[] args) {
        MyStack<Integer> ms = new MyStack<>();
        System.out.println(ms.size());
        ms.push(333);
        ms.push(234);
        ms.push(23);
        ms.push(34);
        ms.push(3);
        ms.push(4);
        System.out.println(ms.get(0));
        System.out.println(ms.size());
        System.out.println("First element in Stack  " + ms.peek());
        System.out.println(" Delete this element " + ms.pop());
        System.out.println("Last element now is " + ms.lastNode.getValue());
        ms.pop();
        ms.pop();
        ms.pop();
        System.out.println("Last element now is " + ms.lastNode.getValue());

    }
}
