package realtimecode;
import java.io.*;
import java.net.*;
import java.util.stream.Collectors;
/**
 *
 * @author Amar Prabhu
 */
public class Handler extends Thread{
    private Socket s;
    private BufferedReader in;
    private PrintWriter out;
    Handler(Socket s,BufferedReader in,PrintWriter out){
        this.s = s;
        this.in = in;
        this.out = out;
    }
    public void run(){
        try{
            
            while(true){
                
                String line = in.readLine();
                System.out.println(line);
                for(PrintWriter clo: Index.cls){
                    if(out != clo){
                        clo.println(line);
                    }
                }
            }   
        }
        catch(Exception e){
            System.out.println("Handeler Ecerid");
        }
        
    }
    
}
