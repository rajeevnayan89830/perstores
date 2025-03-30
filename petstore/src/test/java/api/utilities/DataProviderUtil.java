package api.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviderUtil {

    @DataProvider(name = "UserData")
    public String[][] getAllData() throws IOException {
        String path = System.getProperty("user.dir") + "//userdata//pertstore1.xlsx"; // Corrected file path

        UtilitiesXcel xlUtil = new UtilitiesXcel(path);
        int totalRows = xlUtil.getRowCount("sheet1"); // Fixed method names
        int totalCells = xlUtil.getCellCount("sheet1", 1); // Fixed method names

        // Initialize data array
        String[][] UserData = new String[totalRows][totalCells];

        for (int i = 1; i < totalRows; i++) {  // Looping correctly through rows
            for (int j = 0; j < totalCells; j++) { // Looping correctly through columns
                UserData[i-1][j] = xlUtil.getCellData("sheet1", i, j); // Fixed method name
            }
        }
        return UserData;
    }

    @DataProvider(name = "UserName")
    public String[][] getUserName() throws IOException {
        String path = System.getProperty("user.dir") + "//userdata//petstore1.xlsx"; // Corrected file path

        UtilitiesXcel xlUtil = new UtilitiesXcel(path);
        int totalRows = xlUtil.getRowCount("sheet1"); // Fixed method name

        // Initialize data array
        String[][] apiData = new String[totalRows][1]; // Now a 2D array

        for (int i = 1; i < totalRows; i++) {  // Looping correctly through rows
            apiData[i-1][0] = xlUtil.getCellData("sheet1", i, 1); // Fixed incorrect index
        }

        return apiData;
    }
}
