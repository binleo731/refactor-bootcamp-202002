package cc.xpbootcamp.warmup.cashier;

import com.sun.tools.javac.util.List;

public interface Template {
    String print(List<LineItem> lineItems, String tax, String discount, String totalPrice);
}
