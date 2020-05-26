package tests;

import org.junit.Test;

public class AddToCartItemTest extends SampleTest {

    @Test
    public void addToCartItemTest() {
        user.mainPage.openMainPage();
        user.mainPage.clickOnWomenTab();
        user.mainPage.clickOnAddToCartButtonOnItems(3);
    }
}
