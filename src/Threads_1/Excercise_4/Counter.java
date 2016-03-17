/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Threads_1.Excercise_4;

/**
 *
 * @author Jonathan Henriksen
 */
public class Counter {
    static final long DELAY_VAL = 10000;
    long count = 0;

    public long getValue() {
        return count;
    }

    public void incr() {
        count++;
    }
}

