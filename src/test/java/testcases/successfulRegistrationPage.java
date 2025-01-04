package testcases;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pageobjects.RegistrationPage;
import testbase.BaseClass;
import utilities.DataProviders;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class successfulRegistrationPage extends BaseClass {


    @Test(dataProvider = "successfulRegistration", dataProviderClass = DataProviders.class, groups = {"master"}, priority = 1)
    public void testRegistration(String firstName, String lastName, String address, String city, String state, String zipCode, String phone, String ssn, String userName, String password, String confPassword) throws InterruptedException {

        RegistrationPage registrationPage = new RegistrationPage(driver);

        // Perform the registration
        TimeUnit.SECONDS.sleep(2);
        registrationPage.setRegisterButton();
        TimeUnit.SECONDS.sleep(2);
        registrationPage.enterFirstName(firstName);
        TimeUnit.SECONDS.sleep(2);
        registrationPage.enterLastName(lastName);
        TimeUnit.SECONDS.sleep(2);
        registrationPage.enterAddress(address);
        TimeUnit.SECONDS.sleep(2);
        registrationPage.enterCity(city);
        TimeUnit.SECONDS.sleep(2);
        registrationPage.enterState(state);
        TimeUnit.SECONDS.sleep(2);
        registrationPage.enterZipCode(zipCode);
        TimeUnit.SECONDS.sleep(2);
        registrationPage.enterPhone(phone);
        TimeUnit.SECONDS.sleep(2);
        registrationPage.enterSSN(ssn);
        TimeUnit.SECONDS.sleep(2);
        registrationPage.enterUsername(userName);
        TimeUnit.SECONDS.sleep(2);
        registrationPage.enterPassword(password);
        TimeUnit.SECONDS.sleep(2);
        registrationPage.enterConfirmPassword(confPassword);
        TimeUnit.SECONDS.sleep(2);
        registrationPage.clickRegisterButton();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(driver -> registrationPage.isConfirmationDisplayed());

        // Verify the confirmation page
        if (registrationPage.isConfirmationDisplayed() && registrationPage.getPageTitle().contains("ParaBank | Customer Created")) {
            System.out.println("Test Case Passed: Confirmation page is displayed correctly.");
        } else {

            System.out.println("Test Case Failed: Confirmation page is not displayed correctly.");
        }


    }


}

