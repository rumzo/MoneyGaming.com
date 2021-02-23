package pages;

import core.BasePage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.Browser;

public class Registration extends BasePage {
    private static final By TITLE_DROPDOWN = By.id("title");
    private static final By FIRST_NAME_FIELD = By.id("forename");
    private static final By SURNAME_FIELD = By.cssSelector("#signupForm input[name*='lastName']");
    private static final By TICK_BOX_TERMS_AND_CONDITIONS = By.cssSelector("fieldset.underlay input.terms");
    private static final By JOIN_NOW_BUTTON = By.cssSelector("fieldset.underlay input[value*='Join Now']");
    private static final By VALIDATION_MESSAGE_DATE_OF_BIRTH_BOX = By.cssSelector("#dobYear+.error");


    public static void goTo(){
        Browser.driver.get("https://moneygaming.qa.gameaccount.com/sign-up.shtml");
    }

    public static void signUp(String firstName, String lastName) {
        WebElement title = Browser.driver.findElement(TITLE_DROPDOWN);
        Select title_dropDown = new Select(title);
        title_dropDown.selectByValue("Mr");

        Browser.driver.findElement(FIRST_NAME_FIELD).sendKeys(firstName);
        Browser.driver.findElement(SURNAME_FIELD).sendKeys(lastName);
        Browser.driver.findElement(TICK_BOX_TERMS_AND_CONDITIONS).click();
        Browser.driver.findElement(JOIN_NOW_BUTTON).click();
    }

    public static void verifyValidationMessage(String expectedValidationMessage, String messageOnFailure){
        String actualValidationMessage = getText(VALIDATION_MESSAGE_DATE_OF_BIRTH_BOX);
        Assert.assertTrue(messageOnFailure, actualValidationMessage.contains(expectedValidationMessage));
    }


}
