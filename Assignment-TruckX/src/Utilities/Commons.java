package Utilities;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Commons {

	private static WebDriver driver = null;

	public Commons(WebDriver driver) {
		Commons.driver = driver;
	}

	public void waitUntilVisible(By element) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			wait.until(ExpectedConditions.visibilityOfElementLocated(element));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void navigateTo(String url) {
		driver.get(url);
	}

	public void clickElement(By by) {
		try {
			waitUntilVisible(by);
			driver.findElement(by).click();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean isElementDisplayed(By by) {

		boolean ElementAvailable = false;
		try {
			ElementAvailable = driver.findElement(by).isDisplayed();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ElementAvailable;
	}

	public void setValueToTextBox(By by, String value) {
		try {
			waitUntilVisible(by);
			driver.findElement(by).clear();
			driver.findElement(by).sendKeys(value);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getTextFromElement(By by) {
		String textFromElement = "No Text";
		try {
			waitUntilVisible(by);
			textFromElement = driver.findElement(by).getText();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return textFromElement;
	}
	
	public void frameSwitchByID(int frameid){
        try{
           driver.switchTo().frame(frameid);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
	
	public void SwitchToDefaultWindow(){
        try{
           driver.switchTo().defaultContent();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}
