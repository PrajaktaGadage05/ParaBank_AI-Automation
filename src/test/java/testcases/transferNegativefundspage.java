package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageobjects.TrasferFundsPage;
import testbase.BaseClass;
import utilities.BugUtils;
import utilities.DataProviders;

import java.util.concurrent.TimeUnit;

public class transferNegativefundspage extends BaseClass {


    @Test(dataProvider = "transferNegFunds", dataProviderClass = DataProviders.class, groups = {"master"}, priority = 2)
    public void testTransferFunds(String amountString) throws InterruptedException {

        int amount = Integer.parseInt(amountString);

        TrasferFundsPage trasferFundsPage = new TrasferFundsPage(driver);

        TimeUnit.SECONDS.sleep(2);
        trasferFundsPage.setTRFundsLink();
        TimeUnit.SECONDS.sleep(2);
        trasferFundsPage.setAmount(amount);
        //TimeUnit.SECONDS.sleep(2);
        //trasferFundsPage.selectFromAccountByIndex(1); // Select the second option in the dropdown
        TimeUnit.SECONDS.sleep(2);
        trasferFundsPage.TransferMoney();

        TimeUnit.SECONDS.sleep(2);
        try {
            Assert.assertFalse(trasferFundsPage.isTransferSuccessful(), "Test Case Failed: Money transferred successfully with incorrect amount");
            System.out.println("Test Case Passed: Transfer was not completed due to negative amount.");
        } catch (AssertionError e) {
            reportBug();
            throw e;
        }
    }

    private void reportBug() {
        System.out.println("Test Case Failed: Money transferred successfully with incorrect amount");
        // Generate bug details using OpenAI API
        String bugReport = BugUtils.generateBugDetails("Raise a bug ticket with summary, test steps, actual and expected result for the website https://parabank.parasoft.com/parabank/register.htm open the browser and navigate to the url -> move to the transfer funds page and enter negative -100 amount and click on transfer button,it is transferring the negative amount to the other account. Also provide priority and severity ");
        System.out.println("Generated Bug Report: " + bugReport);
    }


}

