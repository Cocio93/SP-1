package Socket_1.Exercise_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

/**
 *
 * @author Jonathan Henriksen^
 */
public class EchoServer {

    public static void main(String[] args) throws IOException {
        HashMap<String, String> dictionary = new HashMap();
        dictionary.put("taske", "bag");
        dictionary.put("fugl", "bird");
        dictionary.put("stol", "chair");
        dictionary.put("bil", "car");
        dictionary.put("søster", "sister");
        dictionary.put("bror", "brother");
        int portNumber = 8080;

        try (
                
                ServerSocket serverSocket = new ServerSocket(portNumber);
                Socket clientSocket = serverSocket.accept();
                PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));) {
            String inputLine;
            String outputLine = null;
            System.out.println("User Connected");
            out.println("Welcome");
            while ((inputLine = in.readLine()) != null) {
                String[] userinput = inputLine.split("#");
                if (userinput.length != 2) {
                    out.println("Unkown command, closing connection");
                    clientSocket.close();
                } else {

                    String command = userinput[0];
                    String content = userinput[1];

                    switch (command) {
                        case "UPPER":
                            outputLine = content.toUpperCase();
                            break;
                        case "LOWER":
                            outputLine = content.toLowerCase();
                            break;
                        case "REVERSE":
                            outputLine = new StringBuilder(content).reverse().toString();
                            break;
                        case "TRANSLATE":
                            if (dictionary.containsKey(content)) {
                                outputLine = dictionary.get(content);
                            } else {
                                out.println("Error: Unknown word - " + content);
                            }
                            break;

                        default:
                            clientSocket.close();
                            serverSocket.close();
                    }

                }
                if (outputLine != null) {
                    out.println(outputLine);
                }
            }
        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port "
                    + portNumber + " or listening for a connection");
            System.out.println(e.getMessage());
        }
    }
}
