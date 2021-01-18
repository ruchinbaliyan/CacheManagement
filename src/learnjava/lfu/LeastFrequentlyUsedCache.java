package learnjava.lfu;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

class ItemNotfoundException extends Exception {
    public ItemNotfoundException(String s) {
        super(s);
    }
}


public class LeastFrequentlyUsedCache implements Cache {
    private int cacheSize;
    private Node front;
    private Node back;

    Logger LOG = LoggerFactory.getLogger(LeastFrequentlyUsedCache.class);

    private Map<Long, Node> map = null;


    public LeastFrequentlyUsedCache(int size) {
        this.cacheSize = size;
        this.map = new HashMap<>();

    }

    public long getValue(long key){
        try {
            if (map.get(key) == null) {
                throw new ItemNotfoundException("item is not present");
            }
        }
        catch (ItemNotfoundException ex) {
            System.out.println(ex.getMessage());
            return -1;
        }

        Node node = map.get(key);
        removeNode(node);
        node.frequency += 1;
        updateNodeList(node);

        return node.value;

    }

//Overloading
    public ArrayList<Long> getValue(ArrayList<Long> list)
    {
        ArrayList<Long> values =new ArrayList<>();
        for(Long x :list)
        {
            values.add(getValue(x));
        }
        return values;
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

    public void putValue(long key, long value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            map.remove(key);
            removeNode(node);
            node = new Node(key, value, 0);
            updateNodeList(node);
            map.put(key, node);

        } else {
            if (map.size() >= cacheSize) {
                //delete first with least frequency
                Node item = map.get(front.key);
                map.remove(front.key);
                System.out.println(item.key+"is removed due to cache overflow"+item.value);
                removeNode(front);

            }
            Node node = new Node(key, value, 0);
            updateNodeList(node);
            map.put(key, node);
        }

        System.out.println("cache size remaining is"+ getCurrentCacheSize());

    }

    private void removeNode(Node node) {
        if (node.prev != null) {
            node.prev.next = node.next;


        } else {
            front = node.next;

        }
        if (node.next != null) {
            node.next.prev = node.prev;

        } else {
            back = node.prev;

        }

    }

    private void updateNodeList(Node node) {
        if (back != null && front != null) {
            Node temp = front;
            while (temp != null) {
                if (temp.frequency > node.frequency) {
                    if (temp == front) {
                        node.next = front;
                        temp.prev = node;
                        front = node;
                        break;

                    } else {
                        node.next = temp;
                        temp.prev = node;
                        temp.prev.next = node;
                        node.prev = temp.prev;
                    }
                } else {
                    temp = temp.next;
                    if (temp == null) {
                        back.next = node;
                        node.prev = back;
                        back = node;
                        node.next = null;
                        break;
                    }
                }
            }

        } else {
            front = node;
            back = front;

        }

    }

}
