package models.components.global.footer;

import models.components.Component;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FooterColumnComponent extends Component {

    private static final By headerSel = By.tagName("h3");
    private static final By linkSel = By.tagName("li");

    public FooterColumnComponent(WebDriver driver, WebElement component) {
        super(driver, component);
    }

    public WebElement headerElem (){
        return component.findElement(headerSel);
    }

    public WebElement linksElem (){
        return component.findElement(linkSel);
    }
}
