package testcases;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import base.BaseClass;
import dataprovider.CustomDataProvider;
import helper.Utility;


import pages.LoginPage;


public class LoginTest extends BaseClass {
	@Test(dataProvider = "loginDetails", dataProviderClass = CustomDataProvider.class)

	public void LoginToApplication(String uname, String pass) {
		LoginPage login = new LoginPage(driver);
		login.loginToApplication(uname, pass);

		
		
		
	

	}

};