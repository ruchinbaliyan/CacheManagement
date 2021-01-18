package JunitTests;

import learnjava.lfu.LFUusingPQ;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class TestLFUwithPriorityQueue {
    LFUusingPQ cache;


    @Test
    public void TestInitialCacheSize() {
        cache = new LFUusingPQ();
        assertEquals(0, cache.getCacheSize());

    }

    @Test(expected = NullPointerException.class)
    public void puttingValueInCacheWithSizeZero() {
        cache = new LFUusingPQ();
        cache.putValue(1, 1);
        assertFalse(cache.isCacheEmpty());
        assertEquals(1, cache.getValue(1));

    }

    @Test
    public void TestGetValueMethod() {
        cache = new LFUusingPQ(3);
        cache.putValue(1, 1);
        cache.putValue(2, 2);
        assertEquals(2, cache.getValue(2));
        assertEquals(1, cache.getValue(1));
    }

    @Test
    public void LFUWorkingTest() {
        cache = new LFUusingPQ(3);
        cache.putValue(1, 1);
        cache.putValue(2, 2);
        cache.putValue(3, 3);
        cache.getValue(2);
        cache.getValue(1);
        cache.putValue(4, 4);
        assertEquals(-1, cache.getValue(3));

    }


}
