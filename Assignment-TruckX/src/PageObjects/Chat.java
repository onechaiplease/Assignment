package PageObjects;

import org.openqa.selenium.By;

public class Chat {

	public static By ChatButton= By.xpath("//div[text()='Chat with us']");
	public static By StartChat= By.xpath("/html/body/div/div/div[2]/div[2]/button");

	public static By Message= By.xpath("//*[@id=\"chat-input\"]");

	public static By SendMessage= By.xpath("/html/body/div/div/div[2]/div[2]/footer/div/div/button[2]/svg");
	public static By BotMessage= By.xpath("/html/body/div/div/div[2]/div[1]/div/div/div/div[3]/div/div[2]/div/div/div/p");

	
	
	

	


}
