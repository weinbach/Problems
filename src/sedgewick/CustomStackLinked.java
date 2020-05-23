package sedgewick;

import java.util.Iterator;

class Node<Item> {
    public Item data;
    public Node<Item> next;

    public Node(Item data) {
        this.data = data;
    }
}

public class CustomStackLinked<Item> implements Iterable<Item>{

    Node<Item> node;

    public void push(Item item){
        Node<Item> newItem = new Node<>(item);
        newItem.next = node;
        node = newItem;
    }

    public Item pop(){
        if(node==null)
            return null;

        Item popItem = node.data;
        node = node.next;
        return popItem;
    }

    private class ListIterator implements Iterator<Item>{
        private Node<Item> current = node;
        @Override
        public boolean hasNext() {
            return current!=null;
        }

        @Override
        public Item next() {
            if(current==null);//Throw noSuchElementException
            Item item = current.data;
            current = current.next;
            return item;
        }
    }

    @Override
    public Iterator<Item> iterator() {
        return new ListIterator();
    }
}
