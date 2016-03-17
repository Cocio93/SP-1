/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Threads_2.Exercise_1;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 *
 * @author Jonathan Henriksen
 */
public class Thread implements Runnable {
        int sum;
        String url;

        public int getSum() {
            return sum;
        }

        public Thread(String url) {
            this.url = url;
        }

        protected byte[] getBytesFromURL(String url) {
            ByteArrayOutputStream bis = new ByteArrayOutputStream();
            try {
                InputStream is = new URL(url).openStream();
                byte[] bytebuff = new byte[4096];
                int read;
                while ((read = is.read(bytebuff)) > 0) {
                    bis.write(bytebuff, 0, read);
                }
            } catch (IOException ex) {
                System.out.println(ex);
            }
            return bis.toByteArray();
        }

        @Override
        public void run() {
            byte[] bytes = getBytesFromURL(url);
            for (int i = 0; i < bytes.length; i++) {
                sum += bytes[i];
            }
        }
    }
