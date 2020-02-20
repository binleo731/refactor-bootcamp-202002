package cc.xpbootcamp.warmup.cashier.order;

import cc.xpbootcamp.warmup.cashier.LineItem;

import java.util.List;

public interface Order {
    boolean isDiscount();

    double getDiscount();

    List<LineItem> getLineItems();
}
