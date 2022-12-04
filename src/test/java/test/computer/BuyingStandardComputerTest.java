package test.computer;

import models.components.order.StandardComputerComponent;
import org.testng.annotations.Test;
import test.BaseTest;
import test_flows.global.computer.OrderComputerFlow;
import url.Urls;

public class BuyingStandardComputerTest extends BaseTest implements Urls {

    @Test
    public void testStandardComputerBuying(){

        driver.get(DEMO_PAGE_URL.concat(STANDARD_COMPUTER_URL));

        OrderComputerFlow<StandardComputerComponent> orderComputerFlow =
                new OrderComputerFlow<>(driver, StandardComputerComponent.class);

        orderComputerFlow.buildCompSpecAndAddToCart();
    }
}
