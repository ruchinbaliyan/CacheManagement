package learnjava.lfu;

public interface Cache {

     long getValue(long key);
     void putValue(long key,long value);
     int getCurrentCacheSize();
     int getCacheSize();
     boolean isCacheEmpty();


}
