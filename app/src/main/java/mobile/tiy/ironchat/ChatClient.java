package mobile.tiy.ironchat;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


/**
 * Created by willi on 5/11/2016.
 */
public class ChatClient {
    String serverResponse;

    String sendMessage(String incomingString) {

        try {

            Socket clientSocket = new Socket("10.0.0.83", 8005);

            // send out to server
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            // receive in from the server
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            // send to server
            out.println(incomingString);

            String serverResponse;
            while (true) {
                serverResponse = in.readLine();

                if (serverResponse != null && serverResponse.equalsIgnoreCase("end-transmission")) {
                    break;
                }
                System.out.println(serverResponse);
                return serverResponse;
            }

        } catch (IOException ioException) {

        }
        return null;
    }
}
