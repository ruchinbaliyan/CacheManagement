package learnjava.lfu;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class The_Comparator implements Comparator<Node> {
    public int compare(Node node1, Node node2) {
        return node1.frequency - node2.frequency;
    }
}

public class LFUusingPQ implements Cache {

    private int cacheSize;
    private  PriorityQueue<Node> pq;
    private  Map<Long, Node> map;

    public LFUusingPQ() {

    }

    public LFUusingPQ(int size) {
        this.cacheSize = size;
        pq = new PriorityQueue<>(new The_Comparator());
        map = new HashMap<>();
    }


    public int getCurrentCacheSize() {
        return getCacheSize() - map.size();
    }

    public int getCacheSize() {
        return cacheSize;
    }

    @Override
    public boolean isCacheEmpty() {
        return cacheSize == 0;
    }

    public long getValue(long key) {
        if (map.get(key) == null) {
            return -1;
        }
        Node node = map.get(key);
        pq.remove(node);

        node.frequency += 1;
        pq.add(node);

        return node.value;

    }

    public void putValue(long key, long value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            map.remove(key);
            pq.remove(node);
            node = new Node(key, value, 0);
            pq.add(node);
            map.put(key, node);

        } else {
            if (map.size() >= cacheSize) {
                //delete first with least frequnecy
                Node item = pq.poll();
                map.remove(item.key);
                System.out.println(item.key + "," + item.value + " is removed due to cache overflow");


            }
            Node node = new Node(key, value, 0);
            pq.add(node);
            map.put(key, node);

        }
        System.out.println("cache Size remaining is : " + getCurrentCacheSize());


    }


}
