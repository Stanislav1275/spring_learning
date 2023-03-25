package classes;

public class Human {
    private Integer age;
    @Default

    private String name;
    @Default(value = "defaultConfig1.json")
    private String txt;
    @Default
    private Human father;

    public Human(int age, String name) {

        this.age = age;
        this.name = name;
        this.txt = "boba";
    }
    public Human(int age, Human name) {

        this.age = age;
        this.txt = "boba";
    }

    public Human getFather() {
        return father;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getTxt() {
        return txt;
    }

    public void setTxt(String txt) {
        this.txt = txt;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Human{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", txt='" + txt + '\'' +
                ", father=" + father +
                '}';
    }
}
