/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Threads_1.Exercise_1;

/**
 *
 * @author Jonathan Henriksen
 */
public class Excercise_1 {

    public static void main(String[] args) {
        Task1 task1 = new Task1();
        Task3 task3 = new Task3();
        Task2 task2 = new Task2();
        Thread t1 = new Thread(task1);
        Thread t2 = new Thread(task2);
        Thread t3 = new Thread(task3);
        t1.start();
        t2.start();
        t3.start();
        try {
            t2.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        task3.stopThread();
    }
}
