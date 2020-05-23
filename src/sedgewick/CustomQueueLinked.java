package sedgewick;

import java.util.Iterator;

public class CustomQueueLinked<Item> implements Iterable<Item>{

    Node<Item> head;
    Node<Item> tail;

    public void enqueue(Item s){
        Node<Item> newItem = new Node<>(s);
        if(head == null){
            head = newItem;
            tail = newItem;
        } else{
            tail.next = newItem;
            tail = tail.next;
        }
    }

    public Item dequeue(){
        if(head==null)
            return null;// Some error

        Item val = head.data;
        head = head.next;
        return val;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }

    private class ListIterator implements Iterator<Item>{
        Node<Item> current = head;
        @Override
        public boolean hasNext() {
            return current!=null;
        }

        @Override
        public Item next() {
            if(current==null);// Throw exception
            Item item = current.data;
            current = current.next;
            return item;
        }
    }
}
