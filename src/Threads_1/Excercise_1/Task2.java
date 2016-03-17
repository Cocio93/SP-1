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
public class Task2 implements Runnable {

    private int count = 0;
    private boolean keepRunning = true;

    public void stopThread() {
        keepRunning = false;
    }

    @Override
    public void run() {
        while (keepRunning && (count <= 5)) {
            System.out.println("Task 2: " + count++);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
