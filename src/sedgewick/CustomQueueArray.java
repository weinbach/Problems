package sedgewick;

import java.util.Iterator;

public class CustomQueueArray<Item> implements Iterable<Item>{

    Item[] array = (Item[]) new Object[1];
    int head = 0, tail = 0;


    public void enqueue(Item a){
        if(tail == array.length)
            resize();
        array[tail++] = a;
    }

    public Item dequeue(){
        if(tail==head)
            return null; // Some error

        Item val = array[head];
        array[head] = null;
        head++;

        if(tail-head<array.length/4)
            resize();

        return val;
    }

    public void resize(){
        int capacity = (int) Math.pow(2,Math.floor(Math.log(tail-head)/Math.log(2))+1);
        Item[] newArray = (Item[]) new Object[capacity];

        int j = 0;
        for(int i=head; i<tail; i++){
            newArray[j] = array[i];
            j++;
        }

        array = newArray;
        tail = tail - head;
        head = 0;
    }

    @Override
    public Iterator<Item> iterator() {
        return null;
    }

    private class ReverseArrayIterator implements Iterator<Item>{
        private int i = head;
        @Override
        public boolean hasNext() {
            return i<tail;
        }

        @Override
        public Item next() {
            return array[i++];
        }
    }
}
