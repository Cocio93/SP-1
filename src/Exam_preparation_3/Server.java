package Exam_preparation_3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Jonathan Henriksen
 */
public class Server {
    public static void main(String[] args) throws IOException {

        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(8080);
        } catch (IOException e) {
            System.err.println("IOException on host"); 
            System.exit(1);
        }

        Socket clientSocket = null;
        try {
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            System.err.println("Connection not accepted");
            System.exit(1);
        }

        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        String input; 
        String output;
        Counter c = new Counter();

        out.println("Type 'TURN' to turn turnstile. Type 'COUNT' to see total amount of rotations");

        while ((input = in.readLine()) != null) {
            output = c.inputString(input);
            out.println(output);
        }
        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }
    
    
    
    
    
}