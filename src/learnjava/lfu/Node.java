package learnjava.lfu;

public class Node {
    public long key;
    public long value;
    public Node prev;
    public Node next;
    public int frequency;

    public Node(long key, long value, int frequency) {
        this.key = key;
        this.value = value;
        this.prev = null;
        this.next = null;
        this.frequency = frequency;
    }
}
