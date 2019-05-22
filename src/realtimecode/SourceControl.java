
package realtimecode;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import static realtimecode.ClientNew.jTextArea1;

public class SourceControl {
    SourceControl(String comment,String repo) throws FileNotFoundException{
        String source = jTextArea1.getText();
        int hash = source.hashCode();
        String name = hash + "-c" + comment + ".py";
        String path = "Repository"+ File.separator + repo + File.separator + name;
        new File(path);
        PrintWriter out = new PrintWriter(path);
        if(source.contains("\n")){
            String[] sourceCode = source.split("\n");
            for(String s:sourceCode){
                out.println(s);
            }
        }
        else{
            out.println(source);
        }
        
        
        out.close();
    }
}
