package pages;
 
import net.thucydides.core.annotations.DefaultUrl;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// Стандартный адрес:
@DefaultUrl("http://automationpractice.com/index.php")

// Наследуем бейз пейдж:
public class MainPage extends BasePage {

    //// Локаторы:

    // Аннтоация:
    // указываем локатор
    // в данном случае сss
    @FindBy(css = "a.login")
    // Указываем веб элемент и его название:
    private WebElement signInButton;

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "passwd")
    private WebElement passwordField;

    @FindBy(xpath = "//*[@id='create-account_form']/div/p")
    private WebElement createAccountText;

    @FindBy(xpath = "//p[@class='info-account']")
    private WebElement welcomeText;

    @FindBy(xpath = "//div[@class='alert alert-danger']/p")
    private WebElement errorText;

    @FindBy(xpath = "//div[@class='alert alert-danger']/ol/li")
    private WebElement authenticationErrorText;

    @FindBy(xpath = "//div[@class='alert alert-danger']/p")
    private WebElement errorEmailText;

    @FindBy(xpath = "//div[@class='alert alert-danger']/ol/li")
    private WebElement errorLoginText;

    @FindBy(id = "SubmitLogin")
    private WebElement signInButtonOnLoginPage;

    @FindBy(css = "a[title='Women']")
    private WebElement womenTab;

    @FindBy(css = "a[style='background:#F39C11;']")
    private WebElement orangeBox;

    @FindBy(css = "ul[class='color_to_pick_list clearfix']")
    private List<WebElement> colorBoxes;

    @FindBy(xpath = "(//a[@title='Printed Summer Dress'])[2]")
    private WebElement printedSummerDressLink;

    @FindBy(name = "Submit")
    private WebElement addToCartButton;

    @FindBy(xpath = "//span[@class='continue btn btn-default button exclusive-medium']")
    private WebElement continueShoppingButton;

    @FindBy(xpath = "//a[@href='http://automationpractice.com/index.php?controller=order']")
    private WebElement cartTab;

    @FindBy(xpath = "//img[@src='http://automationpractice.com/img/logo.jpg']")
    private WebElement logoLink;

    @FindBy(xpath = "(//a[@title='Proceed to checkout'])[2]")
    private WebElement proceedToCheckoutButton;

    @FindBy(name = "processAddress")
    private WebElement addressProceedToCheckoutButton;

    @FindBy(xpath = "//label[text()='I agree to the terms of service and will adhere to them unconditionally.']")
    private WebElement termsOfServiceCheckbox;

    @FindBy(name = "processCarrier")
    private WebElement shippingProceedToCheckoutButton;

    @FindBy(xpath = "//a[@class='cheque']")
    private WebElement payByCheckButton;

    @FindBy(xpath = "(//button[@type='submit'])[2]")
    private WebElement confirmMyOrderButton;

    @FindBy(xpath = "//p[@class='alert alert-success']")
    private WebElement confirmationMassage;

    @FindBy(xpath = "//*[@id='center_column']/ul/li")
    private List<WebElement> moveToItem;

    @FindBy(css = "a[title='Add to cart'][data-id-product]")
    private List<WebElement> addToCartButtons;

    @FindBy(xpath = "//*[@id='layer_cart']/div[1]/div[2]/div[4]/span/span")
    private WebElement contShoppingButton;

    // Создается автоматом после наследования бейз пейджа:
    public MainPage(WebDriver driver) {
        super(driver);
    }

    //// Методы:

    //Открытия страницы:
    public void openMainPage() {
        open();
    }

    // Нажатия кнопки указанного элемента:
    public void clickOnSignInButton() {
        element(signInButton).click();
    }

    // Вводим адрес:
    public void fillEmailAddressField(String email) {
        element(emailField).sendKeys(email);
    }

    // Вводим пароль:
    public void fillPasswordField(String password) {
        element(passwordField).sendKeys(password);
    }

    //Проверяем элемент с текстом при помощи регулярного выражения:
    // Проверяем что строка начинается с Please (space) enter (space)^
    public void checkText() {
        // Обьявляем текст, берем значение из элемента:
        String text = element(createAccountText).getText();
        //Создаем паттерн и компилируем:
        Pattern pattern = Pattern.compile("(^Please\\senter\\s)");
        Matcher matcher = pattern.matcher(text);
        // Условие, проверяет по тексту регулярное выражение и выдает тру(нашел) фолс(не нашел)
        if (matcher.find()) {
            //Если тру:
            System.out.println("FOUND");
        } else {
            //Если фолс:
            System.out.println("NOT FOUND");
        }
    }

    public void checkWelcomeText() {
        String textWelcome = element(welcomeText).getText();
        String expectedWelcomeText = "Welcome to your account. Here you can manage all of your personal information and orders.";
        if (expectedWelcomeText.equals(textWelcome)) {
            System.out.println("Welcome text is correct");
        } else {
            System.out.println("Welcome text is not correct");
        }
    }

    public void checkAuthenticationErrorText() {
        String textError = element(errorText).getText();
        String expectedErrorText = "There is 1 error";
        String textAuthenticationError = element(authenticationErrorText).getText();
        String expectedAuthenticationErrorText = "Authentication failed.";
        if (expectedErrorText.equals(textError) && expectedAuthenticationErrorText.equals(textAuthenticationError)) {
            System.out.println("Error text is correct");
        } else {
            System.out.println("Error text is not correct");
        }
    }

    public void checkInvalidEmailErrorText() {
        String textErrorEmail = element(errorEmailText).getText();
        String expectedErrorText = "There is 1 error";
        String textErrorLogin = element(errorLoginText).getText();
        String expectedAuthenticationErrorText = "Invalid email address.";
        if (expectedErrorText.equals(textErrorEmail) && expectedAuthenticationErrorText.equals(textErrorLogin)) {
            System.out.println("Email error text is correct");
        } else {
            System.out.println("Email error text is not correct");
        }
    }

    public void clickOnSubmitLoginButton() {
        element(signInButtonOnLoginPage).click();
    }

    public void clickOnWomenTab() {
        element(womenTab).click();
    }

    private List<WebElement> getColorBoxes() {
        return colorBoxes;
    }

    public void checkOrangeColorsOnItems() {
        int counter = 0;
        for (int i = 0; i < getColorBoxes().size(); i++) {
            if (getColorBoxes().get(i).findElements(By.cssSelector("a[style='background:#F39C11;']")).size() == 1) {
                counter++;
            }
        }
        Assert.assertEquals(3, counter);
    }

    public void clickOnPrintedSummerDressLink() { element(printedSummerDressLink).click(); }

    public void clickOnAddToCartButton() { element(addToCartButton).click(); }

    public void clickOnContinueShoppingButton() { element(continueShoppingButton).click(); }

    public void clickOnCartTab() { element(cartTab).click(); }

    public void clickOnLogoLink() {element(logoLink).click(); }

    public void clickOnProceedToCheckoutButton() { element(proceedToCheckoutButton).click(); }

    public void clickOnAddressProceedToCheckoutButton() { element(addressProceedToCheckoutButton).click(); }

    public void checkTermsOfServiceCheckbox() { element(termsOfServiceCheckbox).click(); }

    public void clickOnShippingProceedToCheckoutButton() { element(shippingProceedToCheckoutButton).click(); }

    public void clickOnPayByCheckButton() { element(payByCheckButton).click(); }

    public void clickOnConfirmMyOrderButton() { element(confirmMyOrderButton).click(); }

    public void checkConfirmationOrderText() {
        String expectedConfirmationMassage = "Your order on My Store is complete.";
        if(expectedConfirmationMassage.equals(element(confirmationMassage).getText())) {
            System.out.println("Massage is correct");
        } else {
            System.out.println("Massage is not correct");
        }
    }

    private List<WebElement> getMoveToItemList() {
        return moveToItem;
    }

    private List<WebElement> getAddToCartButtons() {
        return addToCartButtons;
    }

    public void clickOnAddToCartButtonOnItems(int count) {
        for (int i = 0; i < count; i++) {
            // имитация пользователя, чтобы он наводил на элементы
            withAction().moveToElement(moveToItem.get(i)).perform();
            getDriver().findElement(By.cssSelector("a[title='Add to cart'][data-id-product = '" + (i+1) + "']")).click();
            element(contShoppingButton).click();
        }
    }
}
