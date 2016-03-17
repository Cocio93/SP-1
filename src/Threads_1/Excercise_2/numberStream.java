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
public class numberStream implements Runnable {

    Even even;

    public numberStream(Even even) {
        this.even = even;
    }

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println(even.next());
        }
    }
}
