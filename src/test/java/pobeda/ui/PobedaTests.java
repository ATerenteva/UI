package pobeda.ui;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class PobedaTests {

    ChromeOptions options = new ChromeOptions().addArguments("--remote-allow-origins=*", "window-size=1920,1080");
    WebDriver driver = new ChromeDriver(options);
    MainPage objMain;
    InfoBlock objInfo;
    FindTicketBlock objTicket;

    @BeforeEach
    public void before(){
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://pobeda.aero/");

        objMain = new MainPage(driver);

        Assert.assertEquals(objMain.getTitle(), "Авиакомпания «Победа» - купить билеты на самолёт дешево онлайн, прямые и трансферные рейсы");
        Assert.assertTrue(objMain.getLogo().isDisplayed());
    }

    @Test
    public void viewInformation(){
        objMain.pointToInfo();

        objInfo = new InfoBlock(driver);
        Assert.assertTrue(objInfo.getInfoWindow().isDisplayed());
        Assert.assertTrue(objInfo.getInfoTitleReadyToFly().isDisplayed());
        Assert.assertTrue(objInfo.getInfoUsefulInfo().isDisplayed());
        Assert.assertTrue(objInfo.getInfoAboutCompany().isDisplayed());

    }

    @Test
    public void checkFindTicketBlock(){
        objMain.scrollToFindTicket();
        Assert.assertTrue(objMain.getFindTicketBlock().isDisplayed());
        objTicket = new FindTicketBlock(driver);
        Assert.assertTrue(objTicket.getWhereFromField().isEnabled());
        Assert.assertTrue(objTicket.getWhereField().isEnabled());
        Assert.assertTrue(objTicket.getDateThereField().isEnabled());
        Assert.assertTrue(objTicket.getDateBackField().isEnabled());

        objTicket.clickWhereFromField();
        objTicket.getWhereFromField().sendKeys("Москва");
        objTicket.getWhereFromField().sendKeys(Keys.ENTER);
        objTicket.clickWhereField();
        objTicket.getWhereField().sendKeys("Санкт-Петербург");
        objTicket.getWhereField().sendKeys(Keys.ENTER);

        objTicket.clickFindButton();

        Assert.assertEquals(objTicket.getDateThereField().getCssValue("color"), "rgba(185, 0, 85, 1)");
    }

    @AfterEach
    public void close(){
        driver.quit();
    }
}
