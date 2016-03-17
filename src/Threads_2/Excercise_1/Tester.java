/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Threads_2.Excercise_1;

/**
 *
 * @author Jonathan Henriksen
 */
public class Tester {
    public static void main(String[] args) {
        Thread thread1 = new Thread("https://fronter.com/cphbusiness/design_images/images.php/Classic/login/fronter_big-logo.png");
        Thread thread2 = new Thread("https://fronter.com/cphbusiness/design_images/images.php/Classic/login/folder-image-transp.png");
        Thread thread3 = new Thread("https://fronter.com/volY12-cache/cache/img/design_images/Classic/other_images/button_bg.png");
        java.lang.Thread t1 = new java.lang.Thread(thread1);
        java.lang.Thread t2 = new java.lang.Thread(thread2);
        java.lang.Thread t3 = new java.lang.Thread(thread3);
        t1.start();
        t2.start();
        t3.start();
        while (t1.isAlive() || t2.isAlive() || t3.isAlive())
		// Do nothing
		;
        int sum = thread1.getSum() + thread2.getSum() + thread3.getSum();
        System.out.println("The total sum of bytes is " + sum);
    }
}
