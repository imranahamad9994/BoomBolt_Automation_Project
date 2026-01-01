package utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {

    private static final String EXCEL_PATH =
            System.getProperty("user.dir") + "/testData/MOCK_DATA (1).xlsx";

    @DataProvider(name = "LoginData")
    public Object[][] getLoginData() throws IOException {
        return getExcelData("data");
    }

    @DataProvider(name = "RegistrationData")
    public Object[][] getRegistrationData() throws IOException {
        return getExcelData("data");
    }

    // Reusable Excel Reader
    private Object[][] getExcelData(String sheetName) throws IOException {

        ExcelUtility xl = new ExcelUtility(EXCEL_PATH);

        int rows = xl.getRowCount(sheetName);
        int cols = xl.getCellCount(sheetName, 1);

        Object[][] data = new Object[rows][cols];

        for (int i = 1; i <= rows; i++) {
            for (int j = 0; j < cols; j++) {
                data[i - 1][j] = xl.getCellData(sheetName, i, j);
            }
        }
        return data;
    }
}
