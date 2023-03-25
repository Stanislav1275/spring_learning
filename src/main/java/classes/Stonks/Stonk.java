package classes.Stonks;

import java.util.ArrayList;
import java.util.List;

public class Stonk {
    public final String name;
    private int price;
    public Stonk(String name, int price) {
        this.name = name;
        this.price = price;
    }
    public int getPrice() {
        return price;
    }
    protected void setPrice(int price) {
        this.price = price;
    }

}
