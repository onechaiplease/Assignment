package Tests_UI;

import java.time.Duration;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import PageObjects.*;
import Utilities.Commons;
import Utilities.Constants;

public class Tests {
	private WebDriver driver = null;
	private static String OptionalProductQuantity = "6";
	private static String ChatMessage = "Hi";
	ChromeOptions options = new ChromeOptions()
			.setBinary("C:\\Program Files\\Google\\Chrome Beta\\Application\\chrome.exe");

	@BeforeTest
	public void oneTimeSetUp() {

		System.setProperty("webdriver.chrome.driver", ".\\Drivers\\chromedriver.exe");

	}

	@BeforeMethod
	public void setUp() {
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

	}

	@Test(priority = 1, description = "Adding product to the cart")
	public void AddtoCart() {

		// Adding item to cart

		Commons common = new Commons(driver);
		common.navigateTo(Constants.TRUCKX_URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));

		common.clickElement(AddtoCart.OrderOnline);
		common.clickElement(AddtoCart.MoreDetails);
		common.clickElement(AddtoCart.Quaterly);
		common.clickElement(AddtoCart.Continue);
		common.clickElement(AddtoCart.PinAdaptor);
		common.setValueToTextBox(AddtoCart.PinAdaptor, OptionalProductQuantity);
		common.waitUntilVisible(AddtoCart.Checkout);
		common.clickElement(AddtoCart.Checkout);
		String VerifyCheckoutPage = common.getTextFromElement(PageObjects.AddtoCart.ProductSummaryText);
		Assert.assertEquals(VerifyCheckoutPage, "Product Summary");

		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(AddtoCart.IncreaseQuantity)).build().perform();

		for (int i = 1; i < 5; i++) {
			common.clickElement(AddtoCart.IncreaseQuantity);

		}

		common.clickElement(AddtoCart.FinalCheckout);

	}

	@Test(priority = 2, description = "Validating the homepage's UI is fine ")
	public void ValidateHomepageUI() {

		// Navigating to TruckX Homepage and validating the UI

		Commons common = new Commons(driver);
		common.navigateTo(Constants.TRUCKX_URL);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		Assert.assertTrue(common.isElementDisplayed(HomepageUI.AssetTrackers));
		Assert.assertTrue(common.isElementDisplayed(HomepageUI.TermsandCondtions));

	}

	@Test(priority = 3, description = "Verifying the chat option")
	public void Chat() {

		// Verifying the chat option

		Commons common = new Commons(driver);
		common.navigateTo(Constants.TRUCKX_URL);

		common.clickElement(Chat.ChatButton);

		common.frameSwitchByID(2);

		common.clickElement(Chat.StartChat);
		common.clickElement(Chat.Message);
		common.setValueToTextBox(Chat.Message, ChatMessage);
		driver.findElement(Chat.Message).sendKeys(Keys.ENTER);

		String BotText = common.getTextFromElement(Chat.BotMessage);
		Assert.assertEquals(BotText, "Give the team a way to reach you.");

	}

	@AfterMethod
	public void exitBrowser() {
		driver.quit();
	}

}
