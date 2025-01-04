package utilities;

import org.testng.annotations.DataProvider;

import java.io.IOException;

public class DataProviders {

    //DataProvider 1
    @DataProvider(name = "successfulRegistration")
    public Object[][] getSuccessfulRegData() throws IOException {
        String path = ".\\testData\\SuccReg.xlsx";
        return getData(path);
    }

    @DataProvider(name = "openNewAcc")
    public Object[][] getOpenNewAccData() throws IOException {
        String path = ".\\testData\\OpenNewAccount.xlsx";
        return getData(path);
    }


    @DataProvider(name = "accountActivity")
    public Object[][] getAccActivityData() throws IOException {
        String path = ".\\testData\\AccActivity.xlsx";
        return getData(path);
    }

    @DataProvider(name = "transferFunds")
    public Object[][] getTransferFundsData() throws IOException {
        String path = ".\\testData\\TransferFunds.xlsx";
        return getData(path);
    }

    @DataProvider(name = "transferNegFunds")
    public Object[][] getTransferNegFundsData() throws IOException {
        String path = ".\\testData\\TransferNegFunds.xlsx";
        return getData(path);
    }


    public String[][] getData(String filepath) throws IOException {

        ExcelUtility xlutil = new ExcelUtility(filepath);//creating an object for XLUtility

        int totalrows = xlutil.getRowCount("Sheet1");
        int totalcols = xlutil.getCellCount("Sheet1", 0);

        int nonEmptyRows = 0;
        for (int i = 1; i <= totalrows; i++) {
            if (xlutil.getCellData("Sheet1", i, 0) != null && !xlutil.getCellData("Sheet1", i, 0).isEmpty()) {
                nonEmptyRows++;
            }
        }

        String data[][] = new String[nonEmptyRows][totalcols]; // Two-dimensional array to store the data

        int currentRow = 0;
        for (int i = 1; i <= totalrows; i++) {
            if (xlutil.getCellData("Sheet1", i, 0) != null && !xlutil.getCellData("Sheet1", i, 0).isEmpty()) {
                for (int j = 0; j < totalcols; j++) {
                    data[currentRow][j] = xlutil.getCellData("Sheet1", i, j);
                }
                currentRow++;
            }
        }

        return data;
    }


}

	
	

