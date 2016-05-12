package mobile.tiy.ironchat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

import static org.junit.Assert.*;

/**
 * Created by willi on 5/11/2016.
 */
public class ChatClientTest {

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void testSendMessage() throws Exception {

        String messageToSend = "blah blah blah";
        ChatClient myClient = new ChatClient();
        String ex = "echo::"+ messageToSend; // Your expecting from server this msg
        String serverResponse = myClient.sendMessage(messageToSend);

        assertEquals(ex, serverResponse); // serverResponse is blah
    }
}


