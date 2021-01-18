package learningjava.fifo;

import learnjava.lfu.Node;

public class LeastRecentlyUsedCache extends FirstInfirstOutCache{
    public LeastRecentlyUsedCache(int cacheSize) {
        super(cacheSize);
    }

    @Override
    public long getValue(long key) {

        if( map.get(key) == null)
        {
            return -1;
        }
        Node node = map.get(key);
        super.removeNode(node);
        super.updateNodeList(node);
        return node.value;

    }
}
