package entity;

import java.io.Serializable;
import java.util.List;

public class BuyHistory implements Serializable {
    private User user;
    private List<Buy> buyList;

    public BuyHistory(User user, List<Buy> buyList) {
        this.user = user;
        this.buyList = buyList;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Buy> getBuyList() {
        return buyList;
    }

    public void setBuyList(List<Buy> buyList) {
        this.buyList = buyList;
    }

    @Override
    public String toString() {
        return "BuyHistory{" +
                "user=" + user +
                ", buyList=" + buyList +
                '}';
    }
}
