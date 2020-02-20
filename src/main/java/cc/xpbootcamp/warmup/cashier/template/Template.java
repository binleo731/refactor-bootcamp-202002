package cc.xpbootcamp.warmup.cashier.template;

import cc.xpbootcamp.warmup.cashier.LineItem;

import java.util.List;

public interface Template {
    String getTemplate(List<LineItem> lineItems, double tax, double discount, double totalPrice);
}
