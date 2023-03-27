package classes.Stonks;

import org.springframework.stereotype.Component;

public class Stonker implements  StonkListenner{
    public final String name;
    private String [] stonks;
    public Stonker(String name, String ...stonks) {
        this.name = name;
        this.stonks = stonks;
    }
    @Override
    public void onStockChange(Stonk stonk) {
        System.out.println(name + " следит за акцией " + stonk.name + " цена котороый сейчас уже " + stonk.getPrice() + ";");
    }

    @Override
    public String[] getStocks() {
        return stonks;
    }

}
