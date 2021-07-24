package sedgewick;

import java.util.Iterator;

public class CustomStackArray<Item> implements Iterable<Item>{

    Item[] s;
    int index = 0;

    public CustomStackArray(){
        s = (Item[]) new Object[1];
    }

    public void push(Item item){
        if(index == s.length)
            resize(true);
        s[index++] = item;
    }

    public Item pop(){

        if(index == 0)
            return null;

        Item val = s[--index];
        s[index] = null;
        if(s.length/4>=index && s.length>1){
            resize(false);
        }

        return val;
    }

    private void resize(boolean increase){
        int capacity = increase? s.length*2 : s.length/2;
        Item[] copy = (Item[]) new Object[capacity];
        for(int i=0;i<index;i++){
            copy[i] = s[i];
        }
        s = copy;
    }

    @Override
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    private class ReverseArrayIterator implements Iterator<Item>{
        private int i = index;
        @Override
        public boolean hasNext() {
            return i>0;
        }

        @Override
        public Item next() {
            return s[--i];
        }
    }

    public static boolean less(Comparable v, Comparable w){
        return v.compareTo(w) < 0;
    }
}
