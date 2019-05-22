/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package realtimecode;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.event.*;

/**
 *
 * @author Amar Prabhu
 */
class View{
    static JTextField jt = new JTextField();
    static PrintWriter out;
    View(PrintWriter out){
        this.out = out;
        JFrame jf = new JFrame();
        jf.setSize(500,500);
        jf.add(jt);
        jt.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                JTextField textField = (JTextField) e.getSource();
                String text = textField.getText();
                out.println(text);
                jt.setText(text);
            }

            public void keyTyped(KeyEvent e) {
            }

            public void keyPressed(KeyEvent e) {
            }
        });
        jf.setVisible(true);
    }
    static void modify(String m){
        jt.setText(m);
    }
}
class Readerq extends Thread{
    private BufferedReader in;
    Readerq(BufferedReader in){
        this.in = in;
    }
    public void run(){
        try{
            while(true){
                String got = in.readLine();
                View.modify(got);
            }
        }
        catch(Exception e){
            System.out.println("Caughy");
        }
    }
}
public class Client {
    public static void main(String[] args)throws Exception{
        Socket s = new Socket("localhost",9090);
        BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
        PrintWriter out = new PrintWriter(s.getOutputStream(),true);
        Thread t = new Thread(new Reader(in));
        t.start();
        View v = new View(out);
    }
}
