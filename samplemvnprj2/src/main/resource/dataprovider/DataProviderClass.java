package dataprovider;

import org.testng.annotations.DataProvider;

import utilities.ExcelUtilitiesClass;

public class DataProviderClass {

	@DataProvider(name = "login")
	public Object[][] logindata() {
		return new Object[][] { { "Dashboard" }, { "Dashboard" }, { "Dashboard123" } };
	}

	@DataProvider(name = "exceldatadp")
	public Object[][] exceldata() throws Exception {

		{
			return ExcelUtilitiesClass.readData();
		}
	}
}
