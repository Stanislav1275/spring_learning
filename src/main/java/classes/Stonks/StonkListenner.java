package classes.Stonks;

public interface StonkListenner {
    void onStockChange(Stonk stonk);
    String[] getStocks();
}
