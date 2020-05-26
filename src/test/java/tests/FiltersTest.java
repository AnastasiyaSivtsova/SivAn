package tests;

import Helper.PropertiesHelper;
import org.junit.Test;

public class FiltersTest extends SampleTest{

    @Test
    public void filtersTest() {
        user.mainPage.openMainPage();
        user.mainPage.clickOnSignInButton();
        user.mainPage.fillEmailAddressField(PropertiesHelper.INSTANCE.getProperties("email"));
        user.mainPage.fillPasswordField(PropertiesHelper.INSTANCE.getProperties("password"));
        user.mainPage.clickOnSubmitLoginButton();
        user.mainPage.clickOnWomenTab();
        user.mainPage.checkOrangeColorsOnItems();
    }
}
