import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private static final int INIT_CAPACITY = 8;
    private Item[] a; // stores the items in an array
    private int n; // number of items in the array

    // construct an empty randomized queue
    public RandomizedQueue() {
        a = (Item[]) new Object[INIT_CAPACITY];
        n = 0;
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return n == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
        return n;
    }

    // resize the underlying array holding the elements
    private void resize(int capacity) {
        assert capacity >= n;

        // textbook implementation
        Item[] copy = (Item[]) new Object[capacity];
        for (int i = 0; i < n; i++) {
            copy[i] = a[i]; // copies items from a
        }
        a = copy;
    }

    // add the item
    public void enqueue(Item item) {
        if (item == null)
            throw new IllegalArgumentException("");
        if (n == a.length) resize(2 * a.length);  // double size of array
        a[n] = item; // add item
        n++;
    }

    // remove and return a random item
    public Item dequeue() {
        if (isEmpty())
            throw new NoSuchElementException("");
        else {
            if (n == (0.25 * a.length)) resize((int) (0.5 * a.length));
            int k = StdRandom.uniformInt(n); // generates random int for index
            Item store = a[k];
            a[k] = a[n - 1];
            a[n - 1] = null; // last item and dequed item swap
            n--;
            return store;
        }
    }

    // use remove item from the array,
    // return a random item (but do not remove it)
    public Item sample() {
        if (isEmpty())
            throw new NoSuchElementException("");
        else {
            int sample = StdRandom.uniformInt(n);
            return a[sample];
        }
    }

    // return an independent iterator over items in random order
    public Iterator<Item> iterator() {
        return new ReverseArrayIterator();
    }

    // a array iterator, in reverse order
    private class ReverseArrayIterator implements Iterator<Item> {
        // keeps track of items in the array
        private int i;
        private Item[] b; // creates new copy array to shuffle

        // iterates array in reverse order because it's a queue
        public ReverseArrayIterator() {
            b = (Item[]) new Object[n];
            for (int d = 0; d < n; d++) {
                b[d] = a[d];
            }
            StdRandom.shuffle(b);
            i = 0;
        }

        public boolean hasNext() {
            return i < n;
        }

        public Item next() {
            if (!hasNext()) throw new NoSuchElementException();
            return b[i++];
        }
    }

    // unit testing (required)
    public static void main(String[] args) {
        RandomizedQueue<Integer> test = new RandomizedQueue<Integer>();
        StdOut.println(test.isEmpty());
        test.enqueue(1);
        StdOut.println(test.size());
        StdOut.println(test.dequeue()); // used to test each method
        StdOut.println(test.size());
        StdOut.println(test.sample());
        StdOut.println(test.isEmpty());

        for (Integer s : test)
            StdOut.println(s);
    }

}
