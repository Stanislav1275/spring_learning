package classes.Stonks;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
//@Scope("prototype")
public class StonkCastle {
    StonkCastle(List<StonkListenner> listeners){
        listenStonkByListener(listeners);
    }
    private Map<String, Stonk> stocks = new HashMap<>();
    private Map<String, List<StonkListenner>> links = new HashMap<>();
    public void listenStonkByListener(List<StonkListenner> listeners) {
        for (StonkListenner stonkListenner : listeners) {
            List list = new ArrayList();
            for (String stockString : stonkListenner.getStocks()) {
                if (links.containsKey(stockString)) {
                    list = links.get(stockString);
                } else {
                    list.add(stonkListenner);
                }
                links.put(stockString, list);
            }
        }
    }

    public void registerStonk(Stonk stonk) {
        stocks.put(stonk.name, stonk);
    }

    public void updatePrice(Stonk stonk, int newPrice) {
        System.out.println(links.size());
        stonk.setPrice(newPrice);
        notifyStonkers(stonk);
    }
    private void notifyStonkers(Stonk stonk){
        if(links.get(stonk.name) != null)
        for(StonkListenner stonker : links.get(stonk.name)){
            stonker.onStockChange(stonk);
        }else throw  new NullPointerException("links почему-то null");
    }


}