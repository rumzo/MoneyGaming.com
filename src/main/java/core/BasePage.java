package core;

import org.openqa.selenium.By;
import utils.Browser;

public class BasePage {
    protected static String getText(By locator){
        return Browser.driver.findElement(locator).getText();
    }
}
