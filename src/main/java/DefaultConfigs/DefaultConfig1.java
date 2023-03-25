package DefaultConfigs;

import classes.Human;
import classes.Invoke;
import classes.defQualifer;

public class DefaultConfig1 {
    @Invoke
    public Human getOldHuman(Human h){
        Human h1 = new Human(h.getAge(), h.getName());
        h1.setAge(70);
        return h1;
    }
    @Invoke
    @defQualifer(methodName = {"defAge"})
    public Human getDefaultHuman(Integer defAge, String defName){
        return new Human(defAge, defName);
    }
    @Invoke
    public String defName(){
        return "Георгий";
    }
    @Invoke
    public Integer defAge(){
        return 18;
    }
    @Invoke
    public Integer defGrowth(){
        return 180;
    }

}
