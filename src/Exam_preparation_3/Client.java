package Exam_preparation_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author Jonathan Henriksen
 */
public class Client {    
    
    public static void main(String[] args) throws IOException {
        Socket Socket = null; 
        PrintWriter out = null;
        BufferedReader in = null;

        try {
            Socket = new Socket("localhost", 8080);
            out = new PrintWriter(Socket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(Socket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Caught UnknownHostException");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Caught IOException");
            System.exit(1);
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String server;
        String client;

        while ((server = in.readLine()) != null) {
            System.out.println(server);
            client = br.readLine();
            out.println(client);
        }
        out.close();
        in.close();
        br.close();
        Socket.close();
    }
}
