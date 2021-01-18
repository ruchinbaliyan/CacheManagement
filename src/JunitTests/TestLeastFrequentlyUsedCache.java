package JunitTests;

import learnjava.lfu.LeastFrequentlyUsedCache;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestLeastFrequentlyUsedCache {

    @Test
    public void TestgetCacheSize()
{
    LeastFrequentlyUsedCache cache = new LeastFrequentlyUsedCache(5);
    assertEquals(5,cache.getCacheSize());
    cache.putValue(0,0);
    assertEquals(4,cache.getCurrentCacheSize());
    cache.putValue(0,1);
    assertEquals(4,cache.getCurrentCacheSize());

}

@Test
    public void TestgetValue()
{
    LeastFrequentlyUsedCache cache = new LeastFrequentlyUsedCache(3);
    assertEquals(-1,cache.getValue(1));
    cache.putValue(1,10);
    assertEquals(10,cache.getValue(1));
    cache.putValue(2,20);
    assertEquals(20,cache.getValue(2));
    cache.putValue(2,21);
    assertEquals(21,cache.getValue(2));
    cache.putValue(4,4);
    cache.putValue(3,3);

}

@Test
    public void TestputValue()
{
    LeastFrequentlyUsedCache cache = new LeastFrequentlyUsedCache(3);
    cache.putValue(0,0);
    assertEquals(2,cache.getCurrentCacheSize());
    cache.putValue(0,1);
    assertEquals(2,cache.getCurrentCacheSize());
    cache.putValue(1,1);
    cache.putValue(2,2);
    assertEquals(0,cache.getCurrentCacheSize());

}






}
