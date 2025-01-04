package testcases;

import org.testng.annotations.Test;
import pageobjects.NewAccountPage;
import testbase.BaseClass;
import utilities.DataProviders;

import java.util.concurrent.TimeUnit;

public class opennewaccountpage extends BaseClass {


    @Test(dataProvider = "openNewAcc", dataProviderClass = DataProviders.class, groups = {"master"}, priority = 2)
    public void testOpenNewAccount(String accType) throws InterruptedException {

        NewAccountPage newAccountPage = new NewAccountPage(driver);

        TimeUnit.SECONDS.sleep(3);
        newAccountPage.setGetOpenAccountButton();

        TimeUnit.SECONDS.sleep(3);
        newAccountPage.selectAccountType(accType);


        TimeUnit.SECONDS.sleep(3);
        newAccountPage.clickOpenAccountButton();

        TimeUnit.SECONDS.sleep(3);
        if (newAccountPage.isSuccessMessageDisplayed()) {
            System.out.println("New account opened successfully!");
        } else {
            System.out.println("Failed to open a new account or encountered an error.");
        }


    }


}
