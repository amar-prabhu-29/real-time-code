package realtimecode;

import java.io.*;
import java.net.*;
import java.util.*;
/**
 *
 * @author Amar Prabhu
 */
public class Server {
    static ArrayList<PrintWriter> cls = new ArrayList<>();
    public static void main(String[] args)throws Exception{
        ServerSocket so = new ServerSocket(9090);
        try{
            while(true){
                Socket s = so.accept();
                BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
                PrintWriter out = new PrintWriter(s.getOutputStream(),true);
                Thread t = new Thread(new Handler(s,in,out));
                cls.add(out);
                t.start();
            } 
        }
        catch(Exception e){
               System.out.println("Exception");     
        }
    }
}
