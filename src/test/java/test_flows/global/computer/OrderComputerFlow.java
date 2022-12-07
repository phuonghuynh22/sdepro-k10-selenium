package test_flows.global.computer;

import models.components.order.ComputerEssentialComponent;
import models.pages.ComputerItemDetailsPage;
import org.openqa.selenium.WebDriver;
import test_data.computer.ComputerData;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class OrderComputerFlow<T extends ComputerEssentialComponent> {

    private final WebDriver driver;
    private final Class<T> computerEssentialComponent;
    private ComputerData computerData;

    public OrderComputerFlow(WebDriver driver, Class<T> computerEssentialComponent, ComputerData computerData) {
        this.driver = driver;
        this.computerEssentialComponent = computerEssentialComponent;
        this.computerData = computerData;
    }

    public void buildCompSpecAndAddToCart() {

        ComputerItemDetailsPage computerItemDetailsPage = new ComputerItemDetailsPage(driver);
        T computerEssentialComp = computerItemDetailsPage.computerComp(computerEssentialComponent);
//        computerEssentialComp.selectProcessorType("2.2GHz");
//        computerEssentialComp.selectRAMType("4GB");

        //computerEssentialComp.selectProcessorType(computerData.getProcessorType());
        //computerEssentialComp.selectRAMType(computerData.getRam());

        String processorFullStr = computerEssentialComp.selectProcessorType(computerData.getProcessorType());
        double processorAddedPrice = extractAdditionalPrice(processorFullStr);
        String ramFullStr = computerEssentialComp.selectRAMType(computerData.getRam());
        double ramAddedPrice = extractAdditionalPrice(ramFullStr);
        String hddFullStr = computerEssentialComp.selectHDD(computerData.getHdd());
        double hddAddedPrice = extractAdditionalPrice(hddFullStr);

        double osAddedPrice=0;
        if(computerData.getOs() != null){
            String osFullStr = computerEssentialComp.selectOS(computerData.getOs());
            osAddedPrice = extractAdditionalPrice(osFullStr);
        }

        double totalAddedPrice = processorAddedPrice  + ramAddedPrice+ hddAddedPrice + osAddedPrice;
        System.out.println("totalAddedPrice: " + totalAddedPrice);

        try {
            Thread.sleep(10000);
        } catch (Exception ignored) {
        }
    }

    private double extractAdditionalPrice(String itemStr) {

        double price = 0;
        Pattern pattern = Pattern.compile("\\[(.*?)\\]");
        Matcher matcher = pattern.matcher(itemStr);
        if (matcher.find()) {
            price = Double.parseDouble(matcher.group(1).replaceAll("[+-]", ""));
        }
        return price;
    }

}