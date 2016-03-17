/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Threads_1.Excercise_2;

/**
 *
 * @author Jonathan Henriksen
 */
public class Excercise_2 {
    
    public static void main(String[] args) {
        Even even = new Even();
        Runnable p1 = new numberStream(even);
        Runnable p2 = new numberStream(even);
        
        Thread t1 = new Thread(p1);
        Thread t2 = new Thread(p2);
        
        t1.start();
        t2.start();
    } 
}
