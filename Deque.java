/* *****************************************************************************
 *  Name:
 *  Date:
 *  Description:
 **************************************************************************** */

import edu.princeton.cs.algs4.StdOut;

import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {
    private Node first;
    private Node last;
    private int N;

    private class Node {
        Item item;
        Node next;
        Node prior;
    }

    public Deque()                           // construct an empty deque
    {
        first = null;
        last = null;
        N = 0;
    }

    public boolean isEmpty()                 // is the deque empty?
    {
        return N == 0;
    }

    public int size()                        // return the number of items on the deque
    {
        return N;
    }

    public void addFirst(Item item)          // add the item to the front
    {
        if (item == null)
            throw new java.lang.IllegalArgumentException("addFirst has null argument");
        Node oldFirst = first;
        first = new Node(); // I forgot to instantiate it at first!!
        first.item = item;
        first.next = oldFirst;
        first.prior = null;
        if (isEmpty()) last = first;
        else oldFirst.prior = first;
        N++;
    }

    public void addLast(Item item)           // add the item to the end
    {
        if (item == null)
            throw new java.lang.IllegalArgumentException("addLast has null argument");
        Node oldLast = last;
        last = new Node();
        last.item = item;
        last.prior = oldLast;
        last.next = null;
        if (isEmpty()) first = last;
        else oldLast.next = last;
        N++;
    }

    public Item removeFirst()                // remove and return the item from the front
    {
        if (isEmpty()) throw new java.util.NoSuchElementException("empty, cannot removeFirst");
        Item item = first.item;
        first = first.next;
        N--; // this should be before isEmpty() because we determine is Empty by N == 0
        if (isEmpty()) last = null; // if after deletion the deque is empty
        else first.prior = null;
        return item;
    }

    public Item removeLast()                 // remove and return the item from the end
    {
        if (isEmpty()) throw new java.util.NoSuchElementException("empty, cannot removeLast");
        Item item = last.item;
        last = last.prior;
        N--;
        if (isEmpty()) first = null;
            // if after removing is empty, then last=null then. So last.next is null dereference
        else last.next = null;
        return item;
    }

    public Iterator<Item> iterator()         // return an iterator over items in order from front to end
    {
        return new DequeIterator();
    }

    private class DequeIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext() {
            return current != null;
        }

        public void remove() {
            throw new java.lang.UnsupportedOperationException("called remove()");
        }

        public Item next() {
            if (!hasNext()) throw new java.util.NoSuchElementException("no next element");
            Item item = current.item;
            current = current.next;
            return item;
        }
    }

    public static void main(String[] args)   // unit testing (optional)
    {
        Deque<String> deque = new Deque<String>();
        deque.addFirst("b");
        for (String s : deque)
            StdOut.printf("%s ", s);
        StdOut.println();

        deque.addFirst("a");
        for (String s : deque)
            StdOut.printf("%s ", s);
        StdOut.println();

        deque.addLast("c");
        for (String s : deque)
            StdOut.printf("%s ", s);
        StdOut.println();

        deque.removeFirst();
        for (String s : deque)
            StdOut.printf("%s ", s);
        StdOut.println();

        deque.removeLast();
        for (String s : deque)
            StdOut.printf("%s ", s);
        StdOut.println();

        deque.removeLast();
        for (String s : deque)
            StdOut.printf("%s ", s);
        StdOut.println("no more elements");

        deque.removeFirst();

    }
}
