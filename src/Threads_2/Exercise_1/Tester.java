/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Threads_2.Exercise_1;

/**
 *
 * @author Jonathan Henriksen
 */
public class Tester {
    public static void main(String[] args) {
        System.out.println("Avilable Processors: " + Runtime.getRuntime().availableProcessors());
        Thread t1 = new Thread("https://lh3.googleusercontent.com/-XUP0Hv3d_VvDSpDvQWCycZo_s4BrMmhsElkIOYzLPP5SaW-58npsry_8Fi5TI1AYy7-Yfzq=s50-h50-e365");
        Thread t2 = new Thread("https://addons.opera.com/media/extensions/55/19155/1.1-rev1/icons/icon_64x64.png");
        Thread t3 = new Thread("http://rlv.zcache.com/custom_square_button-rd265858763234e9794b6f8554228d00c_x7j1a_8byvr_50.jpg");
        
        long start = System.nanoTime();
        t1.run();
        t2.run();
        t3.run();
        int sum = t1.getSum() + t2.getSum() + t3.getSum();
        long end = System.nanoTime();
        System.out.println("\nTime Sequental: "+(end-start));
        System.out.println("The total sum of bytes is " + sum);
    }
    
}
