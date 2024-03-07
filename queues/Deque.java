import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    private int n; /// size of the deque
    private Node first; // keeps track of first node
    private Node last; // keeps track of the last node

    private class Node // constructor for each node
    {
        private Item item; // holds the item of each node
        private Node next; // holds the reference to the next node in list
        private Node before; // holds reference to the node before
    }

    // construct an empty deque
    public Deque() {
        first = null; // this doesnt access the instance var in deque?
        last = null;
        n = 0; // this doesnt access the instance var in deque?
        assert check();

    }

    // is the deque empty?
    public boolean isEmpty() {
        return n == 0;
    }

    // return the number of items on the deque
    public int size() {
        return n;
    }

    // add the item to the front
    public void addFirst(Item item) {
        if (item == null) {
            throw new IllegalArgumentException("");
        }
        if (n == 0) {
            first = new Node(); // creates new first
            first.item = item;
            last = first;
        }
        else {
            Node oldfirst = first;
            first = new Node();
            first.item = item;
            first.next = oldfirst;
            oldfirst.before = first;
            first.before = null; // ensures first is first
        }
        n++;
        assert check();

    }

    // add the item to the back
    public void addLast(Item item) {
        if (item == null)
            throw new IllegalArgumentException("");
        Node oldlast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (isEmpty()) {
            first = last;
        }
        else {
            oldlast.next = last;
            last.before = oldlast;
        }
        n++;
    }

    // remove and return the item from the front
    public Item removeFirst() {
        if (n == 0)
            throw new NoSuchElementException("");
        Item item = first.item;
        first = first.next;
        n--;
        if (first == null) {
            last = null;
        }
        else {
            first.before = null;
        }
        assert check();
        return item;
    }

    // remove and return the item from the back
    public Item removeLast() {
        if (n == 0)
            throw new NoSuchElementException("");
        Item item = last.item;
        last = last.before;
        if (last == null) {
            first = null;
        }
        else {
            last.next = null;
        }
        n--;

        assert check();
        return item;
    }

    // return an iterator over items in order from front to back
    public Iterator<Item> iterator() {
        return new LinkedIterator();
    }

    // a linked-list iterator
    private class LinkedIterator implements Iterator<Item> {
        private Node current = first; // keeps track of item that is currently
        // being iterated

        public boolean hasNext() {
            return current != null;
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    // check internal invariants
    private boolean check() {

        // check a few properties of instance variable 'first'
        if (n < 0) {
            return false;
        }
        if (n == 0) {
            if (first != null) return false;
        }
        else if (n == 1) {
            if (first == null) return false;
            if (first.next != null) return false;
        }
        else {
            if (first == null) return false;
            if (first.next == null) return false;
        }

        // check internal consistency of instance variable n
        int numberOfNodes = 0;
        for (Node x = first; x != null && numberOfNodes <= n; x = x.next) {
            numberOfNodes++;
        }
        if (numberOfNodes != n) return false;

        return true;
    }


    // unit testing (required)
    public static void main(String[] args) {
        Deque<String> test = new Deque<String>();
        StdOut.println(test.isEmpty());
        String item1 = "cats";
        String item2 = "and";
        String item3 = "dogs";
        test.addFirst(item1);
        test.addLast(item2);
        test.addLast(item3);
        for (String s : test)
            StdOut.println(s);
        StdOut.println(test.removeFirst());
        for (String s : test)
            StdOut.println(s);
        StdOut.println(test.size());
        StdOut.println(test.removeFirst());
        for (String s : test)
            StdOut.println(s);
    }

}
