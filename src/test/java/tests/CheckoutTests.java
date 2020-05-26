package tests;

import Helper.PropertiesHelper;
import org.junit.Before;
import org.junit.Test;

public class CheckoutTests extends SampleTest {

    @Before
    public void loginToShoppingSite() {
        user.mainPage.openMainPage();
        user.mainPage.clickOnSignInButton();
        user.mainPage.fillEmailAddressField(PropertiesHelper.INSTANCE.getProperties("email"));
        user.mainPage.fillPasswordField(PropertiesHelper.INSTANCE.getProperties("password"));
        user.mainPage.clickOnSubmitLoginButton();
        user.mainPage.clickOnLogoLink();
    }

    @Test
    public void checkoutPayByCheckTest() {
        user.mainPage.clickOnPrintedSummerDressLink();
        user.mainPage.clickOnAddToCartButton();
        user.mainPage.clickOnContinueShoppingButton();
        user.mainPage.clickOnCartTab();
        user.mainPage.clickOnProceedToCheckoutButton();
        user.mainPage.clickOnAddressProceedToCheckoutButton();
        user.mainPage.checkTermsOfServiceCheckbox();
        user.mainPage.clickOnShippingProceedToCheckoutButton();
        user.mainPage.clickOnPayByCheckButton();
        user.mainPage.clickOnConfirmMyOrderButton();
        user.mainPage.checkConfirmationOrderText();
    }
}
