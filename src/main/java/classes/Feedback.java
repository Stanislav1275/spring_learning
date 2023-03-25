package classes;

import org.springframework.beans.factory.annotation.Autowired;

public class Feedback {
    private String msg;
    private int rate;
    public Feedback(String msg, int rate) {
        this.msg = msg;
        this.rate = rate;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "msg='" + msg + '\'' +
                ", rate=" + rate +
                '}';
    }
}
