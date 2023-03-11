package pobeda.ui;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    WebDriver driver;

    String title;

    @FindBy(xpath = "//div[contains(@class, \"dp-2ri4z4\")]/a[contains(@class, \"dp-oz7gu4\")]/img[contains(@alt, \"«Авиакомпания «Победа», Группа «Аэрофлот»\")]")
    WebElement logo;

    @FindBy(xpath = "//a[contains(@href, \"/information\")]/div[contains(text(), \"Информация\")]")
    WebElement infoButton;

    public MainPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.title = driver.getTitle();
    }

    public String getTitle() {
        return this.title;
    }

    public WebElement getLogo() {
        return logo;
    }

    public void pointToInfo(){
        Actions builder = new Actions(driver);
        builder.moveToElement(infoButton).perform();
    }
}
