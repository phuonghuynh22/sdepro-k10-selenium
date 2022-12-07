package test.computer;

import models.components.order.StandardComputerComponent;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.BaseTest;
import test_data.computer.ComputerData;
import test_data.DataObjectBuilder;
import test_flows.global.computer.OrderComputerFlow;
import url.Urls;

public class BuyingStandardComputerTest extends BaseTest implements Urls {

    @Test(dataProvider = "computerData")
    public void testStandardComputerBuying(ComputerData computerData){

        driver.get(DEMO_PAGE_URL.concat(STANDARD_COMPUTER_URL));
        OrderComputerFlow<StandardComputerComponent> orderComputerFlow =
                new OrderComputerFlow<>(driver, StandardComputerComponent.class, computerData);

        orderComputerFlow.buildCompSpecAndAddToCart();
    }

    // Data driven supporting by DataProvider of TestNG
    @DataProvider
    public ComputerData[] computerData(){
        String fileLocation = "/src/test/java/test_data/computer/StandardComputerDataList.json"; // add one slash initially
        return DataObjectBuilder.buildDataObjectFrom(fileLocation, ComputerData[].class);

    }
}
