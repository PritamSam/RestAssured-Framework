package dataProvider;

import org.testng.annotations.DataProvider;

import utils.CSVUtils;

public class TestDataProvider {
    @DataProvider(name = "apiData")
    public Object[][] getData() {
        return CSVUtils.getTestData("testdata/testData.csv");
    }
}
