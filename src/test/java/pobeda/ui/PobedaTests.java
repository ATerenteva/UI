package pobeda.ui;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.time.Duration;

public class PobedaTests {

    ChromeOptions options = new ChromeOptions().addArguments("--remote-allow-origins=*");
    WebDriver driver = new ChromeDriver(options);
    MainPage objMain;
    InfoPage objInfo;

    @BeforeEach
    public void before(){
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://pobeda.aero/");
    }

    @Test
    public void viewInformation(){
        objMain = new MainPage(driver);

        Assert.assertEquals(objMain.getTitle(), "Авиакомпания «Победа» - купить билеты на самолёт дешево онлайн, прямые и трансферные рейсы");
        Assert.assertTrue(objMain.getLogo().isDisplayed());

        objMain.pointToInfo();

        objInfo = new InfoPage(driver);
        Assert.assertTrue(objInfo.getInfoWindow().isDisplayed());
        Assert.assertTrue(objInfo.getInfoTitleReadyToFly().isDisplayed());
        Assert.assertTrue(objInfo.getInfoUsefulInfo().isDisplayed());
        Assert.assertTrue(objInfo.getInfoAboutCompany().isDisplayed());

    }

    @AfterEach
    public void close(){
        driver.quit();
    }
}
