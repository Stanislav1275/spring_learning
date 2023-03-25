package Stock;

public interface StockObserver {
    void update(EventStock event);
    String[] getStocks();
}
