package testcases;

import org.testng.annotations.Test;
import pageobjects.AccountActivityPage;
import testbase.BaseClass;
import utilities.DataProviders;
//import utilities.MemoryUtils;

//import java.lang.management.MemoryUsage;
import java.util.concurrent.TimeUnit;

public class accountactivitypage extends BaseClass {

    //MemoryUsage beforeMemoryUsage = MemoryUtils.getMemoryUsage();


    @Test(dataProvider = "accountActivity", dataProviderClass = DataProviders.class, groups = {"master"}, priority = 3)
    public void testAccount(String actPeriod, String type) throws InterruptedException {

        AccountActivityPage accountActivityPage = new AccountActivityPage(driver);

        TimeUnit.SECONDS.sleep(3);
        accountActivityPage.setNewAccoundIdLink();
        TimeUnit.SECONDS.sleep(3);
        accountActivityPage.ActivityPeriod(actPeriod);
        TimeUnit.SECONDS.sleep(3);
        accountActivityPage.setType(type);
        TimeUnit.SECONDS.sleep(3);
        accountActivityPage.setGoButton();
        TimeUnit.SECONDS.sleep(3);
        accountActivityPage.setFundsLink();

        /*MemoryUsage afterMemoryUsage = MemoryUtils.getMemoryUsage();

        // Generate HTML report
        String htmlReport = MemoryUtils.generateHTMLReport("Memory Consumption Report", beforeMemoryUsage, afterMemoryUsage);

        // Write report to file and open it
        String fileName = "C:\\Users\\pragadge\\IdeaProjects\\ParaBank\\memory_report.html";
        MemoryUtils.writeToFile(fileName, htmlReport);
        MemoryUtils.openFileWithDefaultBrowser(fileName);
*/
    }

}
