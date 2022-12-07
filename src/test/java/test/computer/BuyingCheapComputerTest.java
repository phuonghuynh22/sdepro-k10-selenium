package test.computer;

import models.components.order.CheapComputerComponent;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.BaseTest;
import test_data.computer.ComputerData;
import test_data.DataObjectBuilder;
import test_flows.global.computer.OrderComputerFlow;
import url.Urls;

public class BuyingCheapComputerTest extends BaseTest implements Urls {


    @Test(dataProvider =  "computerData")
    public void testCheapComputerBuying(ComputerData computerData){

//        String fileLocation = "/src/test/java/test_data/computer/CheapComputerDataList.json"; // add one slash initially
//        ComputerData[] computerDataList = DataObjectBuilder.buildDataObjectFrom(fileLocation, ComputerData[].class);

        driver.get(DEMO_PAGE_URL.concat(CHEAP_COMPUTER_URL));

        //  Data driven
        //for (ComputerData computerData : computerDataList) {
            //System.out.println(computerData);
            OrderComputerFlow<CheapComputerComponent> orderComputerFlow =
                    new OrderComputerFlow<>(driver, CheapComputerComponent.class, computerData);
            orderComputerFlow.buildCompSpecAndAddToCart();

        //}
    }


    // Data driven supporting by DataProvider of TestNG
    @DataProvider
    public ComputerData[] computerData(){
        String fileLocation = "/src/test/java/test_data/computer/CheapComputerDataList.json"; // add one slash initially
        return DataObjectBuilder.buildDataObjectFrom(fileLocation, ComputerData[].class);

    }
}
