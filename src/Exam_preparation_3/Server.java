package Exam_preparation_3;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 *
 * @author Jonathan Henriksen
 */
public class Server {
    private static int total;
    public static void main(String[] args) throws IOException {
        
        ArrayList<Turnstile> connections = new ArrayList();
        ServerSocket serverSocket = null;
        
        try {
            serverSocket = new ServerSocket(8080);
        } catch (IOException e) {
            System.err.println("IOException on host"); 
            System.exit(1);
        }

        do {
        Socket clientSocket = null;
        try {
            clientSocket = serverSocket.accept();
        } catch (IOException e) {
            System.err.println("Connection not accepted");
            System.exit(1);
        }   
        
        System.out.println("Turnstile succesfully connected to server"); 
        
        Turnstile t = new Turnstile(clientSocket, total);
        t.run();
        connections.add(t); } while (!connections.isEmpty());

        serverSocket.close();
    }
    
    
    
    
    
}