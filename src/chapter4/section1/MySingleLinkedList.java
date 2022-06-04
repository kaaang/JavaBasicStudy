package chapter4.section1;

public class MySingleLinkedList<T> {

    public Node<T> head;
    public int size = 0;

    public MySingleLinkedList(){
        head = null;
        size = 0;
    }

    public void addFirst(T item){
        Node<T> newNode = new Node<>(item);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void addAfter(Node<T> before, T item){
        Node<T> temp = new Node<>(item);
        temp.next = before.next;
        before.next = temp;
        size++;
    }

    public void add(int index, T item){

    }

    public T removeFirst(){
        if(head == null){
            return null;
        }
        T temp = head.data;
        head = head.next;
        size--;
        return temp;
    }

    public T removeAfter(Node<T> before){
        if(before.next == null){
            return null;
        }
        T temp = before.next.data;
        before.next = before.next.next;
        return temp;
    }

    public void remove(int index){

    }

    public T get(int index){
        return null;
    }

    public int indexOf(T item){
        return -1;
    }


    public static void main(String[] args) {
        MySingleLinkedList<String> list = new MySingleLinkedList<>();
        list.add(0, "Saturday");
        list.add(1, "Friday");
        list.add(0, "Monday");
        list.add(2, "Tuesday");

        String str = list.get(2);
        list.remove(2);
        int pos = list.indexOf("Friday");
    }
}
