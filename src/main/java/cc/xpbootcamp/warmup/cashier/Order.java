package cc.xpbootcamp.warmup.cashier;

import java.util.List;

public class Order {
    private List<LineItem> lineItemList;

    public Order(List<LineItem> lineItemList) {
        this.lineItemList = lineItemList;
    }

    List<LineItem> getLineItems() {
        return lineItemList;
    }
}
