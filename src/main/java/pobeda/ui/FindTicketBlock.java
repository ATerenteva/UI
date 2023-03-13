package pobeda.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FindTicketBlock {

    WebDriver driver;

    @FindBy(id = "mantine-R2qualmqm-target")
    WebElement whereFromField;

    @FindBy(id = "mantine-R3qualmqm-target")
    WebElement whereField;

    @FindBy(id = ":Rbcualmqm:")
    WebElement dateThereField;

    @FindBy(id = ":Rrcualmqm:")
    WebElement dateBackField;

    @FindBy(xpath = "//button[contains(@class, \"dp-n39zqv\")]")
    WebElement findButton;


    public FindTicketBlock(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getWhereFromField() {
        return whereFromField;
    }

    public WebElement getWhereField() {
        return whereField;
    }

    public WebElement getDateThereField() {
        return dateThereField;
    }

    public WebElement getDateBackField() {
        return dateBackField;
    }

    public void clickWhereFromField(){ whereFromField.click(); }

    public void clickWhereField(){
        whereField.click();
    }

    public void clickFindButton(){
        findButton.click();
    }

}
