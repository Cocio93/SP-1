package Exam_preparation_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Jonathan Henriksen
 */
public class Turnstile implements Runnable {

    private static int totalTurns;
    private int turns = 0;
    BufferedReader input;
    PrintWriter output;

    public Turnstile(Socket clientSocket, int total) throws IOException {
        input = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        output = new PrintWriter(clientSocket.getOutputStream(), true);
        totalTurns = total;
    }

    public int getCount() {
        return turns;
    }

    private String inputString(String str) throws IOException {
        String reSpons;
        if (str.equalsIgnoreCase("TURN")) {
            turns++;
            totalTurns++;
            reSpons = "This Turnstile has been turned";
        } else if (str.equalsIgnoreCase("COUNT")) {
            reSpons = "This turnstile have been turned " + turns + " times.";
        } else if (str.equalsIgnoreCase("TOTALCOUNT")) {
            reSpons = "This turnstiles have been turned " + totalTurns + " times in total";
        }else {
            reSpons = "";
        }
        return reSpons;
    }

    @Override
    public void run() {
        output.println("Turnstile is now running on server");
        output.println("To see total number of rotations, type 'COUNT', to turn turnstile, type 'TURN'");
        String in;
        String out;
        try {
            while ((in = input.readLine()) != null) {
                out = inputString(in);
                output.println(out);
            }
        } catch (IOException ex) {
            Logger.getLogger(Turnstile.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
