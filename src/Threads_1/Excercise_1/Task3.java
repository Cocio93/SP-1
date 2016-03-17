/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Threads_1.Excercise_1;

/**
 *
 * @author Jonathan Henriksen
 */
public class Task3 implements Runnable {

    private int count = 10;
    private boolean keepRunning = true;

    public void stopThread() {
        keepRunning = false;
    }

    @Override
    public void run() {
        while (keepRunning) {
            System.out.println("Task 3: " + count++);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
