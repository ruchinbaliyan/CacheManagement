package learningjava.fifo;

import learnjava.lfu.Cache;
import learnjava.lfu.Node;

import java.util.HashMap;
import java.util.Map;

public class FirstInfirstOutCache implements Cache {

        int cacheSize= 0;
        Node front;
        Node back;
        Map<Long,Node> map =null;

        public FirstInfirstOutCache(int cacheSize) {
            this.cacheSize = cacheSize;
            map = new HashMap<>();

        }

        @Override
        public long getValue(long key) {

            if( map.get(key) == null)
            {
                return -1;
            }
            Node node = map.get(key);

            return node.value;
        }

        @Override
        public void putValue(long key, long value) {
            if(map.containsKey(key)){
                Node node = map.get(key);
                map.remove(key);
                removeNode(node);
                node = new Node(key,value,0);
                updateNodeList(node);
                map.put(key,node);

            }
            else {
                if(map.size()>=cacheSize){
                    //delete first with least frequnecy
                    Node item = map.get(front.key);
                    map.remove(front.key);
                    System.out.println(item.key + ","+item.value+" is removed due to cache overflow");
                    removeNode(front);

                }
                Node node = new Node(key,value,0);
                updateNodeList(node);
                map.put(key,node);

            }
            System.out.println("cache Size remaining is : "+getCurrentCacheSize());

        }
         void removeNode(Node node)
        {
            if(node.prev != null)
            {
                node.prev.next= node.next;


            }else{
                front = node.next;

            }
            if(node.next !=null)
            {
                node.next.prev =node.prev;

            }
            else{
                back =node.prev;

            }

        }
         void updateNodeList(Node node)
        {
            if(back!=null)
            {
                back.next = node;
                node.prev =back;
                back =node;
                node.next = null;

            }
            else{
                front=node;
                back=front;

            }

        }

        public int getCurrentCacheSize() {
            return getCacheSize()- map.size();
        }

        public int getCacheSize() {
            return cacheSize;
        }

    @Override
    public boolean isCacheEmpty() {
        return cacheSize==0;
    }
}


