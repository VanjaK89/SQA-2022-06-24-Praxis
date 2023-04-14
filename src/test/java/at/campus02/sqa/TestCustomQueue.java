package at.campus02.sqa;

import at.campus02.sqa.CustomQueue;
import org.junit.Assert;
import org.junit.Test;

public class TestCustomQueue {

    @Test
    public void testPopFromEmptyQueue(){
        CustomQueue customQueue = new CustomQueue();
        String result = customQueue.pop();
        Assert.assertNull(result);
    }

    @Test
    public void testPushBadStrings(){
        CustomQueue customQueue = new CustomQueue();
        boolean result = customQueue.push("");
        Assert.assertFalse(result);
        result = customQueue.push("bad! String");
        Assert.assertFalse(result);
    }

    @Test
    public void testQueueOrder(){
        CustomQueue customQueue = new CustomQueue();
        customQueue.push("one");
        customQueue.push("two");
        customQueue.push("three");
        Assert.assertEquals("one", customQueue.pop());
        Assert.assertEquals("two", customQueue.pop());
        Assert.assertEquals("three", customQueue.pop());
        //Assert.assertNull(customQueue.pop());

    }


}
