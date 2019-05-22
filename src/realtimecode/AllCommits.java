
package realtimecode;

import java.io.File;

public class AllCommits {
    AllCommits(String repo){
        File f = new File("/");
        File[] list = f.listFiles();
        //System.out.println(list);
        for(int i=0;i<list.length;i++){
            System.out.println(list[i].getName());
        }
        
    }
    
}
