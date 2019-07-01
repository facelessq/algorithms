/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;

public class RandomizedQueue<Item> {
    // construct an empty randomized queue
    private int N;
    private Node first;
    private Node last;

    private class Node<Item> {
        Item item;
        Node next;
    }

    public RandomizedQueue() {
        first = null;
        last = null;
        N = 0;
    }

    // is the randomized queue empty?
    public boolean isEmpty() {
        return N == 0;
    }

    // return the number of items on the randomized queue
    public int size() {
        return N;
    }

    // add the item
    public void enqueue(Item item) {
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.next = null;
        if (oldLast == null) first = last;
        else oldLast.next = last;
        N++;
    }

    // remove and return a random item
    public Item dequeue() {
        StdRandom.uniform(N);
    }

    // return a random item (but do not remove it)
    public Item sample()

    // return an independent iterator over items in random order
    public Iterator<Item> iterator()

    // unit testing (required)
    public static void main(String[] args) {
        StdOut.print();

    }
}
