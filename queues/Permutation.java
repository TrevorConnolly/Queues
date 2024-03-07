import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Permutation {
    public static void main(String[] args) {
        int k = Integer.parseInt(args[0]);
        RandomizedQueue<String> test = new RandomizedQueue<String>();
        while (!StdIn.isEmpty()) {
            String item = StdIn.readString(); // reads from StdIn
            test.enqueue(item);
        }
        for (int i = 0; i < k; i++) {
            StdOut.println(test.dequeue()); // prints k items
        }
    }
}
