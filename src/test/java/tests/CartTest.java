package tests;

import org.junit.Test;

public class CartTest extends SampleTest{

    @Test
    public void itemAdditionTest() {
        user.mainPage.openMainPage();
        user.mainPage.clickOnPrintedSummerDressLink();
        user.mainPage.clickOnAddToCartButton();
        user.mainPage.clickOnContinueShoppingButton();
        user.mainPage.clickOnCartTab();
    }
}
