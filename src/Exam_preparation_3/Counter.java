package Exam_preparation_3;
/**
 *
 * @author Jonathan Henriksen
 */
public class Counter {
    private int turns = 0;

    public String inputString(String str) {
        String reSpons;
        if (str.equalsIgnoreCase("TURN")) { 
            turns++;
            reSpons = "Turnstile has been turned! Current count = " + turns;
        } else if(str.equalsIgnoreCase("COUNT")) {
            reSpons = "The turnstile has been turned " + turns + " times.";
        } else {
            reSpons = "To see total number of rotations, type 'COUNT', to turn turnstile, type 'TURN'";
        }
        return reSpons;
    }
}  
