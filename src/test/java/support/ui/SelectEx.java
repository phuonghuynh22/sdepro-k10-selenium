package support.ui;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectEx extends Select {

    private static final String OPTION_1 = "Option 1";

    public SelectEx(WebElement dropDownElem) {
        super(dropDownElem);
    }

    public void SelectOption1 (){
        selectByVisibleText(OPTION_1);
    }
}
