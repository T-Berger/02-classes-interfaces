package de.fhro.inf.prg3.a02;


import java.util.Iterator;

/**
 * @author Peter Kurfer
 *         Created on 10/6/17.
 */
public class SimpleListImpl implements SimpleList, Iterable<Object> {

    // TODO: Implement the required methods.
    private Element head;
    private int size;

    @Override
    public void add(Object item) {
        if (head == null) {
            head = new Element(item);
        } else {
            Element current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(new Element(item));
        }
        size++;
    }

    @Override
    public int size() {
        return size;
    }

    public Iterator<Object> iterator() {
        return new SimpleIterator();
    }

    @Override
    public SimpleList filter(SimpleFilter filter) {
        SimpleList result = new SimpleListImpl();
        for (Object o :
                this) {
            if (filter.include(o)) {
                result.add(o);
            }
        }
        return result;
    }

    private static class Element {
        private Object item;
        private Element next;

        Element(Object item) {
            this.item = item;
            this.next = next;
        }

        public Object getItem() {
            return item;
        }

        public Element getNext() {
            return next;
        }

        public void setNext(Element next) {
            this.next = next;
        }
    }

    private class SimpleIterator implements Iterator<Object> {
        private Element current = head;

        @Override
        public Object next() {
            Object tmp = current.getItem();
            current = current.getNext();
            return tmp;
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }
    }

//    @Override
//    public boolean include(Object item) {
//        Element current = head;
//        while(current.getNext()!= null){
//            if (current.item == item){return true;}
//            current = current.getNext();
//        }
//        return false;
//    }
}
