package cc.xpbootcamp.warmup.cashier;

import cc.xpbootcamp.warmup.cashier.order.SuperMarketOrder;
import cc.xpbootcamp.warmup.cashier.template.SuperMarketTemplate;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;

class OrderReceiptTest {
    @Test
    void shouldPrintHeaderOnOrder() {

        SuperMarketTemplate chineseTemplate = new SuperMarketTemplate();
        ArrayList<LineItem> lineItems = new ArrayList<>();
        String template = chineseTemplate.getTemplate(lineItems, "", "", "");

        assertThat(template, containsString("===== 老王超市，值得信赖 ======"));
        assertThat(template, containsString("-----------------------------------"));
        assertThat(template, containsString("税额"));
        assertThat(template, containsString("折扣"));
        assertThat(template, containsString("总价"));
    }

    @Test
    public void shouldPrintLineItemAndSalesTaxInformation() {
        List<LineItem> lineItems = new ArrayList<LineItem>() {{
            add(new LineItem("milk", 10.0, 2));
            add(new LineItem("biscuits", 5.0, 5));
            add(new LineItem("chocolate", 20.0, 1));
        }};
        OrderReceipt receipt = new OrderReceipt(new SuperMarketOrder(lineItems), new SuperMarketTemplate());

        String output = receipt.printReceipt();

        assertThat(output, containsString("milk,10.00 x 2,20.00\n"));
        assertThat(output, containsString("biscuits,5.00 x 5,25.00\n"));
        assertThat(output, containsString("chocolate,20.00 x 1,20.00\n"));
        assertThat(output, containsString("税额: 6.50"));
        assertThat(output, containsString("总价: 71.50"));
    }

}
