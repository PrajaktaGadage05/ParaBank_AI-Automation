package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class NewAccountPage extends BasePage {


    @FindBy(xpath = "//a[normalize-space()='Open New Account']")
    WebElement getOpenAccountButton;

    @FindBy(id = "type")
    WebElement accountTypeDropdown;


    @FindBy(xpath = "//input[@value='Open New Account']")
    WebElement openAccountButton;

    @FindBy(xpath = "//h1[contains(text(), 'Account Opened')]")
    WebElement successMessage;


    public NewAccountPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public void setGetOpenAccountButton() {
        getOpenAccountButton.click();
    }

    public void selectAccountType(String accountType) {
        accountTypeDropdown.sendKeys(accountType);

    }


    public void clickOpenAccountButton() {
        openAccountButton.click();
    }

    public boolean isSuccessMessageDisplayed() {
        return successMessage.isDisplayed();
    }

}


