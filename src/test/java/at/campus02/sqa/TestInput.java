package at.campus02.sqa;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import  static org.mockito.Mockito.*; //otherwise it is with Mockito.mock this is only because we don't want to write statische klasse

import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

public class TestInput {

    @Test
    public void testNextItemOnEmptyQueue(){
        //given
        Scanner scanner = new Scanner("");
        PrintWriter output = mock(PrintWriter.class);
        Input input = new Input(scanner, output);
        CustomQueue customQueue = new CustomQueue();

        //when
        input.nextItem(customQueue);

        //then
        verify(output, times(1)).println("Queue is empty");

    }

    @Test
    public void testHandleNext(){
        //given
        Scanner scanner = new Scanner("n\nn\nq\n\n");
        PrintWriter output = mock(PrintWriter.class);
        Input input = new Input(scanner, output);
        CustomQueue customQueue = new CustomQueue();
        customQueue.push("one");
        customQueue.push("two");

        //when
        input.handle(customQueue);

        //then
        ArgumentCaptor<String> capture = ArgumentCaptor.forClass(String.class);
        verify(output, atLeast(2)).println(capture.capture());
        List<String> result = capture.getAllValues();
        Assert.assertEquals("> one", result.get(0));
        Assert.assertEquals("> two", result.get(1));


    }
}
