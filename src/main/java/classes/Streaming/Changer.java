package classes.Streaming;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.File;
import java.util.Arrays;
import java.util.List;

@Component
@Scope("prototype")
public class Changer {
    File readFile;
    File writeFile;
    List<Writerable> actions;
    @Autowired
    Changer(String readFileName, String writeFileName, List<Writerable> actions){
        this.readFile = new File(readFileName);
        this.writeFile = new File(writeFileName);
        this.actions = actions;

    }
    public void doActs(){
        String [] chs = new Reader().read(readFile);
        for(Writerable wr : actions){
            chs = wr.write(chs);
        }
//        Wri ter.write(writeFile, chs);
    }
}
